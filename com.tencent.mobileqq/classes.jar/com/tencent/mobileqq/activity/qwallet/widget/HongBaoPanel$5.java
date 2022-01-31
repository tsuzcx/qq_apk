package com.tencent.mobileqq.activity.qwallet.widget;

import acxs;
import ahcw;
import ahcz;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

class HongBaoPanel$5
  implements HongBaoPanel.OnHolderItemClickListener
{
  HongBaoPanel$5(HongBaoPanel paramHongBaoPanel) {}
  
  public void onItemClick(View paramView, int paramInt)
  {
    ahcz localahcz = this.this$0.mAdapter.getPanelDataAtPos(paramInt);
    if (QLog.isColorLevel()) {
      if ("OnHolderItemClickListener onItemClick  panelData=" + localahcz != null) {
        break label126;
      }
    }
    label126:
    for (paramView = "null";; paramView = localahcz + ",p=" + paramInt)
    {
      QLog.d("HongBaoPanel", 2, paramView);
      acxs.a(this.this$0.mApp, this.this$0.mActivity, this.this$0.mSessionInfo, localahcz, this.this$0.mAdapter.getDatas(), 3);
      if ((this.this$0.redManager != null) && (localahcz != null)) {
        this.this$0.redManager.a(localahcz.a);
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