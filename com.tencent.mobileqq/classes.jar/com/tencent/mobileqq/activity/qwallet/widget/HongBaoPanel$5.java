package com.tencent.mobileqq.activity.qwallet.widget;

import android.view.View;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager;
import com.tencent.mobileqq.activity.qwallet.redpacket.PanelData;
import com.tencent.mobileqq.activity.qwallet.utils.ReportUtils;
import com.tencent.qphone.base.util.QLog;

class HongBaoPanel$5
  implements HongBaoPanel.OnHolderItemClickListener
{
  HongBaoPanel$5(HongBaoPanel paramHongBaoPanel) {}
  
  public void onItemClick(View paramView, int paramInt)
  {
    PanelData localPanelData = this.this$0.mAdapter.getPanelDataAtPos(paramInt);
    if (QLog.isColorLevel()) {
      if ("OnHolderItemClickListener onItemClick  panelData=" + localPanelData != null) {
        break label149;
      }
    }
    label149:
    for (paramView = "null";; paramView = localPanelData + ",p=" + paramInt)
    {
      QLog.d("HongBaoPanel", 2, paramView);
      PlusPanelUtils.a(this.this$0.mApp, this.this$0.mActivity, this.this$0.mSessionInfo, localPanelData, this.this$0.mAdapter.getDatas(), 3);
      if ((this.this$0.redManager != null) && (localPanelData != null))
      {
        this.this$0.redManager.a(localPanelData.a);
        ReportUtils.a(this.this$0.mApp, "aio.lucky.click", this.this$0.mSessionInfo, localPanelData.b);
      }
      this.this$0.mAdapter.notifyItemChanged(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel.5
 * JD-Core Version:    0.7.0.1
 */