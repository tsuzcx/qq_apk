import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

class bccw
  implements View.OnClickListener
{
  bccw(bccu parambccu) {}
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putString(bdqe.e, alpo.a(2131700595));
    paramView.putString(bdqe.f, "CJCLUBT");
    paramView.putString(bdqe.d, "1450000516");
    paramView.putInt(bdqe.b, 3);
    paramView.putString(bdqe.i, "https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&aid=" + "mvip.pt.vipsite.tqtips_chengyuan");
    paramView.putString(bdqe.g, "svip");
    paramView.putString(bdqe.a, bccu.a(this.a).getCurrentAccountUin());
    bdqe.a(bccu.a(this.a), bccu.a(this.a), paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bccw
 * JD-Core Version:    0.7.0.1
 */