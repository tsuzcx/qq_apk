package com.tencent.biz.qqcircle.fragments.person;

import com.tencent.biz.qqcircle.adapter.QCirclePersonalDetailHeaderBlock;
import com.tencent.biz.qqcircle.viewmodels.QCirclePersonalDetailPushViewModel;
import com.tencent.biz.qqcircle.viewmodels.QCirclePersonalDetailViewModel;
import com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate;
import com.tencent.biz.richframework.part.block.base.LoadInfo;

class QCirclePersonalDetailFragment$3
  implements MultiViewBlock.OnLoadDataDelegate<QCirclePersonalDetailHeaderBlock>
{
  QCirclePersonalDetailFragment$3(QCirclePersonalDetailFragment paramQCirclePersonalDetailFragment) {}
  
  public void a(LoadInfo paramLoadInfo, QCirclePersonalDetailHeaderBlock paramQCirclePersonalDetailHeaderBlock)
  {
    if (paramLoadInfo.d())
    {
      if (QCirclePersonalDetailFragment.b(this.a) != null) {
        QCirclePersonalDetailFragment.b(this.a).a(false);
      }
      if (QCirclePersonalDetailFragment.c(this.a) != null) {
        QCirclePersonalDetailFragment.c(this.a).a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalDetailFragment.3
 * JD-Core Version:    0.7.0.1
 */