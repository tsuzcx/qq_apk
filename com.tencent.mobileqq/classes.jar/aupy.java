import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.intervideo.nowproxy.NowPluginObserver;
import com.tencent.mobileqq.intervideo.now.dynamic.LoadingFragment;

public class aupy
  implements NowPluginObserver
{
  public aupy(LoadingFragment paramLoadingFragment) {}
  
  public void onCloseLoadingView()
  {
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
  
  public void onEnterAvPlugin(Bundle paramBundle) {}
  
  public void onEnterRoom(Bundle paramBundle)
  {
    this.a.a();
  }
  
  public void onExitRoom(Bundle paramBundle) {}
  
  public void onLoadingViewCreated(View paramView)
  {
    if (paramView != null)
    {
      this.a.getActivity();
      FrameLayout localFrameLayout = (FrameLayout)this.a.getView();
      if ((paramView != null) && (localFrameLayout != null)) {
        localFrameLayout.addView(paramView, new FrameLayout.LayoutParams(-1, -1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aupy
 * JD-Core Version:    0.7.0.1
 */