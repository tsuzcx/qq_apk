package androidx.constraintlayout.solver;

import java.io.PrintStream;
import java.util.Arrays;

public class ArrayLinkedVariables
  implements ArrayRow.ArrayRowVariables
{
  private static final boolean DEBUG = false;
  private static final boolean FULL_NEW_CHECK = false;
  static final int NONE = -1;
  private static float epsilon = 0.001F;
  private int ROW_SIZE = 8;
  private SolverVariable candidate = null;
  int currentSize = 0;
  private int[] mArrayIndices;
  private int[] mArrayNextIndices;
  private float[] mArrayValues;
  protected final Cache mCache;
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
  
  public void add(SolverVariable paramSolverVariable, float paramFloat, boolean paramBoolean)
  {
    float f1 = epsilon;
    if ((paramFloat > -f1) && (paramFloat < f1)) {
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
      paramSolverVariable.usageInRowCount += 1;
      paramSolverVariable.addToRow(this.mRow);
      this.currentSize += 1;
      if (!this.mDidFillOnce)
      {
        this.mLast += 1;
        i = this.mLast;
        paramSolverVariable = this.mArrayIndices;
        if (i >= paramSolverVariable.length)
        {
          this.mDidFillOnce = true;
          this.mLast = (paramSolverVariable.length - 1);
        }
      }
      return;
    }
    int j = 0;
    int m = -1;
    while ((i != -1) && (j < this.currentSize))
    {
      if (this.mArrayIndices[i] == paramSolverVariable.id)
      {
        f1 = this.mArrayValues[i] + paramFloat;
        float f2 = epsilon;
        paramFloat = f1;
        if (f1 > -f2)
        {
          paramFloat = f1;
          if (f1 < f2) {
            paramFloat = 0.0F;
          }
        }
        this.mArrayValues[i] = paramFloat;
        if (paramFloat == 0.0F)
        {
          if (i == this.mHead)
          {
            this.mHead = this.mArrayNextIndices[i];
          }
          else
          {
            localObject = this.mArrayNextIndices;
            localObject[m] = localObject[i];
          }
          if (paramBoolean) {
            paramSolverVariable.removeFromRow(this.mRow);
          }
          if (this.mDidFillOnce) {
            this.mLast = i;
          }
          paramSolverVariable.usageInRowCount -= 1;
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
      localObject = this.mArrayNextIndices;
      localObject[i] = localObject[m];
      localObject[m] = i;
    }
    else
    {
      this.mArrayNextIndices[i] = this.mHead;
      this.mHead = i;
    }
    paramSolverVariable.usageInRowCount += 1;
    paramSolverVariable.addToRow(this.mRow);
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
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      SolverVariable localSolverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[j]];
      if (localSolverVariable != null) {
        localSolverVariable.removeFromRow(this.mRow);
      }
      j = this.mArrayNextIndices[j];
      i += 1;
    }
    this.mHead = -1;
    this.mLast = -1;
    this.mDidFillOnce = false;
    this.currentSize = 0;
  }
  
  public boolean contains(SolverVariable paramSolverVariable)
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
  
  public void divideByAmount(float paramFloat)
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
  
  public int getCurrentSize()
  {
    return this.currentSize;
  }
  
  public int getHead()
  {
    return this.mHead;
  }
  
  public final int getId(int paramInt)
  {
    return this.mArrayIndices[paramInt];
  }
  
  public final int getNextIndice(int paramInt)
  {
    return this.mArrayNextIndices[paramInt];
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
  
  public final float getValue(int paramInt)
  {
    return this.mArrayValues[paramInt];
  }
  
  public SolverVariable getVariable(int paramInt)
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
  
  public float getVariableValue(int paramInt)
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
  
  public int indexOf(SolverVariable paramSolverVariable)
  {
    int j = this.mHead;
    if (j == -1) {
      return -1;
    }
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      if (this.mArrayIndices[j] == paramSolverVariable.id) {
        return j;
      }
      j = this.mArrayNextIndices[j];
      i += 1;
    }
    return -1;
  }
  
  public void invert()
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
  
  public final void put(SolverVariable paramSolverVariable, float paramFloat)
  {
    if (paramFloat == 0.0F)
    {
      remove(paramSolverVariable, true);
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
      paramSolverVariable.usageInRowCount += 1;
      paramSolverVariable.addToRow(this.mRow);
      this.currentSize += 1;
      if (!this.mDidFillOnce)
      {
        this.mLast += 1;
        i = this.mLast;
        paramSolverVariable = this.mArrayIndices;
        if (i >= paramSolverVariable.length)
        {
          this.mDidFillOnce = true;
          this.mLast = (paramSolverVariable.length - 1);
        }
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
      localObject = this.mArrayNextIndices;
      localObject[i] = localObject[m];
      localObject[m] = i;
    }
    else
    {
      this.mArrayNextIndices[i] = this.mHead;
      this.mHead = i;
    }
    paramSolverVariable.usageInRowCount += 1;
    paramSolverVariable.addToRow(this.mRow);
    this.currentSize += 1;
    if (!this.mDidFillOnce) {
      this.mLast += 1;
    }
    if (this.currentSize >= this.mArrayIndices.length) {
      this.mDidFillOnce = true;
    }
    i = this.mLast;
    paramSolverVariable = this.mArrayIndices;
    if (i >= paramSolverVariable.length)
    {
      this.mDidFillOnce = true;
      this.mLast = (paramSolverVariable.length - 1);
    }
  }
  
  public final float remove(SolverVariable paramSolverVariable, boolean paramBoolean)
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
      if (this.mArrayIndices[i] == paramSolverVariable.id)
      {
        if (i == this.mHead)
        {
          this.mHead = this.mArrayNextIndices[i];
        }
        else
        {
          int[] arrayOfInt = this.mArrayNextIndices;
          arrayOfInt[k] = arrayOfInt[i];
        }
        if (paramBoolean) {
          paramSolverVariable.removeFromRow(this.mRow);
        }
        paramSolverVariable.usageInRowCount -= 1;
        this.currentSize -= 1;
        this.mArrayIndices[i] = -1;
        if (this.mDidFillOnce) {
          this.mLast = i;
        }
        return this.mArrayValues[i];
      }
      int m = this.mArrayNextIndices[i];
      j += 1;
      k = i;
      i = m;
    }
    return 0.0F;
  }
  
  public int sizeInBytes()
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
  
  public float use(ArrayRow paramArrayRow, boolean paramBoolean)
  {
    float f = get(paramArrayRow.variable);
    remove(paramArrayRow.variable, paramBoolean);
    paramArrayRow = paramArrayRow.variables;
    int j = paramArrayRow.getCurrentSize();
    int i = 0;
    while (i < j)
    {
      SolverVariable localSolverVariable = paramArrayRow.getVariable(i);
      add(localSolverVariable, paramArrayRow.get(localSolverVariable) * f, paramBoolean);
      i += 1;
    }
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.solver.ArrayLinkedVariables
 * JD-Core Version:    0.7.0.1
 */