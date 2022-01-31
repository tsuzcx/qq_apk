import android.database.DataSetObserver;
import com.tencent.mobileqq.emosm.view.DragSortListView;

class appf
  extends DataSetObserver
{
  appf(appe paramappe, DragSortListView paramDragSortListView) {}
  
  public void onChanged()
  {
    this.jdField_a_of_type_Appe.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.jdField_a_of_type_Appe.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appf
 * JD-Core Version:    0.7.0.1
 */