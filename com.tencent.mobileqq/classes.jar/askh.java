import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Map;

public class askh
  implements View.OnClickListener
{
  public askh(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void onClick(View paramView)
  {
    String str = "";
    paramView = "";
    Object localObject = QQGameFeedWebFragment.a(this.a);
    if (localObject != null)
    {
      str = ((QQGameMsgInfo)localObject).gameAppId;
      if (!TextUtils.isEmpty(((QQGameMsgInfo)localObject).paMsgid)) {
        break label159;
      }
    }
    label159:
    for (paramView = "";; paramView = ((QQGameMsgInfo)localObject).paMsgid)
    {
      localObject = new HashMap();
      ((Map)localObject).put(Integer.valueOf(24), "1");
      ((Map)localObject).put(Integer.valueOf(1), paramView);
      ((Map)localObject).put(Integer.valueOf(3), "20");
      aact.a(akro.a(), "769", "205037", str, "76901", "1", "160", (Map)localObject);
      paramView = new Intent(BaseApplication.getContext(), GameCenterActivity.class);
      paramView.putExtra("url", asjb.b());
      paramView.addFlags(268435456);
      paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramView.putExtra("big_brother_source_key", "biz_src_zf_games");
      this.a.startActivity(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     askh
 * JD-Core Version:    0.7.0.1
 */