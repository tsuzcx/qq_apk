package androidx.appcompat.view.menu;

import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.MenuPopupWindow;

class CascadingMenuPopup$CascadingMenuInfo
{
  public final MenuBuilder menu;
  public final int position;
  public final MenuPopupWindow window;
  
  public CascadingMenuPopup$CascadingMenuInfo(@NonNull MenuPopupWindow paramMenuPopupWindow, @NonNull MenuBuilder paramMenuBuilder, int paramInt)
  {
    this.window = paramMenuPopupWindow;
    this.menu = paramMenuBuilder;
    this.position = paramInt;
  }
  
  public ListView getListView()
  {
    return this.window.getListView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.view.menu.CascadingMenuPopup.CascadingMenuInfo
 * JD-Core Version:    0.7.0.1
 */