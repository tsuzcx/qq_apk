import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

class aurc
  implements View.OnClickListener
{
  aurc(aurb paramaurb) {}
  
  public void onClick(View paramView)
  {
    if ((aurb.a(this.a) == null) || (TextUtils.isEmpty(aurb.a(this.a).jumpUrl))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = new Intent(auqu.a(aurb.a(this.a)), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", aurb.a(this.a).jumpUrl);
      auqu.a(aurb.a(this.a)).startActivity((Intent)localObject);
      localObject = new HashMap();
      aceh.a((Map)localObject, aurb.a(this.a).msgId);
      ((Map)localObject).put(Integer.valueOf(2), aurb.a(this.a).msgId);
      ((Map)localObject).put(Integer.valueOf(6), aurb.a(this.a).feedId);
      ((Map)localObject).put(Integer.valueOf(4), "20");
      ((Map)localObject).put(Integer.valueOf(43), aurb.a(this.a).algorithmId);
      ((Map)localObject).put(Integer.valueOf(44), aurb.a(this.a).type + "");
      aceh.a(ampj.a(), "769", "205022", aurb.a(this.a).a().gameAppId, "76902", "1", "160", (Map)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aurc
 * JD-Core Version:    0.7.0.1
 */