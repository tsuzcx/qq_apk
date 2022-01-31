package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.TextView;
import wxe;
import xwh;

public class QQStoryLoadingView
  extends TextView
{
  protected AnimationDrawable a;
  protected Handler a;
  
  public QQStoryLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidOsHandler = new xwh(this, Looper.getMainLooper());
    super.setGravity(17);
    if ((a(this) == 0) && (!post(new QQStoryLoadingView.2(this)))) {
      setVisibility(0);
    }
  }
  
  public static void a(Context paramContext)
  {
    int i = 0;
    while (i < 29)
    {
      paramContext.getResources().getDrawable(2130846120 + i);
      i += 1;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
      return 0;
    }
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(4)) {
      return 4;
    }
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(8)) {
      return 8;
    }
    return -1;
  }
  
  public void a()
  {
    super.setCompoundDrawablesWithIntrinsicBounds(null, super.getResources().getDrawable(2130846120), null, null);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getNumberOfFrames())
      {
        Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getFrame(i);
        if ((!(localDrawable instanceof BitmapDrawable)) || (localDrawable != null)) {
          localDrawable.setCallback(null);
        }
        i += 1;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.setCallback(null);
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    }
  }
  
  public void b()
  {
    int i = 0;
    try
    {
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable == null) || (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getNumberOfFrames() != 29))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = new AnimationDrawable();
        while (i < 29)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(super.getResources().getDrawable(2130846120 + i), 50);
          i += 1;
        }
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.setOneShot(false);
        super.setCompoundDrawablesWithIntrinsicBounds(null, this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable, null, null);
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
      wxe.e("Q.qqstory.QQStoryLoadingView", "start animation error:" + localOutOfMemoryError);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
      wxe.b("QQStoryLoadingView", "ignore VISIBLE");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    String str2;
    String str1;
    if (super.getVisibility() != paramInt)
    {
      super.setVisibility(paramInt);
      str2 = "QQStoryLoadingView" + System.identityHashCode(this);
      if (paramInt != 8) {
        break label87;
      }
      str1 = "GONE";
    }
    for (;;)
    {
      wxe.a(str2, "setVisibility => %s", str1);
      if (paramInt != 0) {
        break;
      }
      b();
      return;
      label87:
      if (paramInt == 0) {
        str1 = "VISIBLE";
      } else {
        str1 = "INVISIBLE";
      }
    }
    a();
  }
  
  public void setVisibilityDelay(int paramInt, long paramLong, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, paramInt, paramString), paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.QQStoryLoadingView
 * JD-Core Version:    0.7.0.1
 */