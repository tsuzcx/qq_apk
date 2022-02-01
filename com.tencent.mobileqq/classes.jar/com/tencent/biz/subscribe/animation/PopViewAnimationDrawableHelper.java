package com.tencent.biz.subscribe.animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;

public class PopViewAnimationDrawableHelper
{
  private int jdField_a_of_type_Int;
  private AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private PopViewAnimationDrawableHelper.OnFrameAnimationListener jdField_a_of_type_ComTencentBizSubscribeAnimationPopViewAnimationDrawableHelper$OnFrameAnimationListener;
  private PopViewAnimationDrawableHelper.OnInnerFrameAnimationListener jdField_a_of_type_ComTencentBizSubscribeAnimationPopViewAnimationDrawableHelper$OnInnerFrameAnimationListener;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private int b;
  private int c;
  
  public PopViewAnimationDrawableHelper(AnimationDrawable paramAnimationDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = paramAnimationDrawable;
    this.c = paramAnimationDrawable.getNumberOfFrames();
    this.jdField_a_of_type_AndroidOsHandler = new PopViewAnimationDrawableHelper.InnerHandler();
    this.jdField_a_of_type_ComTencentBizSubscribeAnimationPopViewAnimationDrawableHelper$OnInnerFrameAnimationListener = new PopViewAnimationDrawableHelper.1(this);
    this.jdField_a_of_type_JavaLangRunnable = new PopViewAnimationDrawableHelper.LoopingRunnable(this);
  }
  
  private int a()
  {
    int i = 0;
    while (i < this.c)
    {
      if (this.jdField_a_of_type_Int < this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getDuration(i)) {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getDuration(i);
      }
      i += 1;
    }
    int j = this.jdField_a_of_type_Int;
    i = j;
    if (j > 1000) {
      i = 1000;
    }
    return i;
  }
  
  private void c()
  {
    Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
    if (localRunnable != null)
    {
      Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
      if (localHandler != null)
      {
        int i = this.b;
        if (i > 0)
        {
          localHandler.postDelayed(localRunnable, i);
          return;
        }
        if (i == 0) {
          i = a();
        } else {
          i = this.jdField_a_of_type_Int;
        }
        localHandler.postDelayed(localRunnable, i);
      }
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
    if (localObject == null) {
      return;
    }
    ((AnimationDrawable)localObject).start();
    c();
    localObject = this.jdField_a_of_type_ComTencentBizSubscribeAnimationPopViewAnimationDrawableHelper$OnFrameAnimationListener;
    if (localObject != null) {
      ((PopViewAnimationDrawableHelper.OnFrameAnimationListener)localObject).a();
    }
  }
  
  public void a(PopViewAnimationDrawableHelper.OnFrameAnimationListener paramOnFrameAnimationListener)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeAnimationPopViewAnimationDrawableHelper$OnFrameAnimationListener = paramOnFrameAnimationListener;
  }
  
  public void b()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.animation.PopViewAnimationDrawableHelper
 * JD-Core Version:    0.7.0.1
 */