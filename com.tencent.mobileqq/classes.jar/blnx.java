import android.database.DataSetObserver;

class blnx
  extends DataSetObserver
{
  blnx(blnw paramblnw) {}
  
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
 * Qualified Name:     blnx
 * JD-Core Version:    0.7.0.1
 */