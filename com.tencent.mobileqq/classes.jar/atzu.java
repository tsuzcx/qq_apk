import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.mobileqq.gamecenter.view.NavBarQQGamePub;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

public class atzu
  implements View.OnClickListener
{
  public atzu(NavBarQQGamePub paramNavBarQQGamePub) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    if ((NavBarQQGamePub.a(this.a) != null) && (NavBarQQGamePub.a(this.a).getVisibility() == 0)) {
      NavBarQQGamePub.a(this.a).setVisibility(4);
    }
    HashMap localHashMap = new HashMap();
    String str = "";
    if (NavBarQQGamePub.a(this.a) == 1)
    {
      Object localObject = atzb.b();
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && ((((String)localObject).startsWith("http")) || (((String)localObject).startsWith("https"))))
      {
        localObject = new Intent(BaseApplication.getContext(), GameCenterActivity.class);
        ((Intent)localObject).putExtra("url", atzb.b());
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_zf_games");
        this.a.getContext().startActivity((Intent)localObject);
      }
      i = 2;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        localHashMap.put(Integer.valueOf(2), str);
      }
      localHashMap.put(Integer.valueOf(3), i + "");
      localHashMap.put(Integer.valueOf(4), "20");
      localHashMap.put(Integer.valueOf(24), "1");
      abet.a(alvx.a(), "770", "207023", "", "77002", "1", "160", localHashMap);
      atzd.a();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (NavBarQQGamePub.a(this.a) == 2)
      {
        if ((!TextUtils.isEmpty(NavBarQQGamePub.a(this.a))) && ((NavBarQQGamePub.a(this.a).startsWith("http")) || (NavBarQQGamePub.a(this.a).startsWith("https")))) {
          NavBarQQGamePub.a(this.a, NavBarQQGamePub.a(this.a));
        }
        str = NavBarQQGamePub.b(this.a);
        this.a.a();
        i = 3;
      }
      else if (NavBarQQGamePub.a(this.a) == 3)
      {
        if ((!TextUtils.isEmpty(NavBarQQGamePub.a(this.a))) && ((NavBarQQGamePub.a(this.a).startsWith("http")) || (NavBarQQGamePub.a(this.a).startsWith("https")))) {
          NavBarQQGamePub.a(this.a, NavBarQQGamePub.a(this.a));
        }
        str = NavBarQQGamePub.b(this.a);
        this.a.a();
      }
      else
      {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzu
 * JD-Core Version:    0.7.0.1
 */