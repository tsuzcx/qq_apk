import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class bnof
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bnof(bnoc parambnoc, View paramView1, View paramView2, View paramView3) {}
  
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
      int m = localRect.top;
      if (!bnoc.b(this.jdField_a_of_type_Bnoc))
      {
        this.b.scrollBy(0, i + j - (k - m));
        bnoc.a(this.jdField_a_of_type_Bnoc, this.c, localRect.bottom / 2);
      }
      bnoc.a(this.jdField_a_of_type_Bnoc, true);
      return;
    }
    this.b.scrollTo(0, 0);
    if (bnoc.b(this.jdField_a_of_type_Bnoc)) {
      bnoc.a(this.jdField_a_of_type_Bnoc, this.c, localRect.bottom / 2);
    }
    bnoc.a(this.jdField_a_of_type_Bnoc, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnof
 * JD-Core Version:    0.7.0.1
 */