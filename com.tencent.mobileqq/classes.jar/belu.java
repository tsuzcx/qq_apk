import android.database.DataSetObserver;

class belu
  extends DataSetObserver
{
  belu(belt parambelt) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.a.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     belu
 * JD-Core Version:    0.7.0.1
 */