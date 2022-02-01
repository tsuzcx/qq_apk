package com.tencent.mobileqq.activity.qwallet;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopUnAccalimedRedPacketList$2
  implements View.OnClickListener
{
  TroopUnAccalimedRedPacketList$2(TroopUnAccalimedRedPacketList paramTroopUnAccalimedRedPacketList) {}
  
  public void onClick(View paramView)
  {
    TroopUnAccalimedRedPacketList.a(this.a, true);
    if (TroopUnAccalimedRedPacketList.a(this.a) != null) {
      QWalletTools.a(TroopUnAccalimedRedPacketList.a(this.a), TroopUnAccalimedRedPacketList.a(this.a).getCurrentAccountUin(), 2, "", 0L, 162, "aio.hongbaolist.back", "", "");
    }
    if (this.a.a != null) {
      this.a.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList.2
 * JD-Core Version:    0.7.0.1
 */