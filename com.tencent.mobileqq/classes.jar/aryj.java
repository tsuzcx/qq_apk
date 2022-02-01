import com.tencent.image.AbstractGifImage;
import com.tencent.widget.AbsListView;

class aryj
  implements bkhe
{
  aryj(aryi paramaryi) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 2)) {
      AbstractGifImage.resumeAll();
    }
    for (;;)
    {
      this.a.d = paramInt;
      return;
      AbstractGifImage.pauseAll();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryj
 * JD-Core Version:    0.7.0.1
 */