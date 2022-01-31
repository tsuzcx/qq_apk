import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

class apqv
  implements bfqu
{
  apqv(apqu paramapqu) {}
  
  public void F()
  {
    apqu.a(this.a, false);
    this.a.jdField_a_of_type_Apqs.o();
  }
  
  public void G()
  {
    apqu.a(this.a, false);
    if (apqu.a(this.a)) {
      this.a.b(true);
    }
    if (apqu.b(this.a)) {
      this.a.a(true);
    }
  }
  
  public void H() {}
  
  public void a(float paramFloat)
  {
    apqu.a(this.a, true);
    if (apqu.a(this.a) != null)
    {
      Drawable localDrawable = apqu.a(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      if (apqu.a(this.a) != null) {
        apqu.a(this.a).setVisibility(8);
      }
      if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apqv
 * JD-Core Version:    0.7.0.1
 */