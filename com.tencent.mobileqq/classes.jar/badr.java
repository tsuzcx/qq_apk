import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class badr
  implements View.OnClickListener
{
  badr(badq parambadq) {}
  
  public void onClick(View paramView)
  {
    if ((badq.a(this.a) instanceof CustomWebView))
    {
      if (2 == badq.a(this.a).c)
      {
        ((CustomWebView)badq.a(this.a)).callJs("openAdvPermissionsMobile()");
        this.a.dismiss();
      }
    }
    else {
      return;
    }
    ((CustomWebView)badq.a(this.a)).callJs("openCooperationMobile()");
    this.a.dismiss();
    azmj.b(badq.a(this.a).app, "dc00898", "", "", "0x8009412", "0x8009412", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     badr
 * JD-Core Version:    0.7.0.1
 */