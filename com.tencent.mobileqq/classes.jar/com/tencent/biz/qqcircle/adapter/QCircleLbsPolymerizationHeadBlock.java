package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseSingleViewBlock;
import com.tencent.biz.qqcircle.widgets.polymerization.QCircleLbsPolymerizationHeadView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase.StGpsPageData;

public class QCircleLbsPolymerizationHeadBlock
  extends QCircleBaseSingleViewBlock
{
  private QCircleLbsPolymerizationHeadView a;
  
  public QCircleLbsPolymerizationHeadBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, MultiViewBlock paramMultiViewBlock)
  {
    this.a = new QCircleLbsPolymerizationHeadView(paramViewGroup.getContext());
    this.a.setReportBean(d());
    return this.a;
  }
  
  protected String a()
  {
    return "QCircleLbsPolymerizationHeadBlock";
  }
  
  public void loadData(LoadInfo paramLoadInfo) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.mDataList != null) && (this.mDataList.size() >= 1))
    {
      if (this.a == null) {
        return;
      }
      paramViewHolder = new StringBuilder();
      paramViewHolder.append("QCircleLbsPolymerizationHeadView setData i");
      paramViewHolder.append(paramInt);
      QLog.d("QCircleLbsPolymerizationHeadBlock", 1, paramViewHolder.toString());
      if ((this.mDataList.get(paramInt) instanceof QQCircleFeedBase.StFeedListBusiRspData)) {
        this.a.setData(((QQCircleFeedBase.StFeedListBusiRspData)this.mDataList.get(paramInt)).gpsPageData.get());
      }
    }
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleLbsPolymerizationHeadBlock
 * JD-Core Version:    0.7.0.1
 */