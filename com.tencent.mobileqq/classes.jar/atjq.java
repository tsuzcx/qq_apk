import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.listentogether.lyrics.FloatIconLayout;
import com.tencent.mobileqq.listentogether.lyrics.FloatTextLayout;

class atjq
  implements ValueAnimator.AnimatorUpdateListener
{
  atjq(atjn paramatjn, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (!this.jdField_a_of_type_Atjn.b)
    {
      paramValueAnimator.cancel();
      this.jdField_a_of_type_Atjn.jdField_a_of_type_AndroidAnimationValueAnimator = null;
      return;
    }
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = (int)(this.jdField_a_of_type_Int + (this.b - this.jdField_a_of_type_Int) * f1 + 0.5F);
    int j = (int)(this.c + (this.d - this.c) * f1 + 0.5F);
    int k = (int)(this.e + (this.f - this.e) * f1 + 0.5F);
    float f2 = this.g;
    int m = (int)(f1 * (this.h - this.g) + f2 + 0.5F);
    this.jdField_a_of_type_Atjn.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(i, j);
    this.jdField_a_of_type_Atjn.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(k, m);
    this.jdField_a_of_type_Atjn.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a();
    this.jdField_a_of_type_Atjn.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atjq
 * JD-Core Version:    0.7.0.1
 */