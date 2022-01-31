import android.database.DataSetObserver;
import com.tencent.mobileqq.emosm.view.DragSortListView;

class apkw
  extends DataSetObserver
{
  apkw(apkv paramapkv, DragSortListView paramDragSortListView) {}
  
  public void onChanged()
  {
    this.jdField_a_of_type_Apkv.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.jdField_a_of_type_Apkv.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apkw
 * JD-Core Version:    0.7.0.1
 */