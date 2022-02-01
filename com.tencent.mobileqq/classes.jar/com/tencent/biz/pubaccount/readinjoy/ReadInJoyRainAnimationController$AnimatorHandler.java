package com.tencent.biz.pubaccount.readinjoy;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class ReadInJoyRainAnimationController$AnimatorHandler
  extends Handler
{
  private WeakReference<ReadInJoyRainAnimationController> a;
  
  public ReadInJoyRainAnimationController$AnimatorHandler(ReadInJoyRainAnimationController paramReadInJoyRainAnimationController)
  {
    this.a = new WeakReference(paramReadInJoyRainAnimationController);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ReadInJoyRainAnimationController localReadInJoyRainAnimationController = (ReadInJoyRainAnimationController)this.a.get();
    if ((localReadInJoyRainAnimationController == null) || (!localReadInJoyRainAnimationController.b())) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    localReadInJoyRainAnimationController.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyRainAnimationController.AnimatorHandler
 * JD-Core Version:    0.7.0.1
 */