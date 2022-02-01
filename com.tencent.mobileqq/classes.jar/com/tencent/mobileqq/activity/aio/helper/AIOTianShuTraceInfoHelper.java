package com.tencent.mobileqq.activity.aio.helper;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import cooperation.vip.tianshu.TianShuManager;

class AIOTianShuTraceInfoHelper
  implements ILifeCycleHelper
{
  private final BaseChatPie a;
  
  public AIOTianShuTraceInfoHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  @NonNull
  public String getTag()
  {
    return "AIOTianShuTraceInfoHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 7 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if ((7 == paramInt) && (!(this.a instanceof PublicAccountChatPie))) {
      TianShuManager.setLastClickAdTraceInfo("", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOTianShuTraceInfoHelper
 * JD-Core Version:    0.7.0.1
 */