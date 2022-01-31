import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

class azyx
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  azyx(azyw paramazyw, String paramString) {}
  
  public void onGlobalLayout()
  {
    azyw.a(this.jdField_a_of_type_Azyw).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    azyw.a(this.jdField_a_of_type_Azyw, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azyx
 * JD-Core Version:    0.7.0.1
 */