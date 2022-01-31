import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.dataline.activities.LiteActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class bm
  implements View.OnTouchListener
{
  public bm(LiteActivity paramLiteActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(LiteActivity.jdField_a_of_type_JavaLangString, 2, "ontouch--fcc----: " + paramMotionEvent.getAction());
    }
    this.a.p();
    LiteActivity.a(this.a, false);
    this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.postDelayed(new bn(this), 200L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bm
 * JD-Core Version:    0.7.0.1
 */