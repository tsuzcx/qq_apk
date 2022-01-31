import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy.IDrawableLoadedCallBack;
import com.tencent.qqmini.sdk.minigame.ui.LoadingUI;

public class bgvs
  implements MiniAppProxy.IDrawableLoadedCallBack
{
  public bgvs(LoadingUI paramLoadingUI) {}
  
  public void onLoadSuccessed(Drawable paramDrawable)
  {
    LoadingUI.a(this.a).setVisibility(0);
    LoadingUI.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgvs
 * JD-Core Version:    0.7.0.1
 */