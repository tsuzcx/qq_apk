import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import java.util.HashMap;
import java.util.Map;

public class askl
  implements View.OnClickListener
{
  public askl(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void onClick(View paramView)
  {
    QQGameFeedWebFragment.a(this.a).setVisibility(8);
    if (QQGameFeedWebFragment.a(this.a) != null) {
      QQGameFeedWebFragment.a(this.a).setCurrentItem(0);
    }
    paramView = (String)QQGameFeedWebFragment.a(this.a).getTag();
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(1), paramView);
    localHashMap.put(Integer.valueOf(2), "");
    localHashMap.put(Integer.valueOf(3), "20");
    localHashMap.put(Integer.valueOf(24), "1");
    aact.a(akro.a(), "769", "205031", "", "76901", "1", "160", localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     askl
 * JD-Core Version:    0.7.0.1
 */