import android.database.DataSetObserver;
import com.tencent.mobileqq.emosm.view.DragSortListView;

class arsg
  extends DataSetObserver
{
  arsg(arsf paramarsf, DragSortListView paramDragSortListView) {}
  
  public void onChanged()
  {
    this.jdField_a_of_type_Arsf.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.jdField_a_of_type_Arsf.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arsg
 * JD-Core Version:    0.7.0.1
 */