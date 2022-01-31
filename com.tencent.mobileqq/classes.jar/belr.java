import android.database.DataSetObserver;
import com.tencent.mobileqq.widget.GridListView;

public class belr
  extends DataSetObserver
{
  public belr(GridListView paramGridListView) {}
  
  public void onChanged()
  {
    if (this.a.jdField_a_of_type_Belu != null) {
      GridListView.a(this.a, this.a.jdField_a_of_type_Belu.getCount());
    }
    if (this.a.jdField_a_of_type_Belv != null) {
      this.a.jdField_a_of_type_Belv.notifyDataSetChanged();
    }
  }
  
  public void onInvalidated()
  {
    if (this.a.jdField_a_of_type_Belu != null) {
      GridListView.a(this.a, this.a.jdField_a_of_type_Belu.getCount());
    }
    if (this.a.jdField_a_of_type_Belv != null) {
      this.a.jdField_a_of_type_Belv.notifyDataSetInvalidated();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     belr
 * JD-Core Version:    0.7.0.1
 */