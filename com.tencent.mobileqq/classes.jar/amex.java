import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ChildDrawingOrderCallback;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper;

public class amex
  implements RecyclerView.ChildDrawingOrderCallback
{
  public amex(ItemTouchHelper paramItemTouchHelper) {}
  
  public int onGetChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_AndroidViewView == null) {}
    int i;
    do
    {
      return paramInt2;
      int j = this.a.d;
      i = j;
      if (j == -1)
      {
        i = this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.indexOfChild(this.a.jdField_a_of_type_AndroidViewView);
        this.a.d = i;
      }
      if (paramInt2 == paramInt1 - 1) {
        return i;
      }
    } while (paramInt2 < i);
    return paramInt2 + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amex
 * JD-Core Version:    0.7.0.1
 */