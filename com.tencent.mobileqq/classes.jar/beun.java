import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class beun
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  beun(beuj parambeuj) {}
  
  public void onGlobalLayout()
  {
    beuj.a(this.a, this.a.jdField_a_of_type_JavaUtilArrayList);
    if ((beuj.a(this.a) != null) && (beuj.a(this.a).getViewTreeObserver() != null) && (Build.VERSION.SDK_INT > 16) && (this.a.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null)) {
      beuj.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this.a.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     beun
 * JD-Core Version:    0.7.0.1
 */