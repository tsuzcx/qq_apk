import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.apollo.game.ApolloWebViewFragment;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class amtg
  implements View.OnLayoutChangeListener
{
  public amtg(ApolloWebViewFragment paramApolloWebViewFragment) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramView = this.a.getHostActivity();
    if (paramView == null) {}
    do
    {
      do
      {
        return;
        paramView = paramView.findViewById(16908290);
      } while (paramView == null);
      paramView.getWindowVisibleDisplayFrame(ApolloWebViewFragment.a(this.a));
      paramInt1 = ApolloWebViewFragment.a(this.a).right - ApolloWebViewFragment.a(this.a).left;
      paramInt2 = ApolloWebViewFragment.a(this.a).bottom - ApolloWebViewFragment.a(this.a).top;
    } while ((ApolloWebViewFragment.a(this.a) == paramInt1) && (ApolloWebViewFragment.b(this.a) == paramInt2));
    ThreadManager.getUIHandler().post(this.a.a);
    ApolloWebViewFragment.a(this.a, paramInt1);
    ApolloWebViewFragment.b(this.a, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtg
 * JD-Core Version:    0.7.0.1
 */