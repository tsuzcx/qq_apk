import android.database.DataSetObserver;
import com.tencent.mobileqq.widget.GridListView;

public class bcmp
  extends DataSetObserver
{
  public bcmp(GridListView paramGridListView) {}
  
  public void onChanged()
  {
    if (this.a.jdField_a_of_type_Bcms != null) {
      GridListView.a(this.a, this.a.jdField_a_of_type_Bcms.getCount());
    }
    if (this.a.jdField_a_of_type_Bcmt != null) {
      this.a.jdField_a_of_type_Bcmt.notifyDataSetChanged();
    }
  }
  
  public void onInvalidated()
  {
    if (this.a.jdField_a_of_type_Bcms != null) {
      GridListView.a(this.a, this.a.jdField_a_of_type_Bcms.getCount());
    }
    if (this.a.jdField_a_of_type_Bcmt != null) {
      this.a.jdField_a_of_type_Bcmt.notifyDataSetInvalidated();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcmp
 * JD-Core Version:    0.7.0.1
 */