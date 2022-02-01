package com.tencent.biz.qqcircle.immersive.tab;

import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleCommentInfo;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart;
import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart.QCirclePolyListShowData;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePartV2;
import com.tencent.biz.qqcircle.immersive.ioc.IQFSTabFragmentIoc;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.qphone.base.util.QLog;

class QFSBaseFeedTabFragment$7
  extends QCircleInteractor
{
  QFSBaseFeedTabFragment$7(QFSBaseFeedTabFragment paramQFSBaseFeedTabFragment) {}
  
  public String a()
  {
    if (this.a.u != null) {
      return this.a.u.d();
    }
    return "";
  }
  
  public void a(QCircleLightInteractListPart.QCirclePolyListShowData paramQCirclePolyListShowData)
  {
    if (this.a.m != null) {
      this.a.m.E().a("light_interact_list_show", paramQCirclePolyListShowData);
    }
  }
  
  public void a(Object paramObject)
  {
    if (this.a.g != null) {
      this.a.g.a("share_action_show_share_sheet", paramObject);
    }
  }
  
  public void a(String paramString, QCircleCommentInfo paramQCircleCommentInfo)
  {
    if (this.a.m != null) {
      this.a.m.E().a(paramString, paramQCircleCommentInfo);
    }
  }
  
  public QCirclePolyLikeAniView b()
  {
    return this.a.l;
  }
  
  public int d()
  {
    if (this.a.c != null) {
      return this.a.c.bl_();
    }
    QLog.e(this.a.b(), 1, "getCurrentPageIndex error!");
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.tab.QFSBaseFeedTabFragment.7
 * JD-Core Version:    0.7.0.1
 */