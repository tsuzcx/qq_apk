package com.tencent.biz.qqcircle.fragments.feeddetail;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.adapter.QCircleInsFeedAdapter;
import com.tencent.biz.qqcircle.beans.ResponseBean;

class QCircleFeedDetailBodyPart$5
  implements Observer<ResponseBean>
{
  QCircleFeedDetailBodyPart$5(QCircleFeedDetailBodyPart paramQCircleFeedDetailBodyPart) {}
  
  public void a(@Nullable ResponseBean paramResponseBean)
  {
    if ((paramResponseBean != null) && (QCircleFeedDetailBodyPart.c(this.a) != null))
    {
      QCircleFeedDetailBodyPart.a(this.a, paramResponseBean);
      if (!QCircleFeedDetailBodyPart.g(this.a))
      {
        QCircleFeedDetailBodyPart.b(this.a, paramResponseBean);
        return;
      }
      if (QCircleFeedDetailBodyPart.c(this.a) != null) {
        QCircleFeedDetailBodyPart.c(this.a).clearData();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.feeddetail.QCircleFeedDetailBodyPart.5
 * JD-Core Version:    0.7.0.1
 */