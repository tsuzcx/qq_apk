package com.tencent.mm.ui.widget.menu;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i.c;
import com.tencent.mm.ui.f;
import java.util.Iterator;
import java.util.List;

class MMPopupMenu$3
  implements AdapterView.OnItemLongClickListener
{
  MMPopupMenu$3(MMPopupMenu paramMMPopupMenu, i.c paramc) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    MMPopupMenu.a(this.b).clear();
    f.a("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView long click", new Object[0]);
    paramAdapterView = new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
    this.a.a(MMPopupMenu.a(this.b), paramView, paramAdapterView);
    paramView = MMPopupMenu.a(this.b).getItemList().iterator();
    while (paramView.hasNext()) {
      ((h)paramView.next()).a(paramAdapterView);
    }
    this.b.show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.menu.MMPopupMenu.3
 * JD-Core Version:    0.7.0.1
 */