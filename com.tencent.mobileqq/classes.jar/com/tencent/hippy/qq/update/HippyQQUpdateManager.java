package com.tencent.hippy.qq.update;

import android.text.TextUtils;
import com.tencent.hippy.qq.api.PackageUpdateListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HippyQQUpdateManager
  implements ReqCallBack
{
  private PackageUpdateListener mUpdateListener;
  
  public static String getGuid()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null) {
      localObject = ((AppRuntime)localObject).getAccount();
    } else {
      localObject = "0";
    }
    int i = 32;
    StringBuffer localStringBuffer = new StringBuffer();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      i = 32 - ((String)localObject).length();
      localStringBuffer.append((String)localObject);
    }
    int j = 0;
    while (j < i)
    {
      localStringBuffer.append("0");
      j += 1;
    }
    return localStringBuffer.toString();
  }
  
  public void checkUpdate(String paramString, PackageUpdateListener paramPackageUpdateListener)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        this.mUpdateListener = paramPackageUpdateListener;
        int j = UpdateSetting.getInstance().getModuleVersion(paramString);
        int i = j;
        if (j < 0) {
          i = 0;
        }
        sendUpdateRequest(paramString, i, this);
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      if (paramPackageUpdateListener != null) {
        paramPackageUpdateListener.onUpdateComplete(1, "", null);
      }
    }
  }
  
  public void loadOnlineBundle(String paramString1, String paramString2, PackageUpdateListener paramPackageUpdateListener)
  {
    ThreadManagerV2.excute(new HippyQQUpdateManager.2(this, paramString1, paramString2, paramPackageUpdateListener), 128, null, true);
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
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Hippy: onResponse iResult=");
          ((StringBuilder)localObject).append(i);
          QLog.d("Hippy", 2, ((StringBuilder)localObject).toString());
        }
        if (i == 0)
        {
          paramString = paramString.getJSONArray("vstModules");
          if ((paramString.length() != 0) || (this.mUpdateListener == null)) {
            break label415;
          }
          this.mUpdateListener.onUpdateComplete(1, "", null);
          break label415;
          if (i < paramString.length())
          {
            JSONObject localJSONObject = paramString.getJSONObject(i);
            localJSONObject.getInt("iUpdateType");
            int j = localJSONObject.getInt("iVersionCode");
            localJSONObject.getString("sMaxAppVer");
            localJSONObject.getString("sMinAppVer");
            localJSONObject.getString("sMaxSdkVer");
            localJSONObject.getString("sMinSdkVer");
            localObject = localJSONObject.getString("sModuleName");
            localJSONObject.getString("sVersionName");
            localJSONObject = localJSONObject.getJSONObject("stTotalPkg");
            String str = localJSONObject.getString("sUrl");
            int k = localJSONObject.getInt("iSize");
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Hippy: onResponse moduleName=");
              localStringBuilder.append((String)localObject);
              localStringBuilder.append(", version=");
              localStringBuilder.append(j);
              localStringBuilder.append(", size=");
              localStringBuilder.append(k);
              QLog.d("Hippy", 2, localStringBuilder.toString());
            }
            new UpdateTotal(str, localJSONObject.getString("sMd5"), null, (String)localObject, j, this.mUpdateListener).startDownload();
            i += 1;
            continue;
          }
        }
        else if (this.mUpdateListener != null)
        {
          paramString = new StringBuilder();
          paramString.append("check update result: ");
          paramString.append(i);
          paramString = paramString.toString();
          this.mUpdateListener.onUpdateComplete(-5, paramString, null);
          return;
        }
      }
      catch (JSONException paramString)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          paramString = paramString.getMessage();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Hippy: onResponse JSONException msg=");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("Hippy", 2, ((StringBuilder)localObject).toString());
        }
      }
      return;
      label415:
      int i = 0;
    }
  }
  
  void sendUpdateRequest(String paramString, int paramInt, ReqCallBack paramReqCallBack)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("iPlatform", 0);
    localJSONObject2.put("sAppKey", "mqq");
    localJSONObject2.put("sAppVer", "8.7.0.5295");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyQQUpdateManager
 * JD-Core Version:    0.7.0.1
 */