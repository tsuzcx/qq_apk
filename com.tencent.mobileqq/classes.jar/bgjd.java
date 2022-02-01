import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgjd
  implements View.OnClickListener
{
  bgjd(bgjb parambgjb) {}
  
  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString(bhzu.e, anzj.a(2131699140));
    localBundle.putString(bhzu.f, "CJCLUBT");
    localBundle.putString(bhzu.d, "1450000516");
    localBundle.putInt(bhzu.b, 3);
    localBundle.putString(bhzu.i, "https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&aid=" + "mvip.pt.vipsite.tqtips_chengyuan");
    localBundle.putString(bhzu.g, "svip");
    localBundle.putString(bhzu.a, bgjb.a(this.a).getCurrentAccountUin());
    bhzu.a(bgjb.a(this.a), bgjb.a(this.a), localBundle);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgjd
 * JD-Core Version:    0.7.0.1
 */