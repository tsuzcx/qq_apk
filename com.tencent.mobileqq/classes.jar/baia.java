import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class baia
  implements View.OnClickListener
{
  baia(bahz parambahz) {}
  
  public void onClick(View paramView)
  {
    if ((bahz.a(this.a) instanceof CustomWebView))
    {
      if (2 == bahz.a(this.a).c)
      {
        ((CustomWebView)bahz.a(this.a)).callJs("openAdvPermissionsMobile()");
        this.a.dismiss();
      }
    }
    else {
      return;
    }
    ((CustomWebView)bahz.a(this.a)).callJs("openCooperationMobile()");
    this.a.dismiss();
    azqs.b(bahz.a(this.a).app, "dc00898", "", "", "0x8009412", "0x8009412", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baia
 * JD-Core Version:    0.7.0.1
 */