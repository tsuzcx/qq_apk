package com.tencent.biz.qqcircle.polylike;

import com.tencent.biz.qqcircle.widgets.AnimationView;
import com.tencent.biz.qqcircle.widgets.AnimationView.AnimationInfo;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import qqcircle.QQCircleFeedBase.StPolyLike;

class QCirclePolyLikePopWindow$3
  implements Runnable
{
  QCirclePolyLikePopWindow$3(QCirclePolyLikePopWindow paramQCirclePolyLikePopWindow) {}
  
  public void run()
  {
    Iterator localIterator = QCirclePolyLikePopWindow.b(this.this$0).keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (QCirclePolyBaseLikeView)QCirclePolyLikePopWindow.b(this.this$0).get(localObject);
      if (QCirclePolyLikeInfoManger.a.containsKey(((QCirclePolyBaseLikeView)localObject).getPolyLike().polySource.get()))
      {
        AnimationView.AnimationInfo localAnimationInfo = (AnimationView.AnimationInfo)QCirclePolyLikeInfoManger.a.get(((QCirclePolyBaseLikeView)localObject).getPolyLike().polySource.get());
        ((QCirclePolyBaseLikeView)localObject).a.setImageDrawable(null);
        ((QCirclePolyBaseLikeView)localObject).a.setAnimationFromInfo(localAnimationInfo);
        ((QCirclePolyBaseLikeView)localObject).a.setVisibility(0);
        ((QCirclePolyBaseLikeView)localObject).b.setVisibility(8);
        ((QCirclePolyBaseLikeView)localObject).a.a();
        QLog.d("QCirclePolymorphicLikePopWindow", 1, "AnimationView play");
      }
      QLog.d("QCirclePolymorphicLikePopWindow", 1, "showAnimations");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikePopWindow.3
 * JD-Core Version:    0.7.0.1
 */