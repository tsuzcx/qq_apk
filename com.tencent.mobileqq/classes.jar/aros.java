import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

class aros
  implements bhvx
{
  aros(aron paramaron) {}
  
  public void F()
  {
    aron.a(this.a, false);
    this.a.jdField_a_of_type_Aroe.o();
    this.a.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
  }
  
  public void G()
  {
    aron.a(this.a, false);
    if (aron.a(this.a)) {
      this.a.f(true);
    }
    if (aron.b(this.a)) {
      this.a.g(true);
    }
    if (aron.c(this.a)) {
      this.a.b(true);
    }
  }
  
  public void H() {}
  
  public void a(float paramFloat)
  {
    aron.a(this.a, true);
    Drawable localDrawable;
    if (aron.a(this.a) != null)
    {
      localDrawable = aron.a(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha(0);
      }
    }
    if (aron.b(this.a) != null)
    {
      localDrawable = aron.b(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      aron.a(this.a).setVisibility(8);
      aron.c(this.a).setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aros
 * JD-Core Version:    0.7.0.1
 */