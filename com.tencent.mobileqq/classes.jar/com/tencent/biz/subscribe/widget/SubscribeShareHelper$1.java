package com.tencent.biz.subscribe.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.event.SharePanelShowStateEvent;

class SubscribeShareHelper$1
  implements DialogInterface.OnDismissListener
{
  SubscribeShareHelper$1(SubscribeShareHelper paramSubscribeShareHelper) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    SimpleEventBus.getInstance().dispatchEvent(new SharePanelShowStateEvent(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeShareHelper.1
 * JD-Core Version:    0.7.0.1
 */