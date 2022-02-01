package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleCommentInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.biz.richframework.part.PartManager;

class QCirclePolymerizeDetailBodyPart$5
  extends QCircleInteractor
{
  QCirclePolymerizeDetailBodyPart$5(QCirclePolymerizeDetailBodyPart paramQCirclePolymerizeDetailBodyPart) {}
  
  public void a(QCircleLightInteractListPart.QCirclePolyListShowData paramQCirclePolyListShowData)
  {
    if (this.a.E() != null) {
      this.a.E().a("light_interact_list_show", paramQCirclePolyListShowData);
    }
  }
  
  public void a(Object paramObject)
  {
    if (this.a.E() != null) {
      this.a.E().a("share_action_show_share_sheet", paramObject);
    }
  }
  
  public void a(String paramString, QCircleCommentInfo paramQCircleCommentInfo)
  {
    if (this.a.E() != null) {
      this.a.E().a(paramString, paramQCircleCommentInfo);
    }
  }
  
  public QCirclePolyLikeAniView b()
  {
    if (QCirclePolymerizeDetailBodyPart.f(this.a) != null) {
      return (QCirclePolyLikeAniView)QCirclePolymerizeDetailBodyPart.f(this.a).findViewById(2131441777);
    }
    return null;
  }
  
  public QCircleInitBean c()
  {
    return QCirclePolymerizeDetailBodyPart.b(this.a);
  }
  
  public int d()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePolymerizeDetailBodyPart.5
 * JD-Core Version:    0.7.0.1
 */