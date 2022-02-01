package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.PressDarkImageView;
import com.tencent.util.LiuHaiUtils;

public class StoryGuideLineView
  extends LinearLayout
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  private PressDarkImageView e;
  private TextView f;
  private LinearLayout g;
  private LinearLayout h;
  private LinearLayout i;
  private View j;
  private View k;
  private View l;
  
  public StoryGuideLineView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public StoryGuideLineView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public StoryGuideLineView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131629313, this, true);
    this.e = ((PressDarkImageView)findViewById(2131442652));
    this.f = ((TextView)findViewById(2131442756));
    this.g = ((LinearLayout)findViewById(2131446808));
    this.h = ((LinearLayout)findViewById(2131435669));
    this.i = ((LinearLayout)findViewById(2131442696));
    this.j = findViewById(2131442697);
    this.l = findViewById(2131442705);
    this.k = findViewById(2131442702);
    setViewAlpha(this.i);
  }
  
  public void a()
  {
    if (this.i != null)
    {
      View localView = this.j;
      if (localView != null)
      {
        localView.setVisibility(8);
        this.i.setVisibility(8);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.i != null)
    {
      View localView = this.j;
      if (localView != null)
      {
        localView.setVisibility(0);
        if (paramBoolean) {
          this.i.setVisibility(0);
        }
      }
    }
  }
  
  public void b()
  {
    View localView = this.l;
    if (localView != null) {
      localView.setVisibility(0);
    }
  }
  
  public void c()
  {
    View localView = this.l;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void d()
  {
    View localView = this.k;
    if (localView != null) {
      localView.setVisibility(0);
    }
  }
  
  public void e()
  {
    View localView = this.k;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void f()
  {
    c();
    e();
    a();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    measureChild(this.i, paramInt1, paramInt2);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    a = this.k.getMeasuredWidth();
    b = localDisplayMetrics.widthPixels - this.l.getMeasuredWidth();
    c = 0;
    d = localDisplayMetrics.heightPixels - this.i.getMeasuredHeight();
    if (LiuHaiUtils.b()) {
      d = localDisplayMetrics.heightPixels - this.i.getMeasuredHeight() - LiuHaiUtils.j - LiuHaiUtils.d;
    }
  }
  
  public void setUserHead(Bitmap paramBitmap)
  {
    PressDarkImageView localPressDarkImageView = this.e;
    if (localPressDarkImageView != null) {
      localPressDarkImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void setUserName(String paramString)
  {
    if ((this.f != null) && (!TextUtils.isEmpty(paramString))) {
      this.f.setText(paramString);
    }
  }
  
  public void setViewAlpha(ViewGroup paramViewGroup)
  {
    int n = paramViewGroup.getChildCount();
    if (n == 0) {
      return;
    }
    int m = 0;
    while (m < n)
    {
      View localView = paramViewGroup.getChildAt(m);
      if ((localView instanceof ViewGroup)) {
        setViewAlpha((ViewGroup)localView);
      }
      if (localView.getBackground() != null) {
        localView.getBackground().mutate().setAlpha(60);
      }
      localView.setAlpha(0.6F);
      m += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.widget.StoryGuideLineView
 * JD-Core Version:    0.7.0.1
 */