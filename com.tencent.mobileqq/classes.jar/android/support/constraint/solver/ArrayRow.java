package android.support.constraint.solver;

public class ArrayRow
{
  private static final boolean DEBUG = false;
  float constantValue = 0.0F;
  boolean isSimpleDefinition = false;
  boolean used = false;
  SolverVariable variable = null;
  final ArrayLinkedVariables variables;
  
  public ArrayRow(Cache paramCache)
  {
    this.variables = new ArrayLinkedVariables(this, paramCache);
  }
  
  public ArrayRow addError(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2)
  {
    this.variables.put(paramSolverVariable1, 1.0F);
    this.variables.put(paramSolverVariable2, -1.0F);
    return this;
  }
  
  ArrayRow addSingleError(SolverVariable paramSolverVariable, int paramInt)
  {
    this.variables.put(paramSolverVariable, paramInt);
    return this;
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
        this.variables.put(paramSolverVariable3, -1.0F);
        this.variables.put(paramSolverVariable4, 1.0F);
        this.constantValue = paramInt2;
        return this;
      }
      ArrayLinkedVariables localArrayLinkedVariables = this.variables;
      float f = 1.0F - paramFloat;
      localArrayLinkedVariables.put(paramSolverVariable1, f * 1.0F);
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
  
  ArrayRow createRowDimensionPercent(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, float paramFloat)
  {
    this.variables.put(paramSolverVariable1, -1.0F);
    this.variables.put(paramSolverVariable2, 1.0F - paramFloat);
    this.variables.put(paramSolverVariable3, paramFloat);
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
  
  void ensurePositiveConstant()
  {
    float f = this.constantValue;
    if (f < 0.0F)
    {
      this.constantValue = (f * -1.0F);
      this.variables.invert();
    }
  }
  
  boolean hasAtLeastOnePositiveVariable()
  {
    return this.variables.hasAtLeastOnePositiveVariable();
  }
  
  boolean hasKeyVariable()
  {
    SolverVariable localSolverVariable = this.variable;
    return (localSolverVariable != null) && ((localSolverVariable.mType == SolverVariable.Type.UNRESTRICTED) || (this.constantValue >= 0.0F));
  }
  
  boolean hasVariable(SolverVariable paramSolverVariable)
  {
    return this.variables.containsKey(paramSolverVariable);
  }
  
  void pickRowVariable()
  {
    SolverVariable localSolverVariable = this.variables.pickPivotCandidate();
    if (localSolverVariable != null) {
      pivot(localSolverVariable);
    }
    if (this.variables.currentSize == 0) {
      this.isSimpleDefinition = true;
    }
  }
  
  void pivot(SolverVariable paramSolverVariable)
  {
    SolverVariable localSolverVariable = this.variable;
    if (localSolverVariable != null)
    {
      this.variables.put(localSolverVariable, -1.0F);
      this.variable = null;
    }
    float f = this.variables.remove(paramSolverVariable) * -1.0F;
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
    int k = this.variables.currentSize;
    while (j < k)
    {
      localObject2 = this.variables.getVariable(j);
      if (localObject2 != null)
      {
        float f2 = this.variables.getVariableValue(j);
        String str = ((SolverVariable)localObject2).toString();
        if (i == 0)
        {
          localObject2 = localObject1;
          f1 = f2;
          if (f2 >= 0.0F) {
            break label346;
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
            break label346;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(" - ");
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        f1 = f2 * -1.0F;
        label346:
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
  
  void updateClientEquations()
  {
    this.variables.updateClientEquations(this);
  }
  
  boolean updateRowWithEquation(ArrayRow paramArrayRow)
  {
    this.variables.updateFromRow(this, paramArrayRow);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.constraint.solver.ArrayRow
 * JD-Core Version:    0.7.0.1
 */