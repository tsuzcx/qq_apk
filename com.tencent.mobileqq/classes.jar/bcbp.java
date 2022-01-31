import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

class bcbp
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bcbp(bcbo parambcbo, String paramString) {}
  
  public void onGlobalLayout()
  {
    bcbo.a(this.jdField_a_of_type_Bcbo).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    bcbo.a(this.jdField_a_of_type_Bcbo, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbp
 * JD-Core Version:    0.7.0.1
 */