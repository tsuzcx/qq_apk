import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.open.agent.QuickLoginAuthorityActivity;
import com.tencent.open.widget.MaxHeightScrollView;

public class bfcm
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public bfcm(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity) {}
  
  public void onGlobalLayout()
  {
    if ((DisplayUtil.hasNavBar(this.a)) && (DisplayUtil.isNavigationBarExist(this.a)))
    {
      int i = QuickLoginAuthorityActivity.a(this.a).a();
      int j = DisplayUtil.getNavigationBarHeight(this.a);
      QuickLoginAuthorityActivity.a(this.a).setMaxHeight(i - j);
    }
    QuickLoginAuthorityActivity.a(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfcm
 * JD-Core Version:    0.7.0.1
 */