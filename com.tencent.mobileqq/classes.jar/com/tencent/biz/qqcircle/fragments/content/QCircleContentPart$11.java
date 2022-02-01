package com.tencent.biz.qqcircle.fragments.content;

import android.graphics.drawable.Drawable;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleCommentInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.biz.richframework.part.PartManager;

class QCircleContentPart$11
  extends QCircleInteractor
{
  QCircleContentPart$11(QCircleContentPart paramQCircleContentPart) {}
  
  public void a(Object paramObject)
  {
    if ((this.a.E() != null) && ((paramObject instanceof QCircleShareInfo))) {
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
    return QCircleContentPart.v(this.a);
  }
  
  public Drawable e()
  {
    return QCircleContentPart.w(this.a);
  }
  
  public void f()
  {
    if (QCircleContentPart.w(this.a) != null) {
      QCircleContentPart.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentPart.11
 * JD-Core Version:    0.7.0.1
 */