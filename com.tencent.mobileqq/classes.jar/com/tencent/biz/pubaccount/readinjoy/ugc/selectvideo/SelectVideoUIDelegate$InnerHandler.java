package com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo;

import android.os.Handler;
import android.os.Message;
import mqq.util.WeakReference;

class SelectVideoUIDelegate$InnerHandler
  extends Handler
{
  private WeakReference<SelectVideoUIDelegate> a;
  
  public SelectVideoUIDelegate$InnerHandler(SelectVideoUIDelegate paramSelectVideoUIDelegate)
  {
    this.a = new WeakReference(paramSelectVideoUIDelegate);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    SelectVideoUIDelegate localSelectVideoUIDelegate = (SelectVideoUIDelegate)this.a.get();
    if (localSelectVideoUIDelegate == null) {}
    while (paramMessage.what != 101) {
      return;
    }
    SelectVideoUIDelegate.a(localSelectVideoUIDelegate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo.SelectVideoUIDelegate.InnerHandler
 * JD-Core Version:    0.7.0.1
 */