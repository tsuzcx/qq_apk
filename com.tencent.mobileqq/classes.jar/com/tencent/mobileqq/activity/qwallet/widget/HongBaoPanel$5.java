package com.tencent.mobileqq.activity.qwallet.widget;

import aepf;
import aixa;
import aixd;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

class HongBaoPanel$5
  implements HongBaoPanel.OnHolderItemClickListener
{
  HongBaoPanel$5(HongBaoPanel paramHongBaoPanel) {}
  
  public void onItemClick(View paramView, int paramInt)
  {
    aixd localaixd = this.this$0.mAdapter.getPanelDataAtPos(paramInt);
    if (QLog.isColorLevel()) {
      if ("OnHolderItemClickListener onItemClick  panelData=" + localaixd != null) {
        break label126;
      }
    }
    label126:
    for (paramView = "null";; paramView = localaixd + ",p=" + paramInt)
    {
      QLog.d("HongBaoPanel", 2, paramView);
      aepf.a(this.this$0.mApp, this.this$0.mActivity, this.this$0.mSessionInfo, localaixd, this.this$0.mAdapter.getDatas(), 3);
      if ((this.this$0.redManager != null) && (localaixd != null)) {
        this.this$0.redManager.a(localaixd.a);
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