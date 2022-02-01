import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class atqk
  extends GridLayoutManager.SpanSizeLookup
{
  atqk(atqj paramatqj) {}
  
  public int getSpanSize(int paramInt)
  {
    if (this.a.getItemViewType(paramInt) == atqf.b) {
      return 5;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atqk
 * JD-Core Version:    0.7.0.1
 */