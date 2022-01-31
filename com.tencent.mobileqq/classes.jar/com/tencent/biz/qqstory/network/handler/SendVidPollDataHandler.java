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
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqStorySubmitPollData;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStorySubmitPollData;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.network.request.CommonRequest;
import com.tencent.biz.qqstory.network.response.CommonResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.StoryAIOUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;

public class SendVidPollDataHandler
  implements CmdTaskManger.CommandCallback
{
  public static final String a;
  public int a;
  public String b;
  public String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.submit_poll_data");
  }
  
  SendVidPollDataHandler(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a()
  {
    SLog.a("Q.qqstory.pollData.SendVidPollDataHandler", "sendRequest() feed=%s, poll=%s, index=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(this.jdField_a_of_type_Int));
    Object localObject = new qqstory_service.ReqStorySubmitPollData();
    ((qqstory_service.ReqStorySubmitPollData)localObject).vid.set(ByteStringMicro.copyFromUtf8(this.c));
    ((qqstory_service.ReqStorySubmitPollData)localObject).poll_data.set(this.jdField_a_of_type_Int);
    localObject = new CommonRequest(jdField_a_of_type_JavaLangString, (MessageMicro)localObject, null);
    CmdTaskManger.a().a((NetworkRequest)localObject, this);
  }
  
  public static void a(@Nullable String paramString1, String paramString2, int paramInt)
  {
    new SendVidPollDataHandler(paramString1, paramString2, paramInt).a();
  }
  
  public void a(@NonNull CommonRequest paramCommonRequest, @Nullable CommonResponse paramCommonResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramCommonResponse == null))
    {
      SLog.c("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond Request Error:%s", paramErrorMessage);
      return;
    }
    paramCommonRequest = new qqstory_service.RspStorySubmitPollData();
    StoryVideoItem localStoryVideoItem;
    try
    {
      paramCommonRequest.mergeFrom(paramCommonResponse.a);
      paramCommonResponse = new SendVidPollDataHandler.SendVidPollDataResultEvent();
      paramCommonResponse.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(paramCommonRequest.result.error_code.get(), paramCommonRequest.result.error_desc.get().toStringUtf8());
      paramCommonResponse.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      paramCommonResponse.jdField_b_of_type_JavaLangString = this.c;
      paramCommonResponse.jdField_a_of_type_Int = paramCommonRequest.comment_id.get();
      paramCommonResponse.jdField_a_of_type_Long = paramCommonRequest.fake_id.get();
      paramCommonResponse.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      paramCommonResponse.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramCommonRequest.video_poll_result.get());
      int j = paramCommonResponse.jdField_a_of_type_JavaUtilArrayList.size();
      paramErrorMessage = (StoryManager)SuperManager.a(5);
      localStoryVideoItem = paramErrorMessage.a(this.c);
      SLog.a("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond() feed=%s, vid=%s, index=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(paramCommonResponse.jdField_b_of_type_Int));
      if ((localStoryVideoItem == null) || (j <= 0)) {
        break label302;
      }
      if ((localStoryVideoItem.mPollNumbers == null) || (localStoryVideoItem.mPollNumbers.length != j)) {
        localStoryVideoItem.mPollNumbers = new int[j];
      }
      int i = 0;
      while (i < j)
      {
        localStoryVideoItem.mPollNumbers[i] = ((Integer)paramCommonRequest.video_poll_result.get(i)).intValue();
        i += 1;
      }
      localStoryVideoItem.mPollResult = this.jdField_a_of_type_Int;
    }
    catch (InvalidProtocolBufferMicroException paramCommonRequest)
    {
      paramCommonRequest.printStackTrace();
      SLog.c("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond Request parse Error:%s", paramCommonRequest);
      return;
    }
    paramErrorMessage.a(localStoryVideoItem);
    label302:
    Dispatchers.get().dispatch(paramCommonResponse);
    StoryAIOUtils.a(QQStoryContext.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.SendVidPollDataHandler
 * JD-Core Version:    0.7.0.1
 */