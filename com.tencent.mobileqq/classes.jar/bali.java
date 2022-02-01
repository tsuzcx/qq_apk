import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import com.tencent.qphone.base.util.QLog;

public class bali
  extends Animation
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
  private balk jdField_a_of_type_Balk;
  private int b;
  
  public bali(View paramView, int paramInt1, int paramInt2, balk parambalk)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Balk = parambalk;
  }
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    if ((this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener != null) && ((this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener instanceof balj))) {
      ((balj)this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener).a(this, paramFloat);
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    int i = this.b;
    if (paramFloat < 1.0F)
    {
      i = Color.argb((int)(Color.alpha(this.jdField_a_of_type_Int) + (Color.alpha(this.b) - Color.alpha(this.jdField_a_of_type_Int)) * paramFloat), (int)(Color.red(this.jdField_a_of_type_Int) + (Color.red(this.b) - Color.red(this.jdField_a_of_type_Int)) * paramFloat), (int)(Color.green(this.jdField_a_of_type_Int) + (Color.green(this.b) - Color.green(this.jdField_a_of_type_Int)) * paramFloat), (int)(Color.blue(this.jdField_a_of_type_Int) + (Color.blue(this.b) - Color.blue(this.jdField_a_of_type_Int)) * paramFloat));
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(i);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Balk != null) {
        this.jdField_a_of_type_Balk.jdField_a_of_type_Int = i;
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("LsRecord", 4, "LS applyTransformation: " + paramFloat + " CLR: " + i);
      return;
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(i);
      this.jdField_a_of_type_AndroidViewView = null;
    }
  }
  
  public void setAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    super.setAnimationListener(paramAnimationListener);
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = paramAnimationListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bali
 * JD-Core Version:    0.7.0.1
 */