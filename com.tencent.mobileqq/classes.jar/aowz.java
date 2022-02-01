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

class aowz
  implements View.OnClickListener
{
  aowz(aowx paramaowx) {}
  
  public void onClick(View paramView)
  {
    aowx.a(this.a).put(aowx.a(this.a).a, Integer.valueOf(1));
    Activity localActivity = aowx.a(this.a).a();
    if (!bfwv.a(localActivity, aowx.a(this.a).c))
    {
      if (!TextUtils.isEmpty(aowx.a(this.a).g))
      {
        Intent localIntent = new Intent(localActivity, QQBrowserActivity.class);
        localIntent.putExtra("url", aowx.a(this.a).g);
        localIntent.putExtra("fromArkAppDownload", true);
        localActivity.startActivity(localIntent);
      }
      acmy.a(aowx.a(this.a), -4, "need to download");
    }
    for (;;)
    {
      aowx.a(this.a).a();
      aowx.a(this.a).dismiss();
      aowx.a(this.a, null);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aowx.a(this.a, aowx.a(this.a).a, aowx.a(this.a).b, aowx.a(this.a).c, aowx.a(this.a).d, aowx.a(this.a).e, aowx.a(this.a).f);
      acmy.a(aowx.a(this.a), acjt.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aowz
 * JD-Core Version:    0.7.0.1
 */