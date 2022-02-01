package com.tencent.aelight.camera.ae.flashshow;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class FlashShowDtReportHelper
{
  private static FlashShowDtReportHelper a;
  private String b;
  private String c;
  private String d;
  
  public static FlashShowDtReportHelper a()
  {
    if (a == null) {
      a = new FlashShowDtReportHelper();
    }
    return a;
  }
  
  private String a(String paramString)
  {
    return String.format(Locale.getDefault(), "%s_%s_%d_%d", new Object[] { paramString, ((IAccountRuntime)QRoute.api(IAccountRuntime.class)).getAccount(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(new Random().nextInt(100)) });
  }
  
  private String b(Activity paramActivity)
  {
    return a("android_camera_session_wink");
  }
  
  private String c(Activity paramActivity)
  {
    return "empty_activity_id";
  }
  
  private String e()
  {
    return a("android_session_wink");
  }
  
  public void a(Activity paramActivity)
  {
    this.b = e();
    this.c = b(paramActivity);
    this.d = c(paramActivity);
    paramActivity = new StringBuilder();
    paramActivity.append("session begin: sessionId = ");
    paramActivity.append(this.b);
    paramActivity.append(", cameraSessionId = ");
    paramActivity.append(this.c);
    AEQLog.b("FlashShowDtReportHelper", paramActivity.toString());
  }
  
  public void b()
  {
    this.b = null;
    this.c = null;
    this.d = null;
  }
  
  @NonNull
  public Map<String, Object> c()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("dt_appkey", "00000QG6YX3X0LZH");
    localHashMap.put("xsj_session_id", this.b);
    localHashMap.put("xsj_camera_session_id", this.c);
    localHashMap.put("xsj_operation_activity_id", this.d);
    return localHashMap;
  }
  
  @NonNull
  public HashMap<String, Object> d()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("dt_appkey", "00000QG6YX3X0LZH");
    localHashMap.put("xsj_session_id", this.b);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.FlashShowDtReportHelper
 * JD-Core Version:    0.7.0.1
 */