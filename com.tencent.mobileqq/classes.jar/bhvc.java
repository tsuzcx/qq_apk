import android.database.DataSetObserver;

class bhvc
  extends DataSetObserver
{
  bhvc(bhvb parambhvb) {}
  
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
 * Qualified Name:     bhvc
 * JD-Core Version:    0.7.0.1
 */