import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class ayfs
  implements View.OnClickListener
{
  ayfs(ayfr paramayfr) {}
  
  public void onClick(View paramView)
  {
    if ((ayfr.a(this.a) instanceof CustomWebView))
    {
      if (2 == ayfr.a(this.a).c)
      {
        ((CustomWebView)ayfr.a(this.a)).callJs("openAdvPermissionsMobile()");
        this.a.b();
      }
    }
    else {
      return;
    }
    ((CustomWebView)ayfr.a(this.a)).callJs("openCooperationMobile()");
    this.a.b();
    axqw.b(ayfr.a(this.a).app, "dc00898", "", "", "0x8009412", "0x8009412", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayfs
 * JD-Core Version:    0.7.0.1
 */