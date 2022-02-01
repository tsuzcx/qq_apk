package com.tencent.mobileqq.activity.qwallet.widget;

import agju;
import alex;
import alfa;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

class HongBaoPanel$5
  implements HongBaoPanel.OnHolderItemClickListener
{
  HongBaoPanel$5(HongBaoPanel paramHongBaoPanel) {}
  
  public void onItemClick(View paramView, int paramInt)
  {
    alfa localalfa = this.this$0.mAdapter.getPanelDataAtPos(paramInt);
    if (QLog.isColorLevel()) {
      if ("OnHolderItemClickListener onItemClick  panelData=" + localalfa != null) {
        break label126;
      }
    }
    label126:
    for (paramView = "null";; paramView = localalfa + ",p=" + paramInt)
    {
      QLog.d("HongBaoPanel", 2, paramView);
      agju.a(this.this$0.mApp, this.this$0.mActivity, this.this$0.mSessionInfo, localalfa, this.this$0.mAdapter.getDatas(), 3);
      if ((this.this$0.redManager != null) && (localalfa != null)) {
        this.this$0.redManager.a(localalfa.a);
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