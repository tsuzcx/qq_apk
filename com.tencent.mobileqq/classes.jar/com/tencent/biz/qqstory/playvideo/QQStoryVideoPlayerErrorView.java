package com.tencent.biz.qqstory.playvideo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;

public class QQStoryVideoPlayerErrorView
  extends RelativeLayout
{
  protected TextView a;
  protected ImageView b;
  
  public QQStoryVideoPlayerErrorView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public QQStoryVideoPlayerErrorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.a.setVisibility(0);
      setTipsText(StoryApi.b(2131897984));
      setTipsIcon(2130848196);
      setTipsTextSize(16.0F);
      return;
    }
    if (paramInt == 1)
    {
      this.a.setVisibility(0);
      setTipsText(HardCodeUtil.a(2131908706));
      setTipsIcon(2130848352);
      setTipsTextSize(14.0F);
      return;
    }
    if (paramInt == 2) {
      this.a.setVisibility(8);
    }
  }
  
  public void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131628205, this, true);
    this.a = ((TextView)paramContext.findViewById(2131447419));
    this.b = ((ImageView)paramContext.findViewById(2131436318));
  }
  
  public void setCloseViewVisibility(boolean paramBoolean)
  {
    ImageView localImageView = this.b;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
  }
  
  public void setOnCloseClickListener(View.OnClickListener paramOnClickListener)
  {
    this.b.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnTipsClickListener(View.OnClickListener paramOnClickListener)
  {
    this.a.setOnClickListener(paramOnClickListener);
  }
  
  public void setTipsIcon(int paramInt)
  {
    try
    {
      Drawable localDrawable = getResources().getDrawable(paramInt);
      this.a.setCompoundDrawablesWithIntrinsicBounds(null, localDrawable, null, null);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label21:
      break label21;
    }
    SLog.d("QQStoryVideoPlayerErrorView", "oom ,set tips error");
  }
  
  public void setTipsText(String paramString)
  {
    this.a.setText(paramString);
  }
  
  public void setTipsTextSize(float paramFloat)
  {
    this.a.setTextSize(1, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView
 * JD-Core Version:    0.7.0.1
 */