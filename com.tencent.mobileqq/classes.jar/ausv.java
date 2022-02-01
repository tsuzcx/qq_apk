import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class ausv
  extends GridLayoutManager.SpanSizeLookup
{
  ausv(ausu paramausu) {}
  
  public int getSpanSize(int paramInt)
  {
    if (this.a.getItemViewType(paramInt) == ausq.b) {
      return 5;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ausv
 * JD-Core Version:    0.7.0.1
 */