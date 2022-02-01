package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleCommentInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.biz.richframework.part.PartManager;

class QCircleTagPageBodyPart$6
  extends QCircleInteractor
{
  QCircleTagPageBodyPart$6(QCircleTagPageBodyPart paramQCircleTagPageBodyPart) {}
  
  public void a(QCircleLightInteractListPart.QCirclePolyListShowData paramQCirclePolyListShowData)
  {
    this.a.E().a("light_interact_list_show", paramQCirclePolyListShowData);
  }
  
  public void a(Object paramObject)
  {
    this.a.c("share_action_show_share_sheet", paramObject);
  }
  
  public void a(String paramString, QCircleCommentInfo paramQCircleCommentInfo)
  {
    this.a.E().a(paramString, paramQCircleCommentInfo);
  }
  
  public QCirclePolyLikeAniView b()
  {
    if (QCircleTagPageBodyPart.e(this.a) != null) {
      return (QCirclePolyLikeAniView)QCircleTagPageBodyPart.e(this.a).findViewById(2131441777);
    }
    return null;
  }
  
  public QCircleInitBean c()
  {
    return QCircleTagPageBodyPart.f(this.a);
  }
  
  public int d()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleTagPageBodyPart.6
 * JD-Core Version:    0.7.0.1
 */