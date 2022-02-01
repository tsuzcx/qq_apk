import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ayat
  implements AbsListView.OnScrollListener
{
  public ayat(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 1) {
      blgx.b(ChooseInterestTagActivity.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayat
 * JD-Core Version:    0.7.0.1
 */