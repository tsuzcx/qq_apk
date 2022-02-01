package com.tencent.biz.subscribe.widget.relativevideo;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.biz.subscribe.utils.SubscribeFollowUserUtil.ResultListener;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class SubScribeDraftItemView$2$1
  implements SubscribeFollowUserUtil.ResultListener
{
  SubScribeDraftItemView$2$1(SubScribeDraftItemView.2 param2) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      VSReporter.b(SubScribeDraftItemView.b(this.a.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoSubScribeDraftItemView), "auth_pubish", "delete_draft", 0, 0, new String[0]);
      paramString = new SubDraftChangeEvent();
      paramString.setDraftID(String.valueOf(this.a.jdField_a_of_type_ComTencentBizSubscribeBeansSubscribeDraftBean.getDraftId()));
      SimpleEventBus.getInstance().dispatchEvent(paramString);
      QLog.d(SubScribeDraftItemView.a(), 4, "delete draft success");
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoSubScribeDraftItemView.getContext(), "delete failed", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.SubScribeDraftItemView.2.1
 * JD-Core Version:    0.7.0.1
 */