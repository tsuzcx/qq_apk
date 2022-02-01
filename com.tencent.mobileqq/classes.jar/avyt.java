import android.graphics.Rect;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;

public class avyt
  implements OnApplyWindowInsetsListener
{
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  
  public avyt(MultiAIOBaseViewPager paramMultiAIOBaseViewPager) {}
  
  public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    paramView = ViewCompat.onApplyWindowInsets(paramView, paramWindowInsetsCompat);
    if (paramView.isConsumed()) {
      return paramView;
    }
    paramWindowInsetsCompat = this.jdField_a_of_type_AndroidGraphicsRect;
    paramWindowInsetsCompat.left = paramView.getSystemWindowInsetLeft();
    paramWindowInsetsCompat.top = paramView.getSystemWindowInsetTop();
    paramWindowInsetsCompat.right = paramView.getSystemWindowInsetRight();
    paramWindowInsetsCompat.bottom = paramView.getSystemWindowInsetBottom();
    int i = 0;
    int j = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.getChildCount();
    while (i < j)
    {
      WindowInsetsCompat localWindowInsetsCompat = ViewCompat.dispatchApplyWindowInsets(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.getChildAt(i), paramView);
      paramWindowInsetsCompat.left = Math.min(localWindowInsetsCompat.getSystemWindowInsetLeft(), paramWindowInsetsCompat.left);
      paramWindowInsetsCompat.top = Math.min(localWindowInsetsCompat.getSystemWindowInsetTop(), paramWindowInsetsCompat.top);
      paramWindowInsetsCompat.right = Math.min(localWindowInsetsCompat.getSystemWindowInsetRight(), paramWindowInsetsCompat.right);
      paramWindowInsetsCompat.bottom = Math.min(localWindowInsetsCompat.getSystemWindowInsetBottom(), paramWindowInsetsCompat.bottom);
      i += 1;
    }
    return paramView.replaceSystemWindowInsets(paramWindowInsetsCompat.left, paramWindowInsetsCompat.top, paramWindowInsetsCompat.right, paramWindowInsetsCompat.bottom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avyt
 * JD-Core Version:    0.7.0.1
 */