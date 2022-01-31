import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class apkr
  extends GridLayoutManager.SpanSizeLookup
{
  apkr(apkq paramapkq) {}
  
  public int getSpanSize(int paramInt)
  {
    if (this.a.getItemViewType(paramInt) == apkm.b) {
      return 5;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apkr
 * JD-Core Version:    0.7.0.1
 */