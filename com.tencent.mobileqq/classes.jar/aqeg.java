import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class aqeg
  extends GridLayoutManager.SpanSizeLookup
{
  aqeg(aqef paramaqef) {}
  
  public int getSpanSize(int paramInt)
  {
    if (this.a.getItemViewType(paramInt) == aqeb.b) {
      return 5;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqeg
 * JD-Core Version:    0.7.0.1
 */