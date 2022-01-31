package com.tencent.biz.qqstory.msgTabNode.view;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class MsgTabStoryNodeDelegate$DeleteStoryVideoEventReceiver
  extends QQUIEventReceiver
{
  public MsgTabStoryNodeDelegate$DeleteStoryVideoEventReceiver(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate)
  {
    super(paramMsgTabStoryNodeDelegate);
  }
  
  public void a(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate, @NonNull DeleteStoryVideoEvent paramDeleteStoryVideoEvent)
  {
    if (!paramDeleteStoryVideoEvent.errorInfo.isSuccess()) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, new Object[] { "delete video event, event=", paramDeleteStoryVideoEvent });
    }
    if (paramDeleteStoryVideoEvent.jdField_a_of_type_Boolean)
    {
      paramDeleteStoryVideoEvent = ((MsgTabStoryManager)paramMsgTabStoryNodeDelegate.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(250)).a();
      localObject = paramMsgTabStoryNodeDelegate.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.a(paramDeleteStoryVideoEvent.jdField_a_of_type_Int, paramDeleteStoryVideoEvent.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        ((MsgTabNodeInfo)localObject).a(paramDeleteStoryVideoEvent);
        paramDeleteStoryVideoEvent = (DeleteStoryVideoEvent)localObject;
      }
      for (;;)
      {
        paramMsgTabStoryNodeDelegate.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.a(paramDeleteStoryVideoEvent, true);
        return;
      }
    }
    int i;
    MsgTabNodeListLoader localMsgTabNodeListLoader;
    if (!TextUtils.isEmpty(paramDeleteStoryVideoEvent.c))
    {
      i = 8;
      localMsgTabNodeListLoader = paramMsgTabStoryNodeDelegate.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader;
      if (TextUtils.isEmpty(paramDeleteStoryVideoEvent.c)) {
        break label175;
      }
    }
    label175:
    for (Object localObject = paramDeleteStoryVideoEvent.c;; localObject = paramDeleteStoryVideoEvent.b)
    {
      localMsgTabNodeListLoader.a(i, (String)localObject, paramDeleteStoryVideoEvent.jdField_a_of_type_Long);
      paramMsgTabStoryNodeDelegate.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.a(i, paramDeleteStoryVideoEvent.b, paramDeleteStoryVideoEvent.c);
      return;
      i = 5;
      break;
    }
  }
  
  public Class acceptEventClass()
  {
    return DeleteStoryVideoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.DeleteStoryVideoEventReceiver
 * JD-Core Version:    0.7.0.1
 */