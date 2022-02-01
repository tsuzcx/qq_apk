import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class blyv
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  blyv(blys paramblys, View paramView1, View paramView2, View paramView3) {}
  
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
      if (!blys.b(this.jdField_a_of_type_Blys))
      {
        this.b.scrollBy(0, i + j - (k - m));
        blys.a(this.jdField_a_of_type_Blys, this.c, localRect.bottom / 2);
      }
      blys.a(this.jdField_a_of_type_Blys, true);
      return;
    }
    this.b.scrollTo(0, 0);
    if (blys.b(this.jdField_a_of_type_Blys)) {
      blys.a(this.jdField_a_of_type_Blys, this.c, localRect.bottom / 2);
    }
    blys.a(this.jdField_a_of_type_Blys, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blyv
 * JD-Core Version:    0.7.0.1
 */