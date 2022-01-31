import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class bcld
  extends Animation
{
  private int jdField_a_of_type_Int;
  private Camera jdField_a_of_type_AndroidGraphicsCamera;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private View jdField_a_of_type_AndroidViewView;
  private int b;
  
  public bcld(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    paramFloat = 90.0F - 90.0F * paramFloat;
    this.jdField_a_of_type_AndroidGraphicsCamera.save();
    this.jdField_a_of_type_AndroidGraphicsCamera.rotateX(paramFloat);
    this.jdField_a_of_type_AndroidGraphicsCamera.getMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
    this.jdField_a_of_type_AndroidGraphicsCamera.restore();
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F - paramFloat / 90.0F);
      this.jdField_a_of_type_AndroidViewView.invalidate();
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.preTranslate(-this.jdField_a_of_type_Int / 2, 0.0F);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.jdField_a_of_type_Int / 2, 0.0F);
    paramTransformation.getMatrix().postConcat(this.jdField_a_of_type_AndroidGraphicsMatrix);
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_AndroidGraphicsCamera = new Camera();
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcld
 * JD-Core Version:    0.7.0.1
 */