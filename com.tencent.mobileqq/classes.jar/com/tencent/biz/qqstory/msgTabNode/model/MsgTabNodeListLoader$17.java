package com.tencent.biz.qqstory.msgTabNode.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.msgTabNode.network.QQStoryGuideRequest;
import com.tencent.biz.qqstory.msgTabNode.network.QQStoryGuideRequest.QQStoryGuideResponse;
import com.tencent.qphone.base.util.QLog;

class MsgTabNodeListLoader$17
  implements CmdTaskManger.CommandCallback<QQStoryGuideRequest, QQStoryGuideRequest.QQStoryGuideResponse>
{
  MsgTabNodeListLoader$17(MsgTabNodeListLoader paramMsgTabNodeListLoader) {}
  
  public void a(@NonNull QQStoryGuideRequest paramQQStoryGuideRequest, @Nullable QQStoryGuideRequest.QQStoryGuideResponse paramQQStoryGuideResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (QLog.isColorLevel())
    {
      paramQQStoryGuideRequest = new StringBuilder();
      paramQQStoryGuideRequest.append("requestQQStoryGuide onCmdRespond = ");
      paramQQStoryGuideRequest.append(paramQQStoryGuideResponse);
      paramQQStoryGuideRequest.append(" ,errorMsg = ");
      paramQQStoryGuideRequest.append(paramErrorMessage);
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, paramQQStoryGuideRequest.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.17
 * JD-Core Version:    0.7.0.1
 */