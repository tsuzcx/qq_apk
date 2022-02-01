import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

class atsy
  implements bkjj
{
  atsy(atsu paramatsu) {}
  
  public void F()
  {
    atsu.a(this.a, false);
    this.a.jdField_a_of_type_Atsk.o();
    this.a.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
  }
  
  public void G()
  {
    atsu.a(this.a, false);
    if (atsu.a(this.a)) {
      this.a.f(true);
    }
    if (atsu.b(this.a)) {
      this.a.g(true);
    }
    if (atsu.c(this.a)) {
      this.a.b(true);
    }
  }
  
  public void H() {}
  
  public void a(float paramFloat)
  {
    atsu.a(this.a, true);
    Drawable localDrawable;
    if (atsu.a(this.a) != null)
    {
      localDrawable = atsu.a(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha(0);
      }
    }
    if (atsu.b(this.a) != null)
    {
      localDrawable = atsu.b(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      atsu.a(this.a).setVisibility(8);
      atsu.c(this.a).setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atsy
 * JD-Core Version:    0.7.0.1
 */