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

class appy
  implements View.OnClickListener
{
  appy(appw paramappw) {}
  
  public void onClick(View paramView)
  {
    appw.a(this.a).put(appw.a(this.a).a, Integer.valueOf(1));
    Activity localActivity = appw.a(this.a).a();
    if (!bgnw.a(localActivity, appw.a(this.a).c))
    {
      if (!TextUtils.isEmpty(appw.a(this.a).g))
      {
        Intent localIntent = new Intent(localActivity, QQBrowserActivity.class);
        localIntent.putExtra("url", appw.a(this.a).g);
        localIntent.putExtra("fromArkAppDownload", true);
        localActivity.startActivity(localIntent);
      }
      adhh.a(appw.a(this.a), -4, "need to download");
    }
    for (;;)
    {
      appw.a(this.a).a();
      appw.a(this.a).dismiss();
      appw.a(this.a, null);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      appw.a(this.a, appw.a(this.a).a, appw.a(this.a).b, appw.a(this.a).c, appw.a(this.a).d, appw.a(this.a).e, appw.a(this.a).f);
      adhh.a(appw.a(this.a), adec.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appy
 * JD-Core Version:    0.7.0.1
 */