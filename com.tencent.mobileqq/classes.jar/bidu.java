import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ChildDrawingOrderCallback;

class bidu
  implements RecyclerView.ChildDrawingOrderCallback
{
  bidu(bidr parambidr) {}
  
  public int onGetChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.a.mOverdrawChild == null) {}
    int i;
    do
    {
      return paramInt2;
      int j = this.a.mOverdrawChildPosition;
      i = j;
      if (j == -1)
      {
        i = this.a.mRecyclerView.indexOfChild(this.a.mOverdrawChild);
        this.a.mOverdrawChildPosition = i;
      }
      if (paramInt2 == paramInt1 - 1) {
        return i;
      }
    } while (paramInt2 < i);
    return paramInt2 + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bidu
 * JD-Core Version:    0.7.0.1
 */