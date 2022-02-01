package com.tencent.mm.ui.widget.menu;

import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.f;

class MMPopupMenu$2
  implements View.OnLongClickListener
{
  MMPopupMenu$2(MMPopupMenu paramMMPopupMenu, View.OnCreateContextMenuListener paramOnCreateContextMenuListener) {}
  
  public boolean onLongClick(View paramView)
  {
    f.a("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view long click", new Object[0]);
    MMPopupMenu.a(this.b).clear();
    MMPopupMenu.a(this.b, paramView);
    this.a.onCreateContextMenu(MMPopupMenu.a(this.b), paramView, null);
    if ((paramView.getTag(2131447798) instanceof int[]))
    {
      paramView = (int[])paramView.getTag(2131447798);
      if (paramView == null)
      {
        this.b.show();
        return true;
      }
      this.b.show(paramView[0], paramView[1]);
      return true;
    }
    this.b.show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.menu.MMPopupMenu.2
 * JD-Core Version:    0.7.0.1
 */