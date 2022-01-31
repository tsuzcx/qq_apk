import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class biuu
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  biuu(biur parambiur, View paramView1, View paramView2, View paramView3) {}
  
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
      if (!biur.b(this.jdField_a_of_type_Biur))
      {
        this.b.scrollBy(0, i + j - k);
        biur.a(this.jdField_a_of_type_Biur, this.c, localRect.bottom / 2);
      }
      biur.a(this.jdField_a_of_type_Biur, true);
      return;
    }
    this.b.scrollTo(0, 0);
    if (biur.b(this.jdField_a_of_type_Biur)) {
      biur.a(this.jdField_a_of_type_Biur, this.c, localRect.bottom / 2);
    }
    biur.a(this.jdField_a_of_type_Biur, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biuu
 * JD-Core Version:    0.7.0.1
 */