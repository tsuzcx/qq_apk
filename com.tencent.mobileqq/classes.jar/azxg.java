import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.DecelerateInterpolator;
import com.tencent.qphone.base.util.QLog;

class azxg
  implements View.OnTouchListener
{
  azxg(azxe paramazxe, View paramView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      if (!this.jdField_a_of_type_Azxe.b)
      {
        this.jdField_a_of_type_Azxe.b = true;
        ObjectAnimator localObjectAnimator = (ObjectAnimator)paramView.getTag(2131373559);
        paramMotionEvent = localObjectAnimator;
        if (localObjectAnimator == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("StructMsgItemLayout12", 2, "animator is null");
          }
          paramMotionEvent = ObjectAnimator.ofPropertyValuesHolder(this.jdField_a_of_type_AndroidViewView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scaleX", new float[] { 0.9F }), PropertyValuesHolder.ofFloat("scaleY", new float[] { 0.95F }) });
          paramMotionEvent.setInterpolator(new DecelerateInterpolator(2.0F));
          paramMotionEvent.setDuration(100L);
          paramView.setTag(2131373559, paramMotionEvent);
        }
        paramMotionEvent.start();
      }
      return true;
      this.jdField_a_of_type_Azxe.a.onClick(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Azxe.b = false;
      paramView = (ObjectAnimator)paramView.getTag(2131373559);
      if (paramView != null) {
        paramView.reverse();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azxg
 * JD-Core Version:    0.7.0.1
 */