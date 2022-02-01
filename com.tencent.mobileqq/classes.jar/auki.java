import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

class auki
  implements blkm
{
  auki(aukh paramaukh) {}
  
  public void F()
  {
    aukh.a(this.a, false);
    this.a.jdField_a_of_type_Aukf.o();
  }
  
  public void G()
  {
    aukh.a(this.a, false);
    if (aukh.a(this.a)) {
      this.a.b(true);
    }
    if (aukh.b(this.a)) {
      this.a.a(true);
    }
  }
  
  public void H() {}
  
  public void a(float paramFloat)
  {
    aukh.a(this.a, true);
    if (aukh.a(this.a) != null)
    {
      Drawable localDrawable = aukh.a(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      if (aukh.a(this.a) != null) {
        aukh.a(this.a).setVisibility(8);
      }
      if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auki
 * JD-Core Version:    0.7.0.1
 */