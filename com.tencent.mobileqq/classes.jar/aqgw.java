import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class aqgw
  extends GridLayoutManager.SpanSizeLookup
{
  aqgw(aqgv paramaqgv) {}
  
  public int getSpanSize(int paramInt)
  {
    if (this.a.getItemViewType(paramInt) == aqgr.b) {
      return 5;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqgw
 * JD-Core Version:    0.7.0.1
 */