package com.tencent.biz.subscribe.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.event.UserStateUpdateEvent;

class SubscribePersonalDetailFragment$SubscribePersonalBroadcastReceiver
  extends BroadcastReceiver
{
  private SubscribePersonalDetailFragment$SubscribePersonalBroadcastReceiver(SubscribePersonalDetailFragment paramSubscribePersonalDetailFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (TextUtils.equals(paramIntent.getAction(), "action_reload_get_main_page")))
    {
      SubscribePersonalDetailFragment.b(this.a, false);
      SimpleEventBus.getInstance().dispatchEvent(new UserStateUpdateEvent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment.SubscribePersonalBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */