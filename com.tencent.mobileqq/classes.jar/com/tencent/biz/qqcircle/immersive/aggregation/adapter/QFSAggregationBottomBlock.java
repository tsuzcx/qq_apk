package com.tencent.biz.qqcircle.immersive.aggregation.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseSingleViewBlock;
import com.tencent.biz.qqcircle.immersive.QFSMusicAggregationFragment;
import com.tencent.biz.qqcircle.immersive.aggregation.bean.QFSMusicAggregationInitBean;
import com.tencent.biz.qqcircle.immersive.aggregation.widget.QFSAggregationBottomWidget;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;

public class QFSAggregationBottomBlock
  extends QCircleBaseSingleViewBlock
{
  private final QFSMusicAggregationInitBean a;
  private QFSAggregationBottomWidget c;
  
  public QFSAggregationBottomBlock(Bundle paramBundle, QFSMusicAggregationInitBean paramQFSMusicAggregationInitBean)
  {
    super(paramBundle);
    this.a = paramQFSMusicAggregationInitBean;
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, MultiViewBlock paramMultiViewBlock)
  {
    this.c = new QFSAggregationBottomWidget(paramViewGroup.getContext(), (QFSMusicAggregationFragment)getParentFragment(), this.a);
    return this.c;
  }
  
  protected String a()
  {
    return null;
  }
  
  public void loadData(LoadInfo paramLoadInfo) {}
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.aggregation.adapter.QFSAggregationBottomBlock
 * JD-Core Version:    0.7.0.1
 */