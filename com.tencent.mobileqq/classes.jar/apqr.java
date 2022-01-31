import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

class apqr
  implements bfqd
{
  apqr(apqq paramapqq) {}
  
  public void F()
  {
    apqq.a(this.a, false);
    this.a.jdField_a_of_type_Apqo.o();
  }
  
  public void G()
  {
    apqq.a(this.a, false);
    if (apqq.a(this.a)) {
      this.a.b(true);
    }
    if (apqq.b(this.a)) {
      this.a.a(true);
    }
  }
  
  public void H() {}
  
  public void a(float paramFloat)
  {
    apqq.a(this.a, true);
    if (apqq.a(this.a) != null)
    {
      Drawable localDrawable = apqq.a(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      if (apqq.a(this.a) != null) {
        apqq.a(this.a).setVisibility(8);
      }
      if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apqr
 * JD-Core Version:    0.7.0.1
 */