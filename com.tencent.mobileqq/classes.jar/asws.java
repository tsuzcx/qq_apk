import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

class asws
  implements bjpi
{
  asws(aswr paramaswr) {}
  
  public void F()
  {
    aswr.a(this.a, false);
    this.a.jdField_a_of_type_Aswp.o();
  }
  
  public void G()
  {
    aswr.a(this.a, false);
    if (aswr.a(this.a)) {
      this.a.b(true);
    }
    if (aswr.b(this.a)) {
      this.a.a(true);
    }
  }
  
  public void H() {}
  
  public void a(float paramFloat)
  {
    aswr.a(this.a, true);
    if (aswr.a(this.a) != null)
    {
      Drawable localDrawable = aswr.a(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      if (aswr.a(this.a) != null) {
        aswr.a(this.a).setVisibility(8);
      }
      if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asws
 * JD-Core Version:    0.7.0.1
 */