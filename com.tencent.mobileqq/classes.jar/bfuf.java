import android.database.DataSetObserver;

class bfuf
  extends DataSetObserver
{
  bfuf(bfue parambfue) {}
  
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
 * Qualified Name:     bfuf
 * JD-Core Version:    0.7.0.1
 */