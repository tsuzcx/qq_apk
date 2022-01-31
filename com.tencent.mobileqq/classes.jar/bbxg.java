import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

class bbxg
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bbxg(bbxf parambbxf, String paramString) {}
  
  public void onGlobalLayout()
  {
    bbxf.a(this.jdField_a_of_type_Bbxf).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    bbxf.a(this.jdField_a_of_type_Bbxf, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbxg
 * JD-Core Version:    0.7.0.1
 */