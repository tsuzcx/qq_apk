package androidx.core.text.util;

class FindAddress$ZipRange
{
  int mException1;
  int mException2;
  int mHigh;
  int mLow;
  
  FindAddress$ZipRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mLow = paramInt1;
    this.mHigh = paramInt2;
    this.mException1 = paramInt3;
    this.mException2 = paramInt4;
  }
  
  boolean matches(String paramString)
  {
    boolean bool = false;
    int i = Integer.parseInt(paramString.substring(0, 2));
    if (((this.mLow <= i) && (i <= this.mHigh)) || (i == this.mException1) || (i == this.mException2)) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.text.util.FindAddress.ZipRange
 * JD-Core Version:    0.7.0.1
 */