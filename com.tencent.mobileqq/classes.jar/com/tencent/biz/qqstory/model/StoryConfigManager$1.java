package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.request.PublishConfigRequest;
import com.tencent.biz.qqstory.network.response.PublishConfigResponse;
import com.tribe.async.dispatch.Dispatcher;

class StoryConfigManager$1
  implements CmdTaskManger.CommandCallback<PublishConfigRequest, PublishConfigResponse>
{
  public void a(@NonNull PublishConfigRequest paramPublishConfigRequest, @Nullable PublishConfigResponse paramPublishConfigResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramPublishConfigResponse != null) && (paramErrorMessage.isSuccess()))
    {
      StoryConfigManager.a(this.a, System.currentTimeMillis());
      this.a.d("show_now_entry", Boolean.valueOf(paramPublishConfigResponse.a));
      this.a.d("publish_picture", Boolean.valueOf(paramPublishConfigResponse.b));
      if (paramPublishConfigResponse.e) {
        this.a.d("first_time_pic", Boolean.valueOf(paramPublishConfigResponse.e));
      }
      this.a.d("upload_video_use_bdh", Boolean.valueOf(paramPublishConfigResponse.f));
    }
    StoryDispatcher.a().dispatch(new StoryConfigManager.StoryConfigEvent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.StoryConfigManager.1
 * JD-Core Version:    0.7.0.1
 */