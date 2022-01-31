import android.database.DataSetObserver;
import com.tencent.widget.ExpandableListConnector;

public class bfro
  extends DataSetObserver
{
  public bfro(ExpandableListConnector paramExpandableListConnector) {}
  
  public void onChanged()
  {
    ExpandableListConnector.a(this.a, true, true);
    this.a.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    ExpandableListConnector.a(this.a, true, true);
    this.a.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfro
 * JD-Core Version:    0.7.0.1
 */