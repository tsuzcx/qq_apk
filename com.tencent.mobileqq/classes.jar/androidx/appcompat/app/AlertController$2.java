package androidx.appcompat.app;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.NestedScrollView.OnScrollChangeListener;

class AlertController$2
  implements NestedScrollView.OnScrollChangeListener
{
  AlertController$2(AlertController paramAlertController, View paramView1, View paramView2) {}
  
  public void onScrollChange(NestedScrollView paramNestedScrollView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AlertController.manageScrollIndicators(paramNestedScrollView, this.val$top, this.val$bottom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AlertController.2
 * JD-Core Version:    0.7.0.1
 */