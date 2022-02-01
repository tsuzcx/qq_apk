package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseSingleViewBlock;
import com.tencent.biz.qqcircle.widgets.polymerization.QCirclePatSamePolymerizationHeadView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import qqcircle.QQCircleFeedBase.StFashionCopyPageData;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;

public class QCirclePatSamePolymerizationHeadBlock
  extends QCircleBaseSingleViewBlock
{
  private QCirclePatSamePolymerizationHeadView a;
  
  public QCirclePatSamePolymerizationHeadBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, MultiViewBlock paramMultiViewBlock)
  {
    this.a = new QCirclePatSamePolymerizationHeadView(paramViewGroup.getContext());
    this.a.setReportBean(d());
    return this.a;
  }
  
  protected String a()
  {
    return "QCirclePatSamePolymerizationHeadBlock";
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
      paramViewHolder.append("QCirclePatSamePolymerizationHeadBlock setData i");
      paramViewHolder.append(paramInt);
      QLog.d("QCirclePatSamePolymerizationHeadBlock", 1, paramViewHolder.toString());
      if ((this.mDataList.get(paramInt) instanceof QQCircleFeedBase.StFeedListBusiRspData)) {
        this.a.setData(((QQCircleFeedBase.StFeedListBusiRspData)this.mDataList.get(paramInt)).fashionCopyPageData.get());
      }
    }
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCirclePatSamePolymerizationHeadBlock
 * JD-Core Version:    0.7.0.1
 */