package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqBatchStoryPollData;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchStoryPollData;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VidPollInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VidRateInfo;
import com.tencent.biz.qqstory.network.request.CommonRequest;
import com.tencent.biz.qqstory.network.response.CommonResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.StoryAIOUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GetVidPollInfoHandler
  implements CmdTaskManger.CommandCallback<CommonRequest<qqstory_service.ReqBatchStoryPollData>, CommonResponse>
{
  public static final String a;
  public ArrayList<String> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.batch_poll_data");
  }
  
  public GetVidPollInfoHandler(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
  }
  
  public static void a(@NonNull List<String> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      new GetVidPollInfoHandler(paramList.subList(i, Math.min(i + 5, j))).a();
      i += 5;
    }
  }
  
  public void a()
  {
    Object localObject = new qqstory_service.ReqBatchStoryPollData();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((qqstory_service.ReqBatchStoryPollData)localObject).vid_list.add(ByteStringMicro.copyFromUtf8(str));
    }
    localObject = new CommonRequest(jdField_a_of_type_JavaLangString, (MessageMicro)localObject, null);
    CmdTaskManger.a().a((NetworkRequest)localObject, this);
  }
  
  public void a(@NonNull CommonRequest<qqstory_service.ReqBatchStoryPollData> paramCommonRequest, @Nullable CommonResponse paramCommonResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramCommonResponse == null))
    {
      SLog.c("Q.qqstory.pollData.GetVidPollInfoHandler", "Error onCmdRespond:%s", paramErrorMessage);
      return;
    }
    paramCommonRequest = new qqstory_service.RspBatchStoryPollData();
    Object localObject;
    StoryVideoItem localStoryVideoItem;
    int j;
    qqstory_struct.UserInfo localUserInfo;
    QQUserUIItem localQQUserUIItem;
    for (;;)
    {
      try
      {
        paramCommonRequest.mergeFrom(paramCommonResponse.a);
        paramCommonResponse = (StoryManager)SuperManager.a(5);
        paramErrorMessage = new GetVidPollInfoHandler.GetVidPollInfoEvent();
        i = 0;
        if (i >= paramCommonRequest.poll_info_list.size()) {
          break;
        }
        localObject = (qqstory_struct.VidPollInfo)paramCommonRequest.poll_info_list.get(i);
        localStoryVideoItem = paramCommonResponse.a(((qqstory_struct.VidPollInfo)localObject).vid.get().toStringUtf8());
        if (localStoryVideoItem == null) {
          break label271;
        }
        localStoryVideoItem.mPollUsers.clear();
        localStoryVideoItem.mPollResult = ((qqstory_struct.VidPollInfo)localObject).self_poll_result.get();
        int k = ((qqstory_struct.VidPollInfo)localObject).video_poll_result.size();
        localStoryVideoItem.mPollNumbers = new int[k];
        j = 0;
        if (j < k)
        {
          localStoryVideoItem.mPollNumbers[j] = ((Integer)((qqstory_struct.VidPollInfo)localObject).video_poll_result.get(j)).intValue();
          j += 1;
          continue;
        }
        j = 0;
      }
      catch (InvalidProtocolBufferMicroException paramCommonRequest)
      {
        SLog.c("Q.qqstory.pollData.GetVidPollInfoHandler", "onCmdRespond Request parse Error!", paramCommonRequest);
        return;
      }
      while (j < ((qqstory_struct.VidPollInfo)localObject).video_poll_users.size())
      {
        localUserInfo = (qqstory_struct.UserInfo)((qqstory_struct.VidPollInfo)localObject).video_poll_users.get(j);
        localQQUserUIItem = new QQUserUIItem();
        localQQUserUIItem.convertFrom(localUserInfo);
        localStoryVideoItem.mPollUsers.add(localQQUserUIItem);
        j += 1;
      }
      paramCommonResponse.a(localStoryVideoItem);
      label271:
      paramErrorMessage.a.add(localObject);
      i += 1;
    }
    int i = 0;
    while (i < paramCommonRequest.rate_info_list.size())
    {
      localObject = (qqstory_struct.VidRateInfo)paramCommonRequest.rate_info_list.get(i);
      SLog.b("Q.qqstory.pollData.GetVidPollInfoHandler", "onCmdRespond, VidRateInfo:[vid=%s, selfRateResult=%s, totalRateCount=%s, totalRateScore=%s]", ((qqstory_struct.VidRateInfo)localObject).vid.get().toStringUtf8(), Integer.valueOf(((qqstory_struct.VidRateInfo)localObject).self_rate_result.get()), Integer.valueOf(((qqstory_struct.VidRateInfo)localObject).total_rate_count.get()), Long.valueOf(((qqstory_struct.VidRateInfo)localObject).total_rate_score.get()));
      localStoryVideoItem = paramCommonResponse.a(((qqstory_struct.VidRateInfo)localObject).vid.get().toStringUtf8());
      if (localStoryVideoItem != null)
      {
        localStoryVideoItem.mRateResult = ((qqstory_struct.VidRateInfo)localObject).self_rate_result.get();
        localStoryVideoItem.mTotalRateCount = ((qqstory_struct.VidRateInfo)localObject).total_rate_count.get();
        localStoryVideoItem.mTotalScore = ((qqstory_struct.VidRateInfo)localObject).total_rate_score.get();
        localStoryVideoItem.mRateUsers.clear();
        j = 0;
        while (j < ((qqstory_struct.VidRateInfo)localObject).video_rate_users.size())
        {
          localUserInfo = (qqstory_struct.UserInfo)((qqstory_struct.VidRateInfo)localObject).video_rate_users.get(j);
          localQQUserUIItem = new QQUserUIItem();
          localQQUserUIItem.convertFrom(localUserInfo);
          localStoryVideoItem.mRateUsers.add(localQQUserUIItem);
          j += 1;
        }
        paramCommonResponse.a(localStoryVideoItem);
      }
      paramErrorMessage.b.add(localObject);
      i += 1;
    }
    StoryDispatcher.a().dispatch(paramErrorMessage);
    StoryAIOUtils.a(QQStoryContext.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetVidPollInfoHandler
 * JD-Core Version:    0.7.0.1
 */