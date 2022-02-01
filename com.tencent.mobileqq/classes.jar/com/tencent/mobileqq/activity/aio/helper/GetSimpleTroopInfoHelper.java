package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;

public class GetSimpleTroopInfoHelper
  implements ILifeCycleHelper
{
  private BaseChatPie a;
  private TroopObserver b = new GetSimpleTroopInfoHelper.1(this);
  
  public GetSimpleTroopInfoHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  private void a()
  {
    BaseChatPie localBaseChatPie = this.a;
    if ((localBaseChatPie != null) && (localBaseChatPie.d != null)) {
      this.a.d.removeObserver(this.b);
    }
  }
  
  private void b()
  {
    BaseChatPie localBaseChatPie = this.a;
    if ((localBaseChatPie != null) && (localBaseChatPie.ah != null) && (this.a.ah.b != null))
    {
      this.a.d.addObserver(this.b);
      ((ITroopInfoHandler)this.a.d.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER)).b(this.a.ah.b);
    }
  }
  
  public String getTag()
  {
    return "GetSimpleTroopInfoHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 15, 9 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 9)
    {
      if (paramInt != 15) {
        return;
      }
      a();
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.GetSimpleTroopInfoHelper
 * JD-Core Version:    0.7.0.1
 */