import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

class aoyx
  implements beij
{
  aoyx(aoyw paramaoyw) {}
  
  public void F()
  {
    aoyw.a(this.a, false);
    this.a.jdField_a_of_type_Aoyu.o();
  }
  
  public void G()
  {
    aoyw.a(this.a, false);
    if (aoyw.a(this.a)) {
      this.a.b(true);
    }
    if (aoyw.b(this.a)) {
      this.a.a(true);
    }
  }
  
  public void H() {}
  
  public void a(float paramFloat)
  {
    aoyw.a(this.a, true);
    if (aoyw.a(this.a) != null)
    {
      Drawable localDrawable = aoyw.a(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      if (aoyw.a(this.a) != null) {
        aoyw.a(this.a).setVisibility(8);
      }
      if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoyx
 * JD-Core Version:    0.7.0.1
 */