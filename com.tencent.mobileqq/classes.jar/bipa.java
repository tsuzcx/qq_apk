import android.database.DataSetObserver;
import com.tencent.mobileqq.widget.GridListView;

public class bipa
  extends DataSetObserver
{
  public bipa(GridListView paramGridListView) {}
  
  public void onChanged()
  {
    if (this.a.jdField_a_of_type_Bipd != null) {
      GridListView.a(this.a, this.a.jdField_a_of_type_Bipd.getCount());
    }
    if (this.a.jdField_a_of_type_Bipe != null) {
      this.a.jdField_a_of_type_Bipe.notifyDataSetChanged();
    }
  }
  
  public void onInvalidated()
  {
    if (this.a.jdField_a_of_type_Bipd != null) {
      GridListView.a(this.a, this.a.jdField_a_of_type_Bipd.getCount());
    }
    if (this.a.jdField_a_of_type_Bipe != null) {
      this.a.jdField_a_of_type_Bipe.notifyDataSetInvalidated();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bipa
 * JD-Core Version:    0.7.0.1
 */