package com.tencent.biz.qqcircle.viewmodels;

import com.tencent.biz.qqcircle.extendpb.QCircleTransFormHelper;
import com.tencent.biz.qqcircle.folder.QCircleFolderCacheHelper.QCircleFolderPageCache;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.List;

class QCircleAbsTabFeedViewModel$3
  implements Runnable
{
  QCircleAbsTabFeedViewModel$3(QCircleAbsTabFeedViewModel paramQCircleAbsTabFeedViewModel, List paramList, QCircleFolderCacheHelper.QCircleFolderPageCache paramQCircleFolderPageCache) {}
  
  public void run()
  {
    ArrayList localArrayList = QCircleTransFormHelper.a(this.a);
    this.this$0.a(localArrayList, false);
    this.this$0.a(UIStateData.a(this.b.a(), this.b.b()).a(false, localArrayList).c(this.this$0.h));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCircleAbsTabFeedViewModel.3
 * JD-Core Version:    0.7.0.1
 */