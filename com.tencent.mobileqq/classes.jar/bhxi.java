import android.database.DataSetObserver;
import com.tencent.mobileqq.widget.GridListView;

public class bhxi
  extends DataSetObserver
{
  public bhxi(GridListView paramGridListView) {}
  
  public void onChanged()
  {
    if (this.a.jdField_a_of_type_Bhxl != null) {
      GridListView.a(this.a, this.a.jdField_a_of_type_Bhxl.getCount());
    }
    if (this.a.jdField_a_of_type_Bhxm != null) {
      this.a.jdField_a_of_type_Bhxm.notifyDataSetChanged();
    }
  }
  
  public void onInvalidated()
  {
    if (this.a.jdField_a_of_type_Bhxl != null) {
      GridListView.a(this.a, this.a.jdField_a_of_type_Bhxl.getCount());
    }
    if (this.a.jdField_a_of_type_Bhxm != null) {
      this.a.jdField_a_of_type_Bhxm.notifyDataSetInvalidated();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhxi
 * JD-Core Version:    0.7.0.1
 */