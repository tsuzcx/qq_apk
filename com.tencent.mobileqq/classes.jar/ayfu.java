import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class ayfu
  implements View.OnClickListener
{
  ayfu(ayft paramayft) {}
  
  public void onClick(View paramView)
  {
    if ((ayft.a(this.a) instanceof CustomWebView))
    {
      if (2 == ayft.a(this.a).c)
      {
        ((CustomWebView)ayft.a(this.a)).callJs("openAdvPermissionsMobile()");
        this.a.b();
      }
    }
    else {
      return;
    }
    ((CustomWebView)ayft.a(this.a)).callJs("openCooperationMobile()");
    this.a.b();
    axqy.b(ayft.a(this.a).app, "dc00898", "", "", "0x8009412", "0x8009412", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayfu
 * JD-Core Version:    0.7.0.1
 */