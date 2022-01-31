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

public class aqwr
  extends QIPCModule
{
  private ArrayList<aqwu> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private volatile boolean jdField_a_of_type_Boolean;
  
  private aqwr()
  {
    super("ListenTogetherIPCModuleWebClient");
  }
  
  public static aqwr a()
  {
    return aqwt.a();
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
              aqwu localaqwu = (aqwu)localIterator.next();
              if (localaqwu != null) {
                localaqwu.a(paramBundle);
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
  
  public void a(aqwu paramaqwu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherIPCModuleWebClient", 2, "register callback:" + paramaqwu);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramaqwu)) {}
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
          this.jdField_a_of_type_JavaUtilArrayList.add(paramaqwu);
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
  
  public void b(aqwu paramaqwu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherIPCModuleWebClient", 2, "unregister callback:" + paramaqwu + " mHasRegistered:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramaqwu)) {}
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramaqwu);
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
    catch (Exception paramaqwu)
    {
      QLog.e("ListenTogetherIPCModuleWebClient", 1, "unregister ipc module error.", paramaqwu);
    }
    paramaqwu = finally;
    throw paramaqwu;
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
 * Qualified Name:     aqwr
 * JD-Core Version:    0.7.0.1
 */