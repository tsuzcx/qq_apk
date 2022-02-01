import android.database.DataSetObserver;

class bkmu
  extends DataSetObserver
{
  bkmu(bkmt parambkmt) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.a.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkmu
 * JD-Core Version:    0.7.0.1
 */