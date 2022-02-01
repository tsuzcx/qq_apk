package com.tencent.biz.qqcircle.immersive.tab;

import com.tencent.biz.qqcircle.bizparts.QCircleBaseMultiViewBlock;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.folder.QCircleFeedBlockStrategyHelper.OnLoadDataListener;
import com.tencent.biz.richframework.part.block.base.LoadInfo;

class QFSBaseFeedTabFragment$6
  implements QCircleFeedBlockStrategyHelper.OnLoadDataListener
{
  QFSBaseFeedTabFragment$6(QFSBaseFeedTabFragment paramQFSBaseFeedTabFragment) {}
  
  public void a(LoadInfo paramLoadInfo, QCircleBaseMultiViewBlock<FeedBlockData> paramQCircleBaseMultiViewBlock)
  {
    if (paramLoadInfo.e())
    {
      this.a.D();
      return;
    }
    if (paramLoadInfo.d()) {
      this.a.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.tab.QFSBaseFeedTabFragment.6
 * JD-Core Version:    0.7.0.1
 */