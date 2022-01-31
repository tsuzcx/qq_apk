package com.tencent.biz.pubaccount.readinjoy.view;

import android.os.Handler.Callback;
import android.os.Message;
import java.lang.ref.WeakReference;

public class ReadInJoyXListView$UICallBack
  implements Handler.Callback
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public ReadInJoyXListView$UICallBack(ReadInJoyXListView paramReadInJoyXListView1, ReadInJoyXListView paramReadInJoyXListView2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramReadInJoyXListView2);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      ((ReadInJoyXListView)this.jdField_a_of_type_JavaLangRefWeakReference.get()).h();
      return true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView.UICallBack
 * JD-Core Version:    0.7.0.1
 */