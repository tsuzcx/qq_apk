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

class avbj
  implements View.OnClickListener
{
  avbj(avbi paramavbi) {}
  
  public void onClick(View paramView)
  {
    if ((avbi.a(this.a) == null) || (TextUtils.isEmpty(avbi.a(this.a).jumpUrl))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = new Intent(avbb.a(avbi.a(this.a)), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", avbi.a(this.a).jumpUrl);
      avbb.a(avbi.a(this.a)).startActivity((Intent)localObject);
      localObject = new HashMap();
      abuf.a((Map)localObject, avbi.a(this.a).msgId);
      ((Map)localObject).put(Integer.valueOf(2), avbi.a(this.a).msgId);
      ((Map)localObject).put(Integer.valueOf(6), avbi.a(this.a).feedId);
      ((Map)localObject).put(Integer.valueOf(4), "20");
      ((Map)localObject).put(Integer.valueOf(43), avbi.a(this.a).algorithmId);
      ((Map)localObject).put(Integer.valueOf(44), avbi.a(this.a).type + "");
      abuf.a(amwn.a(), "769", "205022", avbi.a(this.a).a().gameAppId, "76902", "1", "160", (Map)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avbj
 * JD-Core Version:    0.7.0.1
 */