import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

class arjy
  implements bhrq
{
  arjy(arjx paramarjx) {}
  
  public void F()
  {
    arjx.a(this.a, false);
    this.a.jdField_a_of_type_Arjv.o();
  }
  
  public void G()
  {
    arjx.a(this.a, false);
    if (arjx.a(this.a)) {
      this.a.b(true);
    }
    if (arjx.b(this.a)) {
      this.a.a(true);
    }
  }
  
  public void H() {}
  
  public void a(float paramFloat)
  {
    arjx.a(this.a, true);
    if (arjx.a(this.a) != null)
    {
      Drawable localDrawable = arjx.a(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      if (arjx.a(this.a) != null) {
        arjx.a(this.a).setVisibility(8);
      }
      if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arjy
 * JD-Core Version:    0.7.0.1
 */