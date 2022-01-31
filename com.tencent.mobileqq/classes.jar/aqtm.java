import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mobileqq.gamecenter.view.ScrollTextView;

public class aqtm
  extends Animation
{
  private float jdField_a_of_type_Float;
  private Camera jdField_a_of_type_AndroidGraphicsCamera;
  private final boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private final boolean jdField_b_of_type_Boolean;
  
  public aqtm(ScrollTextView paramScrollTextView, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.jdField_a_of_type_Float;
    float f2 = this.jdField_b_of_type_Float;
    Camera localCamera = this.jdField_a_of_type_AndroidGraphicsCamera;
    int i;
    if (this.jdField_b_of_type_Boolean)
    {
      i = 1;
      paramTransformation = paramTransformation.getMatrix();
      localCamera.save();
      if (!this.jdField_a_of_type_Boolean) {
        break label99;
      }
      localCamera.translate(0.0F, i * this.jdField_b_of_type_Float * (paramFloat - 1.0F), 0.0F);
    }
    for (;;)
    {
      localCamera.getMatrix(paramTransformation);
      localCamera.restore();
      paramTransformation.preTranslate(-f1, -f2);
      paramTransformation.postTranslate(f1, f2);
      return;
      i = -1;
      break;
      label99:
      localCamera.translate(0.0F, i * this.jdField_b_of_type_Float * paramFloat, 0.0F);
    }
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_AndroidGraphicsCamera = new Camera();
    this.jdField_b_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewScrollTextView.getHeight();
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewScrollTextView.getWidth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqtm
 * JD-Core Version:    0.7.0.1
 */