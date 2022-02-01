package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.android.HwBuildEx.VERSION;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions.NoOptions;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.entity.push.EnableNotifyReq;
import com.huawei.hms.support.api.entity.push.SubscribeReq;
import com.huawei.hms.support.api.entity.push.UpSendMsgReq;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.NetWorkUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HmsMessaging
{
  public static final String DEFAULT_TOKEN_SCOPE = "HCM";
  private static final Pattern a = Pattern.compile("[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
  private Context b;
  private HuaweiApi<Api.ApiOptions.NoOptions> c;
  
  private HmsMessaging(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    this.b = paramContext;
    Api localApi = new Api("HuaweiPush.API");
    if ((paramContext instanceof Activity)) {}
    for (this.c = new HuaweiApi((Activity)paramContext, localApi, null, new i());; this.c = new HuaweiApi(paramContext, localApi, null, new i()))
    {
      this.c.setKitSdkVersion(50002300);
      return;
    }
  }
  
  private Task<Void> a()
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    localTaskCompletionSource.setException(a.a(a.ad));
    return localTaskCompletionSource.getTask();
  }
  
  private Task<Void> a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (!a.matcher(paramString1).matches()))
    {
      g.a(this.b, "push.subscribe", paramString3, a.L);
      HMSLog.e("HmsMessaging", "Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
      throw new IllegalArgumentException("Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
    }
    try
    {
      HMSLog.i("HmsMessaging", "EMUI:" + HwBuildEx.VERSION.EMUI_SDK_INT);
      a locala = j.a(this.b);
      if (locala != a.a) {
        throw a.a(locala);
      }
    }
    catch (ApiException paramString1)
    {
      paramString2 = new TaskCompletionSource();
      paramString2.setException(paramString1);
      g.a(this.b, "push.subscribe", paramString3, paramString1.getStatusCode());
      return paramString2.getTask();
      if (NetWorkUtil.getNetworkType(this.b) == 0)
      {
        HMSLog.e("HmsMessaging", "no network");
        throw a.a(a.d);
      }
    }
    catch (Exception paramString1)
    {
      paramString1 = new TaskCompletionSource();
      paramString1.setException(a.a(a.M));
      g.a(this.b, "push.subscribe", paramString3, a.M);
      return paramString1.getTask();
    }
    paramString1 = new SubscribeReq(this.b.getPackageName(), paramString2, paramString1);
    paramString1.setToken(y.a(this.b, "push_client_self_info"));
    if (w.a()) {
      return this.c.doWrite(new b("push.subscribe", JsonUtil.createJsonString(paramString1), paramString3));
    }
    paramString1 = this.c.doWrite(new e("push.subscribe", JsonUtil.createJsonString(paramString1), paramString3));
    return paramString1;
  }
  
  private Task<Void> a(boolean paramBoolean, String paramString)
  {
    if ((!w.a(this.b)) || (w.a()))
    {
      HMSLog.i("HmsMessaging", "turn on/off with AIDL");
      localObject = new EnableNotifyReq();
      ((EnableNotifyReq)localObject).setPackageName(this.b.getPackageName());
      ((EnableNotifyReq)localObject).setEnable(paramBoolean);
      return this.c.doWrite(new b("push.setNotifyFlag", JsonUtil.createJsonString((IMessageEntity)localObject), paramString));
    }
    if (HwBuildEx.VERSION.EMUI_SDK_INT < 12)
    {
      HMSLog.e("HmsMessaging", "operation not available on Huawei device with EMUI lower than 5.1");
      localObject = new TaskCompletionSource();
      ((TaskCompletionSource)localObject).setException(a.a(a.ad));
      g.a(this.b, "push.setNotifyFlag", paramString, a.ad);
      return ((TaskCompletionSource)localObject).getTask();
    }
    if (w.b(this.b) < 90101310L)
    {
      HMSLog.i("HmsMessaging", "turn on/off with broadcast v1");
      localObject = PushEncrypter.encrypterOld(this.b, this.b.getPackageName() + "#" + paramBoolean);
      localObject = new Intent("com.huawei.intent.action.SELF_SHOW_FLAG").putExtra("enalbeFlag", (String)localObject);
      ((Intent)localObject).setPackage("android");
      return Tasks.callInBackground(new c(this.b, (Intent)localObject, paramString));
    }
    HMSLog.i("HmsMessaging", "turn on/off with broadcast v2");
    Object localObject = new ac(this.b, "push_notify_flag");
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((ac)localObject).a("notify_msg_enable", paramBoolean);
      localObject = Uri.parse("content://" + this.b.getPackageName() + ".huawei.push.provider/" + "push_notify_flag" + ".xml");
      Intent localIntent = new Intent("com.huawei.android.push.intent.SDK_COMMAND");
      localIntent.putExtra("type", "enalbeFlag");
      localIntent.putExtra("pkgName", this.b.getPackageName());
      localIntent.putExtra("url", (Parcelable)localObject);
      localIntent.setPackage("android");
      return Tasks.callInBackground(new c(this.b, localIntent, paramString));
    }
  }
  
  private void a(RemoteMessage paramRemoteMessage, String paramString)
  {
    Object localObject = j.a(this.b);
    if (localObject != a.a)
    {
      HMSLog.e("HmsMessaging", "Message sent failed:" + ((a)localObject).b() + ':' + ((a)localObject).c());
      g.a(this.b, "push.sendMessage", paramString, (a)localObject);
      throw new UnsupportedOperationException(((a)localObject).c());
    }
    if (TextUtils.isEmpty(paramRemoteMessage.getTo()))
    {
      HMSLog.e("HmsMessaging", "Mandatory parameter 'to' missing");
      g.a(this.b, "push.sendMessage", paramString, a.L);
      throw new IllegalArgumentException("Mandatory parameter 'to' missing");
    }
    if (TextUtils.isEmpty(paramRemoteMessage.getMessageId()))
    {
      HMSLog.e("HmsMessaging", "Mandatory parameter 'message_id' missing");
      g.a(this.b, "push.sendMessage", paramString, a.L);
      throw new IllegalArgumentException("Mandatory parameter 'message_id' missing");
    }
    if (TextUtils.isEmpty(paramRemoteMessage.getData()))
    {
      HMSLog.e("HmsMessaging", "Mandatory parameter 'data' missing");
      g.a(this.b, "push.sendMessage", paramString, a.L);
      throw new IllegalArgumentException("Mandatory parameter 'data' missing");
    }
    localObject = new UpSendMsgReq();
    ((UpSendMsgReq)localObject).setPackageName(this.b.getPackageName());
    ((UpSendMsgReq)localObject).setMessageId(paramRemoteMessage.getMessageId());
    ((UpSendMsgReq)localObject).setTo(paramRemoteMessage.getTo());
    ((UpSendMsgReq)localObject).setData(paramRemoteMessage.getData());
    ((UpSendMsgReq)localObject).setMessageType(paramRemoteMessage.getMessageType());
    ((UpSendMsgReq)localObject).setTtl(paramRemoteMessage.getTtl());
    ((UpSendMsgReq)localObject).setCollapseKey(paramRemoteMessage.getCollapseKey());
    ((UpSendMsgReq)localObject).setSendMode(paramRemoteMessage.getSendMode());
    ((UpSendMsgReq)localObject).setReceiptMode(paramRemoteMessage.getReceiptMode());
    if (w.a())
    {
      this.c.doWrite(new b("push.sendMessage", JsonUtil.createJsonString((IMessageEntity)localObject), paramString));
      return;
    }
    a((UpSendMsgReq)localObject, paramString);
  }
  
  private void a(UpSendMsgReq paramUpSendMsgReq, String paramString)
  {
    paramUpSendMsgReq.setToken(y.a(this.b, "push_client_self_info"));
    try
    {
      this.c.doWrite(new d("push.sendMessage", JsonUtil.createJsonString(paramUpSendMsgReq), paramString, paramUpSendMsgReq.getPackageName(), paramUpSendMsgReq.getMessageId()));
      return;
    }
    catch (Exception paramUpSendMsgReq)
    {
      if ((paramUpSendMsgReq.getCause() instanceof ApiException))
      {
        paramUpSendMsgReq = (ApiException)paramUpSendMsgReq.getCause();
        g.a(this.b, "push.sendMessage", paramString, paramUpSendMsgReq.getStatusCode());
        return;
      }
      g.a(this.b, "push.sendMessage", paramString, a.M);
    }
  }
  
  private Task<Void> b()
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    localTaskCompletionSource.setResult(null);
    return localTaskCompletionSource.getTask();
  }
  
  public static HmsMessaging getInstance(Context paramContext)
  {
    try
    {
      paramContext = new HmsMessaging(paramContext);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public boolean isAutoInitEnabled()
  {
    return AutoInitHelper.isAutoInitEnabled(this.b);
  }
  
  public void send(RemoteMessage paramRemoteMessage)
  {
    if (ProxyCenter.getInstance().getProxy() != null)
    {
      HMSLog.e("HmsMessaging", "Operation(send) unsupported");
      throw new UnsupportedOperationException("Operation(send) unsupported");
    }
    String str = g.a(this.b, "push.sendMessage");
    HMSLog.i("HmsMessaging", "send upstream message");
    a(paramRemoteMessage, str);
  }
  
  public void setAutoInitEnabled(boolean paramBoolean)
  {
    AutoInitHelper.setAutoInitEnabled(this.b, paramBoolean);
  }
  
  public Task<Void> subscribe(String paramString)
  {
    if (ProxyCenter.getInstance().getProxy() != null)
    {
      HMSLog.e("HmsMessaging", "Operation(subscribe) unsupported");
      return a();
    }
    String str = g.a(this.b, "push.subscribe");
    HMSLog.i("HmsMessaging", "invoke subscribe");
    return a(paramString, "Sub", str);
  }
  
  public Task<Void> turnOffPush()
  {
    if (ProxyCenter.getInstance().getProxy() != null)
    {
      HMSLog.i("HmsMessaging", "turn off for proxy");
      new ac(this.b, "push_notify_flag").a("notify_msg_enable", true);
      return b();
    }
    String str = g.a(this.b, "push.setNotifyFlag");
    HMSLog.i("HmsMessaging", "invoke turnOffPush");
    return a(false, str);
  }
  
  public Task<Void> turnOnPush()
  {
    if (ProxyCenter.getInstance().getProxy() != null)
    {
      HMSLog.i("HmsMessaging", "turn on for proxy");
      new ac(this.b, "push_notify_flag").a("notify_msg_enable", false);
      return b();
    }
    String str = g.a(this.b, "push.setNotifyFlag");
    HMSLog.i("HmsMessaging", "invoke turnOnPush");
    return a(true, str);
  }
  
  public Task<Void> unsubscribe(String paramString)
  {
    if (ProxyCenter.getInstance().getProxy() != null)
    {
      HMSLog.e("HmsMessaging", "Operation(unsubscribe) unsupported");
      return a();
    }
    String str = g.a(this.b, "push.subscribe");
    HMSLog.i("HmsMessaging", "invoke unsubscribe");
    return a(paramString, "UnSub", str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.HmsMessaging
 * JD-Core Version:    0.7.0.1
 */