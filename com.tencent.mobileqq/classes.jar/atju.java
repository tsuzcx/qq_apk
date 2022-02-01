import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.idlefish.flutterboost.containers.BoostFlutterActivity.SerializableMap;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.flutter.channel.qqcircle.QCircleFlutterContainerFragment;
import com.tencent.mobileqq.flutter.container.QFlutterContainerFragment;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Map;

public class atju
{
  public static void a(Activity paramActivity, String paramString, Map<String, Object> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.router", 2, String.format("openPage: %s", new Object[] { paramString }));
    }
    boolean bool = aufo.a("com.tencent.mobileqq:tool");
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
  
  public static void a(Context paramContext, String paramString, Map<String, Object> paramMap, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.router", 2, String.format("openPage: %s", new Object[] { paramString }));
    }
    boolean bool = aufo.a("com.tencent.mobileqq:tool");
    Intent localIntent = new Intent();
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("click_millis", SystemClock.elapsedRealtime());
    localIntent.putExtra("preload_process", bool);
    localIntent.putExtra("moduleId", "qcircle_flutter");
    localIntent.putExtra("report_session", paramArrayOfByte);
    if (paramMap != null)
    {
      paramMap.put("statusbar_height", Integer.valueOf(ViewUtils.PxToDp(ImmersiveUtils.getStatusBarHeight(paramContext))));
      paramString = new BoostFlutterActivity.SerializableMap();
      paramString.setMap(paramMap);
      localIntent.putExtra("params", paramString);
    }
    PublicFragmentActivityForTool.b(paramContext, localIntent, QCircleFlutterContainerFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atju
 * JD-Core Version:    0.7.0.1
 */