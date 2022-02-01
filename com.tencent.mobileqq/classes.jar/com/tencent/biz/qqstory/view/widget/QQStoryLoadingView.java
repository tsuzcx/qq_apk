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
import com.tencent.biz.qqstory.support.logging.SLog;

public class QQStoryLoadingView
  extends TextView
{
  protected AnimationDrawable a;
  protected Handler a;
  
  public QQStoryLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidOsHandler = new QQStoryLoadingView.1(this, Looper.getMainLooper());
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
      paramContext.getResources().getDrawable(2130846801 + i);
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
    super.setCompoundDrawablesWithIntrinsicBounds(null, super.getResources().getDrawable(2130846801), null, null);
    Object localObject = this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
    if (localObject != null)
    {
      ((AnimationDrawable)localObject).stop();
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getNumberOfFrames())
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getFrame(i);
        boolean bool = localObject instanceof BitmapDrawable;
        if (localObject != null) {
          ((Drawable)localObject).setCallback(null);
        }
        i += 1;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.setCallback(null);
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    }
  }
  
  public void b()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable == null) || (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getNumberOfFrames() != 29))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = new AnimationDrawable();
        int i = 0;
        while (i < 29)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(super.getResources().getDrawable(2130846801 + i), 50);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start animation error:");
      localStringBuilder.append(localOutOfMemoryError);
      SLog.e("Q.qqstory.QQStoryLoadingView", localStringBuilder.toString());
    }
  }
  
  public void setVisibility(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
      SLog.b("QQStoryLoadingView", "ignore VISIBLE");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (super.getVisibility() != paramInt)
    {
      super.setVisibility(paramInt);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QQStoryLoadingView");
      ((StringBuilder)localObject).append(System.identityHashCode(this));
      String str = ((StringBuilder)localObject).toString();
      if (paramInt == 8) {
        localObject = "GONE";
      } else if (paramInt == 0) {
        localObject = "VISIBLE";
      } else {
        localObject = "INVISIBLE";
      }
      SLog.a(str, "setVisibility => %s", localObject);
    }
    if (paramInt == 0)
    {
      b();
      return;
    }
    a();
  }
  
  public void setVisibilityDelay(int paramInt, long paramLong, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    localHandler.sendMessageDelayed(Message.obtain(localHandler, paramInt, paramString), paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.QQStoryLoadingView
 * JD-Core Version:    0.7.0.1
 */