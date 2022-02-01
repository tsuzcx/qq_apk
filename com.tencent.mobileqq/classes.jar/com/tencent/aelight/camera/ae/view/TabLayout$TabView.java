package com.tencent.aelight.camera.ae.view;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

class TabLayout$TabView
  extends FrameLayout
{
  private int a;
  private int b;
  private int c;
  private int d;
  private TextView e;
  
  public TabLayout$TabView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AECircleCaptureStyle localAECircleCaptureStyle;
    if (!paramBoolean) {
      localAECircleCaptureStyle = AECircleCaptureStyle.a;
    } else {
      localAECircleCaptureStyle = AECircleCaptureStyle.e;
    }
    this.a = localAECircleCaptureStyle.D;
    if (!paramBoolean) {
      localAECircleCaptureStyle = AECircleCaptureStyle.a;
    } else {
      localAECircleCaptureStyle = AECircleCaptureStyle.e;
    }
    this.b = localAECircleCaptureStyle.C;
    if (!paramBoolean) {
      localAECircleCaptureStyle = AECircleCaptureStyle.b;
    } else {
      localAECircleCaptureStyle = AECircleCaptureStyle.f;
    }
    this.c = localAECircleCaptureStyle.D;
    if (!paramBoolean) {
      localAECircleCaptureStyle = AECircleCaptureStyle.b;
    } else {
      localAECircleCaptureStyle = AECircleCaptureStyle.f;
    }
    this.d = localAECircleCaptureStyle.C;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.e = new TextView(paramContext);
    this.e.setGravity(1);
    this.e.setTextSize(1, 15.0F);
    addView(this.e);
  }
  
  public TextView a()
  {
    return this.e;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    TextView localTextView;
    int i;
    if (!paramBoolean2)
    {
      localTextView = this.e;
      if (paramBoolean1) {
        i = this.b;
      } else {
        i = this.a;
      }
      localTextView.setTextColor(i);
    }
    else
    {
      localTextView = this.e;
      if (paramBoolean1) {
        i = this.d;
      } else {
        i = this.c;
      }
      localTextView.setTextColor(i);
    }
    if (paramBoolean2)
    {
      this.e.setShadowLayer(1.0F, 0.0F, 0.0F, 2131165578);
      return;
    }
    this.e.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.TabLayout.TabView
 * JD-Core Version:    0.7.0.1
 */