import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

class auaz
  implements blau
{
  auaz(auay paramauay) {}
  
  public void F()
  {
    auay.a(this.a, false);
    this.a.jdField_a_of_type_Auaw.o();
  }
  
  public void G()
  {
    auay.a(this.a, false);
    if (auay.a(this.a)) {
      this.a.b(true);
    }
    if (auay.b(this.a)) {
      this.a.a(true);
    }
  }
  
  public void H() {}
  
  public void a(float paramFloat)
  {
    auay.a(this.a, true);
    if (auay.a(this.a) != null)
    {
      Drawable localDrawable = auay.a(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      if (auay.a(this.a) != null) {
        auay.a(this.a).setVisibility(8);
      }
      if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auaz
 * JD-Core Version:    0.7.0.1
 */