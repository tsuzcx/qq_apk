package com.tencent.litetransfersdk;

import com.tencent.qphone.base.util.QLog;

class LiteTransferWrapper$2
  implements Runnable
{
  LiteTransferWrapper$2(LiteTransferWrapper paramLiteTransferWrapper, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      if (LiteTransferWrapper.access$200(this.this$0) != 0L)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("destryOperator mLiteTransferOperator:");
        localStringBuilder1.append(LiteTransferWrapper.access$200(this.this$0));
        localStringBuilder1.append(" threadId:");
        localStringBuilder1.append(Thread.currentThread().getId());
        QLog.i("dataline.LiteTTransferWrapper", 1, localStringBuilder1.toString());
        long l = LiteTransferWrapper.access$200(this.this$0);
        LiteTransferWrapper.access$202(this.this$0, 0L);
        this.this$0.destryOperator(l, this.a);
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("cannot endLiteTransfer, load litetranfer library error?");
        localStringBuilder2.append(QLog.getStackTraceString(localUnsatisfiedLinkError));
        QLog.d("dataline.LiteTTransferWrapper", 2, localStringBuilder2.toString());
      }
    }
    LiteTransferWrapper.access$002(this.this$0, null);
    LiteTransferWrapper.access$102(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.litetransfersdk.LiteTransferWrapper.2
 * JD-Core Version:    0.7.0.1
 */