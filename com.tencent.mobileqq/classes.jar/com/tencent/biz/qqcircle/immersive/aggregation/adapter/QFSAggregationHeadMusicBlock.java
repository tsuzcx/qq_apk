package com.tencent.biz.qqcircle.immersive.aggregation.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseSingleViewBlock;
import com.tencent.biz.qqcircle.immersive.QFSMusicAggregationFragment;
import com.tencent.biz.qqcircle.immersive.aggregation.widget.QFSAggregationHeadWidget;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;

public class QFSAggregationHeadMusicBlock
  extends QCircleBaseSingleViewBlock
{
  private QFSAggregationHeadWidget a;
  
  public QFSAggregationHeadMusicBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, MultiViewBlock paramMultiViewBlock)
  {
    this.a = new QFSAggregationHeadWidget(paramViewGroup.getContext(), (QFSMusicAggregationFragment)getParentFragment());
    return this.a;
  }
  
  protected String a()
  {
    return null;
  }
  
  public void loadData(LoadInfo paramLoadInfo) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    paramActivity = this.a;
    if (paramActivity != null) {
      paramActivity.c();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    paramActivity = this.a;
    if (paramActivity != null) {
      paramActivity.a();
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    paramActivity = this.a;
    if (paramActivity != null) {
      paramActivity.b();
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.aggregation.adapter.QFSAggregationHeadMusicBlock
 * JD-Core Version:    0.7.0.1
 */