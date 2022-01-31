import android.app.Activity;
import android.view.View;
import com.tencent.shadow.dynamic.host.EnterCallback;
import cooperation.qqreader.ReaderSplashImpl.3.1;

public class bgul
  implements EnterCallback
{
  bgul(bgui parambgui) {}
  
  public void onCloseLoadingView() {}
  
  public void onEnterComplete() {}
  
  public void onShowLoadingView(View paramView)
  {
    bgui.a(this.a).runOnUiThread(new ReaderSplashImpl.3.1(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgul
 * JD-Core Version:    0.7.0.1
 */