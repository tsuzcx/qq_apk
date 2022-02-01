package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.request.GetBlackStatusRequest;
import com.tencent.biz.qqstory.network.response.GetBlackListStatusResponse;

class StoryConfigManager$2
  implements CmdTaskManger.CommandCallback<GetBlackStatusRequest, GetBlackListStatusResponse>
{
  StoryConfigManager$2(StoryConfigManager paramStoryConfigManager, long paramLong) {}
  
  public void a(@NonNull GetBlackStatusRequest paramGetBlackStatusRequest, @Nullable GetBlackListStatusResponse paramGetBlackListStatusResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramGetBlackListStatusResponse != null)
    {
      this.b.d("qqstory_black_status", Integer.valueOf(paramGetBlackListStatusResponse.a));
      this.b.d("qqstory_black_status_update_interval", Integer.valueOf(paramGetBlackListStatusResponse.b));
      this.b.d("qqstory_black_status_last_update_time", Integer.valueOf((int)this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.StoryConfigManager.2
 * JD-Core Version:    0.7.0.1
 */