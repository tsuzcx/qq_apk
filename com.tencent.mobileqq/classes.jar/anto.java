import android.database.DataSetObserver;
import com.tencent.mobileqq.emosm.view.DragSortListView;

class anto
  extends DataSetObserver
{
  anto(antn paramantn, DragSortListView paramDragSortListView) {}
  
  public void onChanged()
  {
    this.jdField_a_of_type_Antn.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.jdField_a_of_type_Antn.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anto
 * JD-Core Version:    0.7.0.1
 */