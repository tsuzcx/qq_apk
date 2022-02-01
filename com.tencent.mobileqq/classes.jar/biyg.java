import android.database.DataSetObserver;
import com.tencent.mobileqq.widget.GridListView;

public class biyg
  extends DataSetObserver
{
  public biyg(GridListView paramGridListView) {}
  
  public void onChanged()
  {
    if (this.a.jdField_a_of_type_Biyj != null) {
      GridListView.a(this.a, this.a.jdField_a_of_type_Biyj.getCount());
    }
    if (this.a.jdField_a_of_type_Biyk != null) {
      this.a.jdField_a_of_type_Biyk.notifyDataSetChanged();
    }
  }
  
  public void onInvalidated()
  {
    if (this.a.jdField_a_of_type_Biyj != null) {
      GridListView.a(this.a, this.a.jdField_a_of_type_Biyj.getCount());
    }
    if (this.a.jdField_a_of_type_Biyk != null) {
      this.a.jdField_a_of_type_Biyk.notifyDataSetInvalidated();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biyg
 * JD-Core Version:    0.7.0.1
 */