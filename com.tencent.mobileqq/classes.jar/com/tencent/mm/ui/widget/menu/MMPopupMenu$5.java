package com.tencent.mm.ui.widget.menu;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.i.e;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MMPopupMenu$5
  implements AdapterView.OnItemClickListener
{
  MMPopupMenu$5(MMPopupMenu paramMMPopupMenu) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (MMPopupMenu.b(this.a) != null) {
      MMPopupMenu.b(this.a).a(MMPopupMenu.a(this.a).getItem(paramInt), paramInt);
    }
    if ((MMPopupMenu.c(this.a) != null) && (MMPopupMenu.c(this.a).e())) {
      MMPopupMenu.c(this.a).c();
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.menu.MMPopupMenu.5
 * JD-Core Version:    0.7.0.1
 */