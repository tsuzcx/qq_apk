package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetBatchUserVidList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserVidList;
import com.tencent.biz.qqstory.network.request.CommonRequest;
import com.tencent.biz.qqstory.network.response.CommonResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;

class GetMyStoryVideoListStep$1
  implements CmdTaskManger.CommandCallback<CommonRequest, CommonResponse>
{
  public void a(@NonNull CommonRequest paramCommonRequest, @Nullable CommonResponse paramCommonResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result = new GetMyStoryVideoListStep.Result(paramErrorMessage.errorCode, null);
    if (paramErrorMessage.isFail())
    {
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack != null) {
        this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack.a(paramErrorMessage);
      }
      return;
    }
    if (paramCommonResponse == null)
    {
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack != null)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack.a(this.a.a());
        return;
      }
      SLog.d("GetMyStoryVideoListStep", "finish callBack is null");
      return;
    }
    paramCommonRequest = new qqstory_service.RspGetBatchUserVidList();
    try
    {
      paramCommonRequest.mergeFrom(paramCommonResponse.a);
      this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result = new GetMyStoryVideoListStep.Result(paramCommonRequest.result.error_code.get(), paramCommonRequest.user_vid_list);
      paramCommonRequest = paramCommonRequest.user_vid_list;
      int k = paramCommonRequest.size();
      i = 0;
      if (i < k)
      {
        paramCommonResponse = ((qqstory_struct.UserVidList)paramCommonRequest.get(i)).vid_list;
        int m = paramCommonResponse.size();
        int j = 0;
        while (j < m)
        {
          this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result.a.add(((ByteStringMicro)paramCommonResponse.get(j)).toStringUtf8());
          j += 1;
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramCommonResponse)
    {
      for (;;)
      {
        int i;
        SLog.c("GetMyStoryVideoListStep", "协议返回错误, RspGetBatchUserVidList", paramCommonResponse);
        continue;
        i += 1;
      }
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack != null)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack.a(this.a.a());
        return;
      }
      SLog.d("GetMyStoryVideoListStep", "finish callBack is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetMyStoryVideoListStep.1
 * JD-Core Version:    0.7.0.1
 */