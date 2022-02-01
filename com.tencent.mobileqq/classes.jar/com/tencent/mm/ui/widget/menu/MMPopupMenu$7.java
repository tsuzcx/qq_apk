package com.tencent.mm.ui.widget.menu;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.i.e;
import com.tencent.mm.ui.base.j;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MMPopupMenu$7
  implements View.OnClickListener
{
  MMPopupMenu$7(MMPopupMenu paramMMPopupMenu, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (MMPopupMenu.b(this.b) != null) {
      MMPopupMenu.b(this.b).a(MMPopupMenu.a(this.b).getItem(this.a), this.a);
    }
    MMPopupMenu.e(this.b).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.menu.MMPopupMenu.7
 * JD-Core Version:    0.7.0.1
 */