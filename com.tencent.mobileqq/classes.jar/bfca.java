import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.widget.MaxHeightScrollView;

public class bfca
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public bfca(AuthorityActivity paramAuthorityActivity) {}
  
  public void onGlobalLayout()
  {
    if ((DisplayUtil.hasNavBar(this.a)) && (DisplayUtil.isNavigationBarExist(this.a)))
    {
      i = AuthorityActivity.a(this.a).a();
      int j = DisplayUtil.getNavigationBarHeight(this.a);
      AuthorityActivity.a(this.a).setMaxHeight(i - j);
    }
    int i = ((View)this.a.findViewById(2131376034).getParent()).getTop();
    if (i > 0) {
      AuthorityActivity.a(this.a).setMaxHeight(AuthorityActivity.a(this.a).a() - i);
    }
    AuthorityActivity.a(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfca
 * JD-Core Version:    0.7.0.1
 */