import android.database.DataSetObserver;
import android.widget.BaseAdapter;

public abstract class blgi
  extends BaseAdapter
  implements blgq
{
  private final blgk a = new blgk(this);
  
  public void c(int paramInt1, int paramInt2)
  {
    this.a.a(paramInt1, paramInt2);
  }
  
  public void notifyDataSetChanged()
  {
    this.a.notifyChanged();
  }
  
  public void notifyDataSetInvalidated()
  {
    this.a.notifyInvalidated();
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.a.registerObserver(paramDataSetObserver);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.a.unregisterObserver(paramDataSetObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blgi
 * JD-Core Version:    0.7.0.1
 */