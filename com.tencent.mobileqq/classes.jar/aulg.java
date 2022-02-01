import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class aulg
  extends GridLayoutManager.SpanSizeLookup
{
  aulg(aulf paramaulf) {}
  
  public int getSpanSize(int paramInt)
  {
    if (this.a.getItemViewType(paramInt) == aulb.b) {
      return 5;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aulg
 * JD-Core Version:    0.7.0.1
 */