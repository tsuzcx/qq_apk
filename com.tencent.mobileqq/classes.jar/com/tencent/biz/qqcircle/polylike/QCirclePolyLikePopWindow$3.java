package com.tencent.biz.qqcircle.polylike;

import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import qqcircle.QQCircleFeedBase.StPolyLike;
import vry;
import vsd;

public class QCirclePolyLikePopWindow$3
  implements Runnable
{
  public QCirclePolyLikePopWindow$3(vsd paramvsd) {}
  
  public void run()
  {
    Iterator localIterator = vsd.a(this.this$0).keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (QCirclePolyBaseLikeView)vsd.a(this.this$0).get(localObject);
      if (vry.a.containsKey(((QCirclePolyBaseLikeView)localObject).a().polySource.get()))
      {
        AnimationView.AnimationInfo localAnimationInfo = (AnimationView.AnimationInfo)vry.a.get(((QCirclePolyBaseLikeView)localObject).a().polySource.get());
        ((QCirclePolyBaseLikeView)localObject).jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.setImageDrawable(null);
        ((QCirclePolyBaseLikeView)localObject).jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.setAnimationFromInfo(localAnimationInfo);
        ((QCirclePolyBaseLikeView)localObject).jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.setVisibility(0);
        ((QCirclePolyBaseLikeView)localObject).jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        ((QCirclePolyBaseLikeView)localObject).jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.play();
        QLog.d("QCirclePolymorphicLikePopWindow", 1, "AnimationView play");
      }
      QLog.d("QCirclePolymorphicLikePopWindow", 1, "showAnimations");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikePopWindow.3
 * JD-Core Version:    0.7.0.1
 */