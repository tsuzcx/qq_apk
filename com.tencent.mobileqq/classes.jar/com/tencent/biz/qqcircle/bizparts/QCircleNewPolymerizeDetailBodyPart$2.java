package com.tencent.biz.qqcircle.bizparts;

import com.tencent.biz.qqcircle.viewmodels.QCirclePolymerizeDetailViewModel;
import com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate;
import com.tencent.biz.richframework.part.block.base.LoadInfo;

class QCircleNewPolymerizeDetailBodyPart$2
  implements MultiViewBlock.OnLoadDataDelegate
{
  QCircleNewPolymerizeDetailBodyPart$2(QCircleNewPolymerizeDetailBodyPart paramQCircleNewPolymerizeDetailBodyPart) {}
  
  public void a(LoadInfo paramLoadInfo, Object paramObject)
  {
    if (paramLoadInfo.e())
    {
      if (QCircleNewPolymerizeDetailBodyPart.a(this.a) != null) {
        QCircleNewPolymerizeDetailBodyPart.a(this.a).a(QCircleNewPolymerizeDetailBodyPart.b(this.a), true, false, true);
      }
    }
    else
    {
      if (paramLoadInfo.d())
      {
        QCircleNewPolymerizeDetailBodyPart.a(this.a, false);
        return;
      }
      if (paramLoadInfo.c()) {
        QCircleNewPolymerizeDetailBodyPart.a(this.a, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleNewPolymerizeDetailBodyPart.2
 * JD-Core Version:    0.7.0.1
 */