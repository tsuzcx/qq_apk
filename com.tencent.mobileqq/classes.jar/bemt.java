import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

class bemt
{
  private int jdField_a_of_type_Int = 0;
  private View jdField_a_of_type_AndroidViewView;
  
  private void a()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_Int != 0))
    {
      Drawable localDrawable = this.jdField_a_of_type_AndroidViewView.getBackground().mutate();
      if ((localDrawable instanceof GradientDrawable)) {
        ((GradientDrawable)localDrawable).setColor(this.jdField_a_of_type_Int);
      }
    }
    else
    {
      return;
    }
    besl.c("BrandColorManager", "set band border-color fail");
  }
  
  void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bemt
 * JD-Core Version:    0.7.0.1
 */