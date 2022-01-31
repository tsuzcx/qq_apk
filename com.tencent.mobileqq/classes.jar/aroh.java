import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

class aroh
  implements bhvx
{
  aroh(arog paramarog) {}
  
  public void F()
  {
    arog.a(this.a, false);
    this.a.jdField_a_of_type_Aroe.o();
  }
  
  public void G()
  {
    arog.a(this.a, false);
    if (arog.a(this.a)) {
      this.a.b(true);
    }
    if (arog.b(this.a)) {
      this.a.a(true);
    }
  }
  
  public void H() {}
  
  public void a(float paramFloat)
  {
    arog.a(this.a, true);
    if (arog.a(this.a) != null)
    {
      Drawable localDrawable = arog.a(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      if (arog.a(this.a) != null) {
        arog.a(this.a).setVisibility(8);
      }
      if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aroh
 * JD-Core Version:    0.7.0.1
 */