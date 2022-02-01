package com.tencent.mm.ui.widget.menu;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.i.c;
import com.tencent.mm.ui.f;

class MMPopupMenu$4
  implements View.OnLongClickListener
{
  MMPopupMenu$4(MMPopupMenu paramMMPopupMenu, i.c paramc, View paramView) {}
  
  public boolean onLongClick(View paramView)
  {
    f.a("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view long click", new Object[0]);
    MMPopupMenu.a(this.c).clear();
    MMPopupMenu.a(this.c, paramView);
    this.a.a(MMPopupMenu.a(this.c), paramView, null);
    paramView = new int[2];
    this.b.getLocationInWindow(paramView);
    int i = paramView[0] + (int)(this.b.getWidth() / 2.0F);
    int j = paramView[1];
    if ((i == 0) && (j == 0))
    {
      this.c.show();
      return true;
    }
    this.c.show(i, j);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.menu.MMPopupMenu.4
 * JD-Core Version:    0.7.0.1
 */