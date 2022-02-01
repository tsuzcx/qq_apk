package com.tencent.biz.lebasearch;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;

final class SearchProtocol$1
  extends Handler
{
  SearchProtocol$1(Looper paramLooper, SearchProtocol.SearchObserver paramSearchObserver)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.arg1 == 0)
    {
      this.a.a(paramMessage.arg1, (List)paramMessage.obj);
      return;
    }
    this.a.a(paramMessage.arg1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.lebasearch.SearchProtocol.1
 * JD-Core Version:    0.7.0.1
 */