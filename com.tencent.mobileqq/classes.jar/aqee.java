import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class aqee
  extends GridLayoutManager.SpanSizeLookup
{
  aqee(aqed paramaqed) {}
  
  public int getSpanSize(int paramInt)
  {
    if (this.a.getItemViewType(paramInt) == aqdz.b) {
      return 5;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqee
 * JD-Core Version:    0.7.0.1
 */