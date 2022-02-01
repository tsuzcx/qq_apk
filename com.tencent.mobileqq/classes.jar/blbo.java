import android.database.DataSetObserver;
import com.tencent.widget.ExpandableListConnector;

public class blbo
  extends DataSetObserver
{
  public blbo(ExpandableListConnector paramExpandableListConnector) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbo
 * JD-Core Version:    0.7.0.1
 */