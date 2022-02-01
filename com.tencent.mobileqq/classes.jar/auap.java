import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import com.tencent.mobileqq.gamecenter.web.view.QQGameIndicator2;
import com.tencent.mobileqq.gamecenter.web.view.UnreadTipLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class auap
  implements View.OnClickListener
{
  public auap(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void onClick(View paramView)
  {
    int i;
    int j;
    if (QQGameFeedWebFragment.a(this.a) != null)
    {
      if (QQGameFeedWebFragment.a(this.a) == null) {}
      for (i = 0; this.a.a >= 3; i = QQGameFeedWebFragment.a(this.a).size())
      {
        QQGameFeedWebFragment.a(this.a).setCurrentItem(QQGameFeedWebFragment.a(this.a).getCount());
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
      j = QQGameFeedWebFragment.a(this.a).getCurrentItem();
      if (j + 1 >= i) {
        break label211;
      }
      QQGameFeedWebFragment.a(this.a).setCurrentItem(j + 1);
    }
    for (;;)
    {
      if (this.a.a == 0)
      {
        QQGameFeedWebFragment.a(this.a).setVisibility(0);
        QQGameFeedWebFragment.a(this.a).setVisibility(4);
        QQGameFeedWebFragment.a(this.a).b();
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put(Integer.valueOf(4), "20");
      localHashMap.put(Integer.valueOf(24), "1");
      abet.a(alvx.a(), "769", "207553", "", "76925", "1", "160", localHashMap);
      break;
      label211:
      if (j == i - 1) {
        QQGameFeedWebFragment.a(this.a).setCurrentItem(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auap
 * JD-Core Version:    0.7.0.1
 */