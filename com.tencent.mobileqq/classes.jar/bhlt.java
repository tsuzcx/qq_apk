import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class bhlt
  extends GridLayoutManager.SpanSizeLookup
{
  bhlt(bhls parambhls) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhlt
 * JD-Core Version:    0.7.0.1
 */