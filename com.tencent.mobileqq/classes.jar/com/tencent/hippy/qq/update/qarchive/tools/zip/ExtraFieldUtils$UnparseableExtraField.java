package com.tencent.hippy.qq.update.qarchive.tools.zip;

public final class ExtraFieldUtils$UnparseableExtraField
{
  public static final UnparseableExtraField READ = new UnparseableExtraField(2);
  public static final int READ_KEY = 2;
  public static final UnparseableExtraField SKIP;
  public static final int SKIP_KEY = 1;
  public static final UnparseableExtraField THROW = new UnparseableExtraField(0);
  public static final int THROW_KEY = 0;
  private final int key;
  
  static
  {
    SKIP = new UnparseableExtraField(1);
  }
  
  private ExtraFieldUtils$UnparseableExtraField(int paramInt)
  {
    this.key = paramInt;
  }
  
  public int getKey()
  {
    return this.key;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.ExtraFieldUtils.UnparseableExtraField
 * JD-Core Version:    0.7.0.1
 */