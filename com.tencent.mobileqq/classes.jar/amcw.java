import android.database.DataSetObserver;
import com.tencent.widget.PagerBaseAdapterWrapper;

public class amcw
  extends DataSetObserver
{
  public amcw(PagerBaseAdapterWrapper paramPagerBaseAdapterWrapper) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.a.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amcw
 * JD-Core Version:    0.7.0.1
 */