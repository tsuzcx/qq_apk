import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import com.tencent.mobileqq.ocr.view.ScanOcrView;

public class avzg
  implements ValueAnimator.AnimatorUpdateListener
{
  public avzg(ScanOcrView paramScanOcrView, avzi paramavzi) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int j = (int)(this.jdField_a_of_type_Avzi.a * f);
    int i = (int)(f * this.jdField_a_of_type_Avzi.jdField_b_of_type_Int);
    int m = j - this.jdField_a_of_type_Avzi.a;
    int k = i - this.jdField_a_of_type_Avzi.jdField_b_of_type_Int;
    j = (int)(paramValueAnimator.getAnimatedFraction() * 255.0F);
    i = j;
    if (j > 255) {
      i = 255;
    }
    j = i;
    if (i < 0) {
      j = 0;
    }
    i = this.jdField_a_of_type_Avzi.jdField_b_of_type_AndroidGraphicsRect.left;
    int n = m / 2;
    int i1 = this.jdField_a_of_type_Avzi.jdField_b_of_type_AndroidGraphicsRect.top;
    int i2 = k / 2;
    int i3 = this.jdField_a_of_type_Avzi.jdField_b_of_type_AndroidGraphicsRect.right;
    m /= 2;
    int i4 = this.jdField_a_of_type_Avzi.jdField_b_of_type_AndroidGraphicsRect.bottom;
    k /= 2;
    this.jdField_a_of_type_Avzi.e = j;
    this.jdField_a_of_type_Avzi.c.set(i - n, i1 - i2, m + i3, k + i4);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avzg
 * JD-Core Version:    0.7.0.1
 */