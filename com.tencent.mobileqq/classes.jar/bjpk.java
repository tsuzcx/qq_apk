import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.open.agent.SwitchAccountActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bjpk
  extends GestureDetector.SimpleOnGestureListener
{
  bjpk(bjpj parambjpj) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Math.abs(paramFloat1) > Math.abs(paramFloat2))
    {
      bool1 = bool2;
      if (Math.abs(paramFloat1) > 20.0F)
      {
        bool1 = bool2;
        if (!this.a.jdField_a_of_type_ComTencentOpenAgentSwitchAccountActivity.a)
        {
          this.a.jdField_a_of_type_ComTencentOpenAgentSwitchAccountActivity.a = true;
          if (this.a.jdField_a_of_type_AndroidViewView != null) {
            this.a.jdField_a_of_type_AndroidViewView.setPressed(false);
          }
          if ((paramFloat1 < -20.0F) && (this.a.jdField_a_of_type_JavaLangRefWeakReference != null))
          {
            paramMotionEvent1 = (View)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
            if (paramMotionEvent1 != null)
            {
              paramMotionEvent1 = paramMotionEvent1.findViewById(2131377481);
              if ((paramMotionEvent1 != null) && (paramMotionEvent1.getVisibility() == 0)) {
                ((ShaderAnimLayout)paramMotionEvent1).e();
              }
            }
            this.a.jdField_a_of_type_JavaLangRefWeakReference = null;
          }
          if (paramFloat1 > 20.0F)
          {
            if ((this.a.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.a.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
              break label245;
            }
            paramMotionEvent1 = (View)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
            if (paramMotionEvent1 != this.a.jdField_a_of_type_AndroidViewView)
            {
              paramMotionEvent1 = paramMotionEvent1.findViewById(2131377481);
              if ((paramMotionEvent1 != null) && (paramMotionEvent1.getVisibility() == 0)) {
                ((ShaderAnimLayout)paramMotionEvent1).e();
              }
            }
            this.a.jdField_a_of_type_JavaLangRefWeakReference = null;
          }
        }
      }
    }
    for (;;)
    {
      bool1 = true;
      return bool1;
      label245:
      if (this.a.jdField_a_of_type_AndroidViewView != null)
      {
        paramMotionEvent1 = this.a.jdField_a_of_type_AndroidViewView.findViewById(2131377481);
        if ((paramMotionEvent1 != null) && (paramMotionEvent1.getVisibility() != 0))
        {
          if (QLog.isColorLevel()) {
            QLog.i("AccountManage", 2, "show current selectedAccountView");
          }
          ((ShaderAnimLayout)paramMotionEvent1).a();
          this.a.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.a.jdField_a_of_type_AndroidViewView);
          this.a.jdField_a_of_type_AndroidViewView = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjpk
 * JD-Core Version:    0.7.0.1
 */