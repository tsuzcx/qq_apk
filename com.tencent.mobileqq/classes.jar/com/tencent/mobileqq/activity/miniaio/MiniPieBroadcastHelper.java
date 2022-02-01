package com.tencent.mobileqq.activity.miniaio;

import android.support.annotation.NonNull;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;

class MiniPieBroadcastHelper
  implements ILifeCycleHelper
{
  private MiniPie a;
  
  public MiniPieBroadcastHelper(MiniPie paramMiniPie)
  {
    this.a = paramMiniPie;
  }
  
  private void a()
  {
    SimpleEventBus.getInstance().dispatchEvent(new MiniPieJumpToAioEvent());
  }
  
  @NonNull
  public String getTag()
  {
    return "MiniPieBroadcastHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 13 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (!this.a.f);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPieBroadcastHelper
 * JD-Core Version:    0.7.0.1
 */