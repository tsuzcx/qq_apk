package com.tencent.mobileqq.activity.qwallet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager;
import com.tencent.qphone.base.util.QLog;

public class TroopUnAccalimedRedPacketList$RedPacketRefreshReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((!"troop_hblist_broadcast_action".equals(paramIntent.getAction())) || (!TroopUnAccalimedRedPacketList.a())) {}
    do
    {
      int i;
      do
      {
        return;
        i = paramIntent.getIntExtra("result_code", 0);
        int j = paramIntent.getIntExtra("grap_hb_state", 0);
        paramContext = paramIntent.getStringExtra("listid");
        if (QLog.isColorLevel()) {
          QLog.d(TroopUnAccalimedRedPacketList.b(), 2, "RedPacketRefreshReceiver|resultCode:" + i + "|listId: " + paramContext + "|grabHbState: " + j);
        }
        if (i == -20180322)
        {
          TroopUnAccalimedRedPacketList.a().setVisibility(8);
          TroopUnAccalimedRedPacketList.a().setVisibility(8);
          return;
        }
      } while (i != -20180323);
      TroopUnAccalimedRedPacketList.a().setVisibility(0);
      TroopUnAccalimedRedPacketList.a().setVisibility(0);
    } while ((TroopUnAccalimedRedPacketList.a() == null) || (TextUtils.isEmpty(paramContext)));
    TroopUnAccalimedRedPacketList.a().a(paramContext);
    NotifyMsgManager.a(TroopUnAccalimedRedPacketList.a(), TroopUnAccalimedRedPacketList.a(), paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList.RedPacketRefreshReceiver
 * JD-Core Version:    0.7.0.1
 */