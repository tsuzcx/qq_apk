import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.EnterCallback;

final class blup
  implements EnterCallback
{
  public void onCloseLoadingView() {}
  
  public void onEnterComplete()
  {
    QLog.i("IlivePluginHelper", 1, "Ilive finish preloadOdexPlugin");
    blvi.b("ilive_monitor_preload_odex");
  }
  
  public void onShowLoadingView(View paramView)
  {
    QLog.i("IlivePluginHelper", 1, "Ilive start preloadOdexPlugin");
    blvi.a("ilive_monitor_preload_odex");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blup
 * JD-Core Version:    0.7.0.1
 */