import android.database.DataSetObserver;

class bhzj
  extends DataSetObserver
{
  bhzj(bhzi parambhzi) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.a.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhzj
 * JD-Core Version:    0.7.0.1
 */