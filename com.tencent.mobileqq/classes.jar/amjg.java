import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class amjg
  implements AbsListView.OnScrollListener
{
  amjg(amjc paramamjc) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    amjc.a(this.a, paramInt);
    if (paramInt == 0)
    {
      amjc.a(this.a, null, null);
      amjc.a(this.a).resume();
      return;
    }
    amjc.a(this.a).pause();
    amjc.a(this.a).cancelPendingRequests();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amjg
 * JD-Core Version:    0.7.0.1
 */