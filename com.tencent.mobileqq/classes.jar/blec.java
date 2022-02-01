import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.EnterCallback;
import mqq.app.AppRuntime;

public class blec
{
  private static int a = -1;
  
  public static void a(Context paramContext)
  {
    QLog.i("IlivePluginHelper", 1, "Ilive start preloadOdexPlugin");
    blef.a().enter(paramContext, 1002L, BaseApplicationImpl.getApplication().getRuntime().getAccount(), "", new Bundle(), null);
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString, EnterCallback paramEnterCallback)
  {
    if (paramIntent != null) {}
    for (paramIntent = paramIntent.getExtras();; paramIntent = null)
    {
      Object localObject = paramIntent;
      if (paramIntent == null) {
        localObject = new Bundle();
      }
      ((Bundle)localObject).putString("KEY_ACTIVITY_CLASSNAME", paramString);
      ((Bundle)localObject).putLong("start_plugin_act_begin_time", System.currentTimeMillis());
      blef.a().enter(paramContext, 1003L, BaseApplicationImpl.getApplication().getRuntime().getAccount(), "", (Bundle)localObject, paramEnterCallback);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blec
 * JD-Core Version:    0.7.0.1
 */