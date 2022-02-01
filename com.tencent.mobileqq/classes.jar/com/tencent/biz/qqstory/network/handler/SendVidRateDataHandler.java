package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqStorySubmitRateData;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStorySubmitRateData;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.network.request.CommonRequest;
import com.tencent.biz.qqstory.network.response.CommonResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.StoryAIOUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tribe.async.dispatch.Dispatcher;

public class SendVidRateDataHandler
  implements CmdTaskManger.CommandCallback<CommonRequest<qqstory_service.ReqStorySubmitRateData>, CommonResponse>
{
  public static final String a;
  public final int a;
  public final String b;
  public final String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.submit_rate_data");
  }
  
  public void a(@NonNull CommonRequest<qqstory_service.ReqStorySubmitRateData> paramCommonRequest, @Nullable CommonResponse paramCommonResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    paramCommonRequest = (StoryManager)SuperManager.a(5);
    StoryVideoItem localStoryVideoItem = paramCommonRequest.a(this.c);
    int j = -1;
    int i;
    if (localStoryVideoItem != null) {
      i = localStoryVideoItem.mRateResult;
    } else {
      i = -1;
    }
    if (localStoryVideoItem != null) {
      j = localStoryVideoItem.mTotalRateCount;
    }
    long l;
    if (localStoryVideoItem != null) {
      l = localStoryVideoItem.mTotalScore;
    } else {
      l = -1L;
    }
    SendVidRateDataHandler.SendVidRateDataResultEvent localSendVidRateDataResultEvent = new SendVidRateDataHandler.SendVidRateDataResultEvent();
    if ((!paramErrorMessage.isFail()) && (paramCommonResponse != null))
    {
      paramErrorMessage = new qqstory_service.RspStorySubmitRateData();
      try
      {
        paramErrorMessage.mergeFrom(paramCommonResponse.a);
        localSendVidRateDataResultEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(paramErrorMessage.result.error_code.get(), paramErrorMessage.result.error_desc.get().toStringUtf8());
        localSendVidRateDataResultEvent.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        localSendVidRateDataResultEvent.jdField_b_of_type_JavaLangString = this.c;
        localSendVidRateDataResultEvent.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        localSendVidRateDataResultEvent.jdField_b_of_type_Int = paramErrorMessage.total_rate_count.get();
        localSendVidRateDataResultEvent.jdField_a_of_type_Long = paramErrorMessage.total_rate_score.get();
        localSendVidRateDataResultEvent.c = paramErrorMessage.comment_id.get();
        localSendVidRateDataResultEvent.jdField_b_of_type_Long = paramErrorMessage.fake_id.get();
        SLog.b("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond() feed=%s, vid=%s, rate=%s, rateCount=%s, rateScore=%s, commentId=%s, commentFakeId=%s", new Object[] { this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(localSendVidRateDataResultEvent.jdField_a_of_type_Int), Integer.valueOf(localSendVidRateDataResultEvent.jdField_b_of_type_Int), Long.valueOf(localSendVidRateDataResultEvent.jdField_a_of_type_Long), Integer.valueOf(localSendVidRateDataResultEvent.c), Long.valueOf(localSendVidRateDataResultEvent.jdField_b_of_type_Long) });
      }
      catch (InvalidProtocolBufferMicroException paramCommonRequest)
      {
        paramCommonRequest.printStackTrace();
        SLog.c("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond Request parse Error!", paramCommonRequest);
        return;
      }
    }
    else
    {
      SLog.e("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond Request Error:%s", new Object[] { paramErrorMessage.toString() });
      localSendVidRateDataResultEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localSendVidRateDataResultEvent.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localSendVidRateDataResultEvent.jdField_b_of_type_JavaLangString = this.c;
      localSendVidRateDataResultEvent.jdField_a_of_type_Int = i;
      localSendVidRateDataResultEvent.jdField_b_of_type_Int = j;
      localSendVidRateDataResultEvent.jdField_a_of_type_Long = l;
    }
    if (localStoryVideoItem != null)
    {
      localStoryVideoItem.mRateResult = localSendVidRateDataResultEvent.jdField_a_of_type_Int;
      localStoryVideoItem.mTotalRateCount = localSendVidRateDataResultEvent.jdField_b_of_type_Int;
      localStoryVideoItem.mTotalScore = localSendVidRateDataResultEvent.jdField_a_of_type_Long;
      paramCommonRequest.a(localStoryVideoItem);
    }
    StoryDispatcher.a().dispatch(localSendVidRateDataResultEvent);
    StoryAIOUtils.a(QQStoryContext.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.SendVidRateDataHandler
 * JD-Core Version:    0.7.0.1
 */