import android.graphics.Bitmap;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;

class beeg
  implements Animation.AnimationListener
{
  beeg(beed parambeed) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->on hideAnimationEnd!");
    }
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    if ((this.a.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.a.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.a.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beeg
 * JD-Core Version:    0.7.0.1
 */