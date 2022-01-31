import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class atsr
  extends beem
{
  atsr(atsk paramatsk) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "RESUME_GESTURE_ANI, " + this.a.d);
    }
    this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     atsr
 * JD-Core Version:    0.7.0.1
 */