import android.database.DataSetObserver;
import com.tencent.mobileqq.emosm.view.DragSortListView;

class andb
  extends DataSetObserver
{
  andb(anda paramanda, DragSortListView paramDragSortListView) {}
  
  public void onChanged()
  {
    this.jdField_a_of_type_Anda.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.jdField_a_of_type_Anda.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     andb
 * JD-Core Version:    0.7.0.1
 */