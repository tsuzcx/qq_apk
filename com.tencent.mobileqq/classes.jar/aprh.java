import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

class aprh
  implements bfqu
{
  aprh(aprb paramaprb) {}
  
  public void F()
  {
    aprb.a(this.a, false);
    this.a.jdField_a_of_type_Apqs.o();
    this.a.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
  }
  
  public void G()
  {
    aprb.a(this.a, false);
    if (aprb.a(this.a)) {
      this.a.g(true);
    }
    if (aprb.b(this.a)) {
      this.a.h(true);
    }
    if (aprb.c(this.a)) {
      this.a.b(true);
    }
  }
  
  public void H() {}
  
  public void a(float paramFloat)
  {
    aprb.a(this.a, true);
    Drawable localDrawable;
    if (aprb.a(this.a) != null)
    {
      localDrawable = aprb.a(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha(0);
      }
    }
    if (aprb.b(this.a) != null)
    {
      localDrawable = aprb.b(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      aprb.a(this.a).setVisibility(8);
      aprb.c(this.a).setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aprh
 * JD-Core Version:    0.7.0.1
 */