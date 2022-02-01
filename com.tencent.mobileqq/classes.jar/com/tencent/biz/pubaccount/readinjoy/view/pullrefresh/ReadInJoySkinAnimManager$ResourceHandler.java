package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class ReadInJoySkinAnimManager$ResourceHandler
  extends Handler
{
  private WeakReference<ReadInJoySkinAnimManager> a;
  
  public ReadInJoySkinAnimManager$ResourceHandler(ReadInJoySkinAnimManager paramReadInJoySkinAnimManager)
  {
    this.a = new WeakReference(paramReadInJoySkinAnimManager);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ReadInJoySkinAnimManager localReadInJoySkinAnimManager = (ReadInJoySkinAnimManager)this.a.get();
    if (localReadInJoySkinAnimManager == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      ReadInJoySkinAnimManager.b(localReadInJoySkinAnimManager);
      return;
    }
    ReadInJoySkinAnimManager.a(localReadInJoySkinAnimManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoySkinAnimManager.ResourceHandler
 * JD-Core Version:    0.7.0.1
 */