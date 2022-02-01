package com.tencent.mobileqq.adapter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.widget.DecelerateAccelerateInterpolator;

public class ForwardRecentItemView
  extends RelativeLayout
{
  public View a;
  public TextView b;
  public TextView c;
  public ImageView d;
  public CheckBox e;
  public RelativeLayout f;
  public View g;
  public String h;
  public int i;
  public int j;
  public ResultRecord k;
  
  public ForwardRecentItemView(Context paramContext)
  {
    super(paramContext);
    a();
    b();
  }
  
  private void a()
  {
    this.a = View.inflate(getContext(), 2131629164, this);
    this.f = ((RelativeLayout)this.a.findViewById(2131444929));
    this.b = ((TextView)this.a.findViewById(2131447063));
    this.c = ((TextView)this.a.findViewById(2131447065));
    this.d = ((ImageView)this.a.findViewById(2131435219));
    this.e = ((CheckBox)this.a.findViewById(2131430688));
    this.g = this.a.findViewById(2131448716);
  }
  
  private void b()
  {
    this.i = getResources().getDimensionPixelOffset(2131298977);
    this.j = getResources().getDimensionPixelOffset(2131297151);
  }
  
  public void a(long paramLong)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { -this.i, 0 });
    localValueAnimator.setInterpolator(new DecelerateAccelerateInterpolator());
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.addUpdateListener(new ForwardRecentItemView.1(this, localLayoutParams));
    localValueAnimator.start();
  }
  
  public void a(String paramString1, String paramString2, Drawable paramDrawable, ResultRecord paramResultRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramString1, paramString2, paramDrawable, paramResultRecord, paramBoolean1, paramBoolean2, false);
  }
  
  public void a(String paramString1, String paramString2, Drawable paramDrawable, ResultRecord paramResultRecord, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.h = paramString1;
    this.k = paramResultRecord;
    this.b.setText(paramString1);
    this.d.setImageDrawable(paramDrawable);
    boolean bool = TextUtils.isEmpty(paramString2);
    int m = 8;
    if (bool)
    {
      this.c.setVisibility(8);
    }
    else
    {
      this.c.setVisibility(0);
      if (paramString2.startsWith("(")) {
        this.c.setText(paramString2);
      } else {
        this.c.setText(String.format("(%s)", new Object[] { paramString2 }));
      }
    }
    paramString2 = this.g;
    if (paramString2 != null)
    {
      if (paramBoolean3) {
        m = 0;
      }
      paramString2.setVisibility(m);
    }
    paramString2 = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
    int i1 = this.i;
    paramString2.leftMargin = (-i1);
    int n = this.j;
    m = n;
    if (paramBoolean1)
    {
      paramString2.leftMargin = 0;
      m = n - i1;
    }
    this.f.setLayoutParams(paramString2);
    this.e.setChecked(paramBoolean2);
    this.b.setMaxWidth(m);
    if (AppSetting.e) {
      setContentDescription(paramString1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.e.setChecked(paramBoolean);
    if (AppSetting.e)
    {
      Object localObject = getResources();
      int m;
      if (paramBoolean) {
        m = 2131887795;
      } else {
        m = 2131917725;
      }
      localObject = ((Resources)localObject).getString(m);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.h);
      localStringBuilder.append((String)localObject);
      setContentDescription(localStringBuilder.toString());
    }
  }
  
  public void b(long paramLong)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, -this.i });
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.addUpdateListener(new ForwardRecentItemView.2(this, localLayoutParams));
    localValueAnimator.start();
  }
  
  public void setMultiSelectStatus()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
    localLayoutParams.leftMargin = 0;
    this.f.setLayoutParams(localLayoutParams);
    this.b.setMaxWidth(this.j - this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ForwardRecentItemView
 * JD-Core Version:    0.7.0.1
 */