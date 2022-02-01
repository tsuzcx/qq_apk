package com.tencent.biz.qqcircle.fragments.feeddetail;

import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleCommentInfo;
import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart.QCirclePolyListShowData;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.biz.richframework.part.PartManager;

class QCircleFeedDetailBodyPart$6
  extends QCircleInteractor
{
  QCircleFeedDetailBodyPart$6(QCircleFeedDetailBodyPart paramQCircleFeedDetailBodyPart) {}
  
  public String a()
  {
    return "";
  }
  
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
    return QCircleFeedDetailBodyPart.h(this.a);
  }
  
  public int d()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.feeddetail.QCircleFeedDetailBodyPart.6
 * JD-Core Version:    0.7.0.1
 */