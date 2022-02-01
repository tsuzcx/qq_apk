package androidx.constraintlayout.solver;

import java.io.PrintStream;
import java.util.Arrays;

public class SolverVariableValues
  implements ArrayRow.ArrayRowVariables
{
  private static final boolean DEBUG = false;
  private static final boolean HASH = true;
  private static float epsilon = 0.001F;
  private int HASH_SIZE = 16;
  private final int NONE = -1;
  private int SIZE = 16;
  int head;
  int[] keys;
  protected final Cache mCache;
  int mCount;
  private final ArrayRow mRow;
  int[] next;
  int[] nextKeys;
  int[] previous;
  float[] values;
  int[] variables;
  
  SolverVariableValues(ArrayRow paramArrayRow, Cache paramCache)
  {
    int i = this.SIZE;
    this.keys = new int[i];
    this.nextKeys = new int[i];
    this.variables = new int[i];
    this.values = new float[i];
    this.previous = new int[i];
    this.next = new int[i];
    this.mCount = 0;
    this.head = -1;
    this.mRow = paramArrayRow;
    this.mCache = paramCache;
    clear();
  }
  
  private void addToHashMap(SolverVariable paramSolverVariable, int paramInt)
  {
    int k = paramSolverVariable.id % this.HASH_SIZE;
    paramSolverVariable = this.keys;
    int j = paramSolverVariable[k];
    int i = j;
    if (j == -1)
    {
      paramSolverVariable[k] = paramInt;
    }
    else
    {
      for (;;)
      {
        paramSolverVariable = this.nextKeys;
        if (paramSolverVariable[i] == -1) {
          break;
        }
        i = paramSolverVariable[i];
      }
      paramSolverVariable[i] = paramInt;
    }
    this.nextKeys[paramInt] = -1;
  }
  
  private void addVariable(int paramInt, SolverVariable paramSolverVariable, float paramFloat)
  {
    this.variables[paramInt] = paramSolverVariable.id;
    this.values[paramInt] = paramFloat;
    this.previous[paramInt] = -1;
    this.next[paramInt] = -1;
    paramSolverVariable.addToRow(this.mRow);
    paramSolverVariable.usageInRowCount += 1;
    this.mCount += 1;
  }
  
  private void displayHash()
  {
    int i = 0;
    while (i < this.HASH_SIZE)
    {
      if (this.keys[i] != -1)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(hashCode());
        ((StringBuilder)localObject1).append(" hash [");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append("] => ");
        localObject1 = ((StringBuilder)localObject1).toString();
        int j = this.keys[i];
        int k = 0;
        while (k == 0)
        {
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(" ");
          ((StringBuilder)localObject2).append(this.variables[j]);
          localObject1 = ((StringBuilder)localObject2).toString();
          localObject2 = this.nextKeys;
          if (localObject2[j] != -1) {
            j = localObject2[j];
          } else {
            k = 1;
          }
        }
        System.out.println((String)localObject1);
      }
      i += 1;
    }
  }
  
  private int findEmptySlot()
  {
    int i = 0;
    while (i < this.SIZE)
    {
      if (this.variables[i] == -1) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void increaseSize()
  {
    int j = this.SIZE * 2;
    this.variables = Arrays.copyOf(this.variables, j);
    this.values = Arrays.copyOf(this.values, j);
    this.previous = Arrays.copyOf(this.previous, j);
    this.next = Arrays.copyOf(this.next, j);
    this.nextKeys = Arrays.copyOf(this.nextKeys, j);
    int i = this.SIZE;
    while (i < j)
    {
      this.variables[i] = -1;
      this.nextKeys[i] = -1;
      i += 1;
    }
    this.SIZE = j;
  }
  
  private void insertVariable(int paramInt, SolverVariable paramSolverVariable, float paramFloat)
  {
    int i = findEmptySlot();
    addVariable(i, paramSolverVariable, paramFloat);
    if (paramInt != -1)
    {
      this.previous[i] = paramInt;
      arrayOfInt = this.next;
      arrayOfInt[i] = arrayOfInt[paramInt];
      arrayOfInt[paramInt] = i;
    }
    else
    {
      this.previous[i] = -1;
      if (this.mCount > 0)
      {
        this.next[i] = this.head;
        this.head = i;
      }
      else
      {
        this.next[i] = -1;
      }
    }
    int[] arrayOfInt = this.next;
    if (arrayOfInt[i] != -1) {
      this.previous[arrayOfInt[i]] = i;
    }
    addToHashMap(paramSolverVariable, i);
  }
  
  private void removeFromHashMap(SolverVariable paramSolverVariable)
  {
    int m = paramSolverVariable.id % this.HASH_SIZE;
    int j = this.keys[m];
    if (j == -1) {
      return;
    }
    int k = paramSolverVariable.id;
    int i = j;
    if (this.variables[j] == k)
    {
      paramSolverVariable = this.keys;
      int[] arrayOfInt = this.nextKeys;
      paramSolverVariable[m] = arrayOfInt[j];
      arrayOfInt[j] = -1;
      return;
    }
    for (;;)
    {
      paramSolverVariable = this.nextKeys;
      if ((paramSolverVariable[i] == -1) || (this.variables[paramSolverVariable[i]] == k)) {
        break;
      }
      i = paramSolverVariable[i];
    }
    paramSolverVariable = this.nextKeys;
    j = paramSolverVariable[i];
    if ((j != -1) && (this.variables[j] == k))
    {
      paramSolverVariable[i] = paramSolverVariable[j];
      paramSolverVariable[j] = -1;
    }
  }
  
  public void add(SolverVariable paramSolverVariable, float paramFloat, boolean paramBoolean)
  {
    float f = epsilon;
    if ((paramFloat > -f) && (paramFloat < f)) {
      return;
    }
    int i = indexOf(paramSolverVariable);
    if (i == -1)
    {
      put(paramSolverVariable, paramFloat);
      return;
    }
    float[] arrayOfFloat = this.values;
    arrayOfFloat[i] += paramFloat;
    paramFloat = arrayOfFloat[i];
    f = epsilon;
    if ((paramFloat > -f) && (arrayOfFloat[i] < f))
    {
      arrayOfFloat[i] = 0.0F;
      remove(paramSolverVariable, paramBoolean);
    }
  }
  
  public void clear()
  {
    int j = this.mCount;
    int i = 0;
    while (i < j)
    {
      SolverVariable localSolverVariable = getVariable(i);
      if (localSolverVariable != null) {
        localSolverVariable.removeFromRow(this.mRow);
      }
      i += 1;
    }
    i = 0;
    while (i < this.SIZE)
    {
      this.variables[i] = -1;
      this.nextKeys[i] = -1;
      i += 1;
    }
    i = 0;
    while (i < this.HASH_SIZE)
    {
      this.keys[i] = -1;
      i += 1;
    }
    this.mCount = 0;
    this.head = -1;
  }
  
  public boolean contains(SolverVariable paramSolverVariable)
  {
    return indexOf(paramSolverVariable) != -1;
  }
  
  public void display()
  {
    int j = this.mCount;
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
    int k = this.mCount;
    int j = this.head;
    int i = 0;
    while (i < k)
    {
      float[] arrayOfFloat = this.values;
      arrayOfFloat[j] /= paramFloat;
      j = this.next[j];
      if (j == -1) {
        return;
      }
      i += 1;
    }
  }
  
  public float get(SolverVariable paramSolverVariable)
  {
    int i = indexOf(paramSolverVariable);
    if (i != -1) {
      return this.values[i];
    }
    return 0.0F;
  }
  
  public int getCurrentSize()
  {
    return this.mCount;
  }
  
  public SolverVariable getVariable(int paramInt)
  {
    int k = this.mCount;
    if (k == 0) {
      return null;
    }
    int j = this.head;
    int i = 0;
    while (i < k)
    {
      if ((i == paramInt) && (j != -1)) {
        return this.mCache.mIndexedVariables[this.variables[j]];
      }
      j = this.next[j];
      if (j == -1) {
        return null;
      }
      i += 1;
    }
    return null;
  }
  
  public float getVariableValue(int paramInt)
  {
    int k = this.mCount;
    int j = this.head;
    int i = 0;
    while (i < k)
    {
      if (i == paramInt) {
        return this.values[j];
      }
      j = this.next[j];
      if (j == -1) {
        break;
      }
      i += 1;
    }
    return 0.0F;
  }
  
  public int indexOf(SolverVariable paramSolverVariable)
  {
    if (this.mCount != 0)
    {
      if (paramSolverVariable == null) {
        return -1;
      }
      int k = paramSolverVariable.id;
      int i = this.HASH_SIZE;
      int j = this.keys[(k % i)];
      if (j == -1) {
        return -1;
      }
      i = j;
      if (this.variables[j] == k) {
        return j;
      }
      for (;;)
      {
        paramSolverVariable = this.nextKeys;
        if ((paramSolverVariable[i] == -1) || (this.variables[paramSolverVariable[i]] == k)) {
          break;
        }
        i = paramSolverVariable[i];
      }
      paramSolverVariable = this.nextKeys;
      if (paramSolverVariable[i] == -1) {
        return -1;
      }
      if (this.variables[paramSolverVariable[i]] == k) {
        return paramSolverVariable[i];
      }
    }
    return -1;
  }
  
  public void invert()
  {
    int k = this.mCount;
    int j = this.head;
    int i = 0;
    while (i < k)
    {
      float[] arrayOfFloat = this.values;
      arrayOfFloat[j] *= -1.0F;
      j = this.next[j];
      if (j == -1) {
        return;
      }
      i += 1;
    }
  }
  
  public void put(SolverVariable paramSolverVariable, float paramFloat)
  {
    float f = epsilon;
    if ((paramFloat > -f) && (paramFloat < f))
    {
      remove(paramSolverVariable, true);
      return;
    }
    int i = this.mCount;
    int k = 0;
    if (i == 0)
    {
      addVariable(0, paramSolverVariable, paramFloat);
      addToHashMap(paramSolverVariable, 0);
      this.head = 0;
      return;
    }
    i = indexOf(paramSolverVariable);
    if (i != -1)
    {
      this.values[i] = paramFloat;
      return;
    }
    if (this.mCount + 1 >= this.SIZE) {
      increaseSize();
    }
    int n = this.mCount;
    i = this.head;
    int j = -1;
    int m;
    for (;;)
    {
      m = j;
      if (k >= n) {
        break;
      }
      if (this.variables[i] == paramSolverVariable.id)
      {
        this.values[i] = paramFloat;
        return;
      }
      if (this.variables[i] < paramSolverVariable.id) {
        j = i;
      }
      i = this.next[i];
      if (i == -1)
      {
        m = j;
        break;
      }
      k += 1;
    }
    insertVariable(m, paramSolverVariable, paramFloat);
  }
  
  public float remove(SolverVariable paramSolverVariable, boolean paramBoolean)
  {
    int i = indexOf(paramSolverVariable);
    if (i == -1) {
      return 0.0F;
    }
    removeFromHashMap(paramSolverVariable);
    float f = this.values[i];
    if (this.head == i) {
      this.head = this.next[i];
    }
    this.variables[i] = -1;
    int[] arrayOfInt1 = this.previous;
    int[] arrayOfInt2;
    if (arrayOfInt1[i] != -1)
    {
      arrayOfInt2 = this.next;
      arrayOfInt2[arrayOfInt1[i]] = arrayOfInt2[i];
    }
    arrayOfInt1 = this.next;
    if (arrayOfInt1[i] != -1)
    {
      arrayOfInt2 = this.previous;
      arrayOfInt2[arrayOfInt1[i]] = arrayOfInt2[i];
    }
    this.mCount -= 1;
    paramSolverVariable.usageInRowCount -= 1;
    if (paramBoolean) {
      paramSolverVariable.removeFromRow(this.mRow);
    }
    return f;
  }
  
  public int sizeInBytes()
  {
    return 0;
  }
  
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(hashCode());
    ((StringBuilder)localObject1).append(" { ");
    localObject1 = ((StringBuilder)localObject1).toString();
    int j = this.mCount;
    int i = 0;
    while (i < j)
    {
      localObject2 = getVariable(i);
      if (localObject2 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(localObject2);
        localStringBuilder.append(" = ");
        localStringBuilder.append(getVariableValue(i));
        localStringBuilder.append(" ");
        localObject1 = localStringBuilder.toString();
        int k = indexOf((SolverVariable)localObject2);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("[p: ");
        localObject1 = ((StringBuilder)localObject2).toString();
        if (this.previous[k] != -1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(this.mCache.mIndexedVariables[this.variables[this.previous[k]]]);
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("none");
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(", n: ");
        localObject1 = ((StringBuilder)localObject2).toString();
        if (this.next[k] != -1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(this.mCache.mIndexedVariables[this.variables[this.next[k]]]);
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("none");
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("]");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      i += 1;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" }");
    return ((StringBuilder)localObject2).toString();
  }
  
  public float use(ArrayRow paramArrayRow, boolean paramBoolean)
  {
    float f1 = get(paramArrayRow.variable);
    remove(paramArrayRow.variable, paramBoolean);
    paramArrayRow = (SolverVariableValues)paramArrayRow.variables;
    int m = paramArrayRow.getCurrentSize();
    int i = paramArrayRow.head;
    int j = 0;
    i = 0;
    while (j < m)
    {
      int k = j;
      if (paramArrayRow.variables[i] != -1)
      {
        float f2 = paramArrayRow.values[i];
        add(this.mCache.mIndexedVariables[paramArrayRow.variables[i]], f2 * f1, paramBoolean);
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.solver.SolverVariableValues
 * JD-Core Version:    0.7.0.1
 */