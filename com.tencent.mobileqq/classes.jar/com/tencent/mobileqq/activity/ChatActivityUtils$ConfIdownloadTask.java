package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.av.utils.download.BaseDownloadAsyncTask;
import com.tencent.av.utils.download.DownloadParams;
import com.tencent.av.utils.download.DownloadResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatActivityUtils$ConfIdownloadTask
  extends BaseDownloadAsyncTask
{
  ChatActivityUtils.OnDownloadAsyncTaskListener a;
  final String b;
  
  ChatActivityUtils$ConfIdownloadTask(String paramString, ChatActivityUtils.OnDownloadAsyncTaskListener paramOnDownloadAsyncTaskListener)
  {
    this.b = paramString;
    this.a = paramOnDownloadAsyncTaskListener;
  }
  
  public static void a(String paramString1, String paramString2, ChatActivityUtils.OnDownloadAsyncTaskListener paramOnDownloadAsyncTaskListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("https://pubacc.mobile.qq.com/mqqweb-rtx2qq/mqqweb/get_confid_by_discid?discid=");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getConfId, uin[");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("]");
    QLog.w(paramString1, 1, localStringBuilder.toString());
    paramString1 = new ConfIdownloadTask(paramString1, paramOnDownloadAsyncTaskListener);
    paramString2 = new ArrayList();
    paramOnDownloadAsyncTaskListener = new DownloadParams();
    paramOnDownloadAsyncTaskListener.a = ((String)localObject);
    paramOnDownloadAsyncTaskListener.d = 1000;
    paramOnDownloadAsyncTaskListener.e = 1000;
    paramOnDownloadAsyncTaskListener.c = 0;
    paramString2.add(paramOnDownloadAsyncTaskListener);
    paramString1.execute(new ArrayList[] { paramString2 });
  }
  
  @TargetApi(9)
  public void a(DownloadParams paramDownloadParams)
  {
    boolean bool = paramDownloadParams.f.f;
    int k = 0;
    int m = 0;
    int i = -100;
    if (bool)
    {
      try
      {
        paramDownloadParams = new String(paramDownloadParams.f.a, "UTF-8");
      }
      catch (Exception paramDownloadParams)
      {
        i = -1;
        if (QLog.isColorLevel())
        {
          localObject1 = this.b;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getConfId.Complete :");
          ((StringBuilder)localObject2).append(paramDownloadParams.toString());
          QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        paramDownloadParams = null;
      }
      localObject1 = paramDownloadParams;
      if (paramDownloadParams == null) {
        break label467;
      }
    }
    try
    {
      localObject1 = new JSONObject(paramDownloadParams);
      i = ((JSONObject)localObject1).getInt("retcode");
      if (QLog.isColorLevel())
      {
        localObject2 = this.b;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getConfId.Complete : retcode = ");
        ((StringBuilder)localObject3).append(i);
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
      if (i == 0)
      {
        localObject3 = ((JSONObject)localObject1).getJSONObject("result");
        if (localObject3 != null) {
          localObject1 = ((JSONObject)localObject3).getString("result_code");
        }
      }
    }
    catch (JSONException localJSONException1)
    {
      Object localObject3;
      int j;
      break label387;
    }
    catch (Exception localException1)
    {
      label273:
      label276:
      break label310;
    }
    try
    {
      if (((String)localObject1).equals("0"))
      {
        localObject2 = ((JSONObject)localObject3).getString("confidshort");
        localObject3 = ((JSONObject)localObject3).getString("pstnappid");
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).compareToIgnoreCase("null") != 0)) {
          i = Integer.valueOf((String)localObject2).intValue();
        }
      }
    }
    catch (JSONException localJSONException2)
    {
      break label390;
    }
    catch (Exception localException2)
    {
      break label313;
    }
    try
    {
      j = Integer.valueOf((String)localObject3).intValue();
      m = 0;
      k = i;
      i = m;
    }
    catch (JSONException localJSONException3)
    {
      break label276;
    }
    catch (Exception localException3)
    {
      break label273;
    }
    break label315;
    break label392;
    j = 0;
    i = -2;
    k = m;
    break label297;
    j = 0;
    k = m;
    label297:
    m = j;
    j = k;
    k = m;
    break label472;
    label310:
    Object localObject1 = null;
    label313:
    i = 0;
    label315:
    if (QLog.isColorLevel())
    {
      localObject2 = this.b;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("getConfId.Complete : errorCode = ");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(",ret = ");
      ((StringBuilder)localObject3).append(-4);
      QLog.i((String)localObject2, 2, ((StringBuilder)localObject3).toString());
    }
    j = i;
    i = -4;
    break label472;
    label387:
    localObject1 = null;
    label390:
    i = 0;
    label392:
    if (QLog.isColorLevel())
    {
      localObject2 = this.b;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("getConfId.Complete : errorCode = ");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(",ret = ");
      ((StringBuilder)localObject3).append(-3);
      QLog.i((String)localObject2, 2, ((StringBuilder)localObject3).toString());
    }
    j = i;
    i = -3;
    break label472;
    localObject1 = null;
    label467:
    j = 0;
    paramDownloadParams = (DownloadParams)localObject1;
    label472:
    localObject1 = this.b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getConfId.Complete, ret[");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append("], appId[");
    ((StringBuilder)localObject2).append(k);
    ((StringBuilder)localObject2).append("], confid[");
    ((StringBuilder)localObject2).append(j);
    ((StringBuilder)localObject2).append("], content[");
    ((StringBuilder)localObject2).append(paramDownloadParams);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    paramDownloadParams = this.a;
    if (paramDownloadParams != null)
    {
      paramDownloadParams.a(k, j);
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils.ConfIdownloadTask
 * JD-Core Version:    0.7.0.1
 */