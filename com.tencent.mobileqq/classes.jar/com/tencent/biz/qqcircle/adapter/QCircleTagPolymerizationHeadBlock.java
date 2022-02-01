package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseSingleViewBlock;
import com.tencent.biz.qqcircle.widgets.polymerization.QCircleTagPolymerizationHeadView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase.StTagPageData;

public class QCircleTagPolymerizationHeadBlock
  extends QCircleBaseSingleViewBlock
{
  private QCircleTagPolymerizationHeadView a;
  private QCirclePolymerizationBean c;
  
  public QCircleTagPolymerizationHeadBlock(Bundle paramBundle)
  {
    super(paramBundle);
    if (paramBundle != null) {
      this.c = ((QCirclePolymerizationBean)paramBundle.getSerializable("key_block_bundle_bean"));
    }
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, MultiViewBlock paramMultiViewBlock)
  {
    this.a = new QCircleTagPolymerizationHeadView(paramViewGroup.getContext());
    this.a.setReportBean(d());
    this.a.setInitBean(this.c);
    return this.a;
  }
  
  protected String a()
  {
    return "QCircleTagPolymerizationHeadBlock";
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
      paramViewHolder.append("QcircleTagPolymerizationHeadView setData i");
      paramViewHolder.append(paramInt);
      QLog.d("QCircleTagPolymerizationHeadBlock", 1, paramViewHolder.toString());
      if ((this.mDataList.get(paramInt) instanceof QQCircleFeedBase.StFeedListBusiRspData)) {
        this.a.setData(((QQCircleFeedBase.StFeedListBusiRspData)this.mDataList.get(paramInt)).tagPageData.get());
      }
    }
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleTagPolymerizationHeadBlock
 * JD-Core Version:    0.7.0.1
 */