import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.widget.ReboundLayout;

public class blfa
  extends Animation
{
  private float jdField_a_of_type_Float;
  private float b = 1.0F;
  
  private blfa(ReboundLayout paramReboundLayout)
  {
    ReboundLayout.a(paramReboundLayout, true);
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramFloat = (this.b - this.jdField_a_of_type_Float) * paramFloat + this.jdField_a_of_type_Float;
    this.jdField_a_of_type_ComTencentWidgetReboundLayout.scrollBy((int)((400 - this.jdField_a_of_type_ComTencentWidgetReboundLayout.getScrollX()) * paramFloat), 0);
    if (paramFloat == 1.0F) {
      ReboundLayout.a(this.jdField_a_of_type_ComTencentWidgetReboundLayout, false);
    }
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    setDuration(260L);
    setInterpolator(new AccelerateInterpolator());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blfa
 * JD-Core Version:    0.7.0.1
 */