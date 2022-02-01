import android.database.DataSetObserver;
import com.tencent.mobileqq.emosm.view.DragSortListView;

class ashu
  extends DataSetObserver
{
  ashu(asht paramasht, DragSortListView paramDragSortListView) {}
  
  public void onChanged()
  {
    this.jdField_a_of_type_Asht.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.jdField_a_of_type_Asht.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ashu
 * JD-Core Version:    0.7.0.1
 */