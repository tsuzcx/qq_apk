package androidx.appcompat.widget;

import android.widget.PopupWindow.OnDismissListener;

class PopupMenu$2
  implements PopupWindow.OnDismissListener
{
  PopupMenu$2(PopupMenu paramPopupMenu) {}
  
  public void onDismiss()
  {
    if (this.this$0.mOnDismissListener != null) {
      this.this$0.mOnDismissListener.onDismiss(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.PopupMenu.2
 * JD-Core Version:    0.7.0.1
 */