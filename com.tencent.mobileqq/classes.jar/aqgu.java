import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class aqgu
  extends GridLayoutManager.SpanSizeLookup
{
  aqgu(aqgt paramaqgt) {}
  
  public int getSpanSize(int paramInt)
  {
    if (this.a.getItemViewType(paramInt) == aqgp.b) {
      return 5;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqgu
 * JD-Core Version:    0.7.0.1
 */