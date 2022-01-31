import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class bhub
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bhub(bhty parambhty, View paramView1, View paramView2) {}
  
  public void onGlobalLayout()
  {
    Log.d("AEGIFTextEditFragment", "onGlobalLayout");
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame(localRect);
    if (this.jdField_a_of_type_AndroidViewView.getRootView().getHeight() - localRect.bottom > 150)
    {
      int[] arrayOfInt = new int[2];
      this.b.getLocationInWindow(arrayOfInt);
      int i = arrayOfInt[1];
      int j = this.b.getHeight();
      int k = this.b.getPaddingBottom();
      int m = localRect.bottom;
      if (!bhty.b(this.jdField_a_of_type_Bhty)) {
        this.b.scrollBy(0, i + j + k - m);
      }
      bhty.a(this.jdField_a_of_type_Bhty, true);
      return;
    }
    this.b.scrollTo(0, 0);
    bhty.a(this.jdField_a_of_type_Bhty, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhub
 * JD-Core Version:    0.7.0.1
 */