package com.tencent.biz.qqcircle.widgets;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto.StItemInfo;

class QCircleGroupMoreWidget$GroupMoreAdapter
  extends RecyclerView.Adapter<QCircleGroupMoreWidget.GroupMoreViewHolder>
{
  private List<QQCircleDitto.StItemInfo> b = new ArrayList();
  private int c;
  private FeedBlockData d;
  private RecyclerView e;
  
  public QCircleGroupMoreWidget$GroupMoreAdapter(QCircleGroupMoreWidget paramQCircleGroupMoreWidget, RecyclerView paramRecyclerView)
  {
    this.e = paramRecyclerView;
  }
  
  public QCircleGroupMoreWidget.GroupMoreViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new QCircleGroupMoreWidget.GroupMoreViewHolder(this.a, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131626839, paramViewGroup, false));
  }
  
  protected void a()
  {
    RecyclerView localRecyclerView = this.e;
    if (localRecyclerView != null)
    {
      if (localRecyclerView.isComputingLayout())
      {
        this.e.postDelayed(new QCircleGroupMoreWidget.GroupMoreAdapter.1(this), 200L);
        return;
      }
      notifyDataSetChanged();
    }
  }
  
  public void a(FeedBlockData paramFeedBlockData, int paramInt)
  {
    this.d = paramFeedBlockData;
    this.c = paramInt;
  }
  
  public void a(QCircleGroupMoreWidget.GroupMoreViewHolder paramGroupMoreViewHolder)
  {
    super.onViewAttachedToWindow(paramGroupMoreViewHolder);
    paramGroupMoreViewHolder = paramGroupMoreViewHolder.a();
    if (paramGroupMoreViewHolder == null) {
      return;
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder().setActionType(122).setSubActionType(1).setPageId(this.a.getReportBean().getPageId()).setToUin(paramGroupMoreViewHolder.id.get()).setFeedId(QCircleGroupMoreWidget.a(this.a, paramGroupMoreViewHolder.busiInfo.get(), "feedid")).setExt2(QCircleGroupMoreWidget.a(this.a)));
  }
  
  public void a(QCircleGroupMoreWidget.GroupMoreViewHolder paramGroupMoreViewHolder, int paramInt)
  {
    paramGroupMoreViewHolder.a(this.d, this.c, (QQCircleDitto.StItemInfo)this.b.get(paramInt), paramInt);
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramGroupMoreViewHolder.itemView.getLayoutParams();
    if ((paramInt > 0) && (paramInt == this.b.size() - 1)) {
      localLayoutParams.setMargins(0, 0, ImmersiveUtils.a(-5.0F), 0);
    } else {
      localLayoutParams.setMargins(0, 0, ImmersiveUtils.a(-15.0F), 0);
    }
    paramGroupMoreViewHolder.itemView.setLayoutParams(localLayoutParams);
  }
  
  public void a(List<QQCircleDitto.StItemInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      this.b.clear();
      this.b.addAll(paramList);
      a();
    }
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleGroupMoreWidget.GroupMoreAdapter
 * JD-Core Version:    0.7.0.1
 */