package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;

class ResultReceiver$MyResultReceiver
  extends IResultReceiver.Stub
{
  ResultReceiver$MyResultReceiver(ResultReceiver paramResultReceiver) {}
  
  public void send(int paramInt, Bundle paramBundle)
  {
    if (this.this$0.mHandler != null)
    {
      this.this$0.mHandler.post(new ResultReceiver.MyRunnable(this.this$0, paramInt, paramBundle));
      return;
    }
    this.this$0.onReceiveResult(paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.support.v4.os.ResultReceiver.MyResultReceiver
 * JD-Core Version:    0.7.0.1
 */