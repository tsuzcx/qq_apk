package com.tencent.biz.pubaccount.readinjoy.view;

import android.os.Handler.Callback;
import android.os.Message;
import java.lang.ref.WeakReference;

public class ReadInJoyXListView$UICallBack
  implements Handler.Callback
{
  private WeakReference<ReadInJoyXListView> a;
  
  public ReadInJoyXListView$UICallBack(ReadInJoyXListView paramReadInJoyXListView)
  {
    this.a = new WeakReference(paramReadInJoyXListView);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if ((this.a != null) && (this.a.get() != null))
    {
      ((ReadInJoyXListView)this.a.get()).i();
      return true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView.UICallBack
 * JD-Core Version:    0.7.0.1
 */