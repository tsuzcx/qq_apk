import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout;
import com.tencent.qphone.base.util.QLog;

public class asvk
  implements View.OnClickListener
{
  public asvk(HotVideoMongoliaRelativeLayout paramHotVideoMongoliaRelativeLayout) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.hotpic.HotPicPageView.b = true;
    if (this.a.a == null) {
      return;
    }
    if (HotVideoMongoliaRelativeLayout.a(this.a) != null) {
      HotVideoMongoliaRelativeLayout.a(this.a).b(HotVideoMongoliaRelativeLayout.a(this.a));
    }
    QLog.d("HotVideoRelativeLayout", 2, "click round rect send view");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvk
 * JD-Core Version:    0.7.0.1
 */