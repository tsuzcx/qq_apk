package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqTodayStoryVidList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspTodayStoryVidList;
import com.tencent.biz.qqstory.network.request.CommonRequest;
import com.tencent.biz.qqstory.network.response.CommonResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

class GetMyStoryVideoListStep$2
  implements CmdTaskManger.CommandCallback<CommonRequest, CommonResponse>
{
  GetMyStoryVideoListStep$2(GetMyStoryVideoListStep paramGetMyStoryVideoListStep, qqstory_service.ReqTodayStoryVidList paramReqTodayStoryVidList, String paramString) {}
  
  public void a(@NonNull CommonRequest paramCommonRequest, @Nullable CommonResponse paramCommonResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail())
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack.a(paramErrorMessage);
      }
      return;
    }
    if (paramCommonResponse == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result.jdField_a_of_type_Int = paramErrorMessage.errorCode;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep.a());
        return;
      }
      SLog.d("GetMyStoryVideoListStep", "finish callBack is null");
      return;
    }
    paramCommonRequest = new qqstory_service.RspTodayStoryVidList();
    try
    {
      paramCommonRequest.mergeFrom(paramCommonResponse.a);
      paramCommonResponse = paramCommonRequest.vid_list.get().listIterator();
      paramErrorMessage = paramCommonRequest.feed_id.get().toStringUtf8();
      if (!TextUtils.isEmpty(paramErrorMessage)) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result.jdField_a_of_type_JavaLangString = paramErrorMessage;
      }
      paramErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result;
      boolean bool;
      if (paramCommonRequest.share_to_discover.get() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramErrorMessage.jdField_a_of_type_Boolean = bool;
      ((StoryConfigManager)SuperManager.a(10)).b("qqstory_my_story_have_contributed", Integer.valueOf(paramCommonRequest.share_to_discover.get()));
      while (paramCommonResponse.hasNext()) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result.jdField_a_of_type_JavaUtilArrayList.add(((ByteStringMicro)paramCommonResponse.next()).toStringUtf8());
      }
      if ((paramCommonRequest.is_end.has()) && (paramCommonRequest.is_end.get() != 1))
      {
        paramCommonResponse = new qqstory_service.ReqTodayStoryVidList();
        paramCommonResponse.date.set(this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$ReqTodayStoryVidList.date.get());
        paramCommonResponse.cookie.set(paramCommonRequest.cookie.get());
        CmdTaskManger.a().a(new CommonRequest(this.jdField_a_of_type_JavaLangString, paramCommonResponse, null), this);
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep.a());
        return;
      }
      SLog.d("GetMyStoryVideoListStep", "finish callBack is null");
      return;
    }
    catch (InvalidProtocolBufferMicroException paramCommonRequest)
    {
      SLog.c("GetMyStoryVideoListStep", "协议返回错误, RspGetBatchUserVidList", paramCommonRequest);
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep.a());
        return;
      }
      SLog.d("GetMyStoryVideoListStep", "finish callBack is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetMyStoryVideoListStep.2
 * JD-Core Version:    0.7.0.1
 */