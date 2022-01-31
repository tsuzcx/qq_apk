import android.app.Activity;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;

public final class bdvq
{
  public static FlutterView a(Activity paramActivity, String paramString, FlutterNativeView paramFlutterNativeView)
  {
    FlutterMain.startInitialization(paramActivity.getApplicationContext());
    FlutterMain.ensureInitializationComplete(paramActivity.getApplicationContext(), null);
    if (paramFlutterNativeView != null) {}
    for (;;)
    {
      paramActivity = new bdvr(paramActivity, null, paramFlutterNativeView);
      if (paramString != null) {
        paramActivity.setInitialRoute(paramString);
      }
      paramActivity.setAlpha(0.0F);
      return paramActivity;
      paramFlutterNativeView = new FlutterNativeView(paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdvq
 * JD-Core Version:    0.7.0.1
 */