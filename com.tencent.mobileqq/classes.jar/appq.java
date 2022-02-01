import android.app.Activity;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;

public class appq
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup.MarginLayoutParams jdField_a_of_type_AndroidViewViewGroup$MarginLayoutParams;
  private ArkAppView jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
  private int b;
  private int c;
  
  private appq(Activity paramActivity, ArkAppView paramArkAppView)
  {
    FrameLayout localFrameLayout = (FrameLayout)paramActivity.findViewById(16908290);
    if (localFrameLayout == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView = localFrameLayout.getChildAt(0);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new appr(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = paramArkAppView;
    this.jdField_a_of_type_AndroidViewViewGroup$MarginLayoutParams = ((ViewGroup.MarginLayoutParams)paramArkAppView.getLayoutParams());
    paramArkAppView = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(paramArkAppView);
    this.c = paramArkAppView.heightPixels;
    this.b = this.jdField_a_of_type_AndroidViewViewGroup$MarginLayoutParams.topMargin;
  }
  
  private int a()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame(localRect);
    return localRect.bottom - localRect.top;
  }
  
  private void a()
  {
    int i = a();
    if (i != this.jdField_a_of_type_Int)
    {
      int k = this.jdField_a_of_type_AndroidViewView.getRootView().getHeight();
      int j = k - i;
      if (j <= k / 4) {
        break label104;
      }
      Rect localRect = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getInputRect();
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getLocationOnScreen(arrayOfInt);
      k = localRect.bottom + arrayOfInt[1];
      j = this.c - j;
      if (j < k)
      {
        this.jdField_a_of_type_AndroidViewViewGroup$MarginLayoutParams.topMargin = (j - k);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.requestLayout();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = i;
      return;
      label104:
      this.jdField_a_of_type_AndroidViewViewGroup$MarginLayoutParams.topMargin = this.b;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.requestLayout();
    }
  }
  
  public static void a(Activity paramActivity, ArkAppView paramArkAppView)
  {
    new appq(paramActivity, paramArkAppView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appq
 * JD-Core Version:    0.7.0.1
 */