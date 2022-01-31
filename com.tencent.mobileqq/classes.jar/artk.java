import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import com.idlefish.flutterboost.containers.BoostFlutterActivity.SerializableMap;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.flutter.container.QFlutterContainerFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class artk
{
  public static void a(Activity paramActivity, String paramString, Map<String, Object> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.router", 2, String.format("openPage: %s", new Object[] { paramString }));
    }
    boolean bool = asot.a("com.tencent.mobileqq:tool");
    Intent localIntent = new Intent();
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("click_millis", SystemClock.elapsedRealtime());
    localIntent.putExtra("preload_process", bool);
    if (paramMap != null)
    {
      paramString = new BoostFlutterActivity.SerializableMap();
      paramString.setMap(paramMap);
      localIntent.putExtra("params", paramString);
    }
    PublicFragmentActivityForTool.b(paramActivity, localIntent, QFlutterContainerFragment.class, 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     artk
 * JD-Core Version:    0.7.0.1
 */