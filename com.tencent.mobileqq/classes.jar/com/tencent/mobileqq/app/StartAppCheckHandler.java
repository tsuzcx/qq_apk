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
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
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
import mqq.app.MobileQQ;
import mqq.observer.BusinessObserver;
import znc;
import znd;
import zne;
import znf;
import zng;
import znh;

public class StartAppCheckHandler
  extends BusinessHandler
  implements BusinessObserver
{
  final int jdField_a_of_type_Int = 1;
  public Activity a;
  private Handler jdField_a_of_type_AndroidOsHandler = new znc(this, Looper.getMainLooper());
  public BrowserAppInterface a;
  public Runnable a;
  public Queue a;
  public znf a;
  public znh a;
  public boolean a;
  final int jdField_b_of_type_Int = 2;
  private Handler jdField_b_of_type_AndroidOsHandler = new znd(this, Looper.getMainLooper());
  public AppInterface b;
  final int c = 3;
  
  public StartAppCheckHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = null;
    this.jdField_b_of_type_ComTencentCommonAppAppInterface = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_JavaLangRunnable = new zne(this);
    this.jdField_b_of_type_ComTencentCommonAppAppInterface = paramQQAppInterface;
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
    StatisticCollector.a(BaseApplication.getContext()).a(null, "AppOpenUrl", true, 0L, 0L, localHashMap, null);
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package:server result code ok");
    }
    Object localObject2 = new signature.SignatureResult();
    Object localObject1;
    try
    {
      ((signature.SignatureResult)localObject2).mergeFrom(paramArrayOfByte);
      if (((signature.SignatureResult)localObject2).str_packname.get().equalsIgnoreCase("MobileQQ"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package:MobileQQ fail");
        }
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package:sigResult parse fail");
          }
          paramArrayOfByte.printStackTrace();
        }
        if ((((signature.SignatureResult)localObject2).has()) && (((signature.SignatureResult)localObject2).str_packname.has()) && (((signature.SignatureResult)localObject2).str_packname.get() != null) && (((signature.SignatureResult)localObject2).u32_check_result.has())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package:packname fail");
      return;
      paramArrayOfByte = ((signature.SignatureResult)localObject2).str_packname.get();
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_Znf.jdField_b_of_type_Long = Long.valueOf(l).longValue();
      if (((signature.SignatureResult)localObject2).u32_timeout.has()) {
        this.jdField_a_of_type_Znf.jdField_a_of_type_Long = ((signature.SignatureResult)localObject2).u32_timeout.get();
      }
      if (((signature.SignatureResult)localObject2).u32_check_result.has()) {
        this.jdField_a_of_type_Znf.jdField_a_of_type_Int = ((signature.SignatureResult)localObject2).u32_check_result.get();
      }
      if (((signature.SignatureResult)localObject2).str_title.has()) {
        this.jdField_a_of_type_Znf.jdField_c_of_type_JavaLangString = ((signature.SignatureResult)localObject2).str_title.get();
      }
      if (((signature.SignatureResult)localObject2).str_content.has()) {
        this.jdField_a_of_type_Znf.d = ((signature.SignatureResult)localObject2).str_content.get();
      }
      if (((signature.SignatureResult)localObject2).str_left_button.has()) {
        this.jdField_a_of_type_Znf.e = ((signature.SignatureResult)localObject2).str_left_button.get();
      }
      if (((signature.SignatureResult)localObject2).str_right_button.has()) {
        this.jdField_a_of_type_Znf.f = ((signature.SignatureResult)localObject2).str_right_button.get();
      }
      if (((signature.SignatureResult)localObject2).str_url.has()) {
        this.jdField_a_of_type_Znf.g = ((signature.SignatureResult)localObject2).str_url.get();
      }
      this.jdField_a_of_type_Znf.b();
      this.jdField_a_of_type_Znf = null;
      localObject1 = new LinkedList();
      switch (((signature.SignatureResult)localObject2).u32_check_result.get())
      {
      }
    }
    for (;;)
    {
      paramArrayOfByte = ((List)localObject1).iterator();
      while (paramArrayOfByte.hasNext())
      {
        localObject1 = (zng)paramArrayOfByte.next();
        this.jdField_a_of_type_JavaUtilQueue.remove(localObject1);
      }
      break;
      localObject2 = this.jdField_a_of_type_JavaUtilQueue.iterator();
      Object localObject4;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (zng)((Iterator)localObject2).next();
        if (((zng)localObject3).jdField_a_of_type_JavaLangString.equals(paramArrayOfByte))
        {
          ((List)localObject1).add(localObject3);
          localObject4 = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(2, localObject3);
          this.jdField_b_of_type_AndroidOsHandler.removeMessages(2, localObject3);
          this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject4);
        }
      }
      continue;
      Object localObject3 = this.jdField_a_of_type_JavaUtilQueue.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (zng)((Iterator)localObject3).next();
        if (((zng)localObject4).jdField_a_of_type_JavaLangString.equals(paramArrayOfByte))
        {
          ((List)localObject1).add(localObject4);
          this.jdField_b_of_type_AndroidOsHandler.removeMessages(2, localObject4);
          localObject4 = new Intent(this.jdField_b_of_type_ComTencentCommonAppAppInterface.getApplication(), NotificationActivity.class);
          ((Intent)localObject4).putExtra("type", 9);
          Bundle localBundle = new Bundle();
          localBundle.putString("dlg_title", ((signature.SignatureResult)localObject2).str_title.get());
          localBundle.putString("dlg_content", ((signature.SignatureResult)localObject2).str_content.get());
          localBundle.putString("dlg_lbutton", ((signature.SignatureResult)localObject2).str_left_button.get());
          localBundle.putString("dlg_rbutton", ((signature.SignatureResult)localObject2).str_right_button.get());
          localBundle.putString("dlg_url", ((signature.SignatureResult)localObject2).str_url.get());
          ((Intent)localObject4).putExtras(localBundle);
          ((Intent)localObject4).setFlags(872415232);
          this.jdField_b_of_type_ComTencentCommonAppAppInterface.getApplication().startActivity((Intent)localObject4);
        }
      }
    }
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
    if ((paramToServiceMsg == null) || (paramToServiceMsg.length() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package: server cmd is null");
      }
    }
    do
    {
      do
      {
        return;
      } while (!"SecCheckSigSvc.UploadReq".equalsIgnoreCase(paramToServiceMsg));
      if (QLog.isColorLevel()) {
        QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package:check result");
      }
    } while (!paramFromServiceMsg.isSuccess());
    a((byte[])paramObject);
  }
  
  public void a(String paramString, Context paramContext, Intent paramIntent)
  {
    QQBrowserActivity localQQBrowserActivity = (QQBrowserActivity)paramContext;
    this.jdField_a_of_type_AndroidAppActivity = localQQBrowserActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = ((BrowserAppInterface)localQQBrowserActivity.getAppRuntime());
    this.jdField_b_of_type_ComTencentCommonAppAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface;
    b(paramString, paramContext, paramIntent);
  }
  
  public void b(String paramString, Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppStartedHandler", 2, "<-- AppStartedObserver pkgName=" + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramContext != null) && (paramIntent != null)) {
      a(paramIntent.getStringExtra("report_open_type"), paramIntent.getStringExtra("report_url"), paramString, paramIntent.getStringExtra("report_from"), paramIntent.getStringExtra("report_click_origin"), paramIntent.getStringExtra("report_class_name"));
    }
    if ((true == this.jdField_a_of_type_Boolean) || (paramString == null))
    {
      paramContext.startActivity(paramIntent);
      return;
    }
    this.jdField_a_of_type_Znh = new znh(this, paramString);
    this.jdField_a_of_type_Znf = new znf(this, paramString);
    long l;
    if (Long.valueOf(System.currentTimeMillis()).longValue() < this.jdField_a_of_type_Znf.jdField_b_of_type_Long + 86400000L)
    {
      PackageInfo localPackageInfo = a(this.jdField_b_of_type_ComTencentCommonAppAppInterface.getApplication(), this.jdField_a_of_type_Znh.jdField_a_of_type_JavaLangString);
      if (localPackageInfo != null)
      {
        String str = SecUtil.getSignatureHash(localPackageInfo.signatures[0].toByteArray());
        l = new File(localPackageInfo.applicationInfo.sourceDir).lastModified();
        if ((this.jdField_a_of_type_Znf.jdField_c_of_type_Long == l) && (this.jdField_a_of_type_Znf.jdField_a_of_type_JavaLangString.equalsIgnoreCase(str)))
        {
          if (this.jdField_a_of_type_Znf.jdField_a_of_type_Int != 2)
          {
            paramContext.startActivity(paramIntent);
            return;
          }
          paramString = new Intent(this.jdField_b_of_type_ComTencentCommonAppAppInterface.getApplication(), NotificationActivity.class);
          paramString.putExtra("type", 9);
          paramContext = new Bundle();
          paramContext.putString("dlg_title", this.jdField_a_of_type_Znf.jdField_c_of_type_JavaLangString);
          paramContext.putString("dlg_content", this.jdField_a_of_type_Znf.d);
          paramContext.putString("dlg_lbutton", this.jdField_a_of_type_Znf.e);
          paramContext.putString("dlg_rbutton", this.jdField_a_of_type_Znf.f);
          paramContext.putString("dlg_url", this.jdField_a_of_type_Znf.g);
          paramString.putExtras(paramContext);
          paramString.setFlags(872415232);
          this.jdField_b_of_type_ComTencentCommonAppAppInterface.getApplication().startActivity(paramString);
          try
          {
            ReportController.b(null, "P_CliOper", "Safe_StartAppCheck", this.jdField_b_of_type_ComTencentCommonAppAppInterface.getAccount(), "startAppByCheckValid", this.jdField_a_of_type_Znf.jdField_b_of_type_JavaLangString, 0, 0, "", "", "", "");
            return;
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            return;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Znh.jdField_a_of_type_Long = Long.valueOf(this.jdField_b_of_type_ComTencentCommonAppAppInterface.getAccount()).longValue();
        this.jdField_a_of_type_Znh.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_Znh.jdField_a_of_type_JavaLangString = paramString;
        paramString = new zng(this, paramString, paramContext, paramIntent);
        this.jdField_a_of_type_JavaUtilQueue.offer(paramString);
        paramContext = new Message();
        paramContext.what = 2;
        paramContext.obj = paramString;
        this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramContext);
        paramString = this.jdField_a_of_type_AndroidOsHandler;
        if (this.jdField_a_of_type_Znf.jdField_a_of_type_Long <= 0L) {
          break label581;
        }
        l = this.jdField_a_of_type_Znf.jdField_a_of_type_Long;
        paramString.sendEmptyMessageDelayed(3, l);
        this.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AppStartedHandler", 2, "GetAccount Failed!");
      return;
      label581:
      l = 300L;
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean) {
      if (QLog.isColorLevel()) {
        QLog.d("AppStartedHandler", 2, "onReceive: onReceive Observer package:MobileQQ fail");
      }
    }
    while ((!paramBoolean) || (paramBundle == null)) {
      return;
    }
    a(paramBundle.getByteArray("data"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.StartAppCheckHandler
 * JD-Core Version:    0.7.0.1
 */