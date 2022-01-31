import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.multicard.MultiCardRootLayout;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class aujy
  implements bhsy
{
  float jdField_a_of_type_Float;
  final int jdField_a_of_type_Int = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getContext()));
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  float c;
  float d;
  
  public aujy(MultiCardRootLayout paramMultiCardRootLayout) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    MultiCardRootLayout.a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout, false);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      if (MultiCardRootLayout.a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout) != null)
      {
        aujz localaujz = (aujz)MultiCardRootLayout.a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout).get();
        if (localaujz != null) {
          MultiCardRootLayout.a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout, localaujz.a(paramMotionEvent));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("placeholder", 2, "onInterceptTouchEvent() called with: ev = [" + paramMotionEvent + "], intercept = " + MultiCardRootLayout.a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout));
      }
      return MultiCardRootLayout.a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
      float f1 = paramMotionEvent.getX();
      this.d = f1;
      this.jdField_b_of_type_Float = f1;
      f1 = paramMotionEvent.getY();
      this.c = f1;
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Int = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      continue;
      int i = this.jdField_b_of_type_Int;
      if (i != -1)
      {
        i = MotionEventCompat.findPointerIndex(paramMotionEvent, i);
        if ((i >= 0) && (i <= paramMotionEvent.getPointerCount() - 1))
        {
          float f2 = MotionEventCompat.getX(paramMotionEvent, i);
          f1 = Math.abs(f2 - this.d);
          float f3 = MotionEventCompat.getY(paramMotionEvent, i) - this.jdField_a_of_type_Float;
          float f4 = Math.abs(f3);
          if ((f4 > this.jdField_a_of_type_Int) && (f4 * 0.5F > f1))
          {
            MultiCardRootLayout.a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout, false);
            if (f3 > 0.0F) {}
            for (f1 = this.c + this.jdField_a_of_type_Int;; f1 = this.c - this.jdField_a_of_type_Int)
            {
              this.jdField_a_of_type_Float = f1;
              this.jdField_b_of_type_Float = f2;
              break;
            }
          }
          if (f1 > this.jdField_a_of_type_Int) {
            MultiCardRootLayout.a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout, true);
          } else if (QLog.isColorLevel()) {
            QLog.d("placeholder", 2, "onInterceptTouchEvent() called with: ev = [" + paramMotionEvent + "] do nothing");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aujy
 * JD-Core Version:    0.7.0.1
 */