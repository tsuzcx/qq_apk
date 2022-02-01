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

class avjc
  implements View.OnClickListener
{
  avjc(avjb paramavjb) {}
  
  public void onClick(View paramView)
  {
    if ((avjb.a(this.a) == null) || (TextUtils.isEmpty(avjb.a(this.a).jumpUrl))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = new Intent(aviu.a(avjb.a(this.a)), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", avjb.a(this.a).jumpUrl);
      aviu.a(avjb.a(this.a)).startActivity((Intent)localObject);
      localObject = new HashMap();
      acik.a((Map)localObject, avjb.a(this.a).msgId);
      ((Map)localObject).put(Integer.valueOf(2), avjb.a(this.a).msgId);
      ((Map)localObject).put(Integer.valueOf(6), avjb.a(this.a).feedId);
      ((Map)localObject).put(Integer.valueOf(4), "20");
      ((Map)localObject).put(Integer.valueOf(43), avjb.a(this.a).algorithmId);
      ((Map)localObject).put(Integer.valueOf(44), avjb.a(this.a).type + "");
      acik.a(anbd.a(), "769", "205022", avjb.a(this.a).a().gameAppId, "76902", "1", "160", (Map)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avjc
 * JD-Core Version:    0.7.0.1
 */