import android.database.DataSetObserver;
import com.tencent.widget.HorizontalListView;

public class amjn
  extends DataSetObserver
{
  public amjn(HorizontalListView paramHorizontalListView) {}
  
  public void onChanged()
  {
    this.a.b = true;
    HorizontalListView.a(this.a, false);
    HorizontalListView.a(this.a);
    this.a.invalidate();
    this.a.requestLayout();
  }
  
  public void onInvalidated()
  {
    HorizontalListView.a(this.a, false);
    HorizontalListView.a(this.a);
    this.a.a(true);
    this.a.invalidate();
    this.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amjn
 * JD-Core Version:    0.7.0.1
 */