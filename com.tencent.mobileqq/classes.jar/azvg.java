import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import com.tencent.mobileqq.redtouch.RedTouch;

public class azvg
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public azvg(RedTouch paramRedTouch, String paramString) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    RedTouch.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvg
 * JD-Core Version:    0.7.0.1
 */