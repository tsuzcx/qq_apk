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
  protected Handler b = new QQStoryLoadingView.1(this, Looper.getMainLooper());
  
  public QQStoryLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
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
      paramContext.getResources().getDrawable(2130848353 + i);
      i += 1;
    }
  }
  
  public void a()
  {
    super.setCompoundDrawablesWithIntrinsicBounds(null, super.getResources().getDrawable(2130848353), null, null);
    Object localObject = this.a;
    if (localObject != null)
    {
      ((AnimationDrawable)localObject).stop();
      int i = 0;
      while (i < this.a.getNumberOfFrames())
      {
        localObject = this.a.getFrame(i);
        boolean bool = localObject instanceof BitmapDrawable;
        if (localObject != null) {
          ((Drawable)localObject).setCallback(null);
        }
        i += 1;
      }
      this.a.setCallback(null);
      this.a = null;
    }
  }
  
  public void b()
  {
    try
    {
      if ((this.a == null) || (this.a.getNumberOfFrames() != 29))
      {
        this.a = new AnimationDrawable();
        int i = 0;
        while (i < 29)
        {
          this.a.addFrame(super.getResources().getDrawable(2130848353 + i), 50);
          i += 1;
        }
        this.a.setOneShot(false);
        super.setCompoundDrawablesWithIntrinsicBounds(null, this.a, null, null);
      }
      this.a.start();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      this.a = null;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start animation error:");
      localStringBuilder.append(localOutOfMemoryError);
      SLog.e("Q.qqstory.QQStoryLoadingView", localStringBuilder.toString());
    }
  }
  
  public int getDelayVisibility()
  {
    if (this.b.hasMessages(0)) {
      return 0;
    }
    if (this.b.hasMessages(4)) {
      return 4;
    }
    if (this.b.hasMessages(8)) {
      return 8;
    }
    return -1;
  }
  
  public void setVisibility(int paramInt)
  {
    if (this.b.hasMessages(0)) {
      SLog.b("QQStoryLoadingView", "ignore VISIBLE");
    }
    this.b.removeCallbacksAndMessages(null);
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
    this.b.removeCallbacksAndMessages(null);
    Handler localHandler = this.b;
    localHandler.sendMessageDelayed(Message.obtain(localHandler, paramInt, paramString), paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.QQStoryLoadingView
 * JD-Core Version:    0.7.0.1
 */