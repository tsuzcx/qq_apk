package com.huawei.hms.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HmsMessageService
  extends Service
{
  public static final String PROXY_TYPE = "proxy_type";
  public static final String SUBJECT_ID = "subject_id";
  public final Messenger a = new Messenger(new HmsMessageService.a(this, null));
  
  public final Bundle a(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("message_id", paramIntent.getStringExtra("message_id"));
    localBundle.putByteArray("message_body", paramIntent.getByteArrayExtra("message_body"));
    localBundle.putString("device_token", paramIntent.getStringExtra("device_token"));
    if (paramIntent.getIntExtra("inputType", -1) == 1) {
      localBundle.putInt("inputType", 1);
    }
    return localBundle;
  }
  
  public final void a(Intent paramIntent, Bundle paramBundle, String paramString)
  {
    try
    {
      String str1 = paramIntent.getStringExtra("device_token");
      a(str1, paramString);
      Context localContext = getApplicationContext();
      String str2 = localContext.getPackageName();
      int i = 0;
      boolean bool = TextUtils.isEmpty(BaseUtils.getCacheData(localContext, str2, false));
      if ((paramBundle.isEmpty()) && ((bool ^ true)))
      {
        HMSLog.i("HmsMessageService", "onNewToken to host app.");
        onNewToken(str1);
        BaseUtils.deleteCacheData(localContext, localContext.getPackageName());
      }
      if (TextUtils.isEmpty(paramString))
      {
        paramString = BaseUtils.getSubjectIds(localContext);
        if ((paramString != null) && (paramString.length != 0))
        {
          while (i < paramString.length)
          {
            paramIntent = new Bundle();
            paramIntent.putString("subject_id", paramString[i]);
            paramBundle = new StringBuilder();
            paramBundle.append("onNewToken to sub app, subjectId:");
            paramBundle.append(paramString[i]);
            HMSLog.i("HmsMessageService", paramBundle.toString());
            onNewToken(str1, paramIntent);
            a(str1, paramString[i]);
            i += 1;
          }
          BaseUtils.clearSubjectIds(localContext);
        }
        else
        {
          HMSLog.i("HmsMessageService", "onNewToken to host app with bundle.");
          paramBundle.putString("belongId", paramIntent.getStringExtra("belongId"));
          onNewToken(str1, paramBundle);
        }
      }
      else
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onNewToken to sub app, subjectId:");
        paramIntent.append(paramString);
        HMSLog.i("HmsMessageService", paramIntent.toString());
        onNewToken(str1, paramBundle);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramIntent;
    }
  }
  
  public final void a(Intent paramIntent, String paramString)
  {
    int i = paramIntent.getIntExtra("error", ErrorEnum.SUCCESS.getInternalCode());
    a("push.onNewToken", paramString, i);
    String str = paramIntent.getStringExtra("subjectId");
    Object localObject = paramIntent.getStringExtra("message_proxy_type");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnNewToken:transactionId = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" , internalCode = ");
    localStringBuilder.append(i);
    localStringBuilder.append(",subjectId:");
    localStringBuilder.append(str);
    localStringBuilder.append(",proxyType:");
    localStringBuilder.append((String)localObject);
    HMSLog.i("HmsMessageService", localStringBuilder.toString());
    paramString = new Bundle();
    if (!TextUtils.isEmpty(str)) {
      paramString.putString("subject_id", str);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString.putString("proxy_type", (String)localObject);
    }
    if (i == ErrorEnum.SUCCESS.getInternalCode())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Apply token OnNewToken, subId: ");
      ((StringBuilder)localObject).append(str);
      HMSLog.i("HmsMessageService", ((StringBuilder)localObject).toString());
      a(paramIntent, paramString, str);
      return;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("Apply token failed, subId: ");
    paramIntent.append(str);
    HMSLog.i("HmsMessageService", paramIntent.toString());
    a(paramString, str, i);
  }
  
  public final void a(Bundle paramBundle, String paramString, int paramInt)
  {
    try
    {
      Object localObject1 = getApplicationContext();
      Object localObject2 = ((Context)localObject1).getPackageName();
      int i = 0;
      boolean bool = TextUtils.isEmpty(BaseUtils.getCacheData((Context)localObject1, (String)localObject2, false));
      if ((paramBundle.isEmpty()) && ((bool ^ true)))
      {
        HMSLog.i("HmsMessageService", "onTokenError to host app.");
        onTokenError(new BaseException(paramInt));
        BaseUtils.deleteCacheData((Context)localObject1, ((Context)localObject1).getPackageName());
      }
      if (TextUtils.isEmpty(paramString))
      {
        paramString = BaseUtils.getSubjectIds((Context)localObject1);
        if ((paramString != null) && (paramString.length != 0))
        {
          while (i < paramString.length)
          {
            paramBundle = new Bundle();
            paramBundle.putString("subject_id", paramString[i]);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onTokenError to sub app, subjectId:");
            ((StringBuilder)localObject2).append(paramString[i]);
            HMSLog.i("HmsMessageService", ((StringBuilder)localObject2).toString());
            onTokenError(new BaseException(paramInt), paramBundle);
            i += 1;
          }
          BaseUtils.clearSubjectIds((Context)localObject1);
        }
        else
        {
          HMSLog.i("HmsMessageService", "onTokenError to host app with bundle.");
          onTokenError(new BaseException(paramInt), paramBundle);
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onTokenError to sub app, subjectId:");
        ((StringBuilder)localObject1).append(paramString);
        HMSLog.i("HmsMessageService", ((StringBuilder)localObject1).toString());
        onTokenError(new BaseException(paramInt), paramBundle);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramBundle;
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Context localContext = getApplicationContext();
    if (!paramString1.equals(BaseUtils.getLocalToken(localContext, paramString2)))
    {
      HMSLog.i("HmsMessageService", "receive a token, refresh the local token");
      BaseUtils.saveToken(localContext, paramString2, paramString1);
      return;
    }
    BaseUtils.reportAaidToken(localContext, paramString1);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "null";
    }
    PushBiUtil.reportExit(getApplicationContext(), paramString1, str, paramInt);
  }
  
  public final void b(Intent paramIntent)
  {
    HMSLog.i("HmsMessageService", "parse batch response.");
    paramIntent = paramIntent.getStringExtra("batchMsgbody");
    if (TextUtils.isEmpty(paramIntent)) {
      return;
    }
    try
    {
      paramIntent = new JSONArray(paramIntent);
      int i = 0;
      while (i < paramIntent.length())
      {
        JSONObject localJSONObject = paramIntent.getJSONObject(i);
        String str1 = localJSONObject.optString("transactionId");
        String str2 = localJSONObject.optString("msgId");
        int j = localJSONObject.optInt("ret", ErrorEnum.ERROR_UNKNOWN.getInternalCode());
        if (ErrorEnum.SUCCESS.getInternalCode() == j) {
          b(str1, str2);
        } else {
          b(str1, str2, j);
        }
        i += 1;
      }
    }
    catch (JSONException paramIntent)
    {
      label118:
      break label118;
    }
    HMSLog.w("HmsMessageService", "parse batch response failed.");
  }
  
  public final void b(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onMessageSent, message id:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", transactionId: ");
    localStringBuilder.append(paramString1);
    HMSLog.i("HmsMessageService", localStringBuilder.toString());
    a("push.sendMessageRet", paramString1, ErrorEnum.SUCCESS.getInternalCode());
    onMessageSent(paramString2);
  }
  
  public final void b(String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSendError, message id:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" error:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", transactionId: ");
    localStringBuilder.append(paramString1);
    HMSLog.i("HmsMessageService", localStringBuilder.toString());
    a("push.sendMessageRet", paramString1, paramInt);
    onSendError(paramString2, new SendException(paramInt));
  }
  
  public void doMsgReceived(Intent paramIntent)
  {
    onMessageReceived(new RemoteMessage(a(paramIntent)));
  }
  
  public void handleIntentMessage(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      HMSLog.e("HmsMessageService", "receive message is null");
      return;
    }
    String str1 = paramIntent.getStringExtra("message_id");
    Object localObject = paramIntent.getStringExtra("message_type");
    String str2 = paramIntent.getStringExtra("transaction_id");
    if ("new_token".equals(localObject))
    {
      HMSLog.i("HmsMessageService", "onNewToken");
      a(paramIntent, str2);
      return;
    }
    if ("received_message".equals(localObject))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMessageReceived, message id:");
      ((StringBuilder)localObject).append(str1);
      HMSLog.i("HmsMessageService", ((StringBuilder)localObject).toString());
      a("push.receiveMessage", str1, ErrorEnum.SUCCESS.getInternalCode());
      doMsgReceived(paramIntent);
      return;
    }
    if ("sent_message".equals(localObject))
    {
      b(str2, str1);
      return;
    }
    if ("send_error".equals(localObject))
    {
      b(str2, str1, paramIntent.getIntExtra("error", ErrorEnum.ERROR_UNKNOWN.getInternalCode()));
      return;
    }
    if ("delivery".equals(localObject))
    {
      int i = paramIntent.getIntExtra("error", ErrorEnum.ERROR_APP_SERVER_NOT_ONLINE.getInternalCode());
      paramIntent = new StringBuilder();
      paramIntent.append("onMessageDelivery, message id:");
      paramIntent.append(str1);
      paramIntent.append(", status:");
      paramIntent.append(i);
      paramIntent.append(", transactionId: ");
      paramIntent.append(str2);
      HMSLog.i("HmsMessageService", paramIntent.toString());
      a("push.deliveryMessage", str2, i);
      onMessageDelivered(str1, new SendException(i));
      return;
    }
    if ("server_deleted_message".equals(localObject))
    {
      paramIntent = new StringBuilder();
      paramIntent.append("delete message, message id:");
      paramIntent.append(str1);
      HMSLog.i("HmsMessageService", paramIntent.toString());
      onDeletedMessages();
      return;
    }
    if ("batchSent".equals(localObject))
    {
      b(paramIntent);
      return;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("Receive unknown message: ");
    paramIntent.append((String)localObject);
    HMSLog.e("HmsMessageService", paramIntent.toString());
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    HMSLog.i("HmsMessageService", "start to bind");
    return this.a.getBinder();
  }
  
  public void onDeletedMessages() {}
  
  public void onDestroy()
  {
    HMSLog.i("HmsMessageService", "start to destroy");
    super.onDestroy();
  }
  
  public void onMessageDelivered(String paramString, Exception paramException) {}
  
  public void onMessageReceived(RemoteMessage paramRemoteMessage) {}
  
  public void onMessageSent(String paramString) {}
  
  public void onNewToken(String paramString) {}
  
  public void onNewToken(String paramString, Bundle paramBundle) {}
  
  public void onSendError(String paramString, Exception paramException) {}
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start to command , startId = ");
    localStringBuilder.append(paramInt2);
    HMSLog.i("HmsMessageService", localStringBuilder.toString());
    handleIntentMessage(paramIntent);
    return 2;
  }
  
  public void onTokenError(Exception paramException) {}
  
  public void onTokenError(Exception paramException, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.push.HmsMessageService
 * JD-Core Version:    0.7.0.1
 */