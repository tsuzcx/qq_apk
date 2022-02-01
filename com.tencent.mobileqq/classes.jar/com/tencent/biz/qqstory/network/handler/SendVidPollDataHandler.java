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
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqStorySubmitPollData;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStorySubmitPollData;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.network.request.CommonRequest;
import com.tencent.biz.qqstory.network.response.CommonResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.StoryAIOUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;

public class SendVidPollDataHandler
  implements CmdTaskManger.CommandCallback<CommonRequest<qqstory_service.ReqStorySubmitPollData>, CommonResponse>
{
  public static final String a = StoryApi.a("StorySvc.submit_poll_data");
  public String b;
  public String c;
  public int d;
  
  public void a(@NonNull CommonRequest<qqstory_service.ReqStorySubmitPollData> paramCommonRequest, @Nullable CommonResponse paramCommonResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((!paramErrorMessage.isFail()) && (paramCommonResponse != null))
    {
      paramCommonRequest = new qqstory_service.RspStorySubmitPollData();
      try
      {
        paramCommonRequest.mergeFrom(paramCommonResponse.b);
        paramCommonResponse = new SendVidPollDataHandler.SendVidPollDataResultEvent();
        paramCommonResponse.g = new ErrorMessage(paramCommonRequest.result.error_code.get(), paramCommonRequest.result.error_desc.get().toStringUtf8());
        paramCommonResponse.a = this.b;
        paramCommonResponse.b = this.c;
        paramCommonResponse.d = paramCommonRequest.comment_id.get();
        paramCommonResponse.e = paramCommonRequest.fake_id.get();
        paramCommonResponse.f = this.d;
        paramCommonResponse.c = new ArrayList(paramCommonRequest.video_poll_result.get());
        int j = paramCommonResponse.c.size();
        paramErrorMessage = (StoryManager)SuperManager.a(5);
        StoryVideoItem localStoryVideoItem = paramErrorMessage.a(this.c);
        SLog.a("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond() feed=%s, vid=%s, index=%d", this.b, this.c, Integer.valueOf(paramCommonResponse.f));
        if ((localStoryVideoItem != null) && (j > 0))
        {
          if ((localStoryVideoItem.mPollNumbers == null) || (localStoryVideoItem.mPollNumbers.length != j)) {
            localStoryVideoItem.mPollNumbers = new int[j];
          }
          int i = 0;
          while (i < j)
          {
            localStoryVideoItem.mPollNumbers[i] = ((Integer)paramCommonRequest.video_poll_result.get(i)).intValue();
            i += 1;
          }
          localStoryVideoItem.mPollResult = this.d;
          paramErrorMessage.a(localStoryVideoItem);
        }
        StoryDispatcher.a().dispatch(paramCommonResponse);
        StoryAIOUtils.a(QQStoryContext.j());
        return;
      }
      catch (InvalidProtocolBufferMicroException paramCommonRequest)
      {
        paramCommonRequest.printStackTrace();
        SLog.c("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond Request parse Error:%s", paramCommonRequest);
        return;
      }
    }
    SLog.c("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond Request Error:%s", paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.SendVidPollDataHandler
 * JD-Core Version:    0.7.0.1
 */