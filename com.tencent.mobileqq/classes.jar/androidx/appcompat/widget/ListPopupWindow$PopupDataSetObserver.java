package androidx.appcompat.widget;

import android.database.DataSetObserver;

class ListPopupWindow$PopupDataSetObserver
  extends DataSetObserver
{
  ListPopupWindow$PopupDataSetObserver(ListPopupWindow paramListPopupWindow) {}
  
  public void onChanged()
  {
    if (this.this$0.isShowing()) {
      this.this$0.show();
    }
  }
  
  public void onInvalidated()
  {
    this.this$0.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ListPopupWindow.PopupDataSetObserver
 * JD-Core Version:    0.7.0.1
 */