import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class aseu
  extends GridLayoutManager.SpanSizeLookup
{
  aseu(aset paramaset) {}
  
  public int getSpanSize(int paramInt)
  {
    if (this.a.getItemViewType(paramInt) == asep.b) {
      return 5;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aseu
 * JD-Core Version:    0.7.0.1
 */