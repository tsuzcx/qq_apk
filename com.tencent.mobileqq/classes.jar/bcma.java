import android.database.DataSetObserver;
import com.tencent.mobileqq.widget.GridListView;

public class bcma
  extends DataSetObserver
{
  public bcma(GridListView paramGridListView) {}
  
  public void onChanged()
  {
    if (this.a.jdField_a_of_type_Bcmd != null) {
      GridListView.a(this.a, this.a.jdField_a_of_type_Bcmd.getCount());
    }
    if (this.a.jdField_a_of_type_Bcme != null) {
      this.a.jdField_a_of_type_Bcme.notifyDataSetChanged();
    }
  }
  
  public void onInvalidated()
  {
    if (this.a.jdField_a_of_type_Bcmd != null) {
      GridListView.a(this.a, this.a.jdField_a_of_type_Bcmd.getCount());
    }
    if (this.a.jdField_a_of_type_Bcme != null) {
      this.a.jdField_a_of_type_Bcme.notifyDataSetInvalidated();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcma
 * JD-Core Version:    0.7.0.1
 */