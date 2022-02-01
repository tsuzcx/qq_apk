import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.qphone.base.util.QLog;

public class bhyt
  implements View.OnTouchListener
{
  Context jdField_a_of_type_AndroidContentContext;
  PAHighLightImageView jdField_a_of_type_ComTencentMobileqqWidgetPAHighLightImageView;
  
  public bhyt(PAHighLightImageView paramPAHighLightImageView, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPAHighLightImageView = paramPAHighLightImageView;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAHighLightImageView", 2, "onTouch is called,action is:" + paramMotionEvent.getAction());
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetPAHighLightImageView.getTag(2131373036);
    if (paramView == null) {}
    label100:
    do
    {
      return false;
      if (paramView.equals(Integer.valueOf(1))) {}
      for (boolean bool = true;; bool = false)
      {
        if (paramMotionEvent.getAction() != 0) {
          break label100;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetPAHighLightImageView.a(this.jdField_a_of_type_AndroidContentContext, bool);
        return false;
        if (!paramView.equals(Integer.valueOf(2))) {
          break;
        }
      }
    } while ((paramMotionEvent.getAction() != 3) && (paramMotionEvent.getAction() != 1));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPAHighLightImageView.a();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhyt
 * JD-Core Version:    0.7.0.1
 */