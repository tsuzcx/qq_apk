import android.database.DataSetObserver;
import com.tencent.widget.HorizontalListView;

public class bhxp
  extends DataSetObserver
{
  public bhxp(HorizontalListView paramHorizontalListView) {}
  
  public void onChanged()
  {
    this.a.mDataChanged = true;
    HorizontalListView.access$402(this.a, false);
    HorizontalListView.access$100(this.a);
    this.a.invalidate();
    this.a.requestLayout();
  }
  
  public void onInvalidated()
  {
    HorizontalListView.access$402(this.a, false);
    HorizontalListView.access$100(this.a);
    this.a.reset(true);
    this.a.invalidate();
    this.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhxp
 * JD-Core Version:    0.7.0.1
 */