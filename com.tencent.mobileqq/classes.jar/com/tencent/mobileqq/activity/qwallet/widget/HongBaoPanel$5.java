package com.tencent.mobileqq.activity.qwallet.widget;

import afcm;
import akcq;
import akct;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

class HongBaoPanel$5
  implements HongBaoPanel.OnHolderItemClickListener
{
  HongBaoPanel$5(HongBaoPanel paramHongBaoPanel) {}
  
  public void onItemClick(View paramView, int paramInt)
  {
    akct localakct = this.this$0.mAdapter.getPanelDataAtPos(paramInt);
    if (QLog.isColorLevel()) {
      if ("OnHolderItemClickListener onItemClick  panelData=" + localakct != null) {
        break label126;
      }
    }
    label126:
    for (paramView = "null";; paramView = localakct + ",p=" + paramInt)
    {
      QLog.d("HongBaoPanel", 2, paramView);
      afcm.a(this.this$0.mApp, this.this$0.mActivity, this.this$0.mSessionInfo, localakct, this.this$0.mAdapter.getDatas(), 3);
      if ((this.this$0.redManager != null) && (localakct != null)) {
        this.this$0.redManager.a(localakct.a);
      }
      this.this$0.mAdapter.notifyItemChanged(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel.5
 * JD-Core Version:    0.7.0.1
 */