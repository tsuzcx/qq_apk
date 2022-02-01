import android.database.DataSetObserver;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;

public class axlv
  extends DataSetObserver
{
  public axlv(MultiAIOBaseViewPager paramMultiAIOBaseViewPager) {}
  
  public void onChanged()
  {
    this.a.b();
  }
  
  public void onInvalidated()
  {
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axlv
 * JD-Core Version:    0.7.0.1
 */