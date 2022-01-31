import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.qq.im.poi.LbsPackListAdapter;
import com.tencent.mobileqq.businessCard.helpers.ViewHelper;

public class and
  extends Animation
{
  public and(LbsPackListAdapter paramLbsPackListAdapter, View paramView, int paramInt) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (paramFloat == 1.0F)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    float f = this.jdField_a_of_type_Int;
    ViewHelper.g(this.jdField_a_of_type_AndroidViewView, -1.0F * f * paramFloat);
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     and
 * JD-Core Version:    0.7.0.1
 */