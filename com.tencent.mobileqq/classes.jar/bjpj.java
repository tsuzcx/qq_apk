import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.open.agent.SwitchAccountActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class bjpj
  implements View.OnTouchListener
{
  protected GestureDetector.SimpleOnGestureListener a;
  protected GestureDetector a;
  View jdField_a_of_type_AndroidViewView;
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bjpj(SwitchAccountActivity paramSwitchAccountActivity)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener = new bjpk(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (QLog.isColorLevel()) {
      QLog.i("AccountManage", 2, "action = " + i);
    }
    if (i == 0)
    {
      this.jdField_a_of_type_AndroidViewView = paramView;
      if (this.jdField_a_of_type_ComTencentOpenAgentSwitchAccountActivity.a == true) {
        this.jdField_a_of_type_ComTencentOpenAgentSwitchAccountActivity.a = false;
      }
    }
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjpj
 * JD-Core Version:    0.7.0.1
 */