package com.tencent.biz.qqstory.takevideo.doodle.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.request.GetEmojiPackInfoListRequest;
import com.tencent.biz.qqstory.network.response.GetEmojiPackInfoListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;

class DoodleEmojiManager$7
  implements CmdTaskManger.CommandCallback<GetEmojiPackInfoListRequest, GetEmojiPackInfoListResponse>
{
  DoodleEmojiManager$7(DoodleEmojiManager paramDoodleEmojiManager) {}
  
  public void a(@NonNull GetEmojiPackInfoListRequest paramGetEmojiPackInfoListRequest, @Nullable GetEmojiPackInfoListResponse paramGetEmojiPackInfoListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.b("DoodleEmojiManager", "fireRequestEmojiPackList, result : " + paramGetEmojiPackInfoListResponse + ", errorMsg = " + paramErrorMessage);
    synchronized (this.a.jdField_b_of_type_JavaLangObject)
    {
      if (!TextUtils.equals(paramGetEmojiPackInfoListRequest.a, this.a.jdField_b_of_type_JavaLangString))
      {
        SLog.d("DoodleEmojiManager", "cookie mismatch ! ignore this response : " + paramGetEmojiPackInfoListResponse);
        return;
      }
      if ((paramGetEmojiPackInfoListResponse == null) || (paramErrorMessage.isFail()))
      {
        SLog.d("DoodleEmojiManager", "get emoji error : " + paramGetEmojiPackInfoListResponse + ", " + paramErrorMessage);
        return;
      }
    }
    this.a.jdField_b_of_type_JavaLangString = paramGetEmojiPackInfoListResponse.a;
    this.a.a(TextUtils.isEmpty(paramGetEmojiPackInfoListRequest.a), paramGetEmojiPackInfoListResponse, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.7
 * JD-Core Version:    0.7.0.1
 */