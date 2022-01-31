import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.Map;

public class bhtr
  extends WebViewPlugin
  implements bcbo
{
  private BroadcastReceiver a = new bhts(this);
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("QZoneCardPreDownload");
    localIntentFilter.addAction("action_facade_qzone2js");
    BaseApplication.getContext().registerReceiver(this.a, localIntentFilter);
  }
  
  public void b()
  {
    BaseApplication.getContext().unregisterReceiver(this.a);
  }
  
  public String[] getMultiNameSpace()
  {
    return new String[] { "qzcardstorre", "QzAvatar", "QzFloat" };
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 2L) && (paramString.equals(bhto.a))) {
      bhto.a(this.mRuntime, null);
    }
    return false;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePersonalizePlugin", 2, "handleJsRequest \n url: " + paramString1 + "\n pkgName:" + paramString2 + "\n method:" + paramString3);
    }
    if (bhqk.a(paramString3))
    {
      LocalMultiProcConfig.putBool("qzone_force_refresh", true);
      LocalMultiProcConfig.putBool("qzone_force_refresh_passive", true);
    }
    if (paramString2.equals("qzcardstorre"))
    {
      if (paramString3.equals("closecardpreview")) {
        return true;
      }
      if (paramString3.equals("setcardfinish")) {
        bhtg.a(this, this.mRuntime, paramVarArgs);
      }
      if (paramString3.equals("downloadcard"))
      {
        bhtg.a(this.mRuntime, paramVarArgs);
        return true;
      }
    }
    else
    {
      if (!paramString2.equals("QzAvatar")) {
        break label208;
      }
      if (!paramString3.equals("downloadAvatar")) {
        break label162;
      }
      bhtm.b(this.mRuntime, paramVarArgs);
    }
    label162:
    label208:
    do
    {
      do
      {
        for (;;)
        {
          return false;
          if (paramString3.equals("setAvatar")) {
            bhtm.a(this.mRuntime, paramVarArgs);
          } else if (paramString3.equalsIgnoreCase("checkIdList")) {
            bhtm.c(this.mRuntime, new String[0]);
          }
        }
      } while (!paramString2.equals("QzFloat"));
      if (paramString3.equals("downloadFloat"))
      {
        bhto.a(this.mRuntime, paramVarArgs);
        return true;
      }
    } while (!paramString3.equals("setFloat"));
    bhto.b(this.mRuntime, paramVarArgs);
    return true;
  }
  
  public void onCreate()
  {
    super.onCreate();
    a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhtr
 * JD-Core Version:    0.7.0.1
 */