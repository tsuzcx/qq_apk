package com.tencent.mobileqq.activity.qwallet;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

class TroopUnAccalimedRedPacketList$5
  implements PopupWindow.OnDismissListener
{
  TroopUnAccalimedRedPacketList$5(TroopUnAccalimedRedPacketList paramTroopUnAccalimedRedPacketList) {}
  
  public void onDismiss()
  {
    RedPacketManager.getInstance().onActiveAccount();
    if ((TroopUnAccalimedRedPacketList.a(this.a) != null) && (TroopUnAccalimedRedPacketList.HbListAdapter.a(TroopUnAccalimedRedPacketList.a(this.a)) != null))
    {
      TroopUnAccalimedRedPacketList.HbListAdapter.a(TroopUnAccalimedRedPacketList.a(this.a)).clear();
      TroopUnAccalimedRedPacketList.a(this.a).notifyDataSetChanged();
    }
    if ((!TroopUnAccalimedRedPacketList.a(this.a)) && (TroopUnAccalimedRedPacketList.a(this.a) != null)) {
      QWalletTools.a(TroopUnAccalimedRedPacketList.a(this.a), TroopUnAccalimedRedPacketList.a(this.a).getCurrentAccountUin(), 2, "", 0L, 162, "aio.hongbaolist.keyback", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList.5
 * JD-Core Version:    0.7.0.1
 */