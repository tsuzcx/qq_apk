package androidx.collection;

public final class CircularArray<E>
{
  private int mCapacityBitmask;
  private E[] mElements;
  private int mHead;
  private int mTail;
  
  public CircularArray()
  {
    this(8);
  }
  
  public CircularArray(int paramInt)
  {
    if (paramInt >= 1)
    {
      if (paramInt <= 1073741824)
      {
        int i = paramInt;
        if (Integer.bitCount(paramInt) != 1) {
          i = Integer.highestOneBit(paramInt - 1) << 1;
        }
        this.mCapacityBitmask = (i - 1);
        this.mElements = ((Object[])new Object[i]);
        return;
      }
      throw new IllegalArgumentException("capacity must be <= 2^30");
    }
    throw new IllegalArgumentException("capacity must be >= 1");
  }
  
  private void doubleCapacity()
  {
    Object[] arrayOfObject1 = this.mElements;
    int i = arrayOfObject1.length;
    int j = this.mHead;
    int k = i - j;
    int m = i << 1;
    if (m >= 0)
    {
      Object[] arrayOfObject2 = new Object[m];
      System.arraycopy(arrayOfObject1, j, arrayOfObject2, 0, k);
      System.arraycopy(this.mElements, 0, arrayOfObject2, k, this.mHead);
      this.mElements = ((Object[])arrayOfObject2);
      this.mHead = 0;
      this.mTail = i;
      this.mCapacityBitmask = (m - 1);
      return;
    }
    throw new RuntimeException("Max array capacity exceeded");
  }
  
  public void addFirst(E paramE)
  {
    this.mHead = (this.mHead - 1 & this.mCapacityBitmask);
    Object[] arrayOfObject = this.mElements;
    int i = this.mHead;
    arrayOfObject[i] = paramE;
    if (i == this.mTail) {
      doubleCapacity();
    }
  }
  
  public void addLast(E paramE)
  {
    Object[] arrayOfObject = this.mElements;
    int i = this.mTail;
    arrayOfObject[i] = paramE;
    this.mTail = (this.mCapacityBitmask & i + 1);
    if (this.mTail == this.mHead) {
      doubleCapacity();
    }
  }
  
  public void clear()
  {
    removeFromStart(size());
  }
  
  public E get(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < size()))
    {
      Object[] arrayOfObject = this.mElements;
      int i = this.mHead;
      return arrayOfObject[(this.mCapacityBitmask & i + paramInt)];
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public E getFirst()
  {
    int i = this.mHead;
    if (i != this.mTail) {
      return this.mElements[i];
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public E getLast()
  {
    int i = this.mHead;
    int j = this.mTail;
    if (i != j) {
      return this.mElements[(j - 1 & this.mCapacityBitmask)];
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public boolean isEmpty()
  {
    return this.mHead == this.mTail;
  }
  
  public E popFirst()
  {
    int i = this.mHead;
    if (i != this.mTail)
    {
      Object[] arrayOfObject = this.mElements;
      Object localObject = arrayOfObject[i];
      arrayOfObject[i] = null;
      this.mHead = (i + 1 & this.mCapacityBitmask);
      return localObject;
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public E popLast()
  {
    int i = this.mHead;
    int j = this.mTail;
    if (i != j)
    {
      i = this.mCapacityBitmask & j - 1;
      Object[] arrayOfObject = this.mElements;
      Object localObject = arrayOfObject[i];
      arrayOfObject[i] = null;
      this.mTail = i;
      return localObject;
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public void removeFromEnd(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    if (paramInt <= size())
    {
      int i = 0;
      int j = this.mTail;
      if (paramInt < j) {
        i = j - paramInt;
      }
      j = i;
      int k;
      for (;;)
      {
        k = this.mTail;
        if (j >= k) {
          break;
        }
        this.mElements[j] = null;
        j += 1;
      }
      i = k - i;
      paramInt -= i;
      this.mTail = (k - i);
      if (paramInt > 0)
      {
        this.mTail = this.mElements.length;
        i = this.mTail - paramInt;
        paramInt = i;
        while (paramInt < this.mTail)
        {
          this.mElements[paramInt] = null;
          paramInt += 1;
        }
        this.mTail = i;
      }
      return;
    }
    ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
    for (;;)
    {
      throw localArrayIndexOutOfBoundsException;
    }
  }
  
  public void removeFromStart(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    if (paramInt <= size())
    {
      int j = this.mElements.length;
      int k = this.mHead;
      int i = j;
      if (paramInt < j - k) {
        i = k + paramInt;
      }
      j = this.mHead;
      while (j < i)
      {
        this.mElements[j] = null;
        j += 1;
      }
      j = this.mHead;
      k = i - j;
      i = paramInt - k;
      this.mHead = (this.mCapacityBitmask & j + k);
      if (i > 0)
      {
        paramInt = 0;
        while (paramInt < i)
        {
          this.mElements[paramInt] = null;
          paramInt += 1;
        }
        this.mHead = i;
      }
      return;
    }
    ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
    for (;;)
    {
      throw localArrayIndexOutOfBoundsException;
    }
  }
  
  public int size()
  {
    return this.mTail - this.mHead & this.mCapacityBitmask;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.collection.CircularArray
 * JD-Core Version:    0.7.0.1
 */