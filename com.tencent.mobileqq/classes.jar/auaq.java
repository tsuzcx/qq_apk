import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class auaq
  implements View.OnClickListener
{
  public auaq(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void onClick(View paramView)
  {
    String str2 = "";
    String str1 = "";
    Object localObject = QQGameFeedWebFragment.a(this.a);
    int i;
    if (localObject != null)
    {
      str2 = ((QQGameMsgInfo)localObject).gameAppId;
      if (TextUtils.isEmpty(((QQGameMsgInfo)localObject).paMsgid)) {
        str1 = "";
      }
    }
    else
    {
      localObject = new HashMap();
      ((Map)localObject).put(Integer.valueOf(2), str1);
      ((Map)localObject).put(Integer.valueOf(3), "2");
      ((Map)localObject).put(Integer.valueOf(4), "20");
      ((Map)localObject).put(Integer.valueOf(24), "1");
      abet.a(alvx.a(), "769", "205037", str2, "76901", "1", "160", (Map)localObject);
      if (QQGameFeedWebFragment.a(this.a) != null)
      {
        if (QQGameFeedWebFragment.a(this.a) != null) {
          break label201;
        }
        i = 0;
        label152:
        if (this.a.a < 3) {
          break label217;
        }
        QQGameFeedWebFragment.a(this.a).setCurrentItem(QQGameFeedWebFragment.a(this.a).getCount());
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      str1 = ((QQGameMsgInfo)localObject).paMsgid;
      break;
      label201:
      i = QQGameFeedWebFragment.a(this.a).size();
      break label152;
      label217:
      int j = QQGameFeedWebFragment.a(this.a).getCurrentItem();
      if (j + 1 < i) {
        QQGameFeedWebFragment.a(this.a).setCurrentItem(j + 1);
      } else if (j == i - 1) {
        QQGameFeedWebFragment.a(this.a).setCurrentItem(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auaq
 * JD-Core Version:    0.7.0.1
 */