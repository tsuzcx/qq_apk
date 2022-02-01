package androidx.recyclerview.widget;

class ChildHelper$Bucket
{
  static final int BITS_PER_WORD = 64;
  static final long LAST_BIT = -9223372036854775808L;
  long mData = 0L;
  Bucket mNext;
  
  private void ensureNext()
  {
    if (this.mNext == null) {
      this.mNext = new Bucket();
    }
  }
  
  void clear(int paramInt)
  {
    if (paramInt >= 64)
    {
      if (this.mNext != null) {
        this.mNext.clear(paramInt - 64);
      }
      return;
    }
    this.mData &= (1L << paramInt ^ 0xFFFFFFFF);
  }
  
  int countOnesBefore(int paramInt)
  {
    if (this.mNext == null)
    {
      if (paramInt >= 64) {
        return Long.bitCount(this.mData);
      }
      return Long.bitCount(this.mData & (1L << paramInt) - 1L);
    }
    if (paramInt < 64) {
      return Long.bitCount(this.mData & (1L << paramInt) - 1L);
    }
    return this.mNext.countOnesBefore(paramInt - 64) + Long.bitCount(this.mData);
  }
  
  boolean get(int paramInt)
  {
    if (paramInt >= 64)
    {
      ensureNext();
      return this.mNext.get(paramInt - 64);
    }
    return (this.mData & 1L << paramInt) != 0L;
  }
  
  void insert(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= 64)
    {
      ensureNext();
      this.mNext.insert(paramInt - 64, paramBoolean);
    }
    label113:
    label119:
    for (;;)
    {
      return;
      boolean bool;
      if ((this.mData & 0x0) != 0L)
      {
        bool = true;
        long l1 = (1L << paramInt) - 1L;
        long l2 = this.mData;
        this.mData = (((l1 ^ 0xFFFFFFFF) & this.mData) << 1 | l2 & l1);
        if (!paramBoolean) {
          break label113;
        }
        set(paramInt);
      }
      for (;;)
      {
        if ((!bool) && (this.mNext == null)) {
          break label119;
        }
        ensureNext();
        this.mNext.insert(0, bool);
        return;
        bool = false;
        break;
        clear(paramInt);
      }
    }
  }
  
  boolean remove(int paramInt)
  {
    boolean bool2;
    if (paramInt >= 64)
    {
      ensureNext();
      bool2 = this.mNext.remove(paramInt - 64);
      return bool2;
    }
    long l1 = 1L << paramInt;
    if ((this.mData & l1) != 0L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.mData &= (l1 ^ 0xFFFFFFFF);
      l1 -= 1L;
      long l2 = this.mData;
      this.mData = (Long.rotateRight((l1 ^ 0xFFFFFFFF) & this.mData, 1) | l2 & l1);
      bool2 = bool1;
      if (this.mNext == null) {
        break;
      }
      if (this.mNext.get(0)) {
        set(63);
      }
      this.mNext.remove(0);
      return bool1;
    }
  }
  
  void reset()
  {
    this.mData = 0L;
    if (this.mNext != null) {
      this.mNext.reset();
    }
  }
  
  void set(int paramInt)
  {
    if (paramInt >= 64)
    {
      ensureNext();
      this.mNext.set(paramInt - 64);
      return;
    }
    this.mData |= 1L << paramInt;
  }
  
  public String toString()
  {
    if (this.mNext == null) {
      return Long.toBinaryString(this.mData);
    }
    return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.ChildHelper.Bucket
 * JD-Core Version:    0.7.0.1
 */