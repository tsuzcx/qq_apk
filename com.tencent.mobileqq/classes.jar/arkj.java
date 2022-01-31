import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

class arkj
  implements bhrq
{
  arkj(arke paramarke) {}
  
  public void F()
  {
    arke.a(this.a, false);
    this.a.jdField_a_of_type_Arjv.o();
    this.a.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
  }
  
  public void G()
  {
    arke.a(this.a, false);
    if (arke.a(this.a)) {
      this.a.f(true);
    }
    if (arke.b(this.a)) {
      this.a.g(true);
    }
    if (arke.c(this.a)) {
      this.a.b(true);
    }
  }
  
  public void H() {}
  
  public void a(float paramFloat)
  {
    arke.a(this.a, true);
    Drawable localDrawable;
    if (arke.a(this.a) != null)
    {
      localDrawable = arke.a(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha(0);
      }
    }
    if (arke.b(this.a) != null)
    {
      localDrawable = arke.b(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      arke.a(this.a).setVisibility(8);
      arke.c(this.a).setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arkj
 * JD-Core Version:    0.7.0.1
 */