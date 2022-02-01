package android.support.constraint.solver;

import java.io.PrintStream;
import java.util.Arrays;

public class ArrayLinkedVariables
{
  private static final boolean DEBUG = false;
  private static final int NONE = -1;
  private int ROW_SIZE = 8;
  private SolverVariable candidate = null;
  int currentSize = 0;
  private int[] mArrayIndices;
  private int[] mArrayNextIndices;
  private float[] mArrayValues;
  private final Cache mCache;
  private boolean mDidFillOnce;
  private int mHead;
  private int mLast;
  private final ArrayRow mRow;
  
  ArrayLinkedVariables(ArrayRow paramArrayRow, Cache paramCache)
  {
    int i = this.ROW_SIZE;
    this.mArrayIndices = new int[i];
    this.mArrayNextIndices = new int[i];
    this.mArrayValues = new float[i];
    this.mHead = -1;
    this.mLast = -1;
    this.mDidFillOnce = false;
    this.mRow = paramArrayRow;
    this.mCache = paramCache;
  }
  
  public final void add(SolverVariable paramSolverVariable, float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return;
    }
    int i = this.mHead;
    if (i == -1)
    {
      this.mHead = 0;
      localObject = this.mArrayValues;
      i = this.mHead;
      localObject[i] = paramFloat;
      this.mArrayIndices[i] = paramSolverVariable.id;
      this.mArrayNextIndices[this.mHead] = -1;
      this.currentSize += 1;
      if (!this.mDidFillOnce) {
        this.mLast += 1;
      }
      return;
    }
    int j = 0;
    int m = -1;
    int k;
    while ((i != -1) && (j < this.currentSize))
    {
      k = this.mArrayIndices[i];
      if (k == paramSolverVariable.id)
      {
        paramSolverVariable = this.mArrayValues;
        paramSolverVariable[i] += paramFloat;
        if (paramSolverVariable[i] == 0.0F)
        {
          if (i == this.mHead)
          {
            this.mHead = this.mArrayNextIndices[i];
          }
          else
          {
            paramSolverVariable = this.mArrayNextIndices;
            paramSolverVariable[m] = paramSolverVariable[i];
          }
          this.mCache.mIndexedVariables[k].removeClientEquation(this.mRow);
          if (this.mDidFillOnce) {
            this.mLast = i;
          }
          this.currentSize -= 1;
        }
        return;
      }
      if (this.mArrayIndices[i] < paramSolverVariable.id) {
        m = i;
      }
      i = this.mArrayNextIndices[i];
      j += 1;
    }
    i = this.mLast;
    if (this.mDidFillOnce)
    {
      localObject = this.mArrayIndices;
      if (localObject[i] != -1) {
        i = localObject.length;
      }
    }
    else
    {
      i += 1;
    }
    Object localObject = this.mArrayIndices;
    j = i;
    if (i >= localObject.length)
    {
      j = i;
      if (this.currentSize < localObject.length)
      {
        k = 0;
        for (;;)
        {
          localObject = this.mArrayIndices;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          if (localObject[k] == -1)
          {
            j = k;
            break;
          }
          k += 1;
        }
      }
    }
    localObject = this.mArrayIndices;
    i = j;
    if (j >= localObject.length)
    {
      i = localObject.length;
      this.ROW_SIZE *= 2;
      this.mDidFillOnce = false;
      this.mLast = (i - 1);
      this.mArrayValues = Arrays.copyOf(this.mArrayValues, this.ROW_SIZE);
      this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
      this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
    }
    this.mArrayIndices[i] = paramSolverVariable.id;
    this.mArrayValues[i] = paramFloat;
    if (m != -1)
    {
      paramSolverVariable = this.mArrayNextIndices;
      paramSolverVariable[i] = paramSolverVariable[m];
      paramSolverVariable[m] = i;
    }
    else
    {
      this.mArrayNextIndices[i] = this.mHead;
      this.mHead = i;
    }
    this.currentSize += 1;
    if (!this.mDidFillOnce) {
      this.mLast += 1;
    }
    i = this.mLast;
    paramSolverVariable = this.mArrayIndices;
    if (i >= paramSolverVariable.length)
    {
      this.mDidFillOnce = true;
      this.mLast = (paramSolverVariable.length - 1);
    }
  }
  
  public final void clear()
  {
    this.mHead = -1;
    this.mLast = -1;
    this.mDidFillOnce = false;
    this.currentSize = 0;
  }
  
  final boolean containsKey(SolverVariable paramSolverVariable)
  {
    int j = this.mHead;
    if (j == -1) {
      return false;
    }
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      if (this.mArrayIndices[j] == paramSolverVariable.id) {
        return true;
      }
      j = this.mArrayNextIndices[j];
      i += 1;
    }
    return false;
  }
  
  public void display()
  {
    int j = this.currentSize;
    System.out.print("{ ");
    int i = 0;
    while (i < j)
    {
      SolverVariable localSolverVariable = getVariable(i);
      if (localSolverVariable != null)
      {
        PrintStream localPrintStream = System.out;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localSolverVariable);
        localStringBuilder.append(" = ");
        localStringBuilder.append(getVariableValue(i));
        localStringBuilder.append(" ");
        localPrintStream.print(localStringBuilder.toString());
      }
      i += 1;
    }
    System.out.println(" }");
  }
  
  void divideByAmount(float paramFloat)
  {
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      float[] arrayOfFloat = this.mArrayValues;
      arrayOfFloat[j] /= paramFloat;
      j = this.mArrayNextIndices[j];
      i += 1;
    }
  }
  
  public final float get(SolverVariable paramSolverVariable)
  {
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      if (this.mArrayIndices[j] == paramSolverVariable.id) {
        return this.mArrayValues[j];
      }
      j = this.mArrayNextIndices[j];
      i += 1;
    }
    return 0.0F;
  }
  
  SolverVariable getPivotCandidate()
  {
    Object localObject1 = this.candidate;
    if (localObject1 == null)
    {
      int j = this.mHead;
      int i = 0;
      Object localObject2;
      for (localObject1 = null; (j != -1) && (i < this.currentSize); localObject1 = localObject2)
      {
        localObject2 = localObject1;
        if (this.mArrayValues[j] < 0.0F)
        {
          SolverVariable localSolverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[j]];
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (((SolverVariable)localObject1).strength >= localSolverVariable.strength) {}
          }
          else
          {
            localObject2 = localSolverVariable;
          }
        }
        j = this.mArrayNextIndices[j];
        i += 1;
      }
      return localObject1;
    }
    return localObject1;
  }
  
  final SolverVariable getVariable(int paramInt)
  {
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      if (i == paramInt) {
        return this.mCache.mIndexedVariables[this.mArrayIndices[j]];
      }
      j = this.mArrayNextIndices[j];
      i += 1;
    }
    return null;
  }
  
  final float getVariableValue(int paramInt)
  {
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      if (i == paramInt) {
        return this.mArrayValues[j];
      }
      j = this.mArrayNextIndices[j];
      i += 1;
    }
    return 0.0F;
  }
  
  boolean hasAtLeastOnePositiveVariable()
  {
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      if (this.mArrayValues[j] > 0.0F) {
        return true;
      }
      j = this.mArrayNextIndices[j];
      i += 1;
    }
    return false;
  }
  
  void invert()
  {
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      float[] arrayOfFloat = this.mArrayValues;
      arrayOfFloat[j] *= -1.0F;
      j = this.mArrayNextIndices[j];
      i += 1;
    }
  }
  
  SolverVariable pickPivotCandidate()
  {
    int j = this.mHead;
    Object localObject2 = null;
    int i = 0;
    label81:
    Object localObject4;
    for (Object localObject1 = null; (j != -1) && (i < this.currentSize); localObject1 = localObject4)
    {
      Object localObject3 = this.mArrayValues;
      float f2 = localObject3[j];
      if (f2 < 0.0F)
      {
        f1 = f2;
        if (f2 <= -0.001F) {
          break label81;
        }
        localObject3[j] = 0.0F;
      }
      else
      {
        f1 = f2;
        if (f2 >= 0.001F) {
          break label81;
        }
        localObject3[j] = 0.0F;
      }
      float f1 = 0.0F;
      localObject3 = localObject2;
      localObject4 = localObject1;
      if (f1 != 0.0F)
      {
        SolverVariable localSolverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[j]];
        if (localSolverVariable.mType == SolverVariable.Type.UNRESTRICTED)
        {
          if (f1 < 0.0F) {
            return localSolverVariable;
          }
          localObject3 = localObject2;
          localObject4 = localObject1;
          if (localObject1 == null)
          {
            localObject4 = localSolverVariable;
            localObject3 = localObject2;
          }
        }
        else
        {
          localObject3 = localObject2;
          localObject4 = localObject1;
          if (f1 < 0.0F) {
            if (localObject2 != null)
            {
              localObject3 = localObject2;
              localObject4 = localObject1;
              if (localSolverVariable.strength >= localObject2.strength) {}
            }
            else
            {
              localObject3 = localSolverVariable;
              localObject4 = localObject1;
            }
          }
        }
      }
      j = this.mArrayNextIndices[j];
      i += 1;
      localObject2 = localObject3;
    }
    if (localObject1 != null) {
      return localObject1;
    }
    return localObject2;
  }
  
  public final void put(SolverVariable paramSolverVariable, float paramFloat)
  {
    if (paramFloat == 0.0F)
    {
      remove(paramSolverVariable);
      return;
    }
    int i = this.mHead;
    if (i == -1)
    {
      this.mHead = 0;
      localObject = this.mArrayValues;
      i = this.mHead;
      localObject[i] = paramFloat;
      this.mArrayIndices[i] = paramSolverVariable.id;
      this.mArrayNextIndices[this.mHead] = -1;
      this.currentSize += 1;
      if (!this.mDidFillOnce) {
        this.mLast += 1;
      }
      return;
    }
    int j = 0;
    int m = -1;
    while ((i != -1) && (j < this.currentSize))
    {
      if (this.mArrayIndices[i] == paramSolverVariable.id)
      {
        this.mArrayValues[i] = paramFloat;
        return;
      }
      if (this.mArrayIndices[i] < paramSolverVariable.id) {
        m = i;
      }
      i = this.mArrayNextIndices[i];
      j += 1;
    }
    i = this.mLast;
    if (this.mDidFillOnce)
    {
      localObject = this.mArrayIndices;
      if (localObject[i] != -1) {
        i = localObject.length;
      }
    }
    else
    {
      i += 1;
    }
    Object localObject = this.mArrayIndices;
    j = i;
    if (i >= localObject.length)
    {
      j = i;
      if (this.currentSize < localObject.length)
      {
        int k = 0;
        for (;;)
        {
          localObject = this.mArrayIndices;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          if (localObject[k] == -1)
          {
            j = k;
            break;
          }
          k += 1;
        }
      }
    }
    localObject = this.mArrayIndices;
    i = j;
    if (j >= localObject.length)
    {
      i = localObject.length;
      this.ROW_SIZE *= 2;
      this.mDidFillOnce = false;
      this.mLast = (i - 1);
      this.mArrayValues = Arrays.copyOf(this.mArrayValues, this.ROW_SIZE);
      this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
      this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
    }
    this.mArrayIndices[i] = paramSolverVariable.id;
    this.mArrayValues[i] = paramFloat;
    if (m != -1)
    {
      paramSolverVariable = this.mArrayNextIndices;
      paramSolverVariable[i] = paramSolverVariable[m];
      paramSolverVariable[m] = i;
    }
    else
    {
      this.mArrayNextIndices[i] = this.mHead;
      this.mHead = i;
    }
    this.currentSize += 1;
    if (!this.mDidFillOnce) {
      this.mLast += 1;
    }
    if (this.currentSize >= this.mArrayIndices.length) {
      this.mDidFillOnce = true;
    }
  }
  
  public final float remove(SolverVariable paramSolverVariable)
  {
    if (this.candidate == paramSolverVariable) {
      this.candidate = null;
    }
    int i = this.mHead;
    if (i == -1) {
      return 0.0F;
    }
    int j = 0;
    int k = -1;
    while ((i != -1) && (j < this.currentSize))
    {
      int m = this.mArrayIndices[i];
      if (m == paramSolverVariable.id)
      {
        if (i == this.mHead)
        {
          this.mHead = this.mArrayNextIndices[i];
        }
        else
        {
          paramSolverVariable = this.mArrayNextIndices;
          paramSolverVariable[k] = paramSolverVariable[i];
        }
        this.mCache.mIndexedVariables[m].removeClientEquation(this.mRow);
        this.currentSize -= 1;
        this.mArrayIndices[i] = -1;
        if (this.mDidFillOnce) {
          this.mLast = i;
        }
        return this.mArrayValues[i];
      }
      m = this.mArrayNextIndices[i];
      j += 1;
      k = i;
      i = m;
    }
    return 0.0F;
  }
  
  int sizeInBytes()
  {
    return this.mArrayIndices.length * 4 * 3 + 0 + 36;
  }
  
  public String toString()
  {
    int j = this.mHead;
    String str = "";
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(" -> ");
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(this.mArrayValues[j]);
      localStringBuilder.append(" : ");
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(this.mCache.mIndexedVariables[this.mArrayIndices[j]]);
      str = localStringBuilder.toString();
      j = this.mArrayNextIndices[j];
      i += 1;
    }
    return str;
  }
  
  void updateClientEquations(ArrayRow paramArrayRow)
  {
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      this.mCache.mIndexedVariables[this.mArrayIndices[j]].addClientEquation(paramArrayRow);
      j = this.mArrayNextIndices[j];
      i += 1;
    }
  }
  
  void updateFromRow(ArrayRow paramArrayRow1, ArrayRow paramArrayRow2)
  {
    int i = this.mHead;
    int j = 0;
    for (;;)
    {
      if ((i == -1) || (j >= this.currentSize)) {
        return;
      }
      if (this.mArrayIndices[i] == paramArrayRow2.variable.id)
      {
        float f = this.mArrayValues[i];
        remove(paramArrayRow2.variable);
        ArrayLinkedVariables localArrayLinkedVariables = paramArrayRow2.variables;
        j = localArrayLinkedVariables.mHead;
        i = 0;
        while ((j != -1) && (i < localArrayLinkedVariables.currentSize))
        {
          add(this.mCache.mIndexedVariables[localArrayLinkedVariables.mArrayIndices[j]], localArrayLinkedVariables.mArrayValues[j] * f);
          j = localArrayLinkedVariables.mArrayNextIndices[j];
          i += 1;
        }
        paramArrayRow1.constantValue += paramArrayRow2.constantValue * f;
        paramArrayRow2.variable.removeClientEquation(paramArrayRow1);
        i = this.mHead;
        break;
      }
      i = this.mArrayNextIndices[i];
      j += 1;
    }
  }
  
  void updateFromSystem(ArrayRow paramArrayRow, ArrayRow[] paramArrayOfArrayRow)
  {
    int i = this.mHead;
    int j = 0;
    for (;;)
    {
      if ((i == -1) || (j >= this.currentSize)) {
        return;
      }
      Object localObject = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
      if (((SolverVariable)localObject).definitionId != -1)
      {
        float f = this.mArrayValues[i];
        remove((SolverVariable)localObject);
        localObject = paramArrayOfArrayRow[localObject.definitionId];
        if (!((ArrayRow)localObject).isSimpleDefinition)
        {
          ArrayLinkedVariables localArrayLinkedVariables = ((ArrayRow)localObject).variables;
          j = localArrayLinkedVariables.mHead;
          i = 0;
          while ((j != -1) && (i < localArrayLinkedVariables.currentSize))
          {
            add(this.mCache.mIndexedVariables[localArrayLinkedVariables.mArrayIndices[j]], localArrayLinkedVariables.mArrayValues[j] * f);
            j = localArrayLinkedVariables.mArrayNextIndices[j];
            i += 1;
          }
        }
        paramArrayRow.constantValue += ((ArrayRow)localObject).constantValue * f;
        ((ArrayRow)localObject).variable.removeClientEquation(paramArrayRow);
        i = this.mHead;
        break;
      }
      i = this.mArrayNextIndices[i];
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.constraint.solver.ArrayLinkedVariables
 * JD-Core Version:    0.7.0.1
 */