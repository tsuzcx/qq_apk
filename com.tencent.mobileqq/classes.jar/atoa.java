import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class atoa
  extends GridLayoutManager.SpanSizeLookup
{
  atoa(atnz paramatnz) {}
  
  public int getSpanSize(int paramInt)
  {
    if (this.a.getItemViewType(paramInt) == atnv.b) {
      return 5;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atoa
 * JD-Core Version:    0.7.0.1
 */