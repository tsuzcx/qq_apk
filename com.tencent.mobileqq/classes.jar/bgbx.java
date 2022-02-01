import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

class bgbx
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bgbx(bgbw parambgbw, String paramString) {}
  
  public void onGlobalLayout()
  {
    bgbw.a(this.jdField_a_of_type_Bgbw).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    bgbw.a(this.jdField_a_of_type_Bgbw, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgbx
 * JD-Core Version:    0.7.0.1
 */