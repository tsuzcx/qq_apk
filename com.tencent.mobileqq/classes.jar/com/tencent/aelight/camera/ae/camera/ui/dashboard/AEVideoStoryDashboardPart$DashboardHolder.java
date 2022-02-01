package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

class AEVideoStoryDashboardPart$DashboardHolder
  extends RecyclerView.ViewHolder
{
  private TextView a;
  
  public AEVideoStoryDashboardPart$DashboardHolder(View paramView)
  {
    super(paramView);
    this.a = ((TextView)paramView.findViewById(2064121868));
  }
  
  public void a(@NonNull AEVideoStoryDashboardPart.DashboardInfo paramDashboardInfo)
  {
    this.a.setText(paramDashboardInfo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.DashboardHolder
 * JD-Core Version:    0.7.0.1
 */