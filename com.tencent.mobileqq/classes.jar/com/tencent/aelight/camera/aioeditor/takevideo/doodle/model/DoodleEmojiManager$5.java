package com.tencent.aelight.camera.aioeditor.takevideo.doodle.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.request.GetPoiFacesRequest;
import com.tencent.biz.qqstory.network.response.GetPoiFacesResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.lang.ref.WeakReference;
import java.util.Collections;

class DoodleEmojiManager$5
  implements CmdTaskManger.CommandCallback<GetPoiFacesRequest, GetPoiFacesResponse>
{
  DoodleEmojiManager$5(DoodleEmojiManager paramDoodleEmojiManager, WeakReference paramWeakReference) {}
  
  public void a(@NonNull GetPoiFacesRequest paramGetPoiFacesRequest, @Nullable GetPoiFacesResponse paramGetPoiFacesResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramGetPoiFacesResponse == null)
    {
      paramGetPoiFacesRequest = (DoodleEmojiManager.POIPostersRequestCallback)this.a.get();
      if (paramGetPoiFacesRequest != null) {
        paramGetPoiFacesRequest.a(paramErrorMessage.errorCode, Collections.EMPTY_LIST);
      }
      return;
    }
    paramGetPoiFacesRequest = (DoodleEmojiManager.POIPostersRequestCallback)this.a.get();
    if (paramGetPoiFacesRequest != null)
    {
      paramGetPoiFacesRequest.a(0, paramGetPoiFacesResponse.a);
      return;
    }
    SLog.c("DoodleEmojiManager", "requestPoiFaces callback is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiManager.5
 * JD-Core Version:    0.7.0.1
 */