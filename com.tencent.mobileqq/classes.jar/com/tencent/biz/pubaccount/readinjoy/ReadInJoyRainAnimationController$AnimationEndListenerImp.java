package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.biz.pubaccount.readinjoy.view.RainView.AnimationEndListener;
import java.lang.ref.WeakReference;

class ReadInJoyRainAnimationController$AnimationEndListenerImp
  implements RainView.AnimationEndListener
{
  private WeakReference<ReadInJoyRainAnimationController> a;
  
  public ReadInJoyRainAnimationController$AnimationEndListenerImp(ReadInJoyRainAnimationController paramReadInJoyRainAnimationController)
  {
    this.a = new WeakReference(paramReadInJoyRainAnimationController);
  }
  
  public void a()
  {
    ReadInJoyRainAnimationController localReadInJoyRainAnimationController = (ReadInJoyRainAnimationController)this.a.get();
    if ((localReadInJoyRainAnimationController == null) || (!localReadInJoyRainAnimationController.b())) {
      return;
    }
    ReadInJoyRainAnimationController.a(localReadInJoyRainAnimationController).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyRainAnimationController.AnimationEndListenerImp
 * JD-Core Version:    0.7.0.1
 */