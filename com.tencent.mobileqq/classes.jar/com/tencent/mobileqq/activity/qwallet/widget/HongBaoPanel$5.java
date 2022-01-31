package com.tencent.mobileqq.activity.qwallet.widget;

import acnc;
import agqj;
import agqm;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

class HongBaoPanel$5
  implements HongBaoPanel.OnHolderItemClickListener
{
  HongBaoPanel$5(HongBaoPanel paramHongBaoPanel) {}
  
  public void onItemClick(View paramView, int paramInt)
  {
    agqm localagqm = this.this$0.mAdapter.getPanelDataAtPos(paramInt);
    if (QLog.isColorLevel()) {
      if ("OnHolderItemClickListener onItemClick  panelData=" + localagqm != null) {
        break label126;
      }
    }
    label126:
    for (paramView = "null";; paramView = localagqm + ",p=" + paramInt)
    {
      QLog.d("HongBaoPanel", 2, paramView);
      acnc.a(this.this$0.mApp, this.this$0.mActivity, this.this$0.mSessionInfo, localagqm, this.this$0.mAdapter.getDatas(), 3);
      if ((this.this$0.redManager != null) && (localagqm != null)) {
        this.this$0.redManager.a(localagqm.a);
      }
      this.this$0.mAdapter.notifyItemChanged(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel.5
 * JD-Core Version:    0.7.0.1
 */