import android.database.DataSetObserver;
import com.tencent.mobileqq.widget.GridListView;

public class bhei
  extends DataSetObserver
{
  public bhei(GridListView paramGridListView) {}
  
  public void onChanged()
  {
    if (this.a.jdField_a_of_type_Bhel != null) {
      GridListView.a(this.a, this.a.jdField_a_of_type_Bhel.getCount());
    }
    if (this.a.jdField_a_of_type_Bhem != null) {
      this.a.jdField_a_of_type_Bhem.notifyDataSetChanged();
    }
  }
  
  public void onInvalidated()
  {
    if (this.a.jdField_a_of_type_Bhel != null) {
      GridListView.a(this.a, this.a.jdField_a_of_type_Bhel.getCount());
    }
    if (this.a.jdField_a_of_type_Bhem != null) {
      this.a.jdField_a_of_type_Bhem.notifyDataSetInvalidated();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhei
 * JD-Core Version:    0.7.0.1
 */