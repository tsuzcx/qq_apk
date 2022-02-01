import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.profile.lifeachivement.LifeAchivementPanelView;

public class azzs
  extends RecyclerView.OnScrollListener
{
  public azzs(LifeAchivementPanelView paramLifeAchivementPanelView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0) {
      if (!LifeAchivementPanelView.a(this.a)) {
        break label47;
      }
    }
    label47:
    for (paramInt = 1;; paramInt = 2)
    {
      bdll.b(null, "", "", "", "0X800AE55", "0X800AE55", paramInt, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azzs
 * JD-Core Version:    0.7.0.1
 */