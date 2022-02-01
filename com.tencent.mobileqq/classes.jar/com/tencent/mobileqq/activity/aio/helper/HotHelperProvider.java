package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;

public class HotHelperProvider
  extends HelperProvider
{
  public HotHelperProvider(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void a(HotChatPie paramHotChatPie)
  {
    a(136, new HotGiftPanelHelper(paramHotChatPie));
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    a((HotChatPie)paramBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.HotHelperProvider
 * JD-Core Version:    0.7.0.1
 */