package com.tencent.biz.qqcircle.fragments.feeddetail;

import com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate;
import com.tencent.biz.richframework.part.block.base.LoadInfo;

class QCircleFeedDetailBodyPart$4
  implements MultiViewBlock.OnLoadDataDelegate
{
  QCircleFeedDetailBodyPart$4(QCircleFeedDetailBodyPart paramQCircleFeedDetailBodyPart) {}
  
  public void a(LoadInfo paramLoadInfo, Object paramObject)
  {
    if ((QCircleFeedDetailBodyPart.e(this.a) != null) && (QCircleFeedDetailBodyPart.f(this.a) != null))
    {
      boolean bool = paramLoadInfo.c();
      if ((!bool) && (!paramLoadInfo.d()))
      {
        if (paramLoadInfo.e()) {
          QCircleFeedDetailBodyPart.f(this.a).a(QCircleFeedDetailBodyPart.e(this.a), paramLoadInfo);
        }
      }
      else {
        QCircleFeedDetailBodyPart.f(this.a).a(QCircleFeedDetailBodyPart.e(this.a), bool, paramLoadInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.feeddetail.QCircleFeedDetailBodyPart.4
 * JD-Core Version:    0.7.0.1
 */