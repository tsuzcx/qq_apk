import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bfzr
  implements View.OnClickListener
{
  bfzr(bfzp parambfzp) {}
  
  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString(bhoy.e, anvx.a(2131699726));
    localBundle.putString(bhoy.f, "CJCLUBT");
    localBundle.putString(bhoy.d, "1450000516");
    localBundle.putInt(bhoy.b, 3);
    localBundle.putString(bhoy.i, "https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&aid=" + "mvip.pt.vipsite.tqtips_chengyuan");
    localBundle.putString(bhoy.g, "svip");
    localBundle.putString(bhoy.a, bfzp.a(this.a).getCurrentAccountUin());
    bhoy.a(bfzp.a(this.a), bfzp.a(this.a), localBundle);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfzr
 * JD-Core Version:    0.7.0.1
 */