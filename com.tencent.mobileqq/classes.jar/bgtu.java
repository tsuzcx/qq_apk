import android.app.Activity;
import android.view.View;
import com.tencent.shadow.dynamic.host.EnterCallback;
import cooperation.qqreader.ReaderSplashImpl.3.1;

public class bgtu
  implements EnterCallback
{
  bgtu(bgtr parambgtr) {}
  
  public void onCloseLoadingView() {}
  
  public void onEnterComplete() {}
  
  public void onShowLoadingView(View paramView)
  {
    bgtr.a(this.a).runOnUiThread(new ReaderSplashImpl.3.1(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgtu
 * JD-Core Version:    0.7.0.1
 */