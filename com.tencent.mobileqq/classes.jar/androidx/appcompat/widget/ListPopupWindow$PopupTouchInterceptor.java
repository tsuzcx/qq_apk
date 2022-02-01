package androidx.appcompat.widget;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;

class ListPopupWindow$PopupTouchInterceptor
  implements View.OnTouchListener
{
  ListPopupWindow$PopupTouchInterceptor(ListPopupWindow paramListPopupWindow) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if ((i == 0) && (this.this$0.mPopup != null) && (this.this$0.mPopup.isShowing()) && (j >= 0) && (j < this.this$0.mPopup.getWidth()) && (k >= 0) && (k < this.this$0.mPopup.getHeight())) {
      this.this$0.mHandler.postDelayed(this.this$0.mResizePopupRunnable, 250L);
    } else if (i == 1) {
      this.this$0.mHandler.removeCallbacks(this.this$0.mResizePopupRunnable);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ListPopupWindow.PopupTouchInterceptor
 * JD-Core Version:    0.7.0.1
 */