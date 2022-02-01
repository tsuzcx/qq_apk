import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

class atsn
  implements bkjj
{
  atsn(atsm paramatsm) {}
  
  public void F()
  {
    atsm.a(this.a, false);
    this.a.jdField_a_of_type_Atsk.o();
  }
  
  public void G()
  {
    atsm.a(this.a, false);
    if (atsm.a(this.a)) {
      this.a.b(true);
    }
    if (atsm.b(this.a)) {
      this.a.a(true);
    }
  }
  
  public void H() {}
  
  public void a(float paramFloat)
  {
    atsm.a(this.a, true);
    if (atsm.a(this.a) != null)
    {
      Drawable localDrawable = atsm.a(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      if (atsm.a(this.a) != null) {
        atsm.a(this.a).setVisibility(8);
      }
      if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atsn
 * JD-Core Version:    0.7.0.1
 */