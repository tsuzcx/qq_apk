import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class avdg
  extends GridLayoutManager.SpanSizeLookup
{
  avdg(avdf paramavdf) {}
  
  public int getSpanSize(int paramInt)
  {
    if (this.a.getItemViewType(paramInt) == avdb.b) {
      return 5;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avdg
 * JD-Core Version:    0.7.0.1
 */