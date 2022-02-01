import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;

class aufv
  extends Animation
{
  public float a;
  public int a;
  public PathMeasure a;
  public View a;
  public Interpolator a;
  public aufu a;
  public aufw a;
  public float b;
  
  @TargetApi(11)
  public aufv(Path paramPath, float paramFloat, View paramView1, View paramView2, aufu paramaufu)
  {
    this.jdField_a_of_type_AndroidGraphicsPathMeasure = new PathMeasure(paramPath, false);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidGraphicsPathMeasure.getLength();
    this.jdField_a_of_type_AndroidViewView = paramView2;
    this.jdField_b_of_type_Float = paramFloat;
    this.jdField_a_of_type_Aufu = paramaufu;
    paramView1.setLayerType(2, null);
  }
  
  private static float a(int paramInt, float paramFloat)
  {
    switch (paramInt)
    {
    default: 
      return (float)Math.pow(paramFloat, 2.0D);
    case 1: 
      if (paramFloat < 0.8D) {
        return 0.0F;
      }
      return 5.0F * paramFloat - 4.0F;
    }
    return 0.5F * paramFloat + 0.5F;
  }
  
  @TargetApi(11)
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    Object localObject = paramTransformation.getMatrix();
    this.jdField_a_of_type_AndroidGraphicsPathMeasure.getMatrix(this.jdField_a_of_type_Float * paramFloat, (Matrix)localObject, 1);
    float f;
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject = this.jdField_a_of_type_AndroidViewView;
      f = this.jdField_b_of_type_Float;
      aufu localaufu = this.jdField_a_of_type_Aufu;
      ((View)localObject).setRotation(f * paramFloat * aufu.jdField_b_of_type_Float);
    }
    if (this.jdField_a_of_type_Aufu.jdField_b_of_type_Boolean)
    {
      f = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(paramFloat);
      this.jdField_a_of_type_AndroidViewView.setScaleX(this.jdField_a_of_type_Aufu.c * f);
      this.jdField_a_of_type_AndroidViewView.setScaleY(f * this.jdField_a_of_type_Aufu.c);
    }
    paramTransformation.setAlpha(1.0F - a(this.jdField_a_of_type_Int, paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aufv
 * JD-Core Version:    0.7.0.1
 */