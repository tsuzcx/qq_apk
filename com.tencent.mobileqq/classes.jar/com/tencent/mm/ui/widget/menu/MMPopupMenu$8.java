package com.tencent.mm.ui.widget.menu;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.f;

class MMPopupMenu$8
  implements View.OnTouchListener
{
  MMPopupMenu$8(MMPopupMenu paramMMPopupMenu) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) != 0) {
      return false;
    }
    MMPopupMenu.a((int)paramMotionEvent.getRawX());
    MMPopupMenu.b((int)paramMotionEvent.getRawY());
    paramView = this.a;
    MMPopupMenu.b(paramView, MMPopupMenu.f(paramView));
    MMPopupMenu.a(true);
    paramView = new StringBuilder();
    paramView.append("popmenu view set , x_down=");
    paramView.append(MMPopupMenu.a());
    paramView.append("y_down=");
    paramView.append(MMPopupMenu.b());
    f.c("MicroMsg.MMPopupMenu", paramView.toString(), new Object[0]);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.menu.MMPopupMenu.8
 * JD-Core Version:    0.7.0.1
 */