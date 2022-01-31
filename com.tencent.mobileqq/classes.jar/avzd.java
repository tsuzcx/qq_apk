import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import com.tencent.mobileqq.ocr.view.ScanOcrView;

public class avzd
  implements ValueAnimator.AnimatorUpdateListener
{
  public avzd(ScanOcrView paramScanOcrView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int j = (int)(this.a.a.a * f);
    int i = (int)(f * this.a.a.jdField_b_of_type_Int);
    int m = j - this.a.a.a;
    int k = i - this.a.a.jdField_b_of_type_Int;
    j = (int)(paramValueAnimator.getAnimatedFraction() * 255.0F);
    i = j;
    if (j > 255) {
      i = 255;
    }
    j = i;
    if (i < 0) {
      j = 0;
    }
    i = this.a.a.jdField_b_of_type_AndroidGraphicsRect.left;
    int n = m / 2;
    int i1 = this.a.a.jdField_b_of_type_AndroidGraphicsRect.top;
    int i2 = k / 2;
    int i3 = this.a.a.jdField_b_of_type_AndroidGraphicsRect.right;
    m /= 2;
    int i4 = this.a.a.jdField_b_of_type_AndroidGraphicsRect.bottom;
    k /= 2;
    this.a.a.e = j;
    this.a.a.c.set(i - n, i1 - i2, m + i3, k + i4);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avzd
 * JD-Core Version:    0.7.0.1
 */