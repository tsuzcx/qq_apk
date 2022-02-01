package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPromoteTaskList;
import com.tencent.biz.qqstory.network.request.promotetask.GetPromoteTaskRequest;
import com.tencent.biz.qqstory.network.request.promotetask.GetPromoteTaskRequest.GetPromoteTaskResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;

class StoryPromoteTaskManager$1
  implements CmdTaskManger.CommandCallback<GetPromoteTaskRequest, GetPromoteTaskRequest.GetPromoteTaskResponse>
{
  StoryPromoteTaskManager$1(StoryPromoteTaskManager paramStoryPromoteTaskManager) {}
  
  public void a(@NonNull GetPromoteTaskRequest paramGetPromoteTaskRequest, @Nullable GetPromoteTaskRequest.GetPromoteTaskResponse paramGetPromoteTaskResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramGetPromoteTaskResponse == null)
    {
      SLog.e("StoryPromoteTaskManager", "onCmdRespond() error: %s", new Object[] { paramGetPromoteTaskResponse });
      return;
    }
    if (paramErrorMessage.errorCode == 15000)
    {
      SLog.a("StoryPromoteTaskManager", "onCmdRespond() no change of the request %s", paramGetPromoteTaskResponse);
      this.a.f = paramGetPromoteTaskResponse.a.uint64_expire_time.get();
      return;
    }
    if (paramErrorMessage.isFail())
    {
      SLog.e("StoryPromoteTaskManager", "onCmdRespond() error: %s", new Object[] { paramGetPromoteTaskResponse });
      return;
    }
    if (this.a.e) {
      return;
    }
    this.a.b = paramGetPromoteTaskResponse.a.bytes_cookie.get().toStringUtf8();
    this.a.f = paramGetPromoteTaskResponse.a.uint64_expire_time.get();
    this.a.c();
    this.a.a(paramGetPromoteTaskResponse.a);
    paramGetPromoteTaskRequest = paramGetPromoteTaskResponse.a.bytes_global_promote_url.get().toStringUtf8();
    if (!TextUtils.isEmpty(paramGetPromoteTaskRequest))
    {
      ((StoryConfigManager)SuperManager.a(10)).d("key_story_player_promote_url", paramGetPromoteTaskRequest);
      this.a.g = paramGetPromoteTaskRequest;
    }
    this.a.a("onCmdRespond()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.StoryPromoteTaskManager.1
 * JD-Core Version:    0.7.0.1
 */