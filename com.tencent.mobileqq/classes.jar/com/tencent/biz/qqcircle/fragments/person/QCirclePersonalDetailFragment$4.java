package com.tencent.biz.qqcircle.fragments.person;

import android.view.View;
import com.tencent.biz.qqcircle.adapter.QCirclePersonalBottomBlock;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleCommentInfo;
import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart;
import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart.QCirclePolyListShowData;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePartV2;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.biz.richframework.part.PartManager;

class QCirclePersonalDetailFragment$4
  extends QCircleInteractor
{
  QCirclePersonalDetailFragment$4(QCirclePersonalDetailFragment paramQCirclePersonalDetailFragment) {}
  
  public void a(QCircleLightInteractListPart.QCirclePolyListShowData paramQCirclePolyListShowData)
  {
    if (QCirclePersonalDetailFragment.f(this.a) != null) {
      QCirclePersonalDetailFragment.f(this.a).a("light_interact_list_show", paramQCirclePolyListShowData);
    }
  }
  
  public void a(Object paramObject)
  {
    if (this.a.d != null) {
      this.a.d.a("share_action_show_share_sheet", paramObject);
    }
  }
  
  public void a(String paramString, QCircleCommentInfo paramQCircleCommentInfo)
  {
    if (this.a.p() != null) {
      this.a.p().a(paramString, paramQCircleCommentInfo);
    }
  }
  
  public QCirclePolyLikeAniView b()
  {
    if (QCirclePersonalDetailFragment.d(this.a) != null) {
      return (QCirclePolyLikeAniView)QCirclePersonalDetailFragment.e(this.a).findViewById(2131441777);
    }
    return null;
  }
  
  public int d()
  {
    if (QCirclePersonalDetailFragment.g(this.a) != null) {
      return QCirclePersonalDetailFragment.g(this.a).b();
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalDetailFragment.4
 * JD-Core Version:    0.7.0.1
 */