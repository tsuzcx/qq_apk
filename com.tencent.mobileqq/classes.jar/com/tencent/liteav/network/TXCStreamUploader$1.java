package com.tencent.liteav.network;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class TXCStreamUploader$1
  extends Handler
{
  TXCStreamUploader$1(TXCStreamUploader paramTXCStreamUploader, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 101)
    {
      if (i != 103)
      {
        if (i != 104) {
          return;
        }
        TXCStreamUploader.access$200(this.a);
        if (TXCStreamUploader.access$300(this.a) != null) {
          TXCStreamUploader.access$300(this.a).sendEmptyMessageDelayed(104, 2000L);
        }
      }
      else
      {
        TXCStreamUploader.access$100(this.a);
      }
    }
    else
    {
      TXCStreamUploader localTXCStreamUploader = this.a;
      String str = (String)paramMessage.obj;
      boolean bool;
      if (paramMessage.arg1 == 2) {
        bool = true;
      } else {
        bool = false;
      }
      TXCStreamUploader.access$000(localTXCStreamUploader, str, bool, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.network.TXCStreamUploader.1
 * JD-Core Version:    0.7.0.1
 */