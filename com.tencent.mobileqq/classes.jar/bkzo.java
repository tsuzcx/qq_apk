import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class bkzo
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bkzo(bkzl parambkzl, View paramView1, View paramView2, View paramView3) {}
  
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
      int k = localRect.bottom;
      if (!bkzl.b(this.jdField_a_of_type_Bkzl))
      {
        this.b.scrollBy(0, i + j - k);
        bkzl.a(this.jdField_a_of_type_Bkzl, this.c, localRect.bottom / 2);
      }
      bkzl.a(this.jdField_a_of_type_Bkzl, true);
      return;
    }
    this.b.scrollTo(0, 0);
    if (bkzl.b(this.jdField_a_of_type_Bkzl)) {
      bkzl.a(this.jdField_a_of_type_Bkzl, this.c, localRect.bottom / 2);
    }
    bkzl.a(this.jdField_a_of_type_Bkzl, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzo
 * JD-Core Version:    0.7.0.1
 */