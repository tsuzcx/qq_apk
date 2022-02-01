package com.tencent.biz.pubaccount.readinjoy.view;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class ReadInJoyNavigationGridview$NaviBarHandler
  extends Handler
{
  private WeakReference<ReadInJoyNavigationGridview> a;
  
  public ReadInJoyNavigationGridview$NaviBarHandler(ReadInJoyNavigationGridview paramReadInJoyNavigationGridview)
  {
    this.a = new WeakReference(paramReadInJoyNavigationGridview);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ReadInJoyNavigationGridview localReadInJoyNavigationGridview = (ReadInJoyNavigationGridview)this.a.get();
    if ((localReadInJoyNavigationGridview == null) || (ReadInJoyNavigationGridview.a(localReadInJoyNavigationGridview))) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    ReadInJoyNavigationGridview.a(localReadInJoyNavigationGridview);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview.NaviBarHandler
 * JD-Core Version:    0.7.0.1
 */