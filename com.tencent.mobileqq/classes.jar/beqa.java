import android.database.DataSetObserver;
import com.tencent.mobileqq.widget.GridListView;

public class beqa
  extends DataSetObserver
{
  public beqa(GridListView paramGridListView) {}
  
  public void onChanged()
  {
    if (this.a.jdField_a_of_type_Beqd != null) {
      GridListView.a(this.a, this.a.jdField_a_of_type_Beqd.getCount());
    }
    if (this.a.jdField_a_of_type_Beqe != null) {
      this.a.jdField_a_of_type_Beqe.notifyDataSetChanged();
    }
  }
  
  public void onInvalidated()
  {
    if (this.a.jdField_a_of_type_Beqd != null) {
      GridListView.a(this.a, this.a.jdField_a_of_type_Beqd.getCount());
    }
    if (this.a.jdField_a_of_type_Beqe != null) {
      this.a.jdField_a_of_type_Beqe.notifyDataSetInvalidated();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beqa
 * JD-Core Version:    0.7.0.1
 */