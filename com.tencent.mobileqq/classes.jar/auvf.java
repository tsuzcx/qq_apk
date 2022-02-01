import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class auvf
  extends GridLayoutManager.SpanSizeLookup
{
  auvf(auve paramauve) {}
  
  public int getSpanSize(int paramInt)
  {
    if (this.a.getItemViewType(paramInt) == auva.b) {
      return 5;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auvf
 * JD-Core Version:    0.7.0.1
 */