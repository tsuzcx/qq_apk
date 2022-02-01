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
    if ((paramGetFilterListResponse != null) && (paramGetFilterListResponse.jdField_a_of_type_Int == 0) && (paramErrorMessage.isSuccess()))
    {
      this.a.jdField_a_of_type_JavaUtilList.addAll(paramGetFilterListResponse.jdField_a_of_type_JavaUtilList);
      SLog.d("VideoFilterManager", "new filter count %d, current total count %d, isEnd=%s, cookie=%s", new Object[] { Integer.valueOf(paramGetFilterListResponse.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(this.a.jdField_a_of_type_JavaUtilList.size()), Boolean.valueOf(paramGetFilterListResponse.jdField_a_of_type_Boolean), paramGetFilterListResponse.jdField_a_of_type_JavaLangString });
      if ((!paramGetFilterListResponse.jdField_a_of_type_Boolean) && (!paramGetFilterListResponse.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        this.a.c = paramGetFilterListResponse.jdField_a_of_type_JavaLangString;
        this.a.c();
        return;
      }
      SLog.d("VideoFilterManager", "get filter full list finish, frequency = %d s", new Object[] { Integer.valueOf(paramGetFilterListResponse.b) });
      this.a.a(true, paramGetFilterListResponse.b);
      return;
    }
    SLog.c("VideoFilterManager", "get filter failed %s", paramErrorMessage);
    this.a.a(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.filter.VideoFilterManager.FilterListCallback
 * JD-Core Version:    0.7.0.1
 */