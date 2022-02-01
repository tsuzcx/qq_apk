package com.tencent.ilivesdk.domain.factory;

import com.tencent.ilivesdk.domain.usecase.GetAnchorInfoCase;
import com.tencent.ilivesdk.domain.usecase.GetFollowStateCase;
import com.tencent.ilivesdk.domain.usecase.GetLinkMicUserInfoCase;
import com.tencent.ilivesdk.domain.usecase.ListenVideoCurrentTimeCase;
import com.tencent.ilivesdk.domain.usecase.RequestFollowCase;
import java.util.Map;

public class LiveCaseFactory
{
  private static LiveCaseConfig liveCaseConfig = new LiveCaseConfig();
  
  static
  {
    liveCaseConfig.add(LiveCaseType.GET_ANCHOR_INFO, GetAnchorInfoCase.class);
    liveCaseConfig.add(LiveCaseType.GET_FOLLOW_STATE, GetFollowStateCase.class);
    liveCaseConfig.add(LiveCaseType.REQUEST_FOLLOW, RequestFollowCase.class);
    liveCaseConfig.add(LiveCaseType.REQUEST_LINKMIC_USERINFO, GetLinkMicUserInfoCase.class);
    liveCaseConfig.add(LiveCaseType.LISTEN_VIDEO_CURRENT_POSITION, ListenVideoCurrentTimeCase.class);
  }
  
  public static void config(LiveCaseConfig paramLiveCaseConfig)
  {
    if (paramLiveCaseConfig.get().size() > 0) {
      liveCaseConfig.merge(paramLiveCaseConfig);
    }
  }
  
  public LiveUseCase getCase(LiveCaseType paramLiveCaseType)
  {
    paramLiveCaseType = (Class)liveCaseConfig.get().get(paramLiveCaseType);
    try
    {
      paramLiveCaseType = (LiveUseCase)paramLiveCaseType.newInstance();
      return paramLiveCaseType;
    }
    catch (Exception paramLiveCaseType)
    {
      label26:
      break label26;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.domain.factory.LiveCaseFactory
 * JD-Core Version:    0.7.0.1
 */