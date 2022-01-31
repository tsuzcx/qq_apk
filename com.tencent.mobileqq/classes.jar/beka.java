import android.database.DataSetObserver;
import com.tencent.widget.HorizontalListView;

public class beka
  extends DataSetObserver
{
  public beka(HorizontalListView paramHorizontalListView) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     beka
 * JD-Core Version:    0.7.0.1
 */