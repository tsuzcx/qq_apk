package com.tencent.biz.qqstory.shareGroup.infocard;

import com.tencent.biz.qqstory.newshare.callback.OnSimpleShareListener;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;

class QQStoryShareGroupProfileActivity$UIEventListenerImpl$1
  extends OnSimpleShareListener
{
  QQStoryShareGroupProfileActivity$UIEventListenerImpl$1(QQStoryShareGroupProfileActivity.UIEventListenerImpl paramUIEventListenerImpl) {}
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    StoryReportor.a("share_story", "day_suc", 0, paramInt, new String[] { QQStoryShareGroupProfileActivity.UIEventListenerImpl.a(this.a).jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.getReportUserType() });
  }
  
  public void d()
  {
    super.d();
    QQStoryShareGroupProfileActivity.UIEventListenerImpl.a(this.a).jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.UIEventListenerImpl.1
 * JD-Core Version:    0.7.0.1
 */