package com.tencent.biz.subscribe.animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import wkg;
import wkh;
import wki;
import wkj;

public class PopViewAnimationDrawableHelper
{
  private int jdField_a_of_type_Int;
  private AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private wki jdField_a_of_type_Wki;
  private wkj jdField_a_of_type_Wkj;
  private int b;
  private int c;
  
  public PopViewAnimationDrawableHelper(AnimationDrawable paramAnimationDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = paramAnimationDrawable;
    this.c = paramAnimationDrawable.getNumberOfFrames();
    this.jdField_a_of_type_AndroidOsHandler = new wkh();
    this.jdField_a_of_type_Wkj = new wkg(this);
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
    if (this.jdField_a_of_type_Int > 1000) {
      return 1000;
    }
    return this.jdField_a_of_type_Int;
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_JavaLangRunnable != null) && (this.jdField_a_of_type_AndroidOsHandler != null))
    {
      if (this.b > 0) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.b);
      }
    }
    else {
      return;
    }
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
    if (this.b == 0) {}
    for (long l = a();; l = this.jdField_a_of_type_Int)
    {
      localHandler.postDelayed(localRunnable, l);
      return;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable == null) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
      c();
    } while (this.jdField_a_of_type_Wki == null);
    this.jdField_a_of_type_Wki.a();
  }
  
  public void a(wki paramwki)
  {
    this.jdField_a_of_type_Wki = paramwki;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.animation.PopViewAnimationDrawableHelper
 * JD-Core Version:    0.7.0.1
 */