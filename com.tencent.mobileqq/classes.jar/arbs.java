import android.database.DataSetObserver;
import com.tencent.mobileqq.emosm.view.DragSortListView;

class arbs
  extends DataSetObserver
{
  arbs(arbr paramarbr, DragSortListView paramDragSortListView) {}
  
  public void onChanged()
  {
    this.jdField_a_of_type_Arbr.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.jdField_a_of_type_Arbr.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arbs
 * JD-Core Version:    0.7.0.1
 */