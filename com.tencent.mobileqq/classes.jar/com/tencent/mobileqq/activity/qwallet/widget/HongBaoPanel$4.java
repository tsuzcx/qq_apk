package com.tencent.mobileqq.activity.qwallet.widget;

import android.view.View;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager;
import com.tencent.mobileqq.activity.qwallet.redpacket.PanelData;
import com.tencent.qphone.base.util.QLog;

class HongBaoPanel$4
  implements HongBaoPanel.OnHolderItemClickListener
{
  HongBaoPanel$4(HongBaoPanel paramHongBaoPanel) {}
  
  public void onItemClick(View paramView, int paramInt)
  {
    PanelData localPanelData = this.this$0.mAdapter.getPanelDataAtPos(paramInt);
    if (QLog.isColorLevel()) {
      if ("OnHolderItemClickListener onItemClick  panelData=" + localPanelData != null) {
        break label116;
      }
    }
    label116:
    for (paramView = "null";; paramView = localPanelData + ",p=" + paramInt)
    {
      QLog.d("HongBaoPanel", 2, paramView);
      PlusPanelUtils.a(this.this$0.mApp, this.this$0.mActivity, this.this$0.mSessionInfo, localPanelData, 3);
      if ((this.this$0.redManager != null) && (localPanelData != null)) {
        this.this$0.redManager.a(localPanelData.a);
      }
      this.this$0.mAdapter.notifyItemChanged(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel.4
 * JD-Core Version:    0.7.0.1
 */