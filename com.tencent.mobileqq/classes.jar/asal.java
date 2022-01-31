import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class asal
  extends GridLayoutManager.SpanSizeLookup
{
  asal(asak paramasak) {}
  
  public int getSpanSize(int paramInt)
  {
    if (this.a.getItemViewType(paramInt) == asag.b) {
      return 5;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asal
 * JD-Core Version:    0.7.0.1
 */