package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import uwz;
import vur;
import zvh;
import zwe;
import zwj;

public class FrameAnimationView
  extends URLImageView
{
  private boolean a;
  
  public FrameAnimationView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FrameAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FrameAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.a = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.a = false;
    if (getHandler() != null) {
      getHandler().removeCallbacksAndMessages(null);
    }
    QQAnimationDrawable localQQAnimationDrawable;
    if ((getBackground() instanceof QQAnimationDrawable))
    {
      localQQAnimationDrawable = (QQAnimationDrawable)getBackground();
      if (localQQAnimationDrawable.isRunning()) {
        localQQAnimationDrawable.stop();
      }
    }
    if ((getDrawable() instanceof QQAnimationDrawable))
    {
      localQQAnimationDrawable = (QQAnimationDrawable)getDrawable();
      if (localQQAnimationDrawable.isRunning()) {
        localQQAnimationDrawable.run();
      }
    }
  }
  
  public void setAnimationFile(String paramString, int paramInt, boolean paramBoolean)
  {
    paramString = zvh.a(paramString);
    if ((paramString != null) && (paramString.length > 0) && (getHandler() != null)) {
      getHandler().post(new FrameAnimationView.1(this, paramString, paramInt, paramBoolean));
    }
  }
  
  public void setDownloadZipFilePath(String paramString, int paramInt, boolean paramBoolean)
  {
    zwj.a(uwz.a()).b(paramString, new vur(this, paramInt, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.FrameAnimationView
 * JD-Core Version:    0.7.0.1
 */