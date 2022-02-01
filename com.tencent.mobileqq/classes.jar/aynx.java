import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class aynx
  extends Animation
{
  aynx(aynq paramaynq, View paramView, int paramInt) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    if (paramFloat == 1.0F) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    do
    {
      return;
      paramTransformation = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    } while (paramTransformation == null);
    paramTransformation.height = (this.jdField_a_of_type_Int - (int)(this.jdField_a_of_type_Int * paramFloat));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramTransformation);
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aynx
 * JD-Core Version:    0.7.0.1
 */