import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class bbxh
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bbxh(bbxf parambbxf, boolean paramBoolean) {}
  
  public void onGlobalLayout()
  {
    bbxf.a(this.jdField_a_of_type_Bbxf).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    bbxf.b(this.jdField_a_of_type_Bbxf).setVisibility(4);
    bbxf.a(this.jdField_a_of_type_Bbxf, this.jdField_a_of_type_Boolean, bbxf.a(this.jdField_a_of_type_Bbxf), bbxf.c(this.jdField_a_of_type_Bbxf));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbxh
 * JD-Core Version:    0.7.0.1
 */