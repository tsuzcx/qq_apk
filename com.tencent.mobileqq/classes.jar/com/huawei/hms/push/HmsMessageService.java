package com.huawei.hms.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.text.TextUtils;
import com.huawei.hms.aaid.task.ReportAaidToken;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HmsMessageService
  extends Service
{
  private final Messenger a = new Messenger(new HmsMessageService.a(this, null));
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      HMSLog.e("HmsMessageService", "receive message is null");
      return;
    }
    String str1 = paramIntent.getStringExtra("message_id");
    String str2 = paramIntent.getStringExtra("message_type");
    String str3 = paramIntent.getStringExtra("transaction_id");
    if ("new_token".equals(str2))
    {
      HMSLog.i("HmsMessageService", "onNewToken");
      a(paramIntent, str3);
      return;
    }
    if ("received_message".equals(str2))
    {
      HMSLog.i("HmsMessageService", "onMessageReceived, message id:" + str1);
      a("push.receiveMessage", str1, a.a.a());
      onMessageReceived(new RemoteMessage(b(paramIntent)));
      return;
    }
    if ("sent_message".equals(str2))
    {
      a(str3, str1);
      return;
    }
    if ("send_error".equals(str2))
    {
      b(str3, str1, paramIntent.getIntExtra("error", a.g.a()));
      return;
    }
    if ("delivery".equals(str2))
    {
      int i = paramIntent.getIntExtra("error", a.B.a());
      HMSLog.i("HmsMessageService", "onMessageDelivery, message id:" + str1 + ", status:" + i + ", transactionId: " + str3);
      a("push.deliveryMessage", str3, i);
      onMessageDelivered(str1, new SendException(i));
      return;
    }
    if ("server_deleted_message".equals(str2))
    {
      HMSLog.i("HmsMessageService", "delete message, message id:" + str1);
      onDeletedMessages();
      return;
    }
    if ("batchSent".equals(str2))
    {
      c(paramIntent);
      return;
    }
    HMSLog.e("HmsMessageService", "Receive unknown message: " + str2);
  }
  
  private void a(Intent paramIntent, String paramString)
  {
    int i = paramIntent.getIntExtra("error", a.a.a());
    HMSLog.i("HmsMessageService", "doOnNewToken:transactionId = " + paramString + " , internalCode = " + i);
    a("push.onNewToken", paramString, i);
    if (i == a.a.a())
    {
      a(paramIntent.getStringExtra("device_token"));
      onNewToken(paramIntent.getStringExtra("device_token"));
      return;
    }
    onTokenError(new BaseException(i));
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Context localContext = getApplicationContext();
    ac localac = new ac(localContext, "push_client_self_info");
    localac.a("reqTokenTime", Long.valueOf(System.currentTimeMillis()));
    if (!paramString.equals(y.a(localContext, "push_client_self_info")))
    {
      HMSLog.i("HmsMessageService", "receive a token, refresh the local token");
      localac.d("token_info");
    }
    y.a(localContext, "push_client_self_info", paramString);
    ReportAaidToken.report(localContext, paramString);
  }
  
  private void a(String paramString1, String paramString2)
  {
    HMSLog.i("HmsMessageService", "onMessageSent, message id:" + paramString2 + ", transactionId: " + paramString1);
    a("push.sendMessageRet", paramString1, a.a.a());
    onMessageSent(paramString2);
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "null";
    }
    g.a(getApplicationContext(), paramString1, str, paramInt);
  }
  
  private Bundle b(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("message_id", paramIntent.getStringExtra("message_id"));
    localBundle.putByteArray("message_body", paramIntent.getByteArrayExtra("message_body"));
    localBundle.putString("device_token", paramIntent.getStringExtra("device_token"));
    if (1 == paramIntent.getIntExtra("inputType", -1)) {
      localBundle.putInt("inputType", 1);
    }
    return localBundle;
  }
  
  private void b(String paramString1, String paramString2, int paramInt)
  {
    HMSLog.i("HmsMessageService", "onSendError, message id:" + paramString2 + " error:" + paramInt + ", transactionId: " + paramString1);
    a("push.sendMessageRet", paramString1, paramInt);
    onSendError(paramString2, new SendException(paramInt));
  }
  
  private void c(Intent paramIntent)
  {
    HMSLog.i("HmsMessageService", "parse batch response.");
    paramIntent = paramIntent.getStringExtra("batchMsgbody");
    if (TextUtils.isEmpty(paramIntent)) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        paramIntent = new JSONArray(paramIntent);
        i = 0;
        if (i >= paramIntent.length()) {
          break;
        }
        JSONObject localJSONObject = paramIntent.getJSONObject(i);
        String str1 = localJSONObject.optString("transactionId");
        String str2 = localJSONObject.optString("msgId");
        int j = localJSONObject.optInt("ret", a.g.a());
        if (a.a.a() == j) {
          a(str1, str2);
        } else {
          b(str1, str2, j);
        }
      }
      catch (JSONException paramIntent)
      {
        HMSLog.w("HmsMessageService", "parse batch response failed.");
        return;
      }
      i += 1;
    }
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
  
  public void onSendError(String paramString, Exception paramException) {}
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    HMSLog.i("HmsMessageService", "start to command , startId = " + paramInt2);
    a(paramIntent);
    return 2;
  }
  
  public void onTokenError(Exception paramException) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.HmsMessageService
 * JD-Core Version:    0.7.0.1
 */