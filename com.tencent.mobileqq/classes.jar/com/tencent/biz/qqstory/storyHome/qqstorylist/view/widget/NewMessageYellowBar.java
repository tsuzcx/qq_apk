package com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;

public class NewMessageYellowBar
  extends FrameLayout
{
  protected TextView a = null;
  protected int b = 0;
  protected TranslateAnimation c = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
  protected AlphaAnimation d = new AlphaAnimation(1.0F, 0.0F);
  protected AnimationSet e = new AnimationSet(false);
  
  public NewMessageYellowBar(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public NewMessageYellowBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      if (paramInt2 <= this.b) {
        return;
      }
      this.b = paramInt2;
    }
    if (paramInt1 > 0)
    {
      setVisibility(0);
      post(new NewMessageYellowBar.2(this, paramInt1));
      return;
    }
    setVisibility(8);
    this.a.setText(HardCodeUtil.a(2131905345));
    this.a.setAlpha(0.0F);
    if (!this.e.hasEnded()) {
      this.a.clearAnimation();
    }
  }
  
  public void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    LayoutInflater.from(getContext()).inflate(2131628221, this, true);
    this.a = ((TextView)findViewById(2131450361));
    this.c.setDuration(1000L);
    this.d.setStartOffset(1000L);
    this.d.setDuration(3000L);
    this.e.addAnimation(this.c);
    this.e.addAnimation(this.d);
    this.e.setFillAfter(true);
    this.e.setAnimationListener(new NewMessageYellowBar.1(this));
    setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.NewMessageYellowBar
 * JD-Core Version:    0.7.0.1
 */