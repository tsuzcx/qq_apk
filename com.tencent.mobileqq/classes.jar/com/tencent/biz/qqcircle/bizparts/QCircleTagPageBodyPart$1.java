package com.tencent.biz.qqcircle.bizparts;

import com.tencent.biz.qqcircle.viewmodels.QCircleTagPageViewModel;
import com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate;
import com.tencent.biz.richframework.part.block.base.LoadInfo;

class QCircleTagPageBodyPart$1
  implements MultiViewBlock.OnLoadDataDelegate
{
  QCircleTagPageBodyPart$1(QCircleTagPageBodyPart paramQCircleTagPageBodyPart) {}
  
  public void a(LoadInfo paramLoadInfo, Object paramObject)
  {
    if (paramLoadInfo.e())
    {
      if (QCircleTagPageBodyPart.a(this.a) != null) {
        QCircleTagPageBodyPart.a(this.a).a(QCircleTagPageBodyPart.b(this.a), QCircleTagPageBodyPart.c(this.a), true, false);
      }
    }
    else
    {
      if (paramLoadInfo.d())
      {
        QCircleTagPageBodyPart.a(this.a, false);
        return;
      }
      if (paramLoadInfo.c()) {
        QCircleTagPageBodyPart.a(this.a, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleTagPageBodyPart.1
 * JD-Core Version:    0.7.0.1
 */