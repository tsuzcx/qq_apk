import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.ConcurrentHashMap;

class aqad
  implements View.OnClickListener
{
  aqad(aqab paramaqab) {}
  
  public void onClick(View paramView)
  {
    aqab.a(this.a).put(aqab.a(this.a).a, Integer.valueOf(1));
    Activity localActivity = aqab.a(this.a).a();
    if (!bhfn.a(localActivity, aqab.a(this.a).c))
    {
      if (!TextUtils.isEmpty(aqab.a(this.a).g))
      {
        Intent localIntent = new Intent(localActivity, QQBrowserActivity.class);
        localIntent.putExtra("url", aqab.a(this.a).g);
        localIntent.putExtra("fromArkAppDownload", true);
        localActivity.startActivity(localIntent);
      }
      addh.a(aqab.a(this.a), -4, "need to download");
    }
    for (;;)
    {
      aqab.a(this.a).a();
      aqab.a(this.a).dismiss();
      aqab.a(this.a, null);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aqab.a(this.a, aqab.a(this.a).a, aqab.a(this.a).b, aqab.a(this.a).c, aqab.a(this.a).d, aqab.a(this.a).e, aqab.a(this.a).f);
      addh.a(aqab.a(this.a), adac.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqad
 * JD-Core Version:    0.7.0.1
 */