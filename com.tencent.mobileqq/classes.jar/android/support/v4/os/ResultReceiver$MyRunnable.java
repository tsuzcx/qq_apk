package android.support.v4.os;

import android.os.Bundle;

class ResultReceiver$MyRunnable
  implements Runnable
{
  final int mResultCode;
  final Bundle mResultData;
  
  ResultReceiver$MyRunnable(ResultReceiver paramResultReceiver, int paramInt, Bundle paramBundle)
  {
    this.mResultCode = paramInt;
    this.mResultData = paramBundle;
  }
  
  public void run()
  {
    this.this$0.onReceiveResult(this.mResultCode, this.mResultData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.support.v4.os.ResultReceiver.MyRunnable
 * JD-Core Version:    0.7.0.1
 */