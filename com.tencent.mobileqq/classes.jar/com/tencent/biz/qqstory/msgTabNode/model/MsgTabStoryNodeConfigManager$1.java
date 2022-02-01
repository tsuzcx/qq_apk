package com.tencent.biz.qqstory.msgTabNode.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabCheckActiveRequest;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabCheckActiveRequest.MsgTabCheckActiveResponse;
import com.tencent.qphone.base.util.QLog;

class MsgTabStoryNodeConfigManager$1
  implements CmdTaskManger.CommandCallback<MsgTabCheckActiveRequest, MsgTabCheckActiveRequest.MsgTabCheckActiveResponse>
{
  MsgTabStoryNodeConfigManager$1(MsgTabStoryNodeConfigManager paramMsgTabStoryNodeConfigManager, QQStoryHandler paramQQStoryHandler, QQStoryManager paramQQStoryManager) {}
  
  public void a(@NonNull MsgTabCheckActiveRequest paramMsgTabCheckActiveRequest, @Nullable MsgTabCheckActiveRequest.MsgTabCheckActiveResponse paramMsgTabCheckActiveResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((!paramErrorMessage.isFail()) && (paramMsgTabCheckActiveResponse != null))
    {
      if (paramMsgTabCheckActiveResponse.b == 1)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager.a(true);
        this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.b(2);
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager.a = 2;
      }
      if (QLog.isColorLevel())
      {
        paramMsgTabCheckActiveRequest = new StringBuilder();
        paramMsgTabCheckActiveRequest.append("active value is ");
        paramMsgTabCheckActiveRequest.append(paramMsgTabCheckActiveResponse.b);
        QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, paramMsgTabCheckActiveRequest.toString());
      }
      this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager.a(paramMsgTabCheckActiveResponse.a);
      return;
    }
    paramMsgTabCheckActiveRequest = new StringBuilder();
    paramMsgTabCheckActiveRequest.append("get active fail");
    paramMsgTabCheckActiveRequest.append(paramErrorMessage.getErrorMessage());
    QLog.w("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 1, paramMsgTabCheckActiveRequest.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager.1
 * JD-Core Version:    0.7.0.1
 */