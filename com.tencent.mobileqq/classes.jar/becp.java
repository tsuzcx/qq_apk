import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class becp
  implements View.OnClickListener
{
  becp(beco parambeco) {}
  
  public void onClick(View paramView)
  {
    if ((beco.a(this.a) instanceof CustomWebView))
    {
      if (2 != beco.a(this.a).c) {
        break label57;
      }
      ((CustomWebView)beco.a(this.a)).callJs("openAdvPermissionsMobile()");
      this.a.dismiss();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label57:
      ((CustomWebView)beco.a(this.a)).callJs("openCooperationMobile()");
      this.a.dismiss();
      bdla.b(beco.a(this.a).app, "dc00898", "", "", "0x8009412", "0x8009412", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     becp
 * JD-Core Version:    0.7.0.1
 */