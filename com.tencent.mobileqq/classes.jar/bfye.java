import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

public class bfye
  implements Animator.AnimatorListener
{
  final float jdField_a_of_type_Float;
  private final ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  public boolean a;
  final float jdField_b_of_type_Float;
  final int jdField_b_of_type_Int;
  public final RecyclerView.ViewHolder b;
  public boolean b;
  final float jdField_c_of_type_Float;
  final int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean = false;
  final float d;
  float e;
  float f;
  private float g;
  
  bfye(bfxw parambfxw, RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewHolder;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.jdField_c_of_type_Float = paramFloat3;
    this.d = paramFloat4;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bfyf(this, parambfxw));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setTarget(paramViewHolder.itemView);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this);
    a(0.0F);
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.setIsRecyclable(false);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void a(float paramFloat)
  {
    this.g = paramFloat;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(paramLong);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Float == this.jdField_c_of_type_Float) {}
    for (this.e = this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView.getTranslationX(); this.jdField_b_of_type_Float == this.d; this.e = (this.jdField_a_of_type_Float + this.g * (this.jdField_c_of_type_Float - this.jdField_a_of_type_Float)))
    {
      this.f = this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView.getTranslationY();
      return;
    }
    this.f = (this.jdField_b_of_type_Float + this.g * (this.d - this.jdField_b_of_type_Float));
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    a(1.0F);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.jdField_c_of_type_Boolean) {
      this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.setIsRecyclable(true);
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfye
 * JD-Core Version:    0.7.0.1
 */