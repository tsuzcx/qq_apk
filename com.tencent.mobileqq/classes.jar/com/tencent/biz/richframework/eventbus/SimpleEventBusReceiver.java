package com.tencent.biz.richframework.eventbus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SimpleEventBusReceiver
  extends BroadcastReceiver
{
  public static final String BROADCAST_RECEIVER_ACTION = "SimpleEventBusReceiver_DISPATCH_SIMPLE_BUS_EVENT";
  public static final String INTENT_KEY_DISPATCH_EVENT = "intent_key_dispatch_event";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("SimpleEventBusReceiver_DISPATCH_SIMPLE_BUS_EVENT".equals(paramIntent.getAction())) {
      SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent)paramIntent.getSerializableExtra("intent_key_dispatch_event"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.eventbus.SimpleEventBusReceiver
 * JD-Core Version:    0.7.0.1
 */