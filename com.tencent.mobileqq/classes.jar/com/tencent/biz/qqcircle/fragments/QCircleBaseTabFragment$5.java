package com.tencent.biz.qqcircle.fragments;

import com.tencent.biz.qqcircle.bizparts.QCircleBaseMultiViewBlock;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.folder.QCircleFeedBlockStrategyHelper.OnLoadDataListener;
import com.tencent.biz.richframework.part.block.base.LoadInfo;

class QCircleBaseTabFragment$5
  implements QCircleFeedBlockStrategyHelper.OnLoadDataListener
{
  QCircleBaseTabFragment$5(QCircleBaseTabFragment paramQCircleBaseTabFragment) {}
  
  public void a(LoadInfo paramLoadInfo, QCircleBaseMultiViewBlock<FeedBlockData> paramQCircleBaseMultiViewBlock)
  {
    if (paramLoadInfo.e())
    {
      this.a.P();
      return;
    }
    if (paramLoadInfo.d()) {
      this.a.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment.5
 * JD-Core Version:    0.7.0.1
 */