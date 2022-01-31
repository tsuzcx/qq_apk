import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

class bchf
  implements View.OnClickListener
{
  bchf(bchd parambchd) {}
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putString(bdun.e, alud.a(2131700607));
    paramView.putString(bdun.f, "CJCLUBT");
    paramView.putString(bdun.d, "1450000516");
    paramView.putInt(bdun.b, 3);
    paramView.putString(bdun.i, "https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&aid=" + "mvip.pt.vipsite.tqtips_chengyuan");
    paramView.putString(bdun.g, "svip");
    paramView.putString(bdun.a, bchd.a(this.a).getCurrentAccountUin());
    bdun.a(bchd.a(this.a), bchd.a(this.a), paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchf
 * JD-Core Version:    0.7.0.1
 */