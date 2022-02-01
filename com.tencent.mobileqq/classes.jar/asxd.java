import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

class asxd
  implements bjpi
{
  asxd(aswz paramaswz) {}
  
  public void F()
  {
    aswz.a(this.a, false);
    this.a.jdField_a_of_type_Aswp.o();
    this.a.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
  }
  
  public void G()
  {
    aswz.a(this.a, false);
    if (aswz.a(this.a)) {
      this.a.f(true);
    }
    if (aswz.b(this.a)) {
      this.a.g(true);
    }
    if (aswz.c(this.a)) {
      this.a.b(true);
    }
  }
  
  public void H() {}
  
  public void a(float paramFloat)
  {
    aswz.a(this.a, true);
    Drawable localDrawable;
    if (aswz.a(this.a) != null)
    {
      localDrawable = aswz.a(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha(0);
      }
    }
    if (aswz.b(this.a) != null)
    {
      localDrawable = aswz.b(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      aswz.a(this.a).setVisibility(8);
      aswz.c(this.a).setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxd
 * JD-Core Version:    0.7.0.1
 */