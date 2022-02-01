package com.tencent.biz.qqstory.model.filter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

class VideoFilterManager$FilterListCallback
  implements CmdTaskManger.CommandCallback<VideoFilterManager.GetFilterListRequest, VideoFilterManager.GetFilterListResponse>
{
  private VideoFilterManager$FilterListCallback(VideoFilterManager paramVideoFilterManager) {}
  
  public void a(@NonNull VideoFilterManager.GetFilterListRequest paramGetFilterListRequest, @Nullable VideoFilterManager.GetFilterListResponse paramGetFilterListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramGetFilterListResponse != null) && (paramGetFilterListResponse.c == 0) && (paramErrorMessage.isSuccess()))
    {
      this.a.d.addAll(paramGetFilterListResponse.b);
      SLog.d("VideoFilterManager", "new filter count %d, current total count %d, isEnd=%s, cookie=%s", new Object[] { Integer.valueOf(paramGetFilterListResponse.b.size()), Integer.valueOf(this.a.d.size()), Boolean.valueOf(paramGetFilterListResponse.a), paramGetFilterListResponse.e });
      if ((!paramGetFilterListResponse.a) && (!paramGetFilterListResponse.b.isEmpty()))
      {
        this.a.c = paramGetFilterListResponse.e;
        this.a.c();
        return;
      }
      SLog.d("VideoFilterManager", "get filter full list finish, frequency = %d s", new Object[] { Integer.valueOf(paramGetFilterListResponse.f) });
      this.a.a(true, paramGetFilterListResponse.f);
      return;
    }
    SLog.c("VideoFilterManager", "get filter failed %s", paramErrorMessage);
    this.a.a(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.filter.VideoFilterManager.FilterListCallback
 * JD-Core Version:    0.7.0.1
 */