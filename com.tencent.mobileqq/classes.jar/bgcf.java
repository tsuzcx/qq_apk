import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class bgcf
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bgcf(bgcb parambgcb) {}
  
  public void onGlobalLayout()
  {
    bgcb.a(this.a, this.a.jdField_a_of_type_JavaUtilArrayList);
    if ((bgcb.a(this.a) != null) && (bgcb.a(this.a).getViewTreeObserver() != null) && (Build.VERSION.SDK_INT > 16) && (this.a.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null)) {
      bgcb.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this.a.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgcf
 * JD-Core Version:    0.7.0.1
 */