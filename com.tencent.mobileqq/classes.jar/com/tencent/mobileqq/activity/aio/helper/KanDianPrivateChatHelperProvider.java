package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.KanDianPrivateChatPie;

public class KanDianPrivateChatHelperProvider
  extends HelperProvider
{
  public KanDianPrivateChatHelperProvider(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void a(KanDianPrivateChatPie paramKanDianPrivateChatPie)
  {
    paramKanDianPrivateChatPie = new KanDianPrivateChatAddFriendHelper(paramKanDianPrivateChatPie.bv());
    a(113, paramKanDianPrivateChatPie);
    a(paramKanDianPrivateChatPie);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    a((KanDianPrivateChatPie)paramBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.KanDianPrivateChatHelperProvider
 * JD-Core Version:    0.7.0.1
 */