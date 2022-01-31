import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class biud
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  biud(biua parambiua, View paramView1, View paramView2, View paramView3) {}
  
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
      if (!biua.b(this.jdField_a_of_type_Biua))
      {
        this.b.scrollBy(0, i + j - k);
        biua.a(this.jdField_a_of_type_Biua, this.c, localRect.bottom / 2);
      }
      biua.a(this.jdField_a_of_type_Biua, true);
      return;
    }
    this.b.scrollTo(0, 0);
    if (biua.b(this.jdField_a_of_type_Biua)) {
      biua.a(this.jdField_a_of_type_Biua, this.c, localRect.bottom / 2);
    }
    biua.a(this.jdField_a_of_type_Biua, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biud
 * JD-Core Version:    0.7.0.1
 */