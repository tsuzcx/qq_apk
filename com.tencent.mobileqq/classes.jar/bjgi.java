import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

class bjgi
  implements bleb
{
  private AsyncResult jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult;
  private String jdField_a_of_type_JavaLangString;
  
  public bjgi(bjgg parambjgg, String paramString, AsyncResult paramAsyncResult)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult = paramAsyncResult;
  }
  
  public HashSet<String> getFilterCmds()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("13169");
    return localHashSet;
  }
  
  public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    paramIntent = null;
    Object localObject = null;
    QLog.i("ThirdAppProxyImpl", 1, "onCmdRsp ret=" + paramLong + ",cmd=" + paramString + ",dataJson=" + paramJSONObject);
    AsyncResult localAsyncResult;
    if ("13169".equals(paramString))
    {
      try
      {
        localAsyncResult = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult;
        if (localAsyncResult == null) {
          return;
        }
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult = null;
        if (paramLong != 0L)
        {
          localAsyncResult.onReceiveResult(false, null);
          return;
        }
      }
      catch (Throwable paramIntent)
      {
        QLog.e("ThirdAppProxyImpl", 1, "exception. ", paramIntent);
        return;
      }
      paramString = localObject;
    }
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("v_appd_down_load_info");
        if (paramJSONObject == null) {
          break label186;
        }
        paramString = localObject;
        paramIntent = paramJSONObject.getJSONObject(0);
      }
      catch (Throwable paramIntent)
      {
        QLog.e("ThirdAppProxyImpl", 1, "exception. ", paramIntent);
        if (paramString == null) {
          break label179;
        }
      }
      paramString = paramIntent;
      localAsyncResult.onReceiveResult(bool, paramIntent);
      return;
      boolean bool = true;
      label162:
      localAsyncResult.onReceiveResult(bool, paramString);
      return;
      label179:
      label186:
      do
      {
        bool = false;
        break;
        bool = false;
        break label162;
        return;
      } while (paramIntent == null);
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjgi
 * JD-Core Version:    0.7.0.1
 */