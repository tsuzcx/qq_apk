import android.view.View;
import com.tencent.shadow.dynamic.host.EnterCallback;
import cooperation.qqreader.ui.ReaderHomePageActivity;
import cooperation.qqreader.utils.ReaderSplashActivityUtils.1.1;

public class bfnh
  implements EnterCallback
{
  bfnh(bfng parambfng) {}
  
  public void onCloseLoadingView()
  {
    bfng.a(this.a);
  }
  
  public void onEnterComplete() {}
  
  public void onShowLoadingView(View paramView)
  {
    bfng.a(this.a).runOnUiThread(new ReaderSplashActivityUtils.1.1(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfnh
 * JD-Core Version:    0.7.0.1
 */