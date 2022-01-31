import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class asbx
  extends GridLayoutManager.SpanSizeLookup
{
  asbx(asbw paramasbw) {}
  
  public int getSpanSize(int paramInt)
  {
    if (this.a.getItemViewType(paramInt) == asbs.b) {
      return 5;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asbx
 * JD-Core Version:    0.7.0.1
 */