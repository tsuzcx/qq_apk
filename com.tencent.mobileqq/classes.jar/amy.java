import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.qq.im.poi.LbsPackListAdapter;
import com.tencent.mobileqq.businessCard.helpers.ViewHelper;

public class amy
  extends Animation
{
  public amy(LbsPackListAdapter paramLbsPackListAdapter, int paramInt1, int paramInt2, View paramView) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.jdField_a_of_type_Int;
    float f2 = this.b;
    ViewHelper.f(this.jdField_a_of_type_AndroidViewView, f1 * f2 * paramFloat);
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     amy
 * JD-Core Version:    0.7.0.1
 */