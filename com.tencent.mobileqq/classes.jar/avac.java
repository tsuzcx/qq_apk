import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.View;
import android.view.animation.Transformation;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.widget.RatioLayout;

public class avac
  implements bbkq<Float>
{
  public avac(ProfileTagView paramProfileTagView, View paramView, PointF paramPointF) {}
  
  public void a(bbkk<Float> parambbkk, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    paramTransformation.getMatrix().setScale(paramFloat1.floatValue(), paramFloat1.floatValue(), this.jdField_a_of_type_AndroidViewView.getWidth() * 0.5F, this.jdField_a_of_type_AndroidViewView.getHeight() * 0.5F);
    paramFloat = this.jdField_a_of_type_AndroidGraphicsPointF.x;
    float f1 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.b.x;
    float f2 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.a.getWidth();
    float f3 = this.jdField_a_of_type_AndroidGraphicsPointF.y;
    float f4 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.b.y;
    float f5 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.a.getHeight();
    paramTransformation.getMatrix().postTranslate((paramFloat - f1) * f2 * paramFloat1.floatValue(), (f3 - f4) * f5 * paramFloat1.floatValue());
    paramTransformation.getMatrix().postRotate(paramFloat1.floatValue() * 120.0F - 120.0F, this.jdField_a_of_type_AndroidViewView.getWidth() * 0.5F, this.jdField_a_of_type_AndroidViewView.getHeight() * 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avac
 * JD-Core Version:    0.7.0.1
 */