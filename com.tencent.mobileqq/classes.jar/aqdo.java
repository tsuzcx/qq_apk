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

class aqdo
  implements View.OnClickListener
{
  aqdo(aqdm paramaqdm) {}
  
  public void onClick(View paramView)
  {
    aqdm.a(this.a).put(aqdm.a(this.a).a, Integer.valueOf(1));
    Activity localActivity = aqdm.a(this.a).a();
    if (!bhny.a(localActivity, aqdm.a(this.a).c))
    {
      if (!TextUtils.isEmpty(aqdm.a(this.a).g))
      {
        Intent localIntent = new Intent(localActivity, QQBrowserActivity.class);
        localIntent.putExtra("url", aqdm.a(this.a).g);
        localIntent.putExtra("fromArkAppDownload", true);
        localActivity.startActivity(localIntent);
      }
      adqf.a(aqdm.a(this.a), -4, "need to download");
    }
    for (;;)
    {
      aqdm.a(this.a).a();
      aqdm.a(this.a).dismiss();
      aqdm.a(this.a, null);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aqdm.a(this.a, aqdm.a(this.a).a, aqdm.a(this.a).b, aqdm.a(this.a).c, aqdm.a(this.a).d, aqdm.a(this.a).e, aqdm.a(this.a).f);
      adqf.a(aqdm.a(this.a), adna.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqdo
 * JD-Core Version:    0.7.0.1
 */