import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.SonicTemplateUpdateManager.1;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sonic.sdk.SonicEngine;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;

public class bhom
  implements Manager
{
  QQAppInterface a;
  
  public bhom(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private JSONObject a()
  {
    File localFile = new File(this.a.getApplication().getFilesDir() + File.separator + "sonicTemplateUpdate.json");
    if (localFile.exists()) {
      try
      {
        JSONObject localJSONObject = new JSONObject(FileUtils.readFileContent(localFile));
        return localJSONObject;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SonicTemplateUpdateManager", 2, "getJsonOOM,json_name:sonicTemplateUpdate.json", localThrowable);
        }
        localFile.delete();
      }
    }
    for (;;)
    {
      return null;
      ((VasQuickUpdateManager)this.a.getManager(QQManagerFactory.VAS_QUICKUPDATE_MANAGER)).downloadItem(1001L, "sonicTemplateUpdate.json", "getJSONFromLocal");
    }
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    boolean bool = bhpw.a().a(this.a, paramJSONObject);
    if (QLog.isColorLevel()) {
      QLog.d("SonicTemplateUpdateManager", 2, "isConfigValid isValid = " + bool);
    }
    return bool;
  }
  
  public void a()
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SonicTemplateUpdateManager", 2, "parseJson isMainThread = " + bool);
      }
      if (!bool) {
        break;
      }
      ThreadManager.post(new SonicTemplateUpdateManager.1(this), 5, null, true);
      return;
    }
    b();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SonicTemplateUpdateManager", 2, "parseJson begin");
    }
    Object localObject1 = a();
    if (localObject1 == null)
    {
      QLog.e("SonicTemplateUpdateManager", 1, "parseJson rootObj = null");
      return;
    }
    Object localObject4 = ((JSONObject)localObject1).optJSONArray("sonicTemplateUpdate");
    if ((localObject4 == null) || (((JSONArray)localObject4).length() < 1))
    {
      QLog.e("SonicTemplateUpdateManager", 1, "parseJson configs = null or len < 1");
      return;
    }
    for (;;)
    {
      try
      {
        int j = ((JSONArray)localObject4).length();
        localObject3 = new HashMap();
        i = 0;
        if (i >= j) {
          break label222;
        }
        localObject5 = ((JSONArray)localObject4).getJSONObject(i);
        if (!a((JSONObject)localObject5)) {
          break label430;
        }
        String str = ((JSONObject)localObject5).optString("url");
        if (TextUtils.isEmpty(str)) {
          break label430;
        }
        localObject1 = null;
        if (WebAccelerateHelper.getSonicEngine() != null) {
          localObject1 = SonicEngine.makeSessionId(str, true);
        }
        if (localObject1 == null) {
          QLog.e("SonicTemplateUpdateManager", 1, "parseJsonRunnable sonicSessionId = null, url = " + str);
        }
      }
      catch (Exception localException)
      {
        QLog.e("SonicTemplateUpdateManager", 1, "parseJsonRunnable exception e = " + localException.getMessage());
        return;
      }
      ((Map)localObject3).put(localException, Long.valueOf(((JSONObject)localObject5).optLong("templateUpdateTime")));
      break label430;
      label222:
      if (((Map)localObject3).size() <= 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SonicTemplateUpdateManager", 2, "parseJsonRunnable ready remove expire sonic template");
      }
      if (!WebProcessManager.c())
      {
        localObject2 = WebAccelerateHelper.getSonicEngine();
        if (localObject2 == null) {
          break;
        }
        ((SonicEngine)localObject2).removeExpiredSessionCache((Map)localObject3);
        return;
      }
      QLog.d("SonicTemplateUpdateManager", 1, "parseJsonRunnable WebProcess Exist");
      Object localObject2 = new Intent(BaseApplicationImpl.getApplication(), WebProcessReceiver.class);
      ((Intent)localObject2).setAction("action_delete_sonic_templateinfo");
      localObject4 = ((Map)localObject3).keySet();
      Object localObject3 = ((Map)localObject3).values();
      localObject4 = (String[])((Set)localObject4).toArray(new String[((Set)localObject4).size()]);
      Object localObject5 = new long[((Collection)localObject3).size()];
      localObject3 = ((Collection)localObject3).iterator();
      int i = 0;
      while (((Iterator)localObject3).hasNext()) {
        if (i < localObject5.length)
        {
          localObject5[i] = ((Long)((Iterator)localObject3).next()).longValue();
          i += 1;
        }
      }
      ((Intent)localObject2).putExtra("com.tencent.mobileqq.webprocess.sonic_template_delete_sessionId", (String[])localObject4);
      ((Intent)localObject2).putExtra("com.tencent.mobileqq.webprocess.sonic_template_delete_updateTime", (long[])localObject5);
      BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject2, "com.tencent.msg.permission.pushnotify");
      return;
      label430:
      i += 1;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhom
 * JD-Core Version:    0.7.0.1
 */