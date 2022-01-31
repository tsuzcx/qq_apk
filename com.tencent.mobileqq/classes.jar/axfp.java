import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class axfp
  implements View.OnClickListener
{
  axfp(axfo paramaxfo) {}
  
  public void onClick(View paramView)
  {
    if ((axfo.a(this.a) instanceof CustomWebView))
    {
      if (2 == axfo.a(this.a).c)
      {
        ((CustomWebView)axfo.a(this.a)).callJs("openAdvPermissionsMobile()");
        this.a.b();
      }
    }
    else {
      return;
    }
    ((CustomWebView)axfo.a(this.a)).callJs("openCooperationMobile()");
    this.a.b();
    awqx.b(axfo.a(this.a).app, "dc00898", "", "", "0x8009412", "0x8009412", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axfp
 * JD-Core Version:    0.7.0.1
 */