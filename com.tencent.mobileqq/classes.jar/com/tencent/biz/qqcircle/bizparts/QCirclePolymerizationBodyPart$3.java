package com.tencent.biz.qqcircle.bizparts;

import com.tencent.biz.qqcircle.viewmodels.QCirclePolymerizationViewModel;
import com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate;
import com.tencent.biz.richframework.part.block.base.LoadInfo;

class QCirclePolymerizationBodyPart$3
  implements MultiViewBlock.OnLoadDataDelegate
{
  QCirclePolymerizationBodyPart$3(QCirclePolymerizationBodyPart paramQCirclePolymerizationBodyPart) {}
  
  public void a(LoadInfo paramLoadInfo, Object paramObject)
  {
    if (paramLoadInfo.e())
    {
      if (QCirclePolymerizationBodyPart.a(this.a) != null) {
        QCirclePolymerizationBodyPart.a(this.a).a(this.a.g(), QCirclePolymerizationBodyPart.b(this.a), true, false);
      }
    }
    else
    {
      if (paramLoadInfo.d())
      {
        QCirclePolymerizationBodyPart.a(this.a, false);
        return;
      }
      if (paramLoadInfo.c()) {
        QCirclePolymerizationBodyPart.a(this.a, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePolymerizationBodyPart.3
 * JD-Core Version:    0.7.0.1
 */