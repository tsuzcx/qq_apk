package androidx.appcompat.view.menu;

import androidx.appcompat.widget.ForwardingListener;

class ActionMenuItemView$ActionMenuItemForwardingListener
  extends ForwardingListener
{
  public ActionMenuItemView$ActionMenuItemForwardingListener(ActionMenuItemView paramActionMenuItemView)
  {
    super(paramActionMenuItemView);
  }
  
  public ShowableListMenu getPopup()
  {
    if (this.this$0.mPopupCallback != null) {
      return this.this$0.mPopupCallback.getPopup();
    }
    return null;
  }
  
  protected boolean onForwardingStarted()
  {
    Object localObject = this.this$0.mItemInvoker;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (this.this$0.mItemInvoker.invokeItem(this.this$0.mItemData))
      {
        localObject = getPopup();
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (((ShowableListMenu)localObject).isShowing()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.view.menu.ActionMenuItemView.ActionMenuItemForwardingListener
 * JD-Core Version:    0.7.0.1
 */