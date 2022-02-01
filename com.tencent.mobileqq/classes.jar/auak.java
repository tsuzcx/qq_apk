import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

public class auak
  implements View.OnClickListener
{
  public auak(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void onClick(View paramView)
  {
    String str = "";
    Object localObject1 = "";
    Object localObject2 = QQGameFeedWebFragment.a(this.a);
    if (localObject2 != null)
    {
      str = ((QQGameMsgInfo)localObject2).gameAppId;
      if (!TextUtils.isEmpty(((QQGameMsgInfo)localObject2).paMsgid)) {
        break label189;
      }
    }
    label189:
    for (localObject1 = "";; localObject1 = ((QQGameMsgInfo)localObject2).paMsgid)
    {
      localObject2 = new HashMap();
      ((Map)localObject2).put(Integer.valueOf(2), localObject1);
      ((Map)localObject2).put(Integer.valueOf(3), "1");
      ((Map)localObject2).put(Integer.valueOf(4), "20");
      ((Map)localObject2).put(Integer.valueOf(24), "1");
      abet.a(alvx.a(), "769", "205037", str, "76901", "1", "160", (Map)localObject2);
      localObject1 = new Intent(BaseApplication.getContext(), GameCenterActivity.class);
      ((Intent)localObject1).putExtra("url", atzb.b());
      ((Intent)localObject1).addFlags(268435456);
      ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_zf_games");
      this.a.startActivity((Intent)localObject1);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auak
 * JD-Core Version:    0.7.0.1
 */