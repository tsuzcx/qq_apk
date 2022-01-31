import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

class aprd
  implements bfqd
{
  aprd(apqx paramapqx) {}
  
  public void F()
  {
    apqx.a(this.a, false);
    this.a.jdField_a_of_type_Apqo.o();
    this.a.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
  }
  
  public void G()
  {
    apqx.a(this.a, false);
    if (apqx.a(this.a)) {
      this.a.g(true);
    }
    if (apqx.b(this.a)) {
      this.a.h(true);
    }
    if (apqx.c(this.a)) {
      this.a.b(true);
    }
  }
  
  public void H() {}
  
  public void a(float paramFloat)
  {
    apqx.a(this.a, true);
    Drawable localDrawable;
    if (apqx.a(this.a) != null)
    {
      localDrawable = apqx.a(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha(0);
      }
    }
    if (apqx.b(this.a) != null)
    {
      localDrawable = apqx.b(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      apqx.a(this.a).setVisibility(8);
      apqx.c(this.a).setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aprd
 * JD-Core Version:    0.7.0.1
 */