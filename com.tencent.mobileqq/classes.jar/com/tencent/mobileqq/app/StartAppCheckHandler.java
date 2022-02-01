package com.tencent.mobileqq.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.ims.signature.SignatureResult;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StartAppCheckHandler
  extends BusinessHandler
  implements mqq.observer.BusinessObserver
{
  final int jdField_a_of_type_Int = 1;
  Activity jdField_a_of_type_AndroidAppActivity = null;
  private Handler jdField_a_of_type_AndroidOsHandler = new StartAppCheckHandler.1(this, Looper.getMainLooper());
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  BrowserAppInterface jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = null;
  StartAppCheckHandler.CacheInfo jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo;
  StartAppCheckHandler.SendingAPP jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP;
  Runnable jdField_a_of_type_JavaLangRunnable = new StartAppCheckHandler.3(this);
  Queue<StartAppCheckHandler.PendingAPP> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  boolean jdField_a_of_type_Boolean = false;
  final int jdField_b_of_type_Int = 2;
  private Handler jdField_b_of_type_AndroidOsHandler = new StartAppCheckHandler.2(this, Looper.getMainLooper());
  final int c = 3;
  
  public StartAppCheckHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramQQAppInterface;
  }
  
  private PackageInfo a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getPackageInfo(paramString, 64);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("openType", paramString1);
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (paramString2.length() > 300) {
        paramString1 = paramString2.substring(0, 300);
      }
    }
    localHashMap.put("url", paramString1);
    localHashMap.put("appName", paramString3);
    localHashMap.put("from", paramString4);
    localHashMap.put("clickOrigin", paramString5);
    localHashMap.put("className", paramString6);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "AppOpenUrl", true, 0L, 0L, localHashMap, null);
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package:server result code ok");
    }
    Object localObject2 = new signature.SignatureResult();
    try
    {
      ((signature.SignatureResult)localObject2).mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package:sigResult parse fail");
      }
      paramArrayOfByte.printStackTrace();
    }
    if (!a((signature.SignatureResult)localObject2)) {
      return;
    }
    paramArrayOfByte = ((signature.SignatureResult)localObject2).str_packname.get();
    Object localObject1 = new LinkedList();
    int i = ((signature.SignatureResult)localObject2).u32_check_result.get();
    Object localObject3;
    if ((i != 0) && (i != 1))
    {
      if (i == 2) {
        localObject3 = this.jdField_a_of_type_JavaUtilQueue.iterator();
      }
    }
    else {
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (StartAppCheckHandler.PendingAPP)((Iterator)localObject3).next();
        if (((StartAppCheckHandler.PendingAPP)localObject4).jdField_a_of_type_JavaLangString.equals(paramArrayOfByte))
        {
          ((List)localObject1).add(localObject4);
          this.jdField_b_of_type_AndroidOsHandler.removeMessages(2, localObject4);
          localObject4 = new Intent();
          ((Intent)localObject4).putExtra("type", 9);
          Bundle localBundle = new Bundle();
          localBundle.putString("dlg_title", ((signature.SignatureResult)localObject2).str_title.get());
          localBundle.putString("dlg_content", ((signature.SignatureResult)localObject2).str_content.get());
          localBundle.putString("dlg_lbutton", ((signature.SignatureResult)localObject2).str_left_button.get());
          localBundle.putString("dlg_rbutton", ((signature.SignatureResult)localObject2).str_right_button.get());
          localBundle.putString("dlg_url", ((signature.SignatureResult)localObject2).str_url.get());
          ((Intent)localObject4).putExtras(localBundle);
          ((Intent)localObject4).setFlags(872415232);
          RouteUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), (Intent)localObject4, "/base/notification");
          continue;
          localObject2 = this.jdField_a_of_type_JavaUtilQueue.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (StartAppCheckHandler.PendingAPP)((Iterator)localObject2).next();
            if (((StartAppCheckHandler.PendingAPP)localObject3).jdField_a_of_type_JavaLangString.equals(paramArrayOfByte))
            {
              ((List)localObject1).add(localObject3);
              localObject4 = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(2, localObject3);
              this.jdField_b_of_type_AndroidOsHandler.removeMessages(2, localObject3);
              this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject4);
            }
          }
        }
      }
    }
    paramArrayOfByte = ((List)localObject1).iterator();
    while (paramArrayOfByte.hasNext())
    {
      localObject1 = (StartAppCheckHandler.PendingAPP)paramArrayOfByte.next();
      this.jdField_a_of_type_JavaUtilQueue.remove(localObject1);
    }
  }
  
  private boolean a(signature.SignatureResult paramSignatureResult)
  {
    if ((paramSignatureResult.has()) && (paramSignatureResult.str_packname.has()) && (paramSignatureResult.str_packname.get() != null) && (paramSignatureResult.u32_check_result.has()) && (!paramSignatureResult.str_packname.get().equalsIgnoreCase("MobileQQ")))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo.jdField_b_of_type_Long = System.currentTimeMillis();
      if (paramSignatureResult.u32_timeout.has()) {
        this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo.jdField_a_of_type_Long = paramSignatureResult.u32_timeout.get();
      }
      if (paramSignatureResult.u32_check_result.has()) {
        this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo.jdField_a_of_type_Int = paramSignatureResult.u32_check_result.get();
      }
      if (paramSignatureResult.str_title.has()) {
        this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo.jdField_c_of_type_JavaLangString = paramSignatureResult.str_title.get();
      }
      if (paramSignatureResult.str_content.has()) {
        this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo.d = paramSignatureResult.str_content.get();
      }
      if (paramSignatureResult.str_left_button.has()) {
        this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo.e = paramSignatureResult.str_left_button.get();
      }
      if (paramSignatureResult.str_right_button.has()) {
        this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo.f = paramSignatureResult.str_right_button.get();
      }
      if (paramSignatureResult.str_url.has()) {
        this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo.g = paramSignatureResult.str_url.get();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo.b();
      this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo = null;
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package:packname fail");
    }
    return false;
  }
  
  public void a(String paramString, Context paramContext, Intent paramIntent)
  {
    QQBrowserActivity localQQBrowserActivity = (QQBrowserActivity)paramContext;
    this.jdField_a_of_type_AndroidAppActivity = localQQBrowserActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = ((BrowserAppInterface)localQQBrowserActivity.getAppRuntime());
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface;
    b(paramString, paramContext, paramIntent);
  }
  
  public void b(String paramString, Context paramContext, Intent paramIntent)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<-- AppStartedObserver pkgName=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AppStartedHandler", 2, ((StringBuilder)localObject).toString());
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramContext != null) && (paramIntent != null)) {
      a(paramIntent.getStringExtra("report_open_type"), paramIntent.getStringExtra("report_url"), paramString, paramIntent.getStringExtra("report_from"), paramIntent.getStringExtra("report_click_origin"), paramIntent.getStringExtra("report_class_name"));
    }
    long l;
    if ((true != this.jdField_a_of_type_Boolean) && (paramString != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP = new StartAppCheckHandler.SendingAPP(this, paramString);
      this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo = new StartAppCheckHandler.CacheInfo(this, paramString);
      if (Long.valueOf(System.currentTimeMillis()).longValue() < this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo.jdField_b_of_type_Long + 86400000L)
      {
        localObject = a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.jdField_a_of_type_JavaLangString);
        if (localObject != null)
        {
          String str = SecUtil.getSignatureHash(localObject.signatures[0].toByteArray());
          l = new File(((PackageInfo)localObject).applicationInfo.sourceDir).lastModified();
          if ((this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo.jdField_c_of_type_Long == l) && (this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo.jdField_a_of_type_JavaLangString.equalsIgnoreCase(str)))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo.jdField_a_of_type_Int != 2)
            {
              if ((paramContext != null) && (paramIntent != null)) {
                paramContext.startActivity(paramIntent);
              }
            }
            else
            {
              paramString = new Intent();
              paramString.putExtra("type", 9);
              paramContext = new Bundle();
              paramContext.putString("dlg_title", this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo.jdField_c_of_type_JavaLangString);
              paramContext.putString("dlg_content", this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo.d);
              paramContext.putString("dlg_lbutton", this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo.e);
              paramContext.putString("dlg_rbutton", this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo.f);
              paramContext.putString("dlg_url", this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo.g);
              paramString.putExtras(paramContext);
              paramString.setFlags(872415232);
              RouteUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), paramString, "/base/notification");
              try
              {
                ReportController.b(null, "P_CliOper", "Safe_StartAppCheck", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), "startAppByCheckValid", this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo.jdField_b_of_type_JavaLangString, 0, 0, "", "", "", "");
                return;
              }
              catch (Exception paramString)
              {
                paramString.printStackTrace();
              }
            }
            return;
          }
        }
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()).longValue();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP;
      ((StartAppCheckHandler.SendingAPP)localObject).jdField_a_of_type_Int = 1;
      ((StartAppCheckHandler.SendingAPP)localObject).jdField_a_of_type_JavaLangString = paramString;
      paramString = new StartAppCheckHandler.PendingAPP(this, paramString, paramContext, paramIntent);
      this.jdField_a_of_type_JavaUtilQueue.offer(paramString);
      paramContext = new Message();
      paramContext.what = 2;
      paramContext.obj = paramString;
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramContext);
      paramString = this.jdField_a_of_type_AndroidOsHandler;
      if (this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo.jdField_a_of_type_Long > 0L) {
        l = this.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo.jdField_a_of_type_Long;
      } else {
        l = 300L;
      }
      paramString.sendEmptyMessageDelayed(3, l);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception paramString)
    {
      label578:
      break label578;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppStartedHandler", 2, "GetAccount Failed!");
    }
    return;
    if ((paramContext != null) && (paramIntent != null)) {
      paramContext.startActivity(paramIntent);
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppStartedHandler", 2, "onReceive: onReceive Observer package:MobileQQ fail");
      }
      return;
    }
    if ((paramBoolean) && (paramBundle != null)) {
      a(paramBundle.getByteArray("data"));
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
    if ((paramToServiceMsg != null) && (paramToServiceMsg.length() != 0))
    {
      if ("SecCheckSigSvc.UploadReq".equalsIgnoreCase(paramToServiceMsg))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package:check result");
        }
        if (paramFromServiceMsg.isSuccess()) {
          a((byte[])paramObject);
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package: server cmd is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.StartAppCheckHandler
 * JD-Core Version:    0.7.0.1
 */