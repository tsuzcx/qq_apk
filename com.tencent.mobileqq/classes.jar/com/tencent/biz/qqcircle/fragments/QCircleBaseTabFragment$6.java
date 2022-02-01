package com.tencent.biz.qqcircle.fragments;

import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleCommentInfo;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart;
import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart.QCirclePolyListShowData;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePartV2;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.biz.richframework.part.PartManager;

class QCircleBaseTabFragment$6
  extends QCircleInteractor
{
  QCircleBaseTabFragment$6(QCircleBaseTabFragment paramQCircleBaseTabFragment) {}
  
  public String a()
  {
    if (this.a.o != null) {
      return this.a.o.d();
    }
    return "";
  }
  
  public void a(QCircleLightInteractListPart.QCirclePolyListShowData paramQCirclePolyListShowData)
  {
    if (this.a.r != null) {
      this.a.r.E().a("light_interact_list_show", paramQCirclePolyListShowData);
    }
  }
  
  public void a(Object paramObject)
  {
    if (this.a.k != null) {
      this.a.k.a("share_action_show_share_sheet", paramObject);
    }
  }
  
  public void a(String paramString, QCircleCommentInfo paramQCircleCommentInfo)
  {
    if (this.a.r != null) {
      this.a.r.E().a(paramString, paramQCircleCommentInfo);
    }
  }
  
  public QCirclePolyLikeAniView b()
  {
    return this.a.q;
  }
  
  public int d()
  {
    if (this.a.r != null)
    {
      Object localObject = this.a.r.E().b("get_current_page_index", null);
      if ((localObject instanceof Integer)) {
        return ((Integer)localObject).intValue();
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment.6
 * JD-Core Version:    0.7.0.1
 */