import android.database.DataSetObserver;
import com.tencent.mobileqq.widget.GridListView;

public class bbjd
  extends DataSetObserver
{
  public bbjd(GridListView paramGridListView) {}
  
  public void onChanged()
  {
    if (this.a.jdField_a_of_type_Bbjg != null) {
      GridListView.a(this.a, this.a.jdField_a_of_type_Bbjg.getCount());
    }
    if (this.a.jdField_a_of_type_Bbjh != null) {
      this.a.jdField_a_of_type_Bbjh.notifyDataSetChanged();
    }
  }
  
  public void onInvalidated()
  {
    if (this.a.jdField_a_of_type_Bbjg != null) {
      GridListView.a(this.a, this.a.jdField_a_of_type_Bbjg.getCount());
    }
    if (this.a.jdField_a_of_type_Bbjh != null) {
      this.a.jdField_a_of_type_Bbjh.notifyDataSetInvalidated();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbjd
 * JD-Core Version:    0.7.0.1
 */