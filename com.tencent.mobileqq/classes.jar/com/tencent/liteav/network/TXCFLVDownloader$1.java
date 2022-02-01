package com.tencent.liteav.network;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class TXCFLVDownloader$1
  extends Handler
{
  TXCFLVDownloader$1(TXCFLVDownloader paramTXCFLVDownloader, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 106)
    {
      switch (i)
      {
      default: 
        return;
      case 103: 
        TXCFLVDownloader.access$300(this.a);
        return;
      case 102: 
        TXCFLVDownloader.access$200(this.a);
        return;
      case 101: 
        TXCFLVDownloader.access$100(this.a);
        return;
      }
      TXCFLVDownloader.access$000(this.a);
      return;
    }
    try
    {
      Looper.myLooper().quit();
      return;
    }
    catch (Exception paramMessage) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.network.TXCFLVDownloader.1
 * JD-Core Version:    0.7.0.1
 */