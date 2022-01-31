import android.database.DataSetObserver;
import com.tencent.widget.ExpandableListConnector;

public class bhsk
  extends DataSetObserver
{
  public bhsk(ExpandableListConnector paramExpandableListConnector) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhsk
 * JD-Core Version:    0.7.0.1
 */