import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

class aubk
  implements blau
{
  aubk(aubg paramaubg) {}
  
  public void F()
  {
    aubg.a(this.a, false);
    this.a.jdField_a_of_type_Auaw.o();
    this.a.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
  }
  
  public void G()
  {
    aubg.a(this.a, false);
    if (aubg.a(this.a)) {
      this.a.f(true);
    }
    if (aubg.b(this.a)) {
      this.a.g(true);
    }
    if (aubg.c(this.a)) {
      this.a.b(true);
    }
  }
  
  public void H() {}
  
  public void a(float paramFloat)
  {
    aubg.a(this.a, true);
    Drawable localDrawable;
    if (aubg.a(this.a) != null)
    {
      localDrawable = aubg.a(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha(0);
      }
    }
    if (aubg.b(this.a) != null)
    {
      localDrawable = aubg.b(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      aubg.a(this.a).setVisibility(8);
      aubg.c(this.a).setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubk
 * JD-Core Version:    0.7.0.1
 */