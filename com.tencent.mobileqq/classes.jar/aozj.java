import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

class aozj
  implements beij
{
  aozj(aozd paramaozd) {}
  
  public void F()
  {
    aozd.a(this.a, false);
    this.a.jdField_a_of_type_Aoyu.o();
    this.a.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
  }
  
  public void G()
  {
    aozd.a(this.a, false);
    if (aozd.a(this.a)) {
      this.a.g(true);
    }
    if (aozd.b(this.a)) {
      this.a.h(true);
    }
    if (aozd.c(this.a)) {
      this.a.b(true);
    }
  }
  
  public void H() {}
  
  public void a(float paramFloat)
  {
    aozd.a(this.a, true);
    Drawable localDrawable;
    if (aozd.a(this.a) != null)
    {
      localDrawable = aozd.a(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha(0);
      }
    }
    if (aozd.b(this.a) != null)
    {
      localDrawable = aozd.b(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      aozd.a(this.a).setVisibility(8);
      aozd.c(this.a).setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aozj
 * JD-Core Version:    0.7.0.1
 */