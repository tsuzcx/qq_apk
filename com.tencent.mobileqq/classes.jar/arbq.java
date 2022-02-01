import android.database.DataSetObserver;
import com.tencent.mobileqq.emosm.view.DragSortListView;

public class arbq
  extends DataSetObserver
{
  public arbq(DragSortListView paramDragSortListView) {}
  
  private void a()
  {
    if (this.a.g == 4) {
      this.a.a();
    }
  }
  
  public void onChanged()
  {
    a();
  }
  
  public void onInvalidated()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arbq
 * JD-Core Version:    0.7.0.1
 */