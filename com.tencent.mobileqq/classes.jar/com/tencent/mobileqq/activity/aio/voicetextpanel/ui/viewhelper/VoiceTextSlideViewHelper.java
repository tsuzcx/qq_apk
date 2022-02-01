package com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextEditScrollerView;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;

public class VoiceTextSlideViewHelper
{
  private VoiceTextPanel a;
  private RelativeLayout b;
  private FrameLayout c;
  private VoiceTextEditScrollerView d;
  
  public void a()
  {
    this.d.setListener(this.a.getVoiceTextScrollerListener());
  }
  
  public void a(int paramInt)
  {
    this.d.setMaxHeight(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    VoiceTextEditScrollerView localVoiceTextEditScrollerView = this.d;
    localVoiceTextEditScrollerView.a(localVoiceTextEditScrollerView.getTop(), paramInt1, paramInt2, paramInt3, 0, 200, this.d);
    this.b.setVisibility(8);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.d.a(paramInt4, paramInt2, paramInt3 - paramInt1, paramInt3, 1, 100, this.a);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.d.setPanelActionDownPos(paramInt2, paramInt4);
    this.c.setVisibility(0);
    this.c.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt5, 1073741824));
    this.c.layout(paramInt1, 0, paramInt3, paramInt5);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    this.d.onTouchEvent(paramMotionEvent);
    if (paramMotionEvent.getAction() == 0) {
      this.d.setMaskClick(true);
    }
  }
  
  public void a(VoiceTextPanel paramVoiceTextPanel)
  {
    this.a = paramVoiceTextPanel;
    this.b = ((RelativeLayout)paramVoiceTextPanel.findViewById(2131434940));
    this.c = ((FrameLayout)paramVoiceTextPanel.findViewById(2131437976));
    this.c.setOnTouchListener(new VoiceTextSlideViewHelper.1(this));
    this.d = ((VoiceTextEditScrollerView)paramVoiceTextPanel.findViewById(2131431322));
  }
  
  public void a(boolean paramBoolean)
  {
    this.d.setSlideEnable(paramBoolean);
  }
  
  public void b()
  {
    this.b.setVisibility(0);
    this.d.setSlideEnable(true);
    this.d.setBackgroundDrawable(this.a.getContext().getResources().getDrawable(2130839665));
  }
  
  public void c()
  {
    this.b.setVisibility(8);
    this.d.setSlideEnable(false);
    this.d.setBackgroundDrawable(this.a.getContext().getResources().getDrawable(2130852150));
  }
  
  public void d()
  {
    this.b.setVisibility(8);
    this.d.setBackgroundDrawable(this.a.getContext().getResources().getDrawable(2130852150));
  }
  
  public void e()
  {
    this.d.setListener(null);
  }
  
  public int f()
  {
    return this.d.getTop();
  }
  
  public int g()
  {
    return this.b.getVisibility();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextSlideViewHelper
 * JD-Core Version:    0.7.0.1
 */