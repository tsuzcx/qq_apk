package androidx.recyclerview.widget;

class ViewBoundsCheck$BoundFlags
{
  int mBoundFlags = 0;
  int mChildEnd;
  int mChildStart;
  int mRvEnd;
  int mRvStart;
  
  void addFlags(int paramInt)
  {
    this.mBoundFlags |= paramInt;
  }
  
  boolean boundsMatch()
  {
    if (((this.mBoundFlags & 0x7) != 0) && ((this.mBoundFlags & compare(this.mChildStart, this.mRvStart) << 0) == 0)) {}
    while ((((this.mBoundFlags & 0x70) != 0) && ((this.mBoundFlags & compare(this.mChildStart, this.mRvEnd) << 4) == 0)) || (((this.mBoundFlags & 0x700) != 0) && ((this.mBoundFlags & compare(this.mChildEnd, this.mRvStart) << 8) == 0)) || (((this.mBoundFlags & 0x7000) != 0) && ((this.mBoundFlags & compare(this.mChildEnd, this.mRvEnd) << 12) == 0))) {
      return false;
    }
    return true;
  }
  
  int compare(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return 1;
    }
    if (paramInt1 == paramInt2) {
      return 2;
    }
    return 4;
  }
  
  void resetFlags()
  {
    this.mBoundFlags = 0;
  }
  
  void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mRvStart = paramInt1;
    this.mRvEnd = paramInt2;
    this.mChildStart = paramInt3;
    this.mChildEnd = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.ViewBoundsCheck.BoundFlags
 * JD-Core Version:    0.7.0.1
 */