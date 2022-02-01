import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

class aukt
  implements blkm
{
  aukt(aukp paramaukp) {}
  
  public void F()
  {
    aukp.a(this.a, false);
    this.a.jdField_a_of_type_Aukf.o();
    this.a.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
  }
  
  public void G()
  {
    aukp.a(this.a, false);
    if (aukp.a(this.a)) {
      this.a.f(true);
    }
    if (aukp.b(this.a)) {
      this.a.g(true);
    }
    if (aukp.c(this.a)) {
      this.a.b(true);
    }
  }
  
  public void H() {}
  
  public void a(float paramFloat)
  {
    aukp.a(this.a, true);
    Drawable localDrawable;
    if (aukp.a(this.a) != null)
    {
      localDrawable = aukp.a(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha(0);
      }
    }
    if (aukp.b(this.a) != null)
    {
      localDrawable = aukp.b(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      aukp.a(this.a).setVisibility(8);
      aukp.c(this.a).setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aukt
 * JD-Core Version:    0.7.0.1
 */