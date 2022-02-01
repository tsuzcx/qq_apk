package androidx.appcompat.view.menu;

import android.view.MenuItem;

class CascadingMenuPopup$3$1
  implements Runnable
{
  CascadingMenuPopup$3$1(CascadingMenuPopup.3 param3, CascadingMenuPopup.CascadingMenuInfo paramCascadingMenuInfo, MenuItem paramMenuItem, MenuBuilder paramMenuBuilder) {}
  
  public void run()
  {
    if (this.val$nextInfo != null)
    {
      this.this$1.this$0.mShouldCloseImmediately = true;
      this.val$nextInfo.menu.close(false);
      this.this$1.this$0.mShouldCloseImmediately = false;
    }
    if ((this.val$item.isEnabled()) && (this.val$item.hasSubMenu())) {
      this.val$menu.performItemAction(this.val$item, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.view.menu.CascadingMenuPopup.3.1
 * JD-Core Version:    0.7.0.1
 */