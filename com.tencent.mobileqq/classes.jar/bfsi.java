import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

class bfsi
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bfsi(bfsh parambfsh, String paramString) {}
  
  public void onGlobalLayout()
  {
    bfsh.a(this.jdField_a_of_type_Bfsh).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    bfsh.a(this.jdField_a_of_type_Bfsh, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfsi
 * JD-Core Version:    0.7.0.1
 */