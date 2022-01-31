import android.view.View;
import android.view.View.OnClickListener;
import dov.com.qq.im.capture.text.DynamicTextItem;

class bkby
  implements View.OnClickListener
{
  bkby(bkbv parambkbv) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem != null)
    {
      bkbv.a(this.a, false);
      this.a.a = this.a.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem;
      this.a.a.a(bkbv.a(this.a), this.a.jdField_b_of_type_JavaLangString);
      this.a.a.c(this.a.i);
      if ((this.a.a instanceof bjhs)) {
        ((bjhs)this.a.a).a(this.a.h);
      }
      this.a.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkby
 * JD-Core Version:    0.7.0.1
 */