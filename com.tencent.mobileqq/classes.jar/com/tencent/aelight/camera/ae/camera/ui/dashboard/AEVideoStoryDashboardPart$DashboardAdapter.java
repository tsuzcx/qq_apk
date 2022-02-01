package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

class AEVideoStoryDashboardPart$DashboardAdapter
  extends RecyclerView.Adapter<AEVideoStoryDashboardPart.DashboardHolder>
{
  private Context a;
  private List<AEVideoStoryDashboardPart.DashboardInfo> b;
  
  public AEVideoStoryDashboardPart$DashboardAdapter(@NonNull Context paramContext)
  {
    this.a = paramContext;
    this.b = new LinkedList();
  }
  
  public AEVideoStoryDashboardPart.DashboardHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new AEVideoStoryDashboardPart.DashboardHolder(LayoutInflater.from(this.a).inflate(2064056349, paramViewGroup, false));
  }
  
  public void a(AEVideoStoryDashboardPart.DashboardHolder paramDashboardHolder, int paramInt)
  {
    paramDashboardHolder.a((AEVideoStoryDashboardPart.DashboardInfo)this.b.get(paramInt));
  }
  
  public void a(@NonNull List<AEVideoStoryDashboardPart.DashboardInfo> paramList)
  {
    this.b = paramList;
    ThreadManager.getUIHandler().post(new AEVideoStoryDashboardPart.DashboardAdapter.1(this));
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.DashboardAdapter
 * JD-Core Version:    0.7.0.1
 */