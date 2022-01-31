import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class apng
  extends GridLayoutManager.SpanSizeLookup
{
  apng(apnf paramapnf) {}
  
  public int getSpanSize(int paramInt)
  {
    if (this.a.getItemViewType(paramInt) == apnb.b) {
      return 5;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apng
 * JD-Core Version:    0.7.0.1
 */