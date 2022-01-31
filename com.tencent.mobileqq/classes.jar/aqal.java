import android.app.Activity;
import android.content.Intent;
import com.idlefish.flutterboost.containers.BoostFlutterActivity.SerializableMap;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.flutter.container.QFlutterContainerFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class aqal
{
  public static void a(Activity paramActivity, String paramString, Map<String, Object> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.router", 2, String.format("openPage: %s", new Object[] { paramString }));
    }
    boolean bool = aqyf.a("com.tencent.mobileqq:tool");
    Intent localIntent = new Intent();
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("click_millis", System.currentTimeMillis());
    localIntent.putExtra("process_exist", bool);
    if (paramMap != null)
    {
      paramString = new BoostFlutterActivity.SerializableMap();
      paramString.setMap(paramMap);
      localIntent.putExtra("params", paramString);
    }
    PublicFragmentActivityForTool.b(paramActivity, localIntent, QFlutterContainerFragment.class, 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqal
 * JD-Core Version:    0.7.0.1
 */