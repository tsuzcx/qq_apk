package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseMultiViewBlock;
import com.tencent.biz.qqcircle.requests.QCircleGetTaskCenterListRequest;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.richframework.part.utils.ArrayUtils;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.widgets.QCircleTaskItemView;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter.BaseVH;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.ArrayList;
import qqcircle.TaskCenterReader.TaskRecord;

public class QCircleTaskCenterAdapter
  extends QCircleBaseMultiViewBlock<TaskCenterReader.TaskRecord>
{
  LinearLayout a;
  TextView b;
  private RelativeLayout c;
  private String d;
  private int[] e = { 2130845217, 2130845218, 2130845219, 2130845220, 2130845221, 2130845222, 2130845223, 2130845224, 2130845225, 2130845226 };
  private ReportBean<QCircleReportBean> f;
  
  public QCircleTaskCenterAdapter(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private RelativeLayout a()
  {
    this.c = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131626977, null));
    this.a = ((LinearLayout)this.c.findViewById(2131437524));
    this.b = ((TextView)this.c.findViewById(2131448501));
    this.b.setOnClickListener(new QCircleTaskCenterAdapter.1(this));
    this.c.setLayoutParams(new FrameLayout.LayoutParams(-1, ImmersiveUtils.a(60.0F)));
    return this.c;
  }
  
  public void a(ReportBean<QCircleReportBean> paramReportBean)
  {
    this.f = paramReportBean;
  }
  
  public int getItemCount()
  {
    return getDataNumber();
  }
  
  protected String getLogTag()
  {
    return "QCircleTaskCenterAdapter";
  }
  
  protected int getPageId()
  {
    if (this.mReportBean != null) {
      return QCircleReportBean.getPageId("QCircleTaskCenterAdapter", this.mReportBean);
    }
    ReportBean localReportBean = this.f;
    if (localReportBean != null) {
      return QCircleReportBean.getPageId("QCircleTaskCenterAdapter", (QCircleReportBean)localReportBean.getReportBean());
    }
    return 0;
  }
  
  protected int getParentPageId()
  {
    if (this.mReportBean != null) {
      return QCircleReportBean.getParentPageId("QCircleTaskCenterAdapter", this.mReportBean);
    }
    ReportBean localReportBean = this.f;
    if (localReportBean != null) {
      return QCircleReportBean.getParentPageId("QCircleTaskCenterAdapter", (QCircleReportBean)localReportBean.getReportBean());
    }
    return 0;
  }
  
  public QCircleReportBean getReportBean()
  {
    if (this.mReportBean != null) {
      return QCircleReportBean.getReportBean(getLogTag(), this.mReportBean);
    }
    if (this.f != null) {
      return QCircleReportBean.getReportBean(getLogTag(), (QCircleReportBean)this.f.getReportBean());
    }
    return null;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public void loadData(LoadInfo paramLoadInfo)
  {
    if (paramLoadInfo.d())
    {
      paramLoadInfo = new QCircleGetTaskCenterListRequest(HostDataTransUtils.getAccount());
      paramLoadInfo.setEnableCache(true);
      VSNetworkHelper.getInstance().sendRequest(getContext(), paramLoadInfo, new QCircleTaskCenterAdapter.2(this));
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!ArrayUtils.a(paramInt, getDataList())) {
      ((QCircleTaskItemView)paramViewHolder.itemView).setData(getDataList().get(paramInt));
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new QCircleTaskItemView(paramViewGroup.getContext());
    paramViewGroup.setReportBean(getReportBean());
    return new BaseListViewAdapter.BaseVH(this, paramViewGroup);
  }
  
  public void onDetachedFromRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    setDatas(null);
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    if (this.c == null) {
      addFixViewOccupySpaceAtTop(a(), ImmersiveUtils.a(60.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleTaskCenterAdapter
 * JD-Core Version:    0.7.0.1
 */