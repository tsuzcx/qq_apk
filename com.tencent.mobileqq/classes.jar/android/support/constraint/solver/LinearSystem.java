package android.support.constraint.solver;

import android.support.constraint.solver.widgets.ConstraintAnchor;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LinearSystem
{
  private static final boolean DEBUG = false;
  private static int POOL_SIZE = 1000;
  private int TABLE_SIZE = 32;
  private boolean[] mAlreadyTestedCandidates;
  final Cache mCache;
  private Goal mGoal = new Goal();
  private int mMaxColumns;
  private int mMaxRows;
  int mNumColumns;
  private int mNumRows;
  private SolverVariable[] mPoolVariables;
  private int mPoolVariablesCount;
  private ArrayRow[] mRows;
  private HashMap<String, SolverVariable> mVariables = null;
  int mVariablesID = 0;
  private ArrayRow[] tempClientsCopy;
  
  public LinearSystem()
  {
    int i = this.TABLE_SIZE;
    this.mMaxColumns = i;
    this.mRows = null;
    this.mAlreadyTestedCandidates = new boolean[i];
    this.mNumColumns = 1;
    this.mNumRows = 0;
    this.mMaxRows = i;
    this.mPoolVariables = new SolverVariable[POOL_SIZE];
    this.mPoolVariablesCount = 0;
    this.tempClientsCopy = new ArrayRow[i];
    this.mRows = new ArrayRow[i];
    releaseRows();
    this.mCache = new Cache();
  }
  
  private SolverVariable acquireSolverVariable(SolverVariable.Type paramType)
  {
    Object localObject = (SolverVariable)this.mCache.solverVariablePool.acquire();
    if (localObject == null)
    {
      paramType = new SolverVariable(paramType);
    }
    else
    {
      ((SolverVariable)localObject).reset();
      ((SolverVariable)localObject).setType(paramType);
      paramType = (SolverVariable.Type)localObject;
    }
    int i = this.mPoolVariablesCount;
    int j = POOL_SIZE;
    if (i >= j)
    {
      POOL_SIZE = j * 2;
      this.mPoolVariables = ((SolverVariable[])Arrays.copyOf(this.mPoolVariables, POOL_SIZE));
    }
    localObject = this.mPoolVariables;
    i = this.mPoolVariablesCount;
    this.mPoolVariablesCount = (i + 1);
    localObject[i] = paramType;
    return paramType;
  }
  
  private void addError(ArrayRow paramArrayRow)
  {
    paramArrayRow.addError(createErrorVariable(), createErrorVariable());
  }
  
  private void addSingleError(ArrayRow paramArrayRow, int paramInt)
  {
    paramArrayRow.addSingleError(createErrorVariable(), paramInt);
  }
  
  private void computeValues()
  {
    int i = 0;
    while (i < this.mNumRows)
    {
      ArrayRow localArrayRow = this.mRows[i];
      localArrayRow.variable.computedValue = localArrayRow.constantValue;
      i += 1;
    }
  }
  
  public static ArrayRow createRowCentering(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, float paramFloat, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, int paramInt2, boolean paramBoolean)
  {
    ArrayRow localArrayRow = paramLinearSystem.createRow();
    localArrayRow.createRowCentering(paramSolverVariable1, paramSolverVariable2, paramInt1, paramFloat, paramSolverVariable3, paramSolverVariable4, paramInt2);
    if (paramBoolean)
    {
      paramSolverVariable1 = paramLinearSystem.createErrorVariable();
      paramLinearSystem = paramLinearSystem.createErrorVariable();
      paramSolverVariable1.strength = 4;
      paramLinearSystem.strength = 4;
      localArrayRow.addError(paramSolverVariable1, paramLinearSystem);
    }
    return localArrayRow;
  }
  
  public static ArrayRow createRowDimensionPercent(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, float paramFloat, boolean paramBoolean)
  {
    ArrayRow localArrayRow = paramLinearSystem.createRow();
    if (paramBoolean) {
      paramLinearSystem.addError(localArrayRow);
    }
    return localArrayRow.createRowDimensionPercent(paramSolverVariable1, paramSolverVariable2, paramSolverVariable3, paramFloat);
  }
  
  public static ArrayRow createRowEquals(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt, boolean paramBoolean)
  {
    ArrayRow localArrayRow = paramLinearSystem.createRow();
    localArrayRow.createRowEquals(paramSolverVariable1, paramSolverVariable2, paramInt);
    if (paramBoolean) {
      paramLinearSystem.addSingleError(localArrayRow, 1);
    }
    return localArrayRow;
  }
  
  public static ArrayRow createRowGreaterThan(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt, boolean paramBoolean)
  {
    SolverVariable localSolverVariable = paramLinearSystem.createSlackVariable();
    ArrayRow localArrayRow = paramLinearSystem.createRow();
    localArrayRow.createRowGreaterThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, paramInt);
    if (paramBoolean) {
      paramLinearSystem.addSingleError(localArrayRow, (int)(localArrayRow.variables.get(localSolverVariable) * -1.0F));
    }
    return localArrayRow;
  }
  
  public static ArrayRow createRowLowerThan(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt, boolean paramBoolean)
  {
    SolverVariable localSolverVariable = paramLinearSystem.createSlackVariable();
    ArrayRow localArrayRow = paramLinearSystem.createRow();
    localArrayRow.createRowLowerThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, paramInt);
    if (paramBoolean) {
      paramLinearSystem.addSingleError(localArrayRow, (int)(localArrayRow.variables.get(localSolverVariable) * -1.0F));
    }
    return localArrayRow;
  }
  
  private SolverVariable createVariable(String paramString, SolverVariable.Type paramType)
  {
    if (this.mNumColumns + 1 >= this.mMaxColumns) {
      increaseTableSize();
    }
    paramType = acquireSolverVariable(paramType);
    paramType.setName(paramString);
    this.mVariablesID += 1;
    this.mNumColumns += 1;
    paramType.id = this.mVariablesID;
    if (this.mVariables == null) {
      this.mVariables = new HashMap();
    }
    this.mVariables.put(paramString, paramType);
    this.mCache.mIndexedVariables[this.mVariablesID] = paramType;
    return paramType;
  }
  
  private void displayRows()
  {
    displaySolverVariables();
    String str = "";
    int i = 0;
    while (i < this.mNumRows)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(this.mRows[i]);
      str = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("\n");
      str = ((StringBuilder)localObject).toString();
      i += 1;
    }
    Object localObject = str;
    if (this.mGoal.variables.size() != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(this.mGoal);
      ((StringBuilder)localObject).append("\n");
      localObject = ((StringBuilder)localObject).toString();
    }
    System.out.println((String)localObject);
  }
  
  private void displaySolverVariables()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Display Rows (");
    ((StringBuilder)localObject1).append(this.mNumRows);
    ((StringBuilder)localObject1).append("x");
    ((StringBuilder)localObject1).append(this.mNumColumns);
    ((StringBuilder)localObject1).append(") :\n\t | C | ");
    localObject1 = ((StringBuilder)localObject1).toString();
    int i = 1;
    while (i <= this.mNumColumns)
    {
      localObject2 = this.mCache.mIndexedVariables[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(localObject2);
      localObject1 = localStringBuilder.toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" | ");
      localObject1 = ((StringBuilder)localObject2).toString();
      i += 1;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("\n");
    localObject1 = ((StringBuilder)localObject2).toString();
    System.out.println((String)localObject1);
  }
  
  private int enforceBFS(Goal paramGoal)
  {
    int i = 0;
    while (i < this.mNumRows)
    {
      if ((this.mRows[i].variable.mType != SolverVariable.Type.UNRESTRICTED) && (this.mRows[i].constantValue < 0.0F))
      {
        i = 1;
        break label67;
      }
      i += 1;
    }
    i = 0;
    label67:
    if (i != 0)
    {
      int i2 = 0;
      i = 0;
      for (;;)
      {
        j = i;
        if (i2 != 0) {
          break;
        }
        int i4 = i + 1;
        int m = 0;
        i = -1;
        j = -1;
        float f1 = 3.4028235E+38F;
        ArrayRow localArrayRow;
        int n;
        for (int k = 0; m < this.mNumRows; k = n)
        {
          localArrayRow = this.mRows[m];
          int i3;
          int i1;
          float f2;
          if (localArrayRow.variable.mType == SolverVariable.Type.UNRESTRICTED)
          {
            i3 = i;
            i1 = j;
            f2 = f1;
            n = k;
          }
          else
          {
            i3 = i;
            i1 = j;
            f2 = f1;
            n = k;
            if (localArrayRow.constantValue < 0.0F)
            {
              n = i;
              i1 = 1;
              i = k;
              k = n;
              n = i1;
              while (n < this.mNumColumns)
              {
                SolverVariable localSolverVariable = this.mCache.mIndexedVariables[n];
                float f3 = localArrayRow.variables.get(localSolverVariable);
                if (f3 > 0.0F)
                {
                  i3 = i;
                  i1 = k;
                  i = 0;
                  k = j;
                  for (j = i3; i < 6; j = i3)
                  {
                    f2 = localSolverVariable.strengthVector[i] / f3;
                    if ((f2 >= f1) || (i != j))
                    {
                      i3 = j;
                      if (i <= j) {}
                    }
                    else
                    {
                      f1 = f2;
                      i1 = m;
                      k = n;
                      i3 = i;
                    }
                    i += 1;
                  }
                  i = j;
                  j = k;
                  k = i1;
                }
                n += 1;
              }
              n = i;
              f2 = f1;
              i1 = j;
              i3 = k;
            }
          }
          m += 1;
          i = i3;
          j = i1;
          f1 = f2;
        }
        if (i != -1)
        {
          localArrayRow = this.mRows[i];
          localArrayRow.variable.definitionId = -1;
          localArrayRow.pivot(this.mCache.mIndexedVariables[j]);
          localArrayRow.variable.definitionId = i;
          i = 0;
          while (i < this.mNumRows)
          {
            this.mRows[i].updateRowWithEquation(localArrayRow);
            i += 1;
          }
          paramGoal.updateFromSystem(this);
          i = i4;
        }
        else
        {
          i2 = 1;
          i = i4;
        }
      }
    }
    int j = 0;
    i = 0;
    while (i < this.mNumRows)
    {
      if ((this.mRows[i].variable.mType != SolverVariable.Type.UNRESTRICTED) && (this.mRows[i].constantValue < 0.0F)) {
        return j;
      }
      i += 1;
    }
    return j;
  }
  
  private String getDisplaySize(int paramInt)
  {
    paramInt *= 4;
    int i = paramInt / 1024;
    int j = i / 1024;
    if (j > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(j);
      localStringBuilder.append(" Mb");
      return localStringBuilder.toString();
    }
    if (i > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(i);
      localStringBuilder.append(" Kb");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" bytes");
    return localStringBuilder.toString();
  }
  
  private void increaseTableSize()
  {
    this.TABLE_SIZE *= 2;
    this.mRows = ((ArrayRow[])Arrays.copyOf(this.mRows, this.TABLE_SIZE));
    Cache localCache = this.mCache;
    localCache.mIndexedVariables = ((SolverVariable[])Arrays.copyOf(localCache.mIndexedVariables, this.TABLE_SIZE));
    int i = this.TABLE_SIZE;
    this.mAlreadyTestedCandidates = new boolean[i];
    this.mMaxColumns = i;
    this.mMaxRows = i;
    this.mGoal.variables.clear();
  }
  
  private int optimize(Goal paramGoal)
  {
    int i = 0;
    while (i < this.mNumColumns)
    {
      this.mAlreadyTestedCandidates[i] = false;
      i += 1;
    }
    i = 0;
    int k = 0;
    int m = 0;
    while (i == 0)
    {
      int i1 = k + 1;
      Object localObject2 = paramGoal.getPivotCandidate();
      k = i;
      int j = m;
      Object localObject1 = localObject2;
      if (localObject2 != null) {
        if (this.mAlreadyTestedCandidates[localObject2.id] != 0)
        {
          localObject1 = null;
          k = i;
          j = m;
        }
        else
        {
          this.mAlreadyTestedCandidates[localObject2.id] = true;
          m += 1;
          k = i;
          j = m;
          localObject1 = localObject2;
          if (m >= this.mNumColumns)
          {
            k = 1;
            localObject1 = localObject2;
            j = m;
          }
        }
      }
      if (localObject1 != null)
      {
        i = 0;
        m = -1;
        float f2;
        for (float f1 = 3.4028235E+38F; i < this.mNumRows; f1 = f2)
        {
          localObject2 = this.mRows[i];
          int n;
          if (((ArrayRow)localObject2).variable.mType == SolverVariable.Type.UNRESTRICTED)
          {
            n = m;
            f2 = f1;
          }
          else
          {
            n = m;
            f2 = f1;
            if (((ArrayRow)localObject2).hasVariable(localObject1))
            {
              float f3 = ((ArrayRow)localObject2).variables.get(localObject1);
              n = m;
              f2 = f1;
              if (f3 < 0.0F)
              {
                f3 = -((ArrayRow)localObject2).constantValue / f3;
                n = m;
                f2 = f1;
                if (f3 < f1)
                {
                  n = i;
                  f2 = f3;
                }
              }
            }
          }
          i += 1;
          m = n;
        }
        if (m > -1)
        {
          localObject2 = this.mRows[m];
          ((ArrayRow)localObject2).variable.definitionId = -1;
          ((ArrayRow)localObject2).pivot(localObject1);
          ((ArrayRow)localObject2).variable.definitionId = m;
          i = 0;
          while (i < this.mNumRows)
          {
            this.mRows[i].updateRowWithEquation((ArrayRow)localObject2);
            i += 1;
          }
          paramGoal.updateFromSystem(this);
          try
          {
            enforceBFS(paramGoal);
            i = k;
            k = i1;
            m = j;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            i = k;
            k = i1;
            m = j;
          }
          continue;
        }
      }
      i = 1;
      k = i1;
      m = j;
    }
    return k;
  }
  
  private void releaseRows()
  {
    int i = 0;
    for (;;)
    {
      Object localObject = this.mRows;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      if (localObject != null) {
        this.mCache.arrayRowPool.release(localObject);
      }
      this.mRows[i] = null;
      i += 1;
    }
  }
  
  private void updateRowFromVariables(ArrayRow paramArrayRow)
  {
    if (this.mNumRows > 0)
    {
      paramArrayRow.variables.updateFromSystem(paramArrayRow, this.mRows);
      if (paramArrayRow.variables.currentSize == 0) {
        paramArrayRow.isSimpleDefinition = true;
      }
    }
  }
  
  public void addCentering(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, float paramFloat, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, int paramInt2, int paramInt3)
  {
    ArrayRow localArrayRow = createRow();
    localArrayRow.createRowCentering(paramSolverVariable1, paramSolverVariable2, paramInt1, paramFloat, paramSolverVariable3, paramSolverVariable4, paramInt2);
    paramSolverVariable1 = createErrorVariable();
    paramSolverVariable2 = createErrorVariable();
    paramSolverVariable1.strength = paramInt3;
    paramSolverVariable2.strength = paramInt3;
    localArrayRow.addError(paramSolverVariable1, paramSolverVariable2);
    addConstraint(localArrayRow);
  }
  
  public void addConstraint(ArrayRow paramArrayRow)
  {
    if (paramArrayRow == null) {
      return;
    }
    if ((this.mNumRows + 1 >= this.mMaxRows) || (this.mNumColumns + 1 >= this.mMaxColumns)) {
      increaseTableSize();
    }
    if (!paramArrayRow.isSimpleDefinition)
    {
      updateRowFromVariables(paramArrayRow);
      paramArrayRow.ensurePositiveConstant();
      paramArrayRow.pickRowVariable();
      if (!paramArrayRow.hasKeyVariable()) {
        return;
      }
    }
    if (this.mRows[this.mNumRows] != null) {
      this.mCache.arrayRowPool.release(this.mRows[this.mNumRows]);
    }
    if (!paramArrayRow.isSimpleDefinition) {
      paramArrayRow.updateClientEquations();
    }
    this.mRows[this.mNumRows] = paramArrayRow;
    Object localObject = paramArrayRow.variable;
    int i = this.mNumRows;
    ((SolverVariable)localObject).definitionId = i;
    this.mNumRows = (i + 1);
    int m = paramArrayRow.variable.mClientEquationsCount;
    if (m > 0)
    {
      for (;;)
      {
        localObject = this.tempClientsCopy;
        if (localObject.length >= m) {
          break;
        }
        this.tempClientsCopy = new ArrayRow[localObject.length * 2];
      }
      int k = 0;
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        localObject[i] = paramArrayRow.variable.mClientEquations[i];
        i += 1;
      }
      while (j < m)
      {
        ArrayRow localArrayRow = localObject[j];
        if (localArrayRow != paramArrayRow)
        {
          localArrayRow.variables.updateFromRow(localArrayRow, paramArrayRow);
          localArrayRow.updateClientEquations();
        }
        j += 1;
      }
    }
  }
  
  public ArrayRow addEquality(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2)
  {
    ArrayRow localArrayRow = createRow();
    localArrayRow.createRowEquals(paramSolverVariable1, paramSolverVariable2, paramInt1);
    paramSolverVariable1 = createErrorVariable();
    paramSolverVariable2 = createErrorVariable();
    paramSolverVariable1.strength = paramInt2;
    paramSolverVariable2.strength = paramInt2;
    localArrayRow.addError(paramSolverVariable1, paramSolverVariable2);
    addConstraint(localArrayRow);
    return localArrayRow;
  }
  
  public void addEquality(SolverVariable paramSolverVariable, int paramInt)
  {
    int i = paramSolverVariable.definitionId;
    if (paramSolverVariable.definitionId != -1)
    {
      localArrayRow = this.mRows[i];
      if (localArrayRow.isSimpleDefinition)
      {
        localArrayRow.constantValue = paramInt;
        return;
      }
      localArrayRow = createRow();
      localArrayRow.createRowEquals(paramSolverVariable, paramInt);
      addConstraint(localArrayRow);
      return;
    }
    ArrayRow localArrayRow = createRow();
    localArrayRow.createRowDefinition(paramSolverVariable, paramInt);
    addConstraint(localArrayRow);
  }
  
  public void addGreaterThan(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2)
  {
    ArrayRow localArrayRow = createRow();
    SolverVariable localSolverVariable = createSlackVariable();
    localSolverVariable.strength = paramInt2;
    localArrayRow.createRowGreaterThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, paramInt1);
    addConstraint(localArrayRow);
  }
  
  public void addLowerThan(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2)
  {
    ArrayRow localArrayRow = createRow();
    SolverVariable localSolverVariable = createSlackVariable();
    localSolverVariable.strength = paramInt2;
    localArrayRow.createRowLowerThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, paramInt1);
    addConstraint(localArrayRow);
  }
  
  public SolverVariable createErrorVariable()
  {
    if (this.mNumColumns + 1 >= this.mMaxColumns) {
      increaseTableSize();
    }
    SolverVariable localSolverVariable = acquireSolverVariable(SolverVariable.Type.ERROR);
    this.mVariablesID += 1;
    this.mNumColumns += 1;
    localSolverVariable.id = this.mVariablesID;
    this.mCache.mIndexedVariables[this.mVariablesID] = localSolverVariable;
    return localSolverVariable;
  }
  
  public SolverVariable createObjectVariable(Object paramObject)
  {
    Object localObject = null;
    if (paramObject == null) {
      return null;
    }
    if (this.mNumColumns + 1 >= this.mMaxColumns) {
      increaseTableSize();
    }
    if ((paramObject instanceof ConstraintAnchor))
    {
      ConstraintAnchor localConstraintAnchor = (ConstraintAnchor)paramObject;
      localObject = localConstraintAnchor.getSolverVariable();
      paramObject = localObject;
      if (localObject == null)
      {
        localConstraintAnchor.resetSolverVariable(this.mCache);
        paramObject = localConstraintAnchor.getSolverVariable();
      }
      if ((paramObject.id != -1) && (paramObject.id <= this.mVariablesID))
      {
        localObject = paramObject;
        if (this.mCache.mIndexedVariables[paramObject.id] != null) {}
      }
      else
      {
        if (paramObject.id != -1) {
          paramObject.reset();
        }
        this.mVariablesID += 1;
        this.mNumColumns += 1;
        paramObject.id = this.mVariablesID;
        paramObject.mType = SolverVariable.Type.UNRESTRICTED;
        this.mCache.mIndexedVariables[this.mVariablesID] = paramObject;
        localObject = paramObject;
      }
    }
    return localObject;
  }
  
  public ArrayRow createRow()
  {
    ArrayRow localArrayRow = (ArrayRow)this.mCache.arrayRowPool.acquire();
    if (localArrayRow == null) {
      return new ArrayRow(this.mCache);
    }
    localArrayRow.reset();
    return localArrayRow;
  }
  
  public SolverVariable createSlackVariable()
  {
    if (this.mNumColumns + 1 >= this.mMaxColumns) {
      increaseTableSize();
    }
    SolverVariable localSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK);
    this.mVariablesID += 1;
    this.mNumColumns += 1;
    localSolverVariable.id = this.mVariablesID;
    this.mCache.mIndexedVariables[this.mVariablesID] = localSolverVariable;
    return localSolverVariable;
  }
  
  void displayReadableRows()
  {
    displaySolverVariables();
    String str = "";
    int i = 0;
    while (i < this.mNumRows)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(this.mRows[i].toReadableString());
      str = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("\n");
      str = ((StringBuilder)localObject).toString();
      i += 1;
    }
    Object localObject = str;
    if (this.mGoal != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(this.mGoal);
      ((StringBuilder)localObject).append("\n");
      localObject = ((StringBuilder)localObject).toString();
    }
    System.out.println((String)localObject);
  }
  
  void displaySystemInformations()
  {
    int j = 0;
    for (int i = 0; j < this.TABLE_SIZE; i = k)
    {
      localObject = this.mRows;
      k = i;
      if (localObject[j] != null) {
        k = i + localObject[j].sizeInBytes();
      }
      j += 1;
    }
    int k = 0;
    int m;
    for (j = 0; k < this.mNumRows; j = m)
    {
      localObject = this.mRows;
      m = j;
      if (localObject[k] != null) {
        m = j + localObject[k].sizeInBytes();
      }
      k += 1;
    }
    Object localObject = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Linear System -> Table size: ");
    localStringBuilder.append(this.TABLE_SIZE);
    localStringBuilder.append(" (");
    k = this.TABLE_SIZE;
    localStringBuilder.append(getDisplaySize(k * k));
    localStringBuilder.append(") -- row sizes: ");
    localStringBuilder.append(getDisplaySize(i));
    localStringBuilder.append(", actual size: ");
    localStringBuilder.append(getDisplaySize(j));
    localStringBuilder.append(" rows: ");
    localStringBuilder.append(this.mNumRows);
    localStringBuilder.append("/");
    localStringBuilder.append(this.mMaxRows);
    localStringBuilder.append(" cols: ");
    localStringBuilder.append(this.mNumColumns);
    localStringBuilder.append("/");
    localStringBuilder.append(this.mMaxColumns);
    localStringBuilder.append(" ");
    localStringBuilder.append(0);
    localStringBuilder.append(" occupied cells, ");
    localStringBuilder.append(getDisplaySize(0));
    ((PrintStream)localObject).println(localStringBuilder.toString());
  }
  
  public void displayVariablesReadableRows()
  {
    displaySolverVariables();
    Object localObject1 = "";
    int i = 0;
    while (i < this.mNumRows)
    {
      localObject2 = localObject1;
      if (this.mRows[i].variable.mType == SolverVariable.Type.UNRESTRICTED)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(this.mRows[i].toReadableString());
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("\n");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      i += 1;
      localObject1 = localObject2;
    }
    Object localObject2 = localObject1;
    if (this.mGoal.variables.size() != 0)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(this.mGoal);
      ((StringBuilder)localObject2).append("\n");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    System.out.println((String)localObject2);
  }
  
  public Cache getCache()
  {
    return this.mCache;
  }
  
  Goal getGoal()
  {
    return this.mGoal;
  }
  
  public int getMemoryUsed()
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.mNumRows; j = k)
    {
      ArrayRow[] arrayOfArrayRow = this.mRows;
      k = j;
      if (arrayOfArrayRow[i] != null) {
        k = j + arrayOfArrayRow[i].sizeInBytes();
      }
      i += 1;
    }
    return j;
  }
  
  public int getNumEquations()
  {
    return this.mNumRows;
  }
  
  public int getNumVariables()
  {
    return this.mVariablesID;
  }
  
  public int getObjectVariableValue(Object paramObject)
  {
    paramObject = ((ConstraintAnchor)paramObject).getSolverVariable();
    if (paramObject != null) {
      return (int)(paramObject.computedValue + 0.5F);
    }
    return 0;
  }
  
  ArrayRow getRow(int paramInt)
  {
    return this.mRows[paramInt];
  }
  
  float getValueFor(String paramString)
  {
    paramString = getVariable(paramString, SolverVariable.Type.UNRESTRICTED);
    if (paramString == null) {
      return 0.0F;
    }
    return paramString.computedValue;
  }
  
  SolverVariable getVariable(String paramString, SolverVariable.Type paramType)
  {
    if (this.mVariables == null) {
      this.mVariables = new HashMap();
    }
    SolverVariable localSolverVariable2 = (SolverVariable)this.mVariables.get(paramString);
    SolverVariable localSolverVariable1 = localSolverVariable2;
    if (localSolverVariable2 == null) {
      localSolverVariable1 = createVariable(paramString, paramType);
    }
    return localSolverVariable1;
  }
  
  public void minimize()
  {
    minimizeGoal(this.mGoal);
  }
  
  void minimizeGoal(Goal paramGoal)
  {
    paramGoal.updateFromSystem(this);
    enforceBFS(paramGoal);
    optimize(paramGoal);
    computeValues();
  }
  
  void rebuildGoalFromErrors()
  {
    this.mGoal.updateFromSystem(this);
  }
  
  public void reset()
  {
    int i = 0;
    while (i < this.mCache.mIndexedVariables.length)
    {
      localObject = this.mCache.mIndexedVariables[i];
      if (localObject != null) {
        ((SolverVariable)localObject).reset();
      }
      i += 1;
    }
    this.mCache.solverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
    this.mPoolVariablesCount = 0;
    Arrays.fill(this.mCache.mIndexedVariables, null);
    Object localObject = this.mVariables;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    this.mVariablesID = 0;
    this.mGoal.variables.clear();
    this.mNumColumns = 1;
    i = 0;
    while (i < this.mNumRows)
    {
      this.mRows[i].used = false;
      i += 1;
    }
    releaseRows();
    this.mNumRows = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.constraint.solver.LinearSystem
 * JD-Core Version:    0.7.0.1
 */