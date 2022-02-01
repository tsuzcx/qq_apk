package com.tencent.mm.ui.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.i.e;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MMBottomSheet$6
  implements View.OnClickListener
{
  MMBottomSheet$6(MMBottomSheet paramMMBottomSheet, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((MMBottomSheet.p(this.b) != null) && (this.a < MMBottomSheet.q(this.b).size())) {
      MMBottomSheet.p(this.b).a(MMBottomSheet.q(this.b).getItem(this.a), this.a);
    }
    if (!MMBottomSheet.h(this.b)) {
      this.b.tryHide();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMBottomSheet.6
 * JD-Core Version:    0.7.0.1
 */