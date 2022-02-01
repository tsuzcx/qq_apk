package androidx.recyclerview.widget;

public final class GridLayoutManager$DefaultSpanSizeLookup
  extends GridLayoutManager.SpanSizeLookup
{
  public int getSpanIndex(int paramInt1, int paramInt2)
  {
    return paramInt1 % paramInt2;
  }
  
  public int getSpanSize(int paramInt)
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.GridLayoutManager.DefaultSpanSizeLookup
 * JD-Core Version:    0.7.0.1
 */