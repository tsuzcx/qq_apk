import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class bglb
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bglb(bgkx parambgkx) {}
  
  public void onGlobalLayout()
  {
    bgkx.a(this.a, this.a.jdField_a_of_type_JavaUtilArrayList);
    if ((bgkx.a(this.a) != null) && (bgkx.a(this.a).getViewTreeObserver() != null) && (Build.VERSION.SDK_INT > 16) && (this.a.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null)) {
      bgkx.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this.a.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bglb
 * JD-Core Version:    0.7.0.1
 */