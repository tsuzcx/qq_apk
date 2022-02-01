package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.qroute.QRoute;

public class GameCenterHelper
  implements IHelper, ILifeCycleHelper, OnAioAddShieldClickCallback
{
  private final BaseChatPie a;
  
  public GameCenterHelper(HelperProvider paramHelperProvider, BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
    paramHelperProvider.a(this);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 10007) {
      return;
    }
    if (paramInt1 == 2)
    {
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("0", "1", "176", "969", "96902", "207497", "", "0", "20", "0");
      return;
    }
    if (paramInt1 == 3) {
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("0", "1", "176", "969", "96902", "207496", "", "0", "20", "0");
    }
  }
  
  public String getTag()
  {
    return null;
  }
  
  public int[] interestedIn()
  {
    return new int[0];
  }
  
  public void onMoveToState(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.GameCenterHelper
 * JD-Core Version:    0.7.0.1
 */