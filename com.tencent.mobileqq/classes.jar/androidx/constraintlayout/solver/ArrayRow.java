package androidx.constraintlayout.solver;

import java.util.ArrayList;

public class ArrayRow
  implements LinearSystem.Row
{
  private static final boolean DEBUG = false;
  private static final boolean FULL_NEW_CHECK = false;
  float constantValue = 0.0F;
  boolean isSimpleDefinition = false;
  boolean used = false;
  SolverVariable variable = null;
  public ArrayRow.ArrayRowVariables variables;
  ArrayList<SolverVariable> variablesToUpdate = new ArrayList();
  
  public ArrayRow() {}
  
  public ArrayRow(Cache paramCache)
  {
    this.variables = new ArrayLinkedVariables(this, paramCache);
  }
  
  private boolean isNew(SolverVariable paramSolverVariable, LinearSystem paramLinearSystem)
  {
    return paramSolverVariable.usageInRowCount <= 1;
  }
  
  private SolverVariable pickPivotInVariables(boolean[] paramArrayOfBoolean, SolverVariable paramSolverVariable)
  {
    int j = this.variables.getCurrentSize();
    Object localObject1 = null;
    int i = 0;
    float f2;
    for (float f1 = 0.0F; i < j; f1 = f2)
    {
      float f3 = this.variables.getVariableValue(i);
      Object localObject2 = localObject1;
      f2 = f1;
      if (f3 < 0.0F)
      {
        SolverVariable localSolverVariable = this.variables.getVariable(i);
        if (paramArrayOfBoolean != null)
        {
          localObject2 = localObject1;
          f2 = f1;
          if (paramArrayOfBoolean[localSolverVariable.id] != 0) {}
        }
        else
        {
          localObject2 = localObject1;
          f2 = f1;
          if (localSolverVariable != paramSolverVariable) {
            if (localSolverVariable.mType != SolverVariable.Type.SLACK)
            {
              localObject2 = localObject1;
              f2 = f1;
              if (localSolverVariable.mType != SolverVariable.Type.ERROR) {}
            }
            else
            {
              localObject2 = localObject1;
              f2 = f1;
              if (f3 < f1)
              {
                f2 = f3;
                localObject2 = localSolverVariable;
              }
            }
          }
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public ArrayRow addError(LinearSystem paramLinearSystem, int paramInt)
  {
    this.variables.put(paramLinearSystem.createErrorVariable(paramInt, "ep"), 1.0F);
    this.variables.put(paramLinearSystem.createErrorVariable(paramInt, "em"), -1.0F);
    return this;
  }
  
  public void addError(SolverVariable paramSolverVariable)
  {
    int i = paramSolverVariable.strength;
    float f = 1.0F;
    if (i != 1) {
      if (paramSolverVariable.strength == 2) {
        f = 1000.0F;
      } else if (paramSolverVariable.strength == 3) {
        f = 1000000.0F;
      } else if (paramSolverVariable.strength == 4) {
        f = 1.0E+009F;
      } else if (paramSolverVariable.strength == 5) {
        f = 1.0E+012F;
      }
    }
    this.variables.put(paramSolverVariable, f);
  }
  
  ArrayRow addSingleError(SolverVariable paramSolverVariable, int paramInt)
  {
    this.variables.put(paramSolverVariable, paramInt);
    return this;
  }
  
  boolean chooseSubject(LinearSystem paramLinearSystem)
  {
    paramLinearSystem = chooseSubjectInVariables(paramLinearSystem);
    boolean bool;
    if (paramLinearSystem == null)
    {
      bool = true;
    }
    else
    {
      pivot(paramLinearSystem);
      bool = false;
    }
    if (this.variables.getCurrentSize() == 0) {
      this.isSimpleDefinition = true;
    }
    return bool;
  }
  
  SolverVariable chooseSubjectInVariables(LinearSystem paramLinearSystem)
  {
    int j = this.variables.getCurrentSize();
    Object localObject4 = null;
    int i = 0;
    Object localObject3 = null;
    float f5 = 0.0F;
    boolean bool2 = false;
    float f4 = 0.0F;
    int k;
    for (int m = 0; i < j; m = k)
    {
      float f1 = this.variables.getVariableValue(i);
      SolverVariable localSolverVariable = this.variables.getVariable(i);
      boolean bool1;
      Object localObject1;
      Object localObject2;
      float f2;
      float f3;
      if (localSolverVariable.mType == SolverVariable.Type.UNRESTRICTED)
      {
        if (localObject4 == null) {}
        for (bool1 = isNew(localSolverVariable, paramLinearSystem);; bool1 = isNew(localSolverVariable, paramLinearSystem))
        {
          localObject1 = localSolverVariable;
          localObject2 = localObject3;
          f2 = f1;
          f3 = f4;
          k = m;
          break label411;
          if (f5 <= f1) {
            break;
          }
        }
        localObject1 = localObject4;
        localObject2 = localObject3;
        f2 = f5;
        bool1 = bool2;
        f3 = f4;
        k = m;
        if (!bool2)
        {
          localObject1 = localObject4;
          localObject2 = localObject3;
          f2 = f5;
          bool1 = bool2;
          f3 = f4;
          k = m;
          if (isNew(localSolverVariable, paramLinearSystem))
          {
            bool1 = true;
            localObject1 = localSolverVariable;
            localObject2 = localObject3;
            f2 = f1;
            f3 = f4;
            k = m;
          }
        }
      }
      else
      {
        localObject1 = localObject4;
        localObject2 = localObject3;
        f2 = f5;
        bool1 = bool2;
        f3 = f4;
        k = m;
        if (localObject4 == null)
        {
          localObject1 = localObject4;
          localObject2 = localObject3;
          f2 = f5;
          bool1 = bool2;
          f3 = f4;
          k = m;
          if (f1 < 0.0F)
          {
            if (localObject3 == null) {}
            for (bool1 = isNew(localSolverVariable, paramLinearSystem);; bool1 = isNew(localSolverVariable, paramLinearSystem))
            {
              k = bool1;
              localObject1 = localObject4;
              localObject2 = localSolverVariable;
              f2 = f5;
              bool1 = bool2;
              f3 = f1;
              break label411;
              if (f4 <= f1) {
                break;
              }
            }
            localObject1 = localObject4;
            localObject2 = localObject3;
            f2 = f5;
            bool1 = bool2;
            f3 = f4;
            k = m;
            if (m == 0)
            {
              localObject1 = localObject4;
              localObject2 = localObject3;
              f2 = f5;
              bool1 = bool2;
              f3 = f4;
              k = m;
              if (isNew(localSolverVariable, paramLinearSystem))
              {
                k = 1;
                f3 = f1;
                bool1 = bool2;
                f2 = f5;
                localObject2 = localSolverVariable;
                localObject1 = localObject4;
              }
            }
          }
        }
      }
      label411:
      i += 1;
      localObject4 = localObject1;
      localObject3 = localObject2;
      f5 = f2;
      bool2 = bool1;
      f4 = f3;
    }
    if (localObject4 != null) {
      return localObject4;
    }
    return localObject3;
  }
  
  public void clear()
  {
    this.variables.clear();
    this.variable = null;
    this.constantValue = 0.0F;
  }
  
  ArrayRow createRowCentering(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, float paramFloat, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, int paramInt2)
  {
    if (paramSolverVariable2 == paramSolverVariable3)
    {
      this.variables.put(paramSolverVariable1, 1.0F);
      this.variables.put(paramSolverVariable4, 1.0F);
      this.variables.put(paramSolverVariable2, -2.0F);
      return this;
    }
    if (paramFloat == 0.5F)
    {
      this.variables.put(paramSolverVariable1, 1.0F);
      this.variables.put(paramSolverVariable2, -1.0F);
      this.variables.put(paramSolverVariable3, -1.0F);
      this.variables.put(paramSolverVariable4, 1.0F);
      if ((paramInt1 > 0) || (paramInt2 > 0))
      {
        this.constantValue = (-paramInt1 + paramInt2);
        return this;
      }
    }
    else
    {
      if (paramFloat <= 0.0F)
      {
        this.variables.put(paramSolverVariable1, -1.0F);
        this.variables.put(paramSolverVariable2, 1.0F);
        this.constantValue = paramInt1;
        return this;
      }
      if (paramFloat >= 1.0F)
      {
        this.variables.put(paramSolverVariable4, -1.0F);
        this.variables.put(paramSolverVariable3, 1.0F);
        this.constantValue = (-paramInt2);
        return this;
      }
      ArrayRow.ArrayRowVariables localArrayRowVariables = this.variables;
      float f = 1.0F - paramFloat;
      localArrayRowVariables.put(paramSolverVariable1, f * 1.0F);
      this.variables.put(paramSolverVariable2, f * -1.0F);
      this.variables.put(paramSolverVariable3, -1.0F * paramFloat);
      this.variables.put(paramSolverVariable4, 1.0F * paramFloat);
      if ((paramInt1 > 0) || (paramInt2 > 0)) {
        this.constantValue = (-paramInt1 * f + paramInt2 * paramFloat);
      }
    }
    return this;
  }
  
  ArrayRow createRowDefinition(SolverVariable paramSolverVariable, int paramInt)
  {
    this.variable = paramSolverVariable;
    float f = paramInt;
    paramSolverVariable.computedValue = f;
    this.constantValue = f;
    this.isSimpleDefinition = true;
    return this;
  }
  
  ArrayRow createRowDimensionPercent(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, float paramFloat)
  {
    this.variables.put(paramSolverVariable1, -1.0F);
    this.variables.put(paramSolverVariable2, paramFloat);
    return this;
  }
  
  public ArrayRow createRowDimensionRatio(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, float paramFloat)
  {
    this.variables.put(paramSolverVariable1, -1.0F);
    this.variables.put(paramSolverVariable2, 1.0F);
    this.variables.put(paramSolverVariable3, paramFloat);
    this.variables.put(paramSolverVariable4, -paramFloat);
    return this;
  }
  
  public ArrayRow createRowEqualDimension(float paramFloat1, float paramFloat2, float paramFloat3, SolverVariable paramSolverVariable1, int paramInt1, SolverVariable paramSolverVariable2, int paramInt2, SolverVariable paramSolverVariable3, int paramInt3, SolverVariable paramSolverVariable4, int paramInt4)
  {
    if ((paramFloat2 != 0.0F) && (paramFloat1 != paramFloat3))
    {
      paramFloat1 = paramFloat1 / paramFloat2 / (paramFloat3 / paramFloat2);
      this.constantValue = (-paramInt1 - paramInt2 + paramInt3 * paramFloat1 + paramInt4 * paramFloat1);
      this.variables.put(paramSolverVariable1, 1.0F);
      this.variables.put(paramSolverVariable2, -1.0F);
      this.variables.put(paramSolverVariable4, paramFloat1);
      this.variables.put(paramSolverVariable3, -paramFloat1);
      return this;
    }
    this.constantValue = (-paramInt1 - paramInt2 + paramInt3 + paramInt4);
    this.variables.put(paramSolverVariable1, 1.0F);
    this.variables.put(paramSolverVariable2, -1.0F);
    this.variables.put(paramSolverVariable4, 1.0F);
    this.variables.put(paramSolverVariable3, -1.0F);
    return this;
  }
  
  public ArrayRow createRowEqualMatchDimensions(float paramFloat1, float paramFloat2, float paramFloat3, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4)
  {
    this.constantValue = 0.0F;
    if ((paramFloat2 != 0.0F) && (paramFloat1 != paramFloat3))
    {
      if (paramFloat1 == 0.0F)
      {
        this.variables.put(paramSolverVariable1, 1.0F);
        this.variables.put(paramSolverVariable2, -1.0F);
        return this;
      }
      if (paramFloat3 == 0.0F)
      {
        this.variables.put(paramSolverVariable3, 1.0F);
        this.variables.put(paramSolverVariable4, -1.0F);
        return this;
      }
      paramFloat1 = paramFloat1 / paramFloat2 / (paramFloat3 / paramFloat2);
      this.variables.put(paramSolverVariable1, 1.0F);
      this.variables.put(paramSolverVariable2, -1.0F);
      this.variables.put(paramSolverVariable4, paramFloat1);
      this.variables.put(paramSolverVariable3, -paramFloat1);
      return this;
    }
    this.variables.put(paramSolverVariable1, 1.0F);
    this.variables.put(paramSolverVariable2, -1.0F);
    this.variables.put(paramSolverVariable4, 1.0F);
    this.variables.put(paramSolverVariable3, -1.0F);
    return this;
  }
  
  public ArrayRow createRowEquals(SolverVariable paramSolverVariable, int paramInt)
  {
    if (paramInt < 0)
    {
      this.constantValue = (paramInt * -1);
      this.variables.put(paramSolverVariable, 1.0F);
      return this;
    }
    this.constantValue = paramInt;
    this.variables.put(paramSolverVariable, -1.0F);
    return this;
  }
  
  public ArrayRow createRowEquals(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt)
  {
    int i = 0;
    int j = 0;
    if (paramInt != 0)
    {
      i = j;
      j = paramInt;
      if (paramInt < 0)
      {
        j = paramInt * -1;
        i = 1;
      }
      this.constantValue = j;
    }
    if (i == 0)
    {
      this.variables.put(paramSolverVariable1, -1.0F);
      this.variables.put(paramSolverVariable2, 1.0F);
      return this;
    }
    this.variables.put(paramSolverVariable1, 1.0F);
    this.variables.put(paramSolverVariable2, -1.0F);
    return this;
  }
  
  public ArrayRow createRowGreaterThan(SolverVariable paramSolverVariable1, int paramInt, SolverVariable paramSolverVariable2)
  {
    this.constantValue = paramInt;
    this.variables.put(paramSolverVariable1, -1.0F);
    return this;
  }
  
  public ArrayRow createRowGreaterThan(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, int paramInt)
  {
    int i = 0;
    int j = 0;
    if (paramInt != 0)
    {
      i = j;
      j = paramInt;
      if (paramInt < 0)
      {
        j = paramInt * -1;
        i = 1;
      }
      this.constantValue = j;
    }
    if (i == 0)
    {
      this.variables.put(paramSolverVariable1, -1.0F);
      this.variables.put(paramSolverVariable2, 1.0F);
      this.variables.put(paramSolverVariable3, 1.0F);
      return this;
    }
    this.variables.put(paramSolverVariable1, 1.0F);
    this.variables.put(paramSolverVariable2, -1.0F);
    this.variables.put(paramSolverVariable3, -1.0F);
    return this;
  }
  
  public ArrayRow createRowLowerThan(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, int paramInt)
  {
    int i = 0;
    int j = 0;
    if (paramInt != 0)
    {
      i = j;
      j = paramInt;
      if (paramInt < 0)
      {
        j = paramInt * -1;
        i = 1;
      }
      this.constantValue = j;
    }
    if (i == 0)
    {
      this.variables.put(paramSolverVariable1, -1.0F);
      this.variables.put(paramSolverVariable2, 1.0F);
      this.variables.put(paramSolverVariable3, -1.0F);
      return this;
    }
    this.variables.put(paramSolverVariable1, 1.0F);
    this.variables.put(paramSolverVariable2, -1.0F);
    this.variables.put(paramSolverVariable3, 1.0F);
    return this;
  }
  
  public ArrayRow createRowWithAngle(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, float paramFloat)
  {
    this.variables.put(paramSolverVariable3, 0.5F);
    this.variables.put(paramSolverVariable4, 0.5F);
    this.variables.put(paramSolverVariable1, -0.5F);
    this.variables.put(paramSolverVariable2, -0.5F);
    this.constantValue = (-paramFloat);
    return this;
  }
  
  void ensurePositiveConstant()
  {
    float f = this.constantValue;
    if (f < 0.0F)
    {
      this.constantValue = (f * -1.0F);
      this.variables.invert();
    }
  }
  
  public SolverVariable getKey()
  {
    return this.variable;
  }
  
  public SolverVariable getPivotCandidate(LinearSystem paramLinearSystem, boolean[] paramArrayOfBoolean)
  {
    return pickPivotInVariables(paramArrayOfBoolean, null);
  }
  
  boolean hasKeyVariable()
  {
    SolverVariable localSolverVariable = this.variable;
    return (localSolverVariable != null) && ((localSolverVariable.mType == SolverVariable.Type.UNRESTRICTED) || (this.constantValue >= 0.0F));
  }
  
  boolean hasVariable(SolverVariable paramSolverVariable)
  {
    return this.variables.contains(paramSolverVariable);
  }
  
  public void initFromRow(LinearSystem.Row paramRow)
  {
    if ((paramRow instanceof ArrayRow))
    {
      paramRow = (ArrayRow)paramRow;
      this.variable = null;
      this.variables.clear();
      int i = 0;
      while (i < paramRow.variables.getCurrentSize())
      {
        SolverVariable localSolverVariable = paramRow.variables.getVariable(i);
        float f = paramRow.variables.getVariableValue(i);
        this.variables.add(localSolverVariable, f, true);
        i += 1;
      }
    }
  }
  
  public boolean isEmpty()
  {
    return (this.variable == null) && (this.constantValue == 0.0F) && (this.variables.getCurrentSize() == 0);
  }
  
  public SolverVariable pickPivot(SolverVariable paramSolverVariable)
  {
    return pickPivotInVariables(null, paramSolverVariable);
  }
  
  void pivot(SolverVariable paramSolverVariable)
  {
    SolverVariable localSolverVariable = this.variable;
    if (localSolverVariable != null)
    {
      this.variables.put(localSolverVariable, -1.0F);
      this.variable.definitionId = -1;
      this.variable = null;
    }
    float f = this.variables.remove(paramSolverVariable, true) * -1.0F;
    this.variable = paramSolverVariable;
    if (f == 1.0F) {
      return;
    }
    this.constantValue /= f;
    this.variables.divideByAmount(f);
  }
  
  public void reset()
  {
    this.variable = null;
    this.variables.clear();
    this.constantValue = 0.0F;
    this.isSimpleDefinition = false;
  }
  
  int sizeInBytes()
  {
    int i;
    if (this.variable != null) {
      i = 4;
    } else {
      i = 0;
    }
    return i + 4 + 4 + this.variables.sizeInBytes();
  }
  
  String toReadableString()
  {
    if (this.variable == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append("0");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(this.variable);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" = ");
    Object localObject1 = ((StringBuilder)localObject2).toString();
    float f1 = this.constantValue;
    int j = 0;
    int i;
    if (f1 != 0.0F)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(this.constantValue);
      localObject1 = ((StringBuilder)localObject2).toString();
      i = 1;
    }
    else
    {
      i = 0;
    }
    int k = this.variables.getCurrentSize();
    while (j < k)
    {
      localObject2 = this.variables.getVariable(j);
      if (localObject2 != null)
      {
        float f2 = this.variables.getVariableValue(j);
        if (f2 != 0.0F)
        {
          String str = ((SolverVariable)localObject2).toString();
          if (i == 0)
          {
            localObject2 = localObject1;
            f1 = f2;
            if (f2 >= 0.0F) {
              break label361;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append("- ");
            localObject2 = ((StringBuilder)localObject2).toString();
          }
          else
          {
            if (f2 > 0.0F)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append(" + ");
              localObject2 = ((StringBuilder)localObject2).toString();
              f1 = f2;
              break label361;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(" - ");
            localObject2 = ((StringBuilder)localObject2).toString();
          }
          f1 = f2 * -1.0F;
          label361:
          if (f1 == 1.0F)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append(str);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append(f1);
            ((StringBuilder)localObject1).append(" ");
            ((StringBuilder)localObject1).append(str);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          i = 1;
        }
      }
      j += 1;
    }
    localObject2 = localObject1;
    if (i == 0)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("0.0");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return localObject2;
  }
  
  public String toString()
  {
    return toReadableString();
  }
  
  public void updateFromFinalVariable(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable, boolean paramBoolean)
  {
    if (!paramSolverVariable.isFinalValue) {
      return;
    }
    float f = this.variables.get(paramSolverVariable);
    this.constantValue += paramSolverVariable.computedValue * f;
    this.variables.remove(paramSolverVariable, paramBoolean);
    if (paramBoolean) {
      paramSolverVariable.removeFromRow(this);
    }
    if ((LinearSystem.SIMPLIFY_SYNONYMS) && (paramSolverVariable != null) && (this.variables.getCurrentSize() == 0))
    {
      this.isSimpleDefinition = true;
      paramLinearSystem.hasSimpleDefinition = true;
    }
  }
  
  public void updateFromRow(LinearSystem paramLinearSystem, ArrayRow paramArrayRow, boolean paramBoolean)
  {
    float f = this.variables.use(paramArrayRow, paramBoolean);
    this.constantValue += paramArrayRow.constantValue * f;
    if (paramBoolean) {
      paramArrayRow.variable.removeFromRow(this);
    }
    if ((LinearSystem.SIMPLIFY_SYNONYMS) && (this.variable != null) && (this.variables.getCurrentSize() == 0))
    {
      this.isSimpleDefinition = true;
      paramLinearSystem.hasSimpleDefinition = true;
    }
  }
  
  public void updateFromSynonymVariable(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable, boolean paramBoolean)
  {
    if (!paramSolverVariable.isSynonym) {
      return;
    }
    float f = this.variables.get(paramSolverVariable);
    this.constantValue += paramSolverVariable.synonymDelta * f;
    this.variables.remove(paramSolverVariable, paramBoolean);
    if (paramBoolean) {
      paramSolverVariable.removeFromRow(this);
    }
    this.variables.add(paramLinearSystem.mCache.mIndexedVariables[paramSolverVariable.synonym], f, paramBoolean);
    if ((LinearSystem.SIMPLIFY_SYNONYMS) && (paramSolverVariable != null) && (this.variables.getCurrentSize() == 0))
    {
      this.isSimpleDefinition = true;
      paramLinearSystem.hasSimpleDefinition = true;
    }
  }
  
  public void updateFromSystem(LinearSystem paramLinearSystem)
  {
    if (paramLinearSystem.mRows.length == 0) {
      return;
    }
    int i = 0;
    while (i == 0)
    {
      int k = this.variables.getCurrentSize();
      int j = 0;
      SolverVariable localSolverVariable;
      while (j < k)
      {
        localSolverVariable = this.variables.getVariable(j);
        if ((localSolverVariable.definitionId != -1) || (localSolverVariable.isFinalValue) || (localSolverVariable.isSynonym)) {
          this.variablesToUpdate.add(localSolverVariable);
        }
        j += 1;
      }
      k = this.variablesToUpdate.size();
      if (k > 0)
      {
        j = 0;
        while (j < k)
        {
          localSolverVariable = (SolverVariable)this.variablesToUpdate.get(j);
          if (localSolverVariable.isFinalValue) {
            updateFromFinalVariable(paramLinearSystem, localSolverVariable, true);
          } else if (localSolverVariable.isSynonym) {
            updateFromSynonymVariable(paramLinearSystem, localSolverVariable, true);
          } else {
            updateFromRow(paramLinearSystem, paramLinearSystem.mRows[localSolverVariable.definitionId], true);
          }
          j += 1;
        }
        this.variablesToUpdate.clear();
      }
      else
      {
        i = 1;
      }
    }
    if ((LinearSystem.SIMPLIFY_SYNONYMS) && (this.variable != null) && (this.variables.getCurrentSize() == 0))
    {
      this.isSimpleDefinition = true;
      paramLinearSystem.hasSimpleDefinition = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.solver.ArrayRow
 * JD-Core Version:    0.7.0.1
 */