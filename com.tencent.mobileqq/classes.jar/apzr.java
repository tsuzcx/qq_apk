import android.app.Activity;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.qphone.base.util.QLog;

public class apzr
  implements View.OnTouchListener
{
  public apzr(AIOEmotionFragment paramAIOEmotionFragment, aqap paramaqap) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.b.setBackgroundColor(Color.parseColor("#F7F7F7"));
      paramView = this.jdField_a_of_type_Aqap.a();
      if (QLog.isColorLevel()) {
        QLog.i("AIOEmotionFragment", 2, "updateSelfEmotionDetail id:" + paramView);
      }
      bnld.b((Activity)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.a, paramView);
      paramView = (Activity)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.a;
      if ((paramView != null) && (!paramView.isFinishing())) {
        paramView.finish();
      }
    }
    for (;;)
    {
      return false;
      if (paramMotionEvent.getAction() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.b.setBackgroundColor(Color.parseColor("#DEDEDE"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apzr
 * JD-Core Version:    0.7.0.1
 */