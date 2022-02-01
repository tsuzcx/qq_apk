package com.tencent.mobileqq.adapter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.DecelerateAccelerateInterpolator;
import com.tencent.qphone.base.util.QLog;

public class QQGuildChannelItemView
  extends RelativeLayout
{
  private static final int i = ViewUtils.dpToPx(40.0F);
  private static final int j = ViewUtils.dpToPx(16.0F);
  public View a;
  public TextView b;
  public TextView c;
  public CheckBox d;
  public RelativeLayout e;
  public ImageView f;
  public String g;
  public ResultRecord h;
  
  public QQGuildChannelItemView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    this.a = View.inflate(getContext(), 2131625120, this);
    this.e = ((RelativeLayout)this.a.findViewById(2131444929));
    this.b = ((TextView)this.a.findViewById(2131447067));
    this.c = ((TextView)this.a.findViewById(2131447073));
    this.d = ((CheckBox)this.a.findViewById(2131430688));
    this.f = ((ImageView)this.a.findViewById(2131435219));
  }
  
  public void a(long paramLong)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { -i, j });
    localValueAnimator.setInterpolator(new DecelerateAccelerateInterpolator());
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.addUpdateListener(new QQGuildChannelItemView.1(this, localLayoutParams));
    localValueAnimator.start();
  }
  
  public void a(ResultRecord paramResultRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("bindData resultRecord: ");
      localStringBuilder.append(paramResultRecord.toString());
      localStringBuilder.append(" multiSelect: ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append("selected");
      localStringBuilder.append(paramBoolean2);
      QLog.i("QQGuildChannelItemView", 2, localStringBuilder.toString());
    }
    this.g = paramResultRecord.name;
    this.h = paramResultRecord;
    if (paramResultRecord.uinType == 10016)
    {
      this.b.setVisibility(8);
      this.d.setVisibility(8);
      this.f.setVisibility(8);
      this.c.setText(this.g);
      this.c.setVisibility(0);
      this.a.setBackgroundResource(2130852377);
    }
    else if (paramResultRecord.uinType == 10014)
    {
      this.c.setVisibility(8);
      this.b.setText(this.g);
      this.b.setVisibility(0);
      this.d.setVisibility(0);
      this.f.setVisibility(0);
      this.a.setBackgroundResource(2130839577);
      paramResultRecord = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
      if (paramBoolean1) {
        paramResultRecord.leftMargin = j;
      } else {
        paramResultRecord.leftMargin = (-i);
      }
      this.e.setLayoutParams(paramResultRecord);
      this.d.setChecked(paramBoolean2);
    }
    else if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Err resultRecord.uinType:");
      localStringBuilder.append(paramResultRecord.uinType);
      QLog.e("QQGuildChannelItemView", 2, localStringBuilder.toString());
    }
    if (AppSetting.e) {
      setContentDescription(this.g);
    }
  }
  
  public void b(long paramLong)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { j, -i });
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.addUpdateListener(new QQGuildChannelItemView.2(this, localLayoutParams));
    localValueAnimator.start();
  }
  
  public void setMultiSelectStatus()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
    localLayoutParams.leftMargin = j;
    this.e.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.QQGuildChannelItemView
 * JD-Core Version:    0.7.0.1
 */