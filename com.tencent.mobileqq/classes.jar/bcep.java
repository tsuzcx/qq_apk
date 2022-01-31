import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;

class bcep
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bcep(bceo parambceo, View paramView) {}
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame(localRect);
    int i = this.jdField_a_of_type_AndroidViewView.getRootView().getHeight() - localRect.height();
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "heightDiff:" + i);
    }
    if (i > 150)
    {
      this.jdField_a_of_type_Bceo.c = true;
      this.jdField_a_of_type_Bceo.a(false, 0);
    }
    while (!this.jdField_a_of_type_Bceo.c) {
      return;
    }
    this.jdField_a_of_type_Bceo.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcep
 * JD-Core Version:    0.7.0.1
 */