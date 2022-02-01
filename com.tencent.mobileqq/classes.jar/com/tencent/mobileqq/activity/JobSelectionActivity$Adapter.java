package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.widget.InterestLabelTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class JobSelectionActivity$Adapter
  extends BaseAdapter
{
  private String[] b;
  private String[] c;
  private int[] d;
  
  private JobSelectionActivity$Adapter(JobSelectionActivity paramJobSelectionActivity)
  {
    if (JobSelectionActivity.a(this.a)) {
      paramJobSelectionActivity = ConditionSearchManager.l;
    } else {
      paramJobSelectionActivity = NearbyProfileUtil.e;
    }
    this.b = paramJobSelectionActivity;
    if (JobSelectionActivity.a(this.a)) {
      paramJobSelectionActivity = ConditionSearchManager.m;
    } else {
      paramJobSelectionActivity = NearbyProfileUtil.f;
    }
    this.c = paramJobSelectionActivity;
    if (JobSelectionActivity.a(this.a)) {
      paramJobSelectionActivity = ConditionSearchManager.n;
    } else {
      paramJobSelectionActivity = NearbyProfileUtil.g;
    }
    this.d = paramJobSelectionActivity;
  }
  
  public int getCount()
  {
    if (JobSelectionActivity.b(this.a)) {
      return this.b.length - 2;
    }
    return this.b.length - 1;
  }
  
  public Object getItem(int paramInt)
  {
    paramInt = this.a.a(paramInt);
    return this.b[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = this.a.getLayoutInflater().inflate(2131627474, paramViewGroup, false);
      paramView = new JobSelectionActivity.ViewHolder(null);
      paramView.a = ((InterestLabelTextView)localView.findViewById(2131446778));
      paramView.b = ((TextView)localView.findViewById(2131439121));
      paramView.c = ((ImageView)localView.findViewById(2131430678));
      localView.setTag(paramView);
    }
    paramView = (JobSelectionActivity.ViewHolder)localView.getTag();
    int i = this.a.a(paramInt);
    Drawable localDrawable = this.a.getResources().getDrawable(this.d[i]);
    ProfileCardUtils.setNightModeFilterForDrawable(this.a.app, localDrawable);
    paramView.a.setText(this.c[i]);
    paramView.a.setBackgroundDrawable(localDrawable);
    int j = AIOUtils.b(4.0F, JobSelectionActivity.c(this.a).getResources());
    paramView.a.setPadding(j, 0, j, 0);
    if (i < this.b.length - 1) {
      paramView.a.setVisibility(0);
    } else {
      paramView.a.setVisibility(4);
    }
    if ((JobSelectionActivity.b(this.a)) && (i == 0)) {
      paramView.a.setVisibility(4);
    }
    paramView.b.setText(this.b[i]);
    if (JobSelectionActivity.d(this.a) == i) {
      paramView.c.setVisibility(0);
    } else {
      paramView.c.setVisibility(4);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JobSelectionActivity.Adapter
 * JD-Core Version:    0.7.0.1
 */