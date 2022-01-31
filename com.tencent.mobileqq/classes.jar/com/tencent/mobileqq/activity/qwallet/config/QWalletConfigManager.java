package com.tencent.mobileqq.activity.qwallet.config;

import Wallet.ReqWalletConfig;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonServlet;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import wzl;
import wzm;
import wzn;

public class QWalletConfigManager
  implements Manager
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QWalletConfig jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public QWalletConfigManager(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletConfigManager", 2, "QWalletConfigManager init");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig = QWalletConfig.readConfig(paramQQAppInterface);
  }
  
  private Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {}
    try
    {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
      return this.jdField_a_of_type_AndroidOsHandler;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  private void a(long paramLong, QWalletConfigManager.ConfigListener paramConfigListener, String paramString, Map paramMap)
  {
    long l = 0L;
    int i = QWalletSetting.a("", "qwallet_config_last_appid", 0);
    if (i != AppSetting.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.seriesNo = 0L;
      QWalletSetting.a("", "qwallet_config_last_appid", AppSetting.jdField_a_of_type_Int);
      QLog.i("QWalletConfigManager", 2, "replace install:" + i + "|" + AppSetting.jdField_a_of_type_Int);
    }
    if (paramLong == 0L) {
      l = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.seriesNo;
    }
    ReqWalletConfig localReqWalletConfig = ReqWalletConfig.createReq(paramLong, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin(), l, paramString, paramMap);
    if (QLog.isColorLevel()) {
      QLog.d("QWalletConfigManager", 2, "realGetConfig:" + paramLong + "|" + paramConfigListener + "|" + paramString + "|" + paramMap + "|" + localReqWalletConfig);
    }
    QWalletCommonServlet.a(localReqWalletConfig, new wzm(this, paramLong, paramConfigListener, new WeakReference(this)));
  }
  
  private boolean a()
  {
    return Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) > 5000L;
  }
  
  private void c(int paramInt)
  {
    if (paramInt == 1) {}
  }
  
  public int a(String paramString, int paramInt, String... paramVarArgs)
  {
    return JSONParseUtils.a(a(paramString), paramInt, paramVarArgs);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.lastReqTime;
  }
  
  public QWalletConfig.ConfigInfo a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.getConfigInfo(paramString);
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.getConfig(paramString);
  }
  
  public String a(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    Object localObject2 = a(paramString1);
    paramString1 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      paramString1 = localObject1;
      if (localObject2 != null)
      {
        paramString1 = localObject1;
        if (((JSONObject)localObject2).has(paramString2)) {
          paramString1 = ((JSONObject)localObject2).optString(paramString2);
        }
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public String a(String paramString1, String paramString2, String... paramVarArgs)
  {
    return JSONParseUtils.a(a(paramString1), paramString2, paramVarArgs);
  }
  
  public JSONArray a(String paramString, String... paramVarArgs)
  {
    return JSONParseUtils.a(a(paramString), paramVarArgs);
  }
  
  public JSONObject a(String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.getParsedConfig(paramString);
    if ((paramString instanceof JSONObject)) {
      return (JSONObject)paramString;
    }
    return null;
  }
  
  public JSONObject a(String paramString, String... paramVarArgs)
  {
    return JSONParseUtils.a(a(paramString), paramVarArgs);
  }
  
  public void a()
  {
    WeakReference localWeakReference = new WeakReference(this);
    Handler localHandler = a();
    if (localHandler != null) {
      localHandler.postDelayed(new wzl(this, localWeakReference), 5000L);
    }
  }
  
  public void a(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.getValidReqOcca(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("QWalletConfigManager", 2, "tryGetConfig:" + paramInt + "|" + i + "|" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig);
    }
    if (i != -1)
    {
      if (!a()) {
        break label91;
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      b(i);
    }
    for (;;)
    {
      c(paramInt);
      return;
      label91:
      if (QLog.isColorLevel()) {
        QLog.d("QWalletConfigManager", 2, "tryGetConfig too frequently to req");
      }
    }
  }
  
  public void a(long paramLong, QWalletConfigManager.ConfigListener paramConfigListener, Map paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletConfigManager", 2, "getConfig:" + paramLong + "|" + paramMap + "|" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig);
    }
    if (paramLong == 0L) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.isValidToReq(paramLong))
    {
      a(paramLong, paramConfigListener, null, paramMap);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.notifyListener(paramConfigListener);
  }
  
  public void a(String paramString, QWalletConfigManager.ConfigUpdateListener paramConfigUpdateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.addUpdateListener(paramString, paramConfigUpdateListener);
  }
  
  public void a(Map paramMap)
  {
    if (paramMap == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletConfigManager", 2, "setConfig params is null");
      }
    }
    do
    {
      return;
      paramMap = ReqWalletConfig.createReq(0L, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.seriesNo, null, paramMap);
      QWalletCommonServlet.a(paramMap, 1, new wzn(this));
    } while (!QLog.isColorLevel());
    QLog.d("QWalletConfigManager", 2, "setConfig:" + paramMap);
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = a("pub_acc", "pay_puin_list");
      bool1 = bool2;
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      localObject = new JSONArray((String)localObject);
      bool1 = bool2;
      int i;
      if (localObject != null) {
        i = 0;
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < ((JSONArray)localObject).length())
        {
          bool1 = paramString.equals("" + ((JSONArray)localObject).get(i));
          if (bool1) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      return false;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    HashMap localHashMap = new HashMap();
    localHashMap.put("req_when", paramInt + "");
    String str = ((QWalletRedManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(272)).a();
    if (!TextUtils.isEmpty(str)) {
      localHashMap.put("redPoint", str);
    }
    a(0L, null, null, localHashMap);
  }
  
  public void b(String paramString, QWalletConfigManager.ConfigUpdateListener paramConfigUpdateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.removeUpdateListener(paramString, paramConfigUpdateListener);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager
 * JD-Core Version:    0.7.0.1
 */