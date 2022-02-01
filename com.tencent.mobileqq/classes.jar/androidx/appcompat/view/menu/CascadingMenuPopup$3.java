package androidx.appcompat.view.menu;

import android.os.Handler;
import android.os.SystemClock;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.MenuItemHoverListener;
import java.util.List;

class CascadingMenuPopup$3
  implements MenuItemHoverListener
{
  CascadingMenuPopup$3(CascadingMenuPopup paramCascadingMenuPopup) {}
  
  public void onItemHoverEnter(@NonNull MenuBuilder paramMenuBuilder, @NonNull MenuItem paramMenuItem)
  {
    Handler localHandler = this.this$0.mSubMenuHoverHandler;
    CascadingMenuPopup.CascadingMenuInfo localCascadingMenuInfo = null;
    localHandler.removeCallbacksAndMessages(null);
    int j = this.this$0.mShowingMenus.size();
    int i = 0;
    while (i < j)
    {
      if (paramMenuBuilder == ((CascadingMenuPopup.CascadingMenuInfo)this.this$0.mShowingMenus.get(i)).menu) {
        break label75;
      }
      i += 1;
    }
    i = -1;
    label75:
    if (i == -1) {
      return;
    }
    i += 1;
    if (i < this.this$0.mShowingMenus.size()) {
      localCascadingMenuInfo = (CascadingMenuPopup.CascadingMenuInfo)this.this$0.mShowingMenus.get(i);
    }
    paramMenuItem = new CascadingMenuPopup.3.1(this, localCascadingMenuInfo, paramMenuItem, paramMenuBuilder);
    long l = SystemClock.uptimeMillis();
    this.this$0.mSubMenuHoverHandler.postAtTime(paramMenuItem, paramMenuBuilder, l + 200L);
  }
  
  public void onItemHoverExit(@NonNull MenuBuilder paramMenuBuilder, @NonNull MenuItem paramMenuItem)
  {
    this.this$0.mSubMenuHoverHandler.removeCallbacksAndMessages(paramMenuBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.view.menu.CascadingMenuPopup.3
 * JD-Core Version:    0.7.0.1
 */