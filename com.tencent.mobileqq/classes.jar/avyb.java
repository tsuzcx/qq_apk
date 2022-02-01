import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.multiaio.MultiAIOItemFragment;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.qphone.base.util.QLog;

public class avyb
  implements bjqq
{
  float jdField_a_of_type_Float;
  final int jdField_a_of_type_Int = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOItemFragment.getActivity()));
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  float c;
  float d;
  
  public avyb(MultiAIOItemFragment paramMultiAIOItemFragment) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOItemFragment", 2, "onInterceptTouchEvent() called with: ev = [" + paramMotionEvent + "], intercept = " + bool1);
      }
      return bool1;
      float f1 = paramMotionEvent.getX();
      this.d = f1;
      this.jdField_b_of_type_Float = f1;
      f1 = paramMotionEvent.getY();
      this.c = f1;
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Int = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      bool1 = bool2;
      continue;
      int i = this.jdField_b_of_type_Int;
      bool1 = bool2;
      if (i != -1)
      {
        i = MotionEventCompat.findPointerIndex(paramMotionEvent, i);
        bool1 = bool2;
        if (i >= 0)
        {
          bool1 = bool2;
          if (i <= paramMotionEvent.getPointerCount() - 1)
          {
            float f2 = MotionEventCompat.getX(paramMotionEvent, i);
            f1 = Math.abs(f2 - this.d);
            float f3 = MotionEventCompat.getY(paramMotionEvent, i) - this.jdField_a_of_type_Float;
            float f4 = Math.abs(f3);
            if ((f4 > this.jdField_a_of_type_Int) && (f4 * 0.5F > f1)) {
              if (f3 > 0.0F)
              {
                f1 = this.c + this.jdField_a_of_type_Int;
                label250:
                this.jdField_a_of_type_Float = f1;
                this.jdField_b_of_type_Float = f2;
                bool1 = false;
              }
            }
            for (;;)
            {
              MultiAIOBaseViewPager localMultiAIOBaseViewPager = MultiAIOItemFragment.a(this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOItemFragment);
              bool2 = bool1;
              if (localMultiAIOBaseViewPager != null)
              {
                bool2 = bool1;
                if (localMultiAIOBaseViewPager.a() != MultiAIOItemFragment.a(this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOItemFragment)) {
                  bool2 = true;
                }
              }
              bool1 = bool2;
              break;
              f1 = this.c - this.jdField_a_of_type_Int;
              break label250;
              if (f1 > this.jdField_a_of_type_Int)
              {
                bool1 = true;
              }
              else
              {
                if (QLog.isColorLevel()) {
                  QLog.d("MultiAIOItemFragment", 2, "onInterceptTouchEvent() called with: ev = [" + paramMotionEvent + "] do nothing");
                }
                bool1 = false;
              }
            }
            bool1 = true;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avyb
 * JD-Core Version:    0.7.0.1
 */