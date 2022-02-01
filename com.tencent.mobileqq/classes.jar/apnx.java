import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Point;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout;

public class apnx
  implements ValueAnimator.AnimatorUpdateListener
{
  public apnx(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout1, ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout2, Point paramPoint, LinearLayout.LayoutParams paramLayoutParams, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * (ColorNoteSmallScreenRelativeLayout.b(this.b) / 2));
    int j = ColorNoteSmallScreenRelativeLayout.a(this.b, this.b.e());
    int k = ColorNoteSmallScreenRelativeLayout.c(this.b);
    if (ColorNoteSmallScreenRelativeLayout.a(this.b) != null) {
      ColorNoteSmallScreenRelativeLayout.a(this.b).a(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout, this.jdField_a_of_type_AndroidGraphicsPoint.x - i, this.jdField_a_of_type_AndroidGraphicsPoint.y, j + this.jdField_a_of_type_AndroidGraphicsPoint.x - i, k + this.jdField_a_of_type_AndroidGraphicsPoint.y);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.leftMargin = (this.jdField_a_of_type_Int + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apnx
 * JD-Core Version:    0.7.0.1
 */