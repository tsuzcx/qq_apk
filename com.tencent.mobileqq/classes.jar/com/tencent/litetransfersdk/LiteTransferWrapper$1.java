package com.tencent.litetransfersdk;

import com.tencent.qphone.base.util.QLog;

class LiteTransferWrapper$1
  implements Runnable
{
  LiteTransferWrapper$1(LiteTransferWrapper paramLiteTransferWrapper) {}
  
  public void run()
  {
    if ((LiteTransferWrapper.access$000(this.this$0) != null) && (LiteTransferWrapper.access$100(this.this$0) != null))
    {
      if (LiteTransferWrapper.access$200(this.this$0) == 0L) {
        try
        {
          LiteTransferWrapper.access$202(this.this$0, this.this$0.createOperator(LiteTransferWrapper.access$000(this.this$0), LiteTransferWrapper.access$100(this.this$0)));
          this.this$0.SetBusinessID(38, 3, 106, 102);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("createOperator mLiteTransferOperator:");
          localStringBuilder.append(LiteTransferWrapper.access$200(this.this$0));
          localStringBuilder.append(" threadId:");
          localStringBuilder.append(Thread.currentThread().getId());
          QLog.i("dataline.LiteTTransferWrapper", 1, localStringBuilder.toString());
          this.this$0.checkPathExist();
          this.this$0.SetProxyToJni();
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          localUnsatisfiedLinkError.printStackTrace();
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTTransferWrapper", 2, "litetransfer callback is null, do nothing");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.litetransfersdk.LiteTransferWrapper.1
 * JD-Core Version:    0.7.0.1
 */