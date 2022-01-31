import android.view.View;
import android.view.View.OnClickListener;
import dov.com.qq.im.capture.text.DynamicTextItem;

class bkcp
  implements View.OnClickListener
{
  bkcp(bkcm parambkcm) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem != null)
    {
      bkcm.a(this.a, false);
      this.a.a = this.a.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem;
      this.a.a.a(bkcm.a(this.a), this.a.jdField_b_of_type_JavaLangString);
      this.a.a.c(this.a.i);
      if ((this.a.a instanceof bjij)) {
        ((bjij)this.a.a).a(this.a.h);
      }
      this.a.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkcp
 * JD-Core Version:    0.7.0.1
 */