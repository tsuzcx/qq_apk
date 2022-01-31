import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout.LayoutParams;

public class azrq
  extends Animation
{
  int jdField_a_of_type_Int;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  
  public azrq(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidViewViewGroup.getHeight();
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    paramTransformation.height = ((int)(this.jdField_a_of_type_Int * (1.0F - paramFloat)));
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramTransformation);
    if (paramFloat == 1.0F)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      paramTransformation.height = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramTransformation);
    }
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azrq
 * JD-Core Version:    0.7.0.1
 */