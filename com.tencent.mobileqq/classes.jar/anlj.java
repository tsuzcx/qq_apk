import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import java.util.concurrent.ConcurrentHashMap;

class anlj
  implements View.OnClickListener
{
  anlj(anlh paramanlh) {}
  
  public void onClick(View paramView)
  {
    anlh.a(this.a).put(anlh.a(this.a).a, Integer.valueOf(1));
    paramView = anlh.a(this.a).a();
    if (!bdem.a(paramView, anlh.a(this.a).c))
    {
      if (!TextUtils.isEmpty(anlh.a(this.a).g))
      {
        Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
        localIntent.putExtra("url", anlh.a(this.a).g);
        localIntent.putExtra("fromArkAppDownload", true);
        paramView.startActivity(localIntent);
      }
      abvm.a(anlh.a(this.a), -4, "need to download");
    }
    for (;;)
    {
      anlh.a(this.a).a();
      anlh.a(this.a).dismiss();
      anlh.a(this.a, null);
      return;
      anlh.a(this.a, anlh.a(this.a).a, anlh.a(this.a).b, anlh.a(this.a).c, anlh.a(this.a).d, anlh.a(this.a).e, anlh.a(this.a).f);
      abvm.a(anlh.a(this.a), absh.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anlj
 * JD-Core Version:    0.7.0.1
 */