package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class ReadInJoyScrollViewSwitcher$MyHandler
  extends Handler
{
  private WeakReference a;
  
  public ReadInJoyScrollViewSwitcher$MyHandler(ReadInJoyScrollViewSwitcher paramReadInJoyScrollViewSwitcher)
  {
    this.a = new WeakReference(paramReadInJoyScrollViewSwitcher);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    paramMessage = (ReadInJoyScrollViewSwitcher)this.a.get();
    if (paramMessage != null)
    {
      paramMessage.a();
      paramMessage.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyScrollViewSwitcher.MyHandler
 * JD-Core Version:    0.7.0.1
 */