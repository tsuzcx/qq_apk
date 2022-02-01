package androidx.constraintlayout.solver;

import java.util.Arrays;
import java.util.HashSet;

public class SolverVariable
{
  private static final boolean INTERNAL_DEBUG = false;
  static final int MAX_STRENGTH = 9;
  public static final int STRENGTH_BARRIER = 6;
  public static final int STRENGTH_CENTERING = 7;
  public static final int STRENGTH_EQUALITY = 5;
  public static final int STRENGTH_FIXED = 8;
  public static final int STRENGTH_HIGH = 3;
  public static final int STRENGTH_HIGHEST = 4;
  public static final int STRENGTH_LOW = 1;
  public static final int STRENGTH_MEDIUM = 2;
  public static final int STRENGTH_NONE = 0;
  private static final boolean VAR_USE_HASH = false;
  private static int uniqueConstantId = 1;
  private static int uniqueErrorId = 1;
  private static int uniqueId = 1;
  private static int uniqueSlackId = 1;
  private static int uniqueUnrestrictedId = 1;
  public float computedValue;
  int definitionId = -1;
  float[] goalStrengthVector = new float[9];
  public int id = -1;
  public boolean inGoal;
  HashSet<ArrayRow> inRows = null;
  public boolean isFinalValue = false;
  boolean isSynonym = false;
  ArrayRow[] mClientEquations = new ArrayRow[16];
  int mClientEquationsCount = 0;
  private String mName;
  SolverVariable.Type mType;
  public int strength = 0;
  float[] strengthVector = new float[9];
  int synonym = -1;
  float synonymDelta = 0.0F;
  public int usageInRowCount = 0;
  
  public SolverVariable(SolverVariable.Type paramType, String paramString)
  {
    this.mType = paramType;
  }
  
  public SolverVariable(String paramString, SolverVariable.Type paramType)
  {
    this.mName = paramString;
    this.mType = paramType;
  }
  
  private static String getUniqueName(SolverVariable.Type paramType, String paramString)
  {
    if (paramString != null)
    {
      paramType = new StringBuilder();
      paramType.append(paramString);
      paramType.append(uniqueErrorId);
      return paramType.toString();
    }
    int i = SolverVariable.1.$SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[paramType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i == 5)
            {
              paramType = new StringBuilder();
              paramType.append("V");
              i = uniqueId + 1;
              uniqueId = i;
              paramType.append(i);
              return paramType.toString();
            }
            throw new AssertionError(paramType.name());
          }
          paramType = new StringBuilder();
          paramType.append("e");
          i = uniqueErrorId + 1;
          uniqueErrorId = i;
          paramType.append(i);
          return paramType.toString();
        }
        paramType = new StringBuilder();
        paramType.append("S");
        i = uniqueSlackId + 1;
        uniqueSlackId = i;
        paramType.append(i);
        return paramType.toString();
      }
      paramType = new StringBuilder();
      paramType.append("C");
      i = uniqueConstantId + 1;
      uniqueConstantId = i;
      paramType.append(i);
      return paramType.toString();
    }
    paramType = new StringBuilder();
    paramType.append("U");
    i = uniqueUnrestrictedId + 1;
    uniqueUnrestrictedId = i;
    paramType.append(i);
    return paramType.toString();
  }
  
  static void increaseErrorId()
  {
    uniqueErrorId += 1;
  }
  
  public final void addToRow(ArrayRow paramArrayRow)
  {
    int i = 0;
    int j;
    for (;;)
    {
      j = this.mClientEquationsCount;
      if (i >= j) {
        break;
      }
      if (this.mClientEquations[i] == paramArrayRow) {
        return;
      }
      i += 1;
    }
    ArrayRow[] arrayOfArrayRow = this.mClientEquations;
    if (j >= arrayOfArrayRow.length) {
      this.mClientEquations = ((ArrayRow[])Arrays.copyOf(arrayOfArrayRow, arrayOfArrayRow.length * 2));
    }
    arrayOfArrayRow = this.mClientEquations;
    i = this.mClientEquationsCount;
    arrayOfArrayRow[i] = paramArrayRow;
    this.mClientEquationsCount = (i + 1);
  }
  
  void clearStrengths()
  {
    int i = 0;
    while (i < 9)
    {
      this.strengthVector[i] = 0.0F;
      i += 1;
    }
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public final void removeFromRow(ArrayRow paramArrayRow)
  {
    int k = this.mClientEquationsCount;
    int i = 0;
    while (i < k)
    {
      if (this.mClientEquations[i] == paramArrayRow)
      {
        while (i < k - 1)
        {
          paramArrayRow = this.mClientEquations;
          int j = i + 1;
          paramArrayRow[i] = paramArrayRow[j];
          i = j;
        }
        this.mClientEquationsCount -= 1;
        return;
      }
      i += 1;
    }
  }
  
  public void reset()
  {
    this.mName = null;
    this.mType = SolverVariable.Type.UNKNOWN;
    this.strength = 0;
    this.id = -1;
    this.definitionId = -1;
    this.computedValue = 0.0F;
    this.isFinalValue = false;
    this.isSynonym = false;
    this.synonym = -1;
    this.synonymDelta = 0.0F;
    int j = this.mClientEquationsCount;
    int i = 0;
    while (i < j)
    {
      this.mClientEquations[i] = null;
      i += 1;
    }
    this.mClientEquationsCount = 0;
    this.usageInRowCount = 0;
    this.inGoal = false;
    Arrays.fill(this.goalStrengthVector, 0.0F);
  }
  
  public void setFinalValue(LinearSystem paramLinearSystem, float paramFloat)
  {
    this.computedValue = paramFloat;
    this.isFinalValue = true;
    this.isSynonym = false;
    this.synonym = -1;
    this.synonymDelta = 0.0F;
    int j = this.mClientEquationsCount;
    this.definitionId = -1;
    int i = 0;
    while (i < j)
    {
      this.mClientEquations[i].updateFromFinalVariable(paramLinearSystem, this, false);
      i += 1;
    }
    this.mClientEquationsCount = 0;
  }
  
  public void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public void setSynonym(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable, float paramFloat)
  {
    this.isSynonym = true;
    this.synonym = paramSolverVariable.id;
    this.synonymDelta = paramFloat;
    int j = this.mClientEquationsCount;
    this.definitionId = -1;
    int i = 0;
    while (i < j)
    {
      this.mClientEquations[i].updateFromSynonymVariable(paramLinearSystem, this, false);
      i += 1;
    }
    this.mClientEquationsCount = 0;
    paramLinearSystem.displayReadableRows();
  }
  
  public void setType(SolverVariable.Type paramType, String paramString)
  {
    this.mType = paramType;
  }
  
  String strengthsToString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this);
    ((StringBuilder)localObject1).append("[");
    localObject1 = ((StringBuilder)localObject1).toString();
    int j = 0;
    int i = 0;
    int k = 1;
    while (j < this.strengthVector.length)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(this.strengthVector[j]);
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = this.strengthVector;
      if (localObject2[j] > 0.0F) {
        i = 0;
      } else if (localObject2[j] < 0.0F) {
        i = 1;
      }
      if (this.strengthVector[j] != 0.0F) {
        k = 0;
      }
      if (j < this.strengthVector.length - 1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(", ");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("] ");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      j += 1;
    }
    Object localObject2 = localObject1;
    if (i != 0)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" (-)");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    localObject1 = localObject2;
    if (k != 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(" (*)");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    return localObject1;
  }
  
  public String toString()
  {
    if (this.mName != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.mName);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.id);
    return localStringBuilder.toString();
  }
  
  public final void updateReferencesWithNewDefinition(LinearSystem paramLinearSystem, ArrayRow paramArrayRow)
  {
    int j = this.mClientEquationsCount;
    int i = 0;
    while (i < j)
    {
      this.mClientEquations[i].updateFromRow(paramLinearSystem, paramArrayRow, false);
      i += 1;
    }
    this.mClientEquationsCount = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.solver.SolverVariable
 * JD-Core Version:    0.7.0.1
 */