import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import com.tencent.qphone.base.util.QLog;

public class auby
  extends ScaleAnimation
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private GradientDrawable jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
  private aucb jdField_a_of_type_Aucb;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  
  public auby(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, float paramFloat5, int paramInt2, float paramFloat6, aucb paramaucb)
  {
    super(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt1, paramFloat5, paramInt2, paramFloat6);
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = (paramFloat2 - paramFloat1);
    this.jdField_a_of_type_Aucb = paramaucb;
  }
  
  public void a(GradientDrawable paramGradientDrawable, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = paramGradientDrawable;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS setColorChanger: " + paramInt1 + " --> " + paramInt2);
    }
  }
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    if ((this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener != null) && ((this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener instanceof auca))) {
      ((auca)this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener).a(this, paramFloat);
    }
    this.jdField_a_of_type_Aucb.jdField_a_of_type_Float = (this.jdField_a_of_type_Float + this.jdField_b_of_type_Float * paramFloat);
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS applyTransformation: " + paramFloat + " F: " + this.jdField_a_of_type_Aucb.jdField_a_of_type_Float);
    }
    int i;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable != null)
    {
      i = this.jdField_b_of_type_Int;
      if (paramFloat >= 1.0F) {
        break label296;
      }
      i = Color.argb((int)(Color.alpha(this.jdField_a_of_type_Int) + (Color.alpha(this.jdField_b_of_type_Int) - Color.alpha(this.jdField_a_of_type_Int)) * paramFloat), (int)(Color.red(this.jdField_a_of_type_Int) + (Color.red(this.jdField_b_of_type_Int) - Color.red(this.jdField_a_of_type_Int)) * paramFloat), (int)(Color.green(this.jdField_a_of_type_Int) + (Color.green(this.jdField_b_of_type_Int) - Color.green(this.jdField_a_of_type_Int)) * paramFloat), (int)(Color.blue(this.jdField_a_of_type_Int) + (Color.blue(this.jdField_b_of_type_Int) - Color.blue(this.jdField_a_of_type_Int)) * paramFloat));
      this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(i);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aucb.jdField_a_of_type_Int = i;
      if (QLog.isDevelopLevel()) {
        QLog.d("LsRecord", 4, "LS applyTransformation: " + paramFloat + " CLR: " + this.jdField_a_of_type_Aucb.jdField_a_of_type_Int);
      }
      return;
      label296:
      this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(i);
      this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = null;
    }
  }
  
  public void setAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    super.setAnimationListener(paramAnimationListener);
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = paramAnimationListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auby
 * JD-Core Version:    0.7.0.1
 */