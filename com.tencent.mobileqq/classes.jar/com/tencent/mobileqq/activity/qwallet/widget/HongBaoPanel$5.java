package com.tencent.mobileqq.activity.qwallet.widget;

import aetu;
import ajbp;
import ajbs;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

class HongBaoPanel$5
  implements HongBaoPanel.OnHolderItemClickListener
{
  HongBaoPanel$5(HongBaoPanel paramHongBaoPanel) {}
  
  public void onItemClick(View paramView, int paramInt)
  {
    ajbs localajbs = this.this$0.mAdapter.getPanelDataAtPos(paramInt);
    if (QLog.isColorLevel()) {
      if ("OnHolderItemClickListener onItemClick  panelData=" + localajbs != null) {
        break label126;
      }
    }
    label126:
    for (paramView = "null";; paramView = localajbs + ",p=" + paramInt)
    {
      QLog.d("HongBaoPanel", 2, paramView);
      aetu.a(this.this$0.mApp, this.this$0.mActivity, this.this$0.mSessionInfo, localajbs, this.this$0.mAdapter.getDatas(), 3);
      if ((this.this$0.redManager != null) && (localajbs != null)) {
        this.this$0.redManager.a(localajbs.a);
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