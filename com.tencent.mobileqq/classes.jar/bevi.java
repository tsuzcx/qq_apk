import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.widget.AbsListView;

public class bevi
  implements bhtv
{
  public bevi(SlideDetectListView paramSlideDetectListView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (SlideDetectListView.a(this.a) != null) {
      SlideDetectListView.a(this.a).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (SlideDetectListView.b(this.a) != null) {
      SlideDetectListView.b(this.a).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.a.c = paramInt;
    if (SlideDetectListView.a(this.a) != null) {
      SlideDetectListView.a(this.a).onScrollStateChanged(paramAbsListView, paramInt);
    }
    if (SlideDetectListView.b(this.a) != null) {
      SlideDetectListView.b(this.a).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bevi
 * JD-Core Version:    0.7.0.1
 */