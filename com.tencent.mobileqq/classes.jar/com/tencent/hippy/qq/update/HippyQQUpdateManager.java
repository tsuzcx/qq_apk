package com.tencent.hippy.qq.update;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HippyQQUpdateManager
  implements ReqCallBack
{
  private HippyQQUpdateManager.PackageUpdateListener mUpdateListener;
  
  private String getGuid()
  {
    Object localObject2 = "0";
    Object localObject3 = BaseApplicationImpl.getApplication();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((BaseApplicationImpl)localObject3).getRuntime();
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((AppRuntime)localObject3).getAccount();
      }
    }
    int i = 32;
    localObject2 = new StringBuffer();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      i = 32 - ((String)localObject1).length();
      ((StringBuffer)localObject2).append((String)localObject1);
    }
    int j = 0;
    while (j < i)
    {
      ((StringBuffer)localObject2).append("0");
      j += 1;
    }
    return ((StringBuffer)localObject2).toString();
  }
  
  public void checkUpdate(String paramString, int paramInt, HippyQQUpdateManager.PackageUpdateListener paramPackageUpdateListener)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        this.mUpdateListener = paramPackageUpdateListener;
        sendUpdateRequest(paramString, paramInt, this);
      }
      return;
    }
    catch (JSONException paramString)
    {
      do
      {
        paramString.printStackTrace();
      } while (paramPackageUpdateListener == null);
      paramPackageUpdateListener.onUpdateComplete(1, "", null);
    }
  }
  
  public void onResponse(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        i = paramString.getInt("iResult");
        if (QLog.isColorLevel()) {
          QLog.d("Hippy", 2, "Hippy: onResponse iResult=" + i);
        }
        if (i == 0)
        {
          paramString = paramString.getJSONArray("vstModules");
          if ((paramString.length() != 0) || (this.mUpdateListener == null)) {
            break label377;
          }
          this.mUpdateListener.onUpdateComplete(1, "", null);
          break label377;
          if (i >= paramString.length()) {
            break;
          }
          JSONObject localJSONObject = paramString.getJSONObject(i);
          localJSONObject.getInt("iUpdateType");
          int j = localJSONObject.getInt("iVersionCode");
          localJSONObject.getString("sMaxAppVer");
          localJSONObject.getString("sMinAppVer");
          localJSONObject.getString("sMaxSdkVer");
          localJSONObject.getString("sMinSdkVer");
          String str1 = localJSONObject.getString("sModuleName");
          localJSONObject.getString("sVersionName");
          localJSONObject = localJSONObject.getJSONObject("stTotalPkg");
          String str2 = localJSONObject.getString("sUrl");
          int k = localJSONObject.getInt("iSize");
          if (QLog.isColorLevel()) {
            QLog.d("Hippy", 2, "Hippy: onResponse moduleName=" + str1 + ", version=" + j + ", size=" + k);
          }
          new UpdateTotal(str2, localJSONObject.getString("sMd5"), null, str1, j, this.mUpdateListener).startDownload();
          i += 1;
          continue;
        }
        if (this.mUpdateListener == null) {
          break;
        }
        paramString = "check update result: " + i;
        this.mUpdateListener.onUpdateComplete(-5, paramString, null);
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      if (paramString != null) {}
      for (paramString = paramString.getMessage();; paramString = "")
      {
        QLog.d("Hippy", 2, "Hippy: onResponse JSONException msg=" + paramString);
        return;
      }
      label377:
      int i = 0;
    }
  }
  
  void sendUpdateRequest(String paramString, int paramInt, ReqCallBack paramReqCallBack)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("iPlatform", 0);
    localJSONObject2.put("sAppKey", "mqq");
    localJSONObject2.put("sAppVer", "8.4.8.4810");
    localJSONObject2.put("sSdkVer", "3.0");
    localJSONObject2.put("sChannel", "10001");
    localJSONObject2.put("sGuid", getGuid());
    localJSONObject1.put("stAppInfo", localJSONObject2);
    localJSONObject2 = new JSONObject();
    localJSONObject2.put("eType", 1);
    localJSONObject2.put("iVersionCode", paramInt);
    localJSONObject2.put("sModuleName", paramString);
    paramString = new JSONArray();
    paramString.put(localJSONObject2);
    localJSONObject1.put("vstModuleInfos", paramString);
    ThreadManager.post(new HippyQQUpdateManager.1(this, localJSONObject1, paramReqCallBack), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyQQUpdateManager
 * JD-Core Version:    0.7.0.1
 */