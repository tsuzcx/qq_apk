package com.tencent.kwstudio.office.preview;

final class TdsReaderHelper$RunnableImpl
  implements Runnable
{
  private static final int JOB_TYPE_CHECK = 1;
  private static final int JOB_TYPE_DELETE = 2;
  private final int mJobType;
  
  private TdsReaderHelper$RunnableImpl(int paramInt)
  {
    this.mJobType = paramInt;
  }
  
  public void run()
  {
    int i = this.mJobType;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      TdsReaderHelper.access$200();
      return;
    }
    TdsReaderHelper.access$100();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.kwstudio.office.preview.TdsReaderHelper.RunnableImpl
 * JD-Core Version:    0.7.0.1
 */