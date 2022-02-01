package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;

public abstract class AbsEmptyView
  extends FrameLayout
{
  private TextView a;
  private ImageView b;
  private View c;
  private View d;
  private View e;
  private View f;
  private Button g;
  private int h;
  private int i;
  private int j = 0;
  
  public AbsEmptyView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AbsEmptyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      int k = this.j;
      if (k == paramInt) {
        return;
      }
      if ((k == 0) && (paramInt == 3)) {
        return;
      }
    }
    this.j = paramInt;
    this.f.setVisibility(8);
    if (paramInt == 0)
    {
      this.c.setVisibility(8);
      this.d.setVisibility(8);
      this.e.setVisibility(8);
      return;
    }
    if (paramInt == 3)
    {
      this.c.setVisibility(0);
      this.d.setVisibility(8);
      this.e.setVisibility(8);
      return;
    }
    if (paramInt == 1)
    {
      this.e.setVisibility(0);
      this.d.setVisibility(8);
      this.c.setVisibility(8);
      this.a = ((TextView)super.findViewById(2131450155));
      this.b = ((ImageView)super.findViewById(2131450140));
      return;
    }
    if (paramInt == 2)
    {
      this.c.setVisibility(8);
      this.d.setVisibility(0);
      this.e.setVisibility(8);
      this.a = ((TextView)super.findViewById(2131447419));
      this.b = ((ImageView)super.findViewById(2131429584));
      return;
    }
    if (paramInt == 4)
    {
      this.c.setVisibility(8);
      this.d.setVisibility(8);
      this.e.setVisibility(8);
      this.f.setVisibility(0);
    }
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131628135, this);
    this.c = super.findViewById(2131437648);
    this.d = super.findViewById(2131447411);
    this.e = super.findViewById(2131447410);
    this.g = ((Button)super.findViewById(2131444737));
    this.a = ((TextView)super.findViewById(2131447419));
    this.b = ((ImageView)super.findViewById(2131429584));
    this.f = super.findViewById(2131447937);
    this.h = UIUtils.b(getContext());
    this.i = getViewHeight();
    a(0, true);
    super.postDelayed(new AbsEmptyView.2(this), 500L);
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  public abstract int getViewHeight();
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.h, 1073741824), View.MeasureSpec.makeMeasureSpec(this.i, 1073741824));
  }
  
  public void setRetryClickListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.g.setOnClickListener(null);
      return;
    }
    this.g.setOnClickListener(new AbsEmptyView.1(this, paramOnClickListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.AbsEmptyView
 * JD-Core Version:    0.7.0.1
 */