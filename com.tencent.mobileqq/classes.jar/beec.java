import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class beec
{
  public static long a;
  public static WebViewPluginEngine a;
  public static final Object a;
  public static HashMap<Integer, beee> a;
  public static volatile boolean a;
  public static WebViewPluginEngine b;
  public static HashMap<Integer, beee> b;
  public static volatile boolean b;
  public static volatile boolean c;
  public static volatile boolean d;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    b = new HashMap();
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static void a()
  {
    if (System.currentTimeMillis() - jdField_a_of_type_Long > 3600000L)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.values().iterator();
      beee localbeee;
      HashMap localHashMap;
      while (localIterator.hasNext())
      {
        localbeee = (beee)localIterator.next();
        localHashMap = new HashMap(4);
        localHashMap.put("type", String.valueOf(localbeee.a));
        localHashMap.put("totalNum", String.valueOf(localbeee.b));
        localHashMap.put("hasProc", String.valueOf(localbeee.c));
        localHashMap.put("noProc", String.valueOf(localbeee.d));
        azri.a(BaseApplicationImpl.getApplication().getApplicationContext()).a(null, "actPreloadWebview", true, 0L, 0L, localHashMap, null);
      }
      localIterator = b.values().iterator();
      while (localIterator.hasNext())
      {
        localbeee = (beee)localIterator.next();
        localHashMap = new HashMap(4);
        localHashMap.put("type", String.valueOf(localbeee.a));
        localHashMap.put("totalNum", String.valueOf(localbeee.b));
        localHashMap.put("hasProc", String.valueOf(localbeee.c));
        localHashMap.put("noProc", String.valueOf(localbeee.d));
        azri.a(BaseApplicationImpl.getApplication().getApplicationContext()).a(null, "actJumpWebview", true, 0L, 0L, localHashMap, null);
      }
      jdField_a_of_type_JavaUtilHashMap.clear();
      b.clear();
      jdField_a_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("PreloadService", 2, "reportInterval...");
      }
    }
  }
  
  public static void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("_accelerator_mode_", 3);
    localBundle.putInt("from", paramInt);
    bejx.a().a(localBundle);
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getClass().getSimpleName().equals("ReaderRuntime");
  }
  
  public static void b(int paramInt)
  {
    int j = 0;
    Object localObject = (aosk)aoks.a().a(158);
    if ((localObject != null) && (((aosk)localObject).b == 1)) {
      return;
    }
    boolean bool = QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool");
    if (!bool)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("from", 305);
      ((Intent)localObject).setAction("com.tencent.mobileqq.webprocess.preload_web_process");
      ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
      ((Intent)localObject).putExtra("com.tencent.mobileqq.webprocess.start_time", System.currentTimeMillis());
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
      if (QLog.isColorLevel()) {
        QLog.d("PreloadService", 2, "preloadWebview...");
      }
    }
    localObject = new beee(paramInt);
    if (jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      localObject = (beee)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    }
    ((beee)localObject).b += 1;
    int k = ((beee)localObject).c;
    if (bool)
    {
      i = 1;
      label184:
      ((beee)localObject).c = (i + k);
      k = ((beee)localObject).d;
      if (!bool) {
        break label244;
      }
    }
    label244:
    for (int i = j;; i = 1)
    {
      ((beee)localObject).d = (k + i);
      jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localObject);
      if (((beee)localObject).b <= 3) {
        break;
      }
      a();
      return;
      i = 0;
      break label184;
    }
  }
  
  public static boolean b(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getClass().getSimpleName().equals("VipComicPluginRuntime");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beec
 * JD-Core Version:    0.7.0.1
 */