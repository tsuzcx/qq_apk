import android.database.DataSetObserver;

class bfto
  extends DataSetObserver
{
  bfto(bftn parambftn) {}
  
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
 * Qualified Name:     bfto
 * JD-Core Version:    0.7.0.1
 */