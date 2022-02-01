package android.support.constraint.solver;

import java.util.Arrays;

public class SolverVariable
{
  private static final boolean INTERNAL_DEBUG = false;
  static final int MAX_STRENGTH = 6;
  public static final int STRENGTH_EQUALITY = 5;
  public static final int STRENGTH_HIGH = 3;
  public static final int STRENGTH_HIGHEST = 4;
  public static final int STRENGTH_LOW = 1;
  public static final int STRENGTH_MEDIUM = 2;
  public static final int STRENGTH_NONE = 0;
  private static int uniqueId = 1;
  public float computedValue;
  int definitionId = -1;
  public int id = -1;
  ArrayRow[] mClientEquations = new ArrayRow[8];
  int mClientEquationsCount = 0;
  private String mName;
  SolverVariable.Type mType;
  public int strength = 0;
  float[] strengthVector = new float[6];
  
  public SolverVariable(SolverVariable.Type paramType)
  {
    this.mType = paramType;
  }
  
  public SolverVariable(String paramString, SolverVariable.Type paramType)
  {
    this.mName = paramString;
    this.mType = paramType;
  }
  
  private static String getUniqueName(SolverVariable.Type paramType)
  {
    uniqueId += 1;
    int i = SolverVariable.1.$SwitchMap$android$support$constraint$solver$SolverVariable$Type[paramType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            paramType = new StringBuilder();
            paramType.append("V");
            paramType.append(uniqueId);
            return paramType.toString();
          }
          paramType = new StringBuilder();
          paramType.append("e");
          paramType.append(uniqueId);
          return paramType.toString();
        }
        paramType = new StringBuilder();
        paramType.append("S");
        paramType.append(uniqueId);
        return paramType.toString();
      }
      paramType = new StringBuilder();
      paramType.append("C");
      paramType.append(uniqueId);
      return paramType.toString();
    }
    paramType = new StringBuilder();
    paramType.append("U");
    paramType.append(uniqueId);
    return paramType.toString();
  }
  
  void addClientEquation(ArrayRow paramArrayRow)
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
    while (i < 6)
    {
      this.strengthVector[i] = 0.0F;
      i += 1;
    }
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  void removeClientEquation(ArrayRow paramArrayRow)
  {
    int j = 0;
    int i = 0;
    while (i < this.mClientEquationsCount)
    {
      if (this.mClientEquations[i] == paramArrayRow)
      {
        int k;
        for (;;)
        {
          k = this.mClientEquationsCount;
          if (j >= k - i - 1) {
            break;
          }
          paramArrayRow = this.mClientEquations;
          k = i + j;
          paramArrayRow[k] = paramArrayRow[(k + 1)];
          j += 1;
        }
        this.mClientEquationsCount = (k - 1);
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
    this.mClientEquationsCount = 0;
  }
  
  public void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public void setType(SolverVariable.Type paramType)
  {
    this.mType = paramType;
  }
  
  String strengthsToString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append("[");
    localObject = ((StringBuilder)localObject).toString();
    int i = 0;
    while (i < this.strengthVector.length)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(this.strengthVector[i]);
      localObject = localStringBuilder.toString();
      if (i < this.strengthVector.length - 1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(", ");
        localObject = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("] ");
        localObject = localStringBuilder.toString();
      }
      i += 1;
    }
    return localObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.mName);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.constraint.solver.SolverVariable
 * JD-Core Version:    0.7.0.1
 */