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
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.plugin.PushProxy;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.android.HwBuildEx.VERSION;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions.NoOptions;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.push.task.BaseVoidTask;
import com.huawei.hms.push.task.IntentCallable;
import com.huawei.hms.push.task.SendUpStreamTask;
import com.huawei.hms.push.task.SubscribeTask;
import com.huawei.hms.push.utils.PushBiUtil;
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
  public static final Pattern a = Pattern.compile("[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
  public Context b;
  public HuaweiApi<Api.ApiOptions.NoOptions> c;
  
  public HmsMessaging(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    this.b = paramContext;
    Api localApi = new Api("HuaweiPush.API");
    if ((paramContext instanceof Activity)) {
      this.c = new HuaweiApi((Activity)paramContext, localApi, null, new PushClientBuilder());
    } else {
      this.c = new HuaweiApi(paramContext, localApi, null, new PushClientBuilder());
    }
    this.c.setKitSdkVersion(50101300);
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
  
  public final Task<Void> a(String paramString1, String paramString2)
  {
    str = PushBiUtil.reportEntry(this.b, "push.subscribe");
    if ((paramString1 != null) && (a.matcher(paramString1).matches())) {
      if (ProxyCenter.getProxy() != null)
      {
        HMSLog.i("HmsMessaging", "use proxy subscribe.");
        if (TextUtils.equals(paramString2, "Sub")) {
          return ProxyCenter.getProxy().subscribe(this.b, paramString1, str);
        }
        return ProxyCenter.getProxy().unsubscribe(this.b, paramString1, str);
      }
    }
    try
    {
      ErrorEnum localErrorEnum = d.a(this.b);
      if (localErrorEnum == ErrorEnum.SUCCESS)
      {
        if (NetWorkUtil.getNetworkType(this.b) != 0)
        {
          paramString1 = new SubscribeReq(this.b, paramString2, paramString1);
          paramString1.setToken(BaseUtils.getLocalToken(this.b, null));
          if (s.b()) {
            return this.c.doWrite(new BaseVoidTask("push.subscribe", JsonUtil.createJsonString(paramString1), str));
          }
          paramString1 = this.c.doWrite(new SubscribeTask("push.subscribe", JsonUtil.createJsonString(paramString1), str));
          return paramString1;
        }
        HMSLog.e("HmsMessaging", "no network");
        throw ErrorEnum.ERROR_NO_NETWORK.toApiException();
      }
      throw localErrorEnum.toApiException();
    }
    catch (ApiException paramString1)
    {
      paramString2 = new TaskCompletionSource();
      paramString2.setException(paramString1);
      PushBiUtil.reportExit(this.b, "push.subscribe", str, paramString1.getStatusCode());
      return paramString2.getTask();
      PushBiUtil.reportExit(this.b, "push.subscribe", str, ErrorEnum.ERROR_ARGUMENTS_INVALID);
      HMSLog.e("HmsMessaging", "Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
      throw new IllegalArgumentException("Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
    }
    catch (Exception paramString1)
    {
      label204:
      break label204;
    }
    paramString1 = new TaskCompletionSource();
    paramString1.setException(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
    PushBiUtil.reportExit(this.b, "push.subscribe", str, ErrorEnum.ERROR_INTERNAL_ERROR);
    return paramString1.getTask();
  }
  
  public final Task<Void> a(boolean paramBoolean)
  {
    String str = PushBiUtil.reportEntry(this.b, "push.setNotifyFlag");
    if ((s.d(this.b)) && (!s.b()))
    {
      if (HwBuildEx.VERSION.EMUI_SDK_INT < 12)
      {
        HMSLog.e("HmsMessaging", "operation not available on Huawei device with EMUI lower than 5.1");
        localObject1 = new TaskCompletionSource();
        ((TaskCompletionSource)localObject1).setException(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException());
        PushBiUtil.reportExit(this.b, "push.setNotifyFlag", str, ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED);
        return ((TaskCompletionSource)localObject1).getTask();
      }
      if (s.b(this.b) < 90101310L)
      {
        HMSLog.i("HmsMessaging", "turn on/off with broadcast v1");
        localObject1 = this.b;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.b.getPackageName());
        ((StringBuilder)localObject2).append("#");
        ((StringBuilder)localObject2).append(paramBoolean);
        localObject1 = PushEncrypter.encrypterOld((Context)localObject1, ((StringBuilder)localObject2).toString());
        localObject1 = new Intent("com.huawei.intent.action.SELF_SHOW_FLAG").putExtra("enalbeFlag", (String)localObject1);
        ((Intent)localObject1).setPackage("android");
        return Tasks.callInBackground(new IntentCallable(this.b, (Intent)localObject1, str));
      }
      HMSLog.i("HmsMessaging", "turn on/off with broadcast v2");
      new PushPreferences(this.b, "push_notify_flag").saveBoolean("notify_msg_enable", paramBoolean ^ true);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("content://");
      ((StringBuilder)localObject1).append(this.b.getPackageName());
      ((StringBuilder)localObject1).append(".huawei.push.provider/");
      ((StringBuilder)localObject1).append("push_notify_flag");
      ((StringBuilder)localObject1).append(".xml");
      localObject1 = Uri.parse(((StringBuilder)localObject1).toString());
      Object localObject2 = new Intent("com.huawei.android.push.intent.SDK_COMMAND");
      ((Intent)localObject2).putExtra("type", "enalbeFlag");
      ((Intent)localObject2).putExtra("pkgName", this.b.getPackageName());
      ((Intent)localObject2).putExtra("url", (Parcelable)localObject1);
      ((Intent)localObject2).setPackage("android");
      return Tasks.callInBackground(new IntentCallable(this.b, (Intent)localObject2, str));
    }
    HMSLog.i("HmsMessaging", "turn on/off with AIDL");
    Object localObject1 = new EnableNotifyReq();
    ((EnableNotifyReq)localObject1).setPackageName(this.b.getPackageName());
    ((EnableNotifyReq)localObject1).setEnable(paramBoolean);
    return this.c.doWrite(new BaseVoidTask("push.setNotifyFlag", JsonUtil.createJsonString((IMessageEntity)localObject1), str));
  }
  
  public final void a(RemoteMessage paramRemoteMessage)
  {
    String str = PushBiUtil.reportEntry(this.b, "push.sendMessage");
    Object localObject = d.a(this.b);
    if (localObject == ErrorEnum.SUCCESS)
    {
      if (!TextUtils.isEmpty(paramRemoteMessage.getTo()))
      {
        if (!TextUtils.isEmpty(paramRemoteMessage.getMessageId()))
        {
          if (!TextUtils.isEmpty(paramRemoteMessage.getData()))
          {
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
            if (s.b())
            {
              this.c.doWrite(new BaseVoidTask("push.sendMessage", JsonUtil.createJsonString((IMessageEntity)localObject), str));
              return;
            }
            a((UpSendMsgReq)localObject, str);
            return;
          }
          HMSLog.e("HmsMessaging", "Mandatory parameter 'data' missing");
          PushBiUtil.reportExit(this.b, "push.sendMessage", str, ErrorEnum.ERROR_ARGUMENTS_INVALID);
          throw new IllegalArgumentException("Mandatory parameter 'data' missing");
        }
        HMSLog.e("HmsMessaging", "Mandatory parameter 'message_id' missing");
        PushBiUtil.reportExit(this.b, "push.sendMessage", str, ErrorEnum.ERROR_ARGUMENTS_INVALID);
        throw new IllegalArgumentException("Mandatory parameter 'message_id' missing");
      }
      HMSLog.e("HmsMessaging", "Mandatory parameter 'to' missing");
      PushBiUtil.reportExit(this.b, "push.sendMessage", str, ErrorEnum.ERROR_ARGUMENTS_INVALID);
      throw new IllegalArgumentException("Mandatory parameter 'to' missing");
    }
    paramRemoteMessage = new StringBuilder();
    paramRemoteMessage.append("Message sent failed:");
    paramRemoteMessage.append(((ErrorEnum)localObject).getExternalCode());
    paramRemoteMessage.append(':');
    paramRemoteMessage.append(((ErrorEnum)localObject).getMessage());
    HMSLog.e("HmsMessaging", paramRemoteMessage.toString());
    PushBiUtil.reportExit(this.b, "push.sendMessage", str, (ErrorEnum)localObject);
    throw new UnsupportedOperationException(((ErrorEnum)localObject).getMessage());
  }
  
  public final void a(UpSendMsgReq paramUpSendMsgReq, String paramString)
  {
    paramUpSendMsgReq.setToken(BaseUtils.getLocalToken(this.b, null));
    try
    {
      HuaweiApi localHuaweiApi = this.c;
      localHuaweiApi.doWrite(new SendUpStreamTask("push.sendMessage", JsonUtil.createJsonString(paramUpSendMsgReq), paramString, paramUpSendMsgReq.getPackageName(), paramUpSendMsgReq.getMessageId()));
      return;
    }
    catch (Exception paramUpSendMsgReq)
    {
      if ((paramUpSendMsgReq.getCause() instanceof ApiException))
      {
        paramUpSendMsgReq = (ApiException)paramUpSendMsgReq.getCause();
        PushBiUtil.reportExit(this.b, "push.sendMessage", paramString, paramUpSendMsgReq.getStatusCode());
        return;
      }
      PushBiUtil.reportExit(this.b, "push.sendMessage", paramString, ErrorEnum.ERROR_INTERNAL_ERROR);
    }
  }
  
  public boolean isAutoInitEnabled()
  {
    return AutoInitHelper.isAutoInitEnabled(this.b);
  }
  
  public void send(RemoteMessage paramRemoteMessage)
  {
    if (ProxyCenter.getProxy() == null)
    {
      HMSLog.i("HmsMessaging", "send upstream message");
      a(paramRemoteMessage);
      return;
    }
    HMSLog.e("HmsMessaging", "Operation(send) unsupported");
    throw new UnsupportedOperationException("Operation(send) unsupported");
  }
  
  public void setAutoInitEnabled(boolean paramBoolean)
  {
    AutoInitHelper.setAutoInitEnabled(this.b, paramBoolean);
  }
  
  public Task<Void> subscribe(String paramString)
  {
    HMSLog.i("HmsMessaging", "invoke subscribe");
    return a(paramString, "Sub");
  }
  
  public Task<Void> turnOffPush()
  {
    if (ProxyCenter.getProxy() != null)
    {
      HMSLog.i("HmsMessaging", "turn off for proxy");
      return ProxyCenter.getProxy().turnOff(this.b, null);
    }
    HMSLog.i("HmsMessaging", "invoke turnOffPush");
    return a(false);
  }
  
  public Task<Void> turnOnPush()
  {
    if (ProxyCenter.getProxy() != null)
    {
      HMSLog.i("HmsMessaging", "turn on for proxy");
      return ProxyCenter.getProxy().turnOn(this.b, null);
    }
    HMSLog.i("HmsMessaging", "invoke turnOnPush");
    return a(true);
  }
  
  public Task<Void> unsubscribe(String paramString)
  {
    HMSLog.i("HmsMessaging", "invoke unsubscribe");
    return a(paramString, "UnSub");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.push.HmsMessaging
 * JD-Core Version:    0.7.0.1
 */