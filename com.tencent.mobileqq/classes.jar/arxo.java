import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class arxo
  extends GridLayoutManager.SpanSizeLookup
{
  arxo(arxn paramarxn) {}
  
  public int getSpanSize(int paramInt)
  {
    if (this.a.getItemViewType(paramInt) == arxj.b) {
      return 5;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxo
 * JD-Core Version:    0.7.0.1
 */