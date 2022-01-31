import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;

public class auwi
  implements AbsListView.OnScrollListener
{
  public auwi(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      bhoc.b(ChooseInterestTagActivity.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auwi
 * JD-Core Version:    0.7.0.1
 */