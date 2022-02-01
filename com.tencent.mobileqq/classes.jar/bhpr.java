import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;

class bhpr
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bhpr(bhpq parambhpq, View paramView) {}
  
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
      this.jdField_a_of_type_Bhpq.c = true;
      this.jdField_a_of_type_Bhpq.a(false, 0);
    }
    while (!this.jdField_a_of_type_Bhpq.c) {
      return;
    }
    this.jdField_a_of_type_Bhpq.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhpr
 * JD-Core Version:    0.7.0.1
 */