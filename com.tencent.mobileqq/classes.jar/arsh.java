import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class arsh
  extends QIPCModule
{
  private ArrayList<arsk> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private volatile boolean jdField_a_of_type_Boolean;
  
  private arsh()
  {
    super("ListenTogetherIPCModuleWebClient");
  }
  
  public static arsh a()
  {
    return arsj.a();
  }
  
  private EIPCResult a(String arg1, Bundle paramBundle, int paramInt)
  {
    if ((!"action_status_changed".equals(???)) || (paramBundle == null)) {}
    for (;;)
    {
      return null;
      paramBundle = paramBundle.getString("data");
      try
      {
        paramBundle = new JSONObject(paramBundle);
        if (QLog.isColorLevel()) {
          QLog.d("ListenTogetherIPCModuleWebClient", 2, "statusChanged action:" + ??? + " data=" + paramBundle);
        }
        if (paramBundle != null) {
          synchronized (this.jdField_a_of_type_JavaUtilArrayList)
          {
            Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (localIterator.hasNext())
            {
              arsk localarsk = (arsk)localIterator.next();
              if (localarsk != null) {
                localarsk.a(paramBundle);
              }
            }
          }
        }
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          QLog.i("ListenTogetherIPCModuleWebClient", 1, "statusChanged error:" + paramBundle.getMessage());
          paramBundle = null;
        }
        ??? = new EIPCResult();
        ???.code = 0;
      }
    }
    return ???;
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("data", paramJSONObject.toString());
    QIPCClientHelper.getInstance().getClient().callServer("ListenTogetherIPCModuleMainServer", "action_status_changed", localBundle, null);
  }
  
  public static void a(JSONObject paramJSONObject, String paramString, EIPCResultCallback paramEIPCResultCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("data", paramJSONObject.toString());
    QIPCClientHelper.getInstance().getClient().callServer("ListenTogetherIPCModuleMainServer", paramString, localBundle, paramEIPCResultCallback);
  }
  
  public void a(arsk paramarsk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherIPCModuleWebClient", 2, "register callback:" + paramarsk);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramarsk)) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        ??? = a();
      }
      try
      {
        QIPCClientHelper.getInstance().register((QIPCModule)???);
        this.jdField_a_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("ListenTogetherIPCModuleWebClient", 2, "register real");
        }
      }
      catch (Exception localException)
      {
        synchronized (this.jdField_a_of_type_JavaUtilArrayList)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramarsk);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ListenTogetherIPCModuleWebClient", 2, "register mListenTogetherClient2WebCallbacks.size:" + this.jdField_a_of_type_JavaUtilArrayList.size());
          return;
          localException = localException;
          QLog.e("ListenTogetherIPCModuleWebClient", 1, "register ipc module error.", localException);
        }
      }
    }
  }
  
  public void b(arsk paramarsk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherIPCModuleWebClient", 2, "unregister callback:" + paramarsk + " mHasRegistered:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramarsk)) {}
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramarsk);
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogetherIPCModuleWebClient", 2, "unregister mListenTogetherClient2WebCallbacks.size:" + this.jdField_a_of_type_JavaUtilArrayList.size());
      }
      if ((!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) || (!this.jdField_a_of_type_Boolean)) {}
    }
    try
    {
      if (QIPCClientHelper.getInstance().getClient() != null)
      {
        QIPCClientHelper.getInstance().getClient().unRegisterModule(a());
        this.jdField_a_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.d("ListenTogetherIPCModuleWebClient", 2, "unregister real");
        }
      }
      return;
    }
    catch (Exception paramarsk)
    {
      QLog.e("ListenTogetherIPCModuleWebClient", 1, "unregister ipc module error.", paramarsk);
    }
    paramarsk = finally;
    throw paramarsk;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherIPCModuleWebClient", 2, "onCall, params=" + paramBundle + ", action=" + paramString + ", callBackId=" + paramInt);
    }
    if (paramBundle == null) {
      QLog.i("ListenTogetherIPCModuleWebClient", 1, "onCall, param is null, action=" + paramString + ", callBackId=" + paramInt);
    }
    while (!"action_status_changed".equals(paramString)) {
      return null;
    }
    return a(paramString, paramBundle, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arsh
 * JD-Core Version:    0.7.0.1
 */