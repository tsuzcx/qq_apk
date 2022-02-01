import android.database.DataSetObserver;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;

public class awtc
  extends DataSetObserver
{
  public awtc(MultiAIOBaseViewPager paramMultiAIOBaseViewPager) {}
  
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
 * Qualified Name:     awtc
 * JD-Core Version:    0.7.0.1
 */