import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class bbnw
  extends GridLayoutManager.SpanSizeLookup
{
  bbnw(bbnv parambbnv) {}
  
  public int getSpanSize(int paramInt)
  {
    int i = 3;
    switch (this.a.getItemViewType(paramInt))
    {
    default: 
      i = 1;
    case 1: 
    case 2: 
    case 4: 
      return i;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbnw
 * JD-Core Version:    0.7.0.1
 */