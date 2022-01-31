import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper;

public class amet
  implements Runnable
{
  public amet(ItemTouchHelper paramItemTouchHelper) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder != null) && (this.a.b()))
    {
      if (this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder != null) {
        this.a.a(this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
      }
      this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
      ViewCompat.postOnAnimation(this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amet
 * JD-Core Version:    0.7.0.1
 */