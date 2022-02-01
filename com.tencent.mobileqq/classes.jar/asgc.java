import android.database.DataSetObserver;
import com.tencent.mobileqq.emosm.view.DragSortListView;

class asgc
  extends DataSetObserver
{
  asgc(asgb paramasgb, DragSortListView paramDragSortListView) {}
  
  public void onChanged()
  {
    this.jdField_a_of_type_Asgb.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.jdField_a_of_type_Asgb.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgc
 * JD-Core Version:    0.7.0.1
 */