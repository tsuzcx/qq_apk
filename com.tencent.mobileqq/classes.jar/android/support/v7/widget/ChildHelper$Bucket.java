package android.support.v7.widget;

class ChildHelper$Bucket
{
  static final int BITS_PER_WORD = 64;
  static final long LAST_BIT = -9223372036854775808L;
  long mData = 0L;
  Bucket next;
  
  private void ensureNext()
  {
    if (this.next == null) {
      this.next = new Bucket();
    }
  }
  
  void clear(int paramInt)
  {
    if (paramInt >= 64)
    {
      Bucket localBucket = this.next;
      if (localBucket != null) {
        localBucket.clear(paramInt - 64);
      }
    }
    else
    {
      this.mData &= (1L << paramInt ^ 0xFFFFFFFF);
    }
  }
  
  int countOnesBefore(int paramInt)
  {
    Bucket localBucket = this.next;
    if (localBucket == null)
    {
      if (paramInt >= 64) {
        return Long.bitCount(this.mData);
      }
      return Long.bitCount(this.mData & (1L << paramInt) - 1L);
    }
    if (paramInt < 64) {
      return Long.bitCount(this.mData & (1L << paramInt) - 1L);
    }
    return localBucket.countOnesBefore(paramInt - 64) + Long.bitCount(this.mData);
  }
  
  boolean get(int paramInt)
  {
    if (paramInt >= 64)
    {
      ensureNext();
      return this.next.get(paramInt - 64);
    }
    return (this.mData & 1L << paramInt) != 0L;
  }
  
  void insert(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= 64)
    {
      ensureNext();
      this.next.insert(paramInt - 64, paramBoolean);
      return;
    }
    boolean bool;
    if ((this.mData & 0x0) != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    long l1 = (1L << paramInt) - 1L;
    long l2 = this.mData;
    this.mData = ((l2 & (l1 ^ 0xFFFFFFFF)) << 1 | l2 & l1);
    if (paramBoolean) {
      set(paramInt);
    } else {
      clear(paramInt);
    }
    if ((bool) || (this.next != null))
    {
      ensureNext();
      this.next.insert(0, bool);
    }
  }
  
  boolean remove(int paramInt)
  {
    if (paramInt >= 64)
    {
      ensureNext();
      return this.next.remove(paramInt - 64);
    }
    long l1 = 1L << paramInt;
    boolean bool;
    if ((this.mData & l1) != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    this.mData &= (l1 ^ 0xFFFFFFFF);
    l1 -= 1L;
    long l2 = this.mData;
    this.mData = (Long.rotateRight(l2 & (l1 ^ 0xFFFFFFFF), 1) | l2 & l1);
    Bucket localBucket = this.next;
    if (localBucket != null)
    {
      if (localBucket.get(0)) {
        set(63);
      }
      this.next.remove(0);
    }
    return bool;
  }
  
  void reset()
  {
    this.mData = 0L;
    Bucket localBucket = this.next;
    if (localBucket != null) {
      localBucket.reset();
    }
  }
  
  void set(int paramInt)
  {
    if (paramInt >= 64)
    {
      ensureNext();
      this.next.set(paramInt - 64);
      return;
    }
    this.mData |= 1L << paramInt;
  }
  
  public String toString()
  {
    if (this.next == null) {
      return Long.toBinaryString(this.mData);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.next.toString());
    localStringBuilder.append("xx");
    localStringBuilder.append(Long.toBinaryString(this.mData));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.ChildHelper.Bucket
 * JD-Core Version:    0.7.0.1
 */