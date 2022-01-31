import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import java.util.concurrent.ConcurrentHashMap;

class anps
  implements View.OnClickListener
{
  anps(anpq paramanpq) {}
  
  public void onClick(View paramView)
  {
    anpq.a(this.a).put(anpq.a(this.a).a, Integer.valueOf(1));
    paramView = anpq.a(this.a).a();
    if (!bdiv.a(paramView, anpq.a(this.a).c))
    {
      if (!TextUtils.isEmpty(anpq.a(this.a).g))
      {
        Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
        localIntent.putExtra("url", anpq.a(this.a).g);
        localIntent.putExtra("fromArkAppDownload", true);
        paramView.startActivity(localIntent);
      }
      acab.a(anpq.a(this.a), -4, "need to download");
    }
    for (;;)
    {
      anpq.a(this.a).a();
      anpq.a(this.a).dismiss();
      anpq.a(this.a, null);
      return;
      anpq.a(this.a, anpq.a(this.a).a, anpq.a(this.a).b, anpq.a(this.a).c, anpq.a(this.a).d, anpq.a(this.a).e, anpq.a(this.a).f);
      acab.a(anpq.a(this.a), abww.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anps
 * JD-Core Version:    0.7.0.1
 */