package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseSingleViewBlock;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.widgets.QCircleFeedTianShuBannerView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class QCircleTianShuBannerBlock
  extends QCircleBaseSingleViewBlock
{
  public static final long a = TimeUnit.SECONDS.toMillis(QCircleConfigHelper.l());
  private QCircleFeedTianShuBannerView c;
  
  public QCircleTianShuBannerBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, MultiViewBlock paramMultiViewBlock)
  {
    this.c = new QCircleFeedTianShuBannerView(getContext());
    this.c.setReportBean(d());
    return this.c;
  }
  
  protected String a()
  {
    return "QCircleInviteBannerBlock";
  }
  
  public void a(FeedBlockData paramFeedBlockData)
  {
    if (paramFeedBlockData != null)
    {
      setDatas(new ArrayList(Arrays.asList(new FeedBlockData[] { paramFeedBlockData })));
      a(true);
      return;
    }
    a(false);
  }
  
  protected int getFixedViewTypeOffset()
  {
    return 300000;
  }
  
  public void loadData(LoadInfo paramLoadInfo) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.mDataList != null) && (this.mDataList.size() > 0) && (this.c != null) && ((this.mDataList.get(0) instanceof FeedBlockData))) {
      this.c.setData(this.mDataList.get(0), 0);
    }
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleTianShuBannerBlock
 * JD-Core Version:    0.7.0.1
 */