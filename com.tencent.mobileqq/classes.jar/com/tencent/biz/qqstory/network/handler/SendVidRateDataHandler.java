package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.channel.NetworkRequest;
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
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class SendVidRateDataHandler
  implements CmdTaskManger.CommandCallback
{
  public static final String a;
  public final int a;
  public final String b;
  public final String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.submit_rate_data");
  }
  
  SendVidRateDataHandler(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a()
  {
    SLog.a("Q.qqstory.pollData.SendVidRateDataHandler", "sendRequest() feed=%s, vid=%s, rate=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(this.jdField_a_of_type_Int));
    Object localObject = new qqstory_service.ReqStorySubmitRateData();
    ((qqstory_service.ReqStorySubmitRateData)localObject).vid.set(ByteStringMicro.copyFromUtf8(this.c));
    ((qqstory_service.ReqStorySubmitRateData)localObject).rate_data.set(this.jdField_a_of_type_Int);
    localObject = new CommonRequest(jdField_a_of_type_JavaLangString, (MessageMicro)localObject, null);
    CmdTaskManger.a().a((NetworkRequest)localObject, this);
  }
  
  public static void a(@Nullable String paramString1, String paramString2, int paramInt)
  {
    new SendVidRateDataHandler(paramString1, paramString2, paramInt).a();
  }
  
  public void a(@NonNull CommonRequest paramCommonRequest, @Nullable CommonResponse paramCommonResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    int j = -1;
    paramCommonRequest = (StoryManager)SuperManager.a(5);
    StoryVideoItem localStoryVideoItem = paramCommonRequest.a(this.c);
    int i;
    long l;
    label57:
    SendVidRateDataHandler.SendVidRateDataResultEvent localSendVidRateDataResultEvent;
    if (localStoryVideoItem != null)
    {
      i = localStoryVideoItem.mRateResult;
      if (localStoryVideoItem != null) {
        j = localStoryVideoItem.mTotalRateCount;
      }
      if (localStoryVideoItem == null) {
        break label205;
      }
      l = localStoryVideoItem.mTotalScore;
      localSendVidRateDataResultEvent = new SendVidRateDataHandler.SendVidRateDataResultEvent();
      if ((!paramErrorMessage.isFail()) && (paramCommonResponse != null)) {
        break label213;
      }
      SLog.e("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond Request Error:%s", new Object[] { paramErrorMessage.toString() });
      localSendVidRateDataResultEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localSendVidRateDataResultEvent.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localSendVidRateDataResultEvent.jdField_b_of_type_JavaLangString = this.c;
      localSendVidRateDataResultEvent.jdField_a_of_type_Int = i;
      localSendVidRateDataResultEvent.jdField_b_of_type_Int = j;
      localSendVidRateDataResultEvent.jdField_a_of_type_Long = l;
    }
    for (;;)
    {
      if (localStoryVideoItem != null)
      {
        localStoryVideoItem.mRateResult = localSendVidRateDataResultEvent.jdField_a_of_type_Int;
        localStoryVideoItem.mTotalRateCount = localSendVidRateDataResultEvent.jdField_b_of_type_Int;
        localStoryVideoItem.mTotalScore = localSendVidRateDataResultEvent.jdField_a_of_type_Long;
        paramCommonRequest.a(localStoryVideoItem);
      }
      Dispatchers.get().dispatch(localSendVidRateDataResultEvent);
      StoryAIOUtils.a(QQStoryContext.a());
      return;
      i = -1;
      break;
      label205:
      l = -1L;
      break label57;
      label213:
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
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.SendVidRateDataHandler
 * JD-Core Version:    0.7.0.1
 */