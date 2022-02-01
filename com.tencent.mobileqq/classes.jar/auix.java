import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class auix
  extends GridLayoutManager.SpanSizeLookup
{
  auix(auiw paramauiw) {}
  
  public int getSpanSize(int paramInt)
  {
    if (this.a.getItemViewType(paramInt) == auis.b) {
      return 5;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auix
 * JD-Core Version:    0.7.0.1
 */