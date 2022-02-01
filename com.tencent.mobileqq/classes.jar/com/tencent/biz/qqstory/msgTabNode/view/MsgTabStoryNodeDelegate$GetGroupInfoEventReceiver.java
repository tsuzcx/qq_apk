package com.tencent.biz.qqstory.msgTabNode.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.network.handler.GetShareGroupInfoHandler.GetShareGroupInfoEvent;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class MsgTabStoryNodeDelegate$GetGroupInfoEventReceiver
  extends QQUIEventReceiver<MsgTabStoryNodeDelegate, GetShareGroupInfoHandler.GetShareGroupInfoEvent>
{
  public MsgTabStoryNodeDelegate$GetGroupInfoEventReceiver(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate)
  {
    super(paramMsgTabStoryNodeDelegate);
  }
  
  public void a(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate, @NonNull GetShareGroupInfoHandler.GetShareGroupInfoEvent paramGetShareGroupInfoEvent)
  {
    if (paramGetShareGroupInfoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      if (QLog.isColorLevel()) {
        QLog.i("zivonchen", 2, "MsgTabStoryNodeDelegate#GetGroupInfoEventReceiver isSuccess sharegroupInfo: " + paramGetShareGroupInfoEvent.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem);
      }
      if (paramGetShareGroupInfoEvent.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null) {
        paramMsgTabStoryNodeDelegate.a(paramMsgTabStoryNodeDelegate.a.a(8, paramGetShareGroupInfoEvent.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.shareGroupId));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("zivonchen", 2, "MsgTabStoryNodeDelegate#GetGroupInfoEventReceiver errorInfo: " + paramGetShareGroupInfoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage + ", sharegroupInfo = " + paramGetShareGroupInfoEvent.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem);
  }
  
  public Class acceptEventClass()
  {
    return GetShareGroupInfoHandler.GetShareGroupInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.GetGroupInfoEventReceiver
 * JD-Core Version:    0.7.0.1
 */