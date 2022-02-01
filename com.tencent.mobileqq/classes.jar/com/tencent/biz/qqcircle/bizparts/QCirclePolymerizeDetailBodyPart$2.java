package com.tencent.biz.qqcircle.bizparts;

import com.tencent.biz.qqcircle.viewmodels.QCirclePolymerizeDetailViewModel;
import com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate;
import com.tencent.biz.richframework.part.block.base.LoadInfo;

class QCirclePolymerizeDetailBodyPart$2
  implements MultiViewBlock.OnLoadDataDelegate
{
  QCirclePolymerizeDetailBodyPart$2(QCirclePolymerizeDetailBodyPart paramQCirclePolymerizeDetailBodyPart) {}
  
  public void a(LoadInfo paramLoadInfo, Object paramObject)
  {
    if (paramLoadInfo.e())
    {
      if (QCirclePolymerizeDetailBodyPart.a(this.a) != null) {
        QCirclePolymerizeDetailBodyPart.a(this.a).a(QCirclePolymerizeDetailBodyPart.b(this.a), true, false);
      }
    }
    else
    {
      if (paramLoadInfo.d())
      {
        QCirclePolymerizeDetailBodyPart.a(this.a, false);
        return;
      }
      if (paramLoadInfo.c())
      {
        QCirclePolymerizeDetailBodyPart.c(this.a);
        QCirclePolymerizeDetailBodyPart.a(this.a, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePolymerizeDetailBodyPart.2
 * JD-Core Version:    0.7.0.1
 */