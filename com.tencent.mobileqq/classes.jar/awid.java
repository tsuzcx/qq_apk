import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class awid
  extends bhnr
{
  awid(awhw paramawhw) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "RESUME_GESTURE_ANI, " + this.a.d);
    }
    this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awid
 * JD-Core Version:    0.7.0.1
 */