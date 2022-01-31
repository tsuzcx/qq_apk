package com.tencent.mobileqq.activity.qwallet;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Vibrator;
import android.text.TextUtils;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.QNotificationManager;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.openapi.sdk.QQResult.QQStringResult;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.jtcode.JtcodeIpcServiceManager;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qwallet.plugin.QWalletLockScreenActivity;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x857.TroopTips0x857.GoldMsgTipsElem;
import tencent.im.s2c.msgtype0x210.submsgtype0x66.submsgtype0x66.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x7e.submsgtype0x7e.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x7e.submsgtype0x7e.WalletMsgPush;
import xau;

public class QWalletPushManager
{
  public static long a;
  private static ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(16);
  private static final long[] jdField_a_of_type_ArrayOfLong = { 100L, 200L, 200L, 100L };
  private static long b;
  
  public static int a()
  {
    if (jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    int i = 0;
    int k;
    for (int j = 0; i < jdField_a_of_type_JavaUtilArrayList.size(); j = k)
    {
      QWalletPushManager.PCPayData localPCPayData = (QWalletPushManager.PCPayData)jdField_a_of_type_JavaUtilArrayList.get(i);
      k = j;
      if (localPCPayData != null)
      {
        k = j;
        if (localPCPayData.jdField_c_of_type_Int == 0) {
          k = j + 1;
        }
      }
      i += 1;
    }
    return j;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 9;
    case 2: 
      return 4;
    case 3: 
      return 11;
    case 4: 
      return 8;
    case 5: 
      return 7;
    case 6: 
      return 6;
    case 8: 
      return 14;
    }
    return 5;
  }
  
  private static QWalletPushManager.PCPayData a()
  {
    Object localObject;
    if (jdField_a_of_type_JavaUtilArrayList == null)
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= jdField_a_of_type_JavaUtilArrayList.size()) {
        break label54;
      }
      QWalletPushManager.PCPayData localPCPayData = (QWalletPushManager.PCPayData)jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localPCPayData != null)
      {
        localObject = localPCPayData;
        if (localPCPayData.jdField_c_of_type_Int == 1) {
          break;
        }
      }
      i += 1;
    }
    label54:
    return null;
  }
  
  public static QWalletPushManager.PCPayData a(boolean paramBoolean)
  {
    Object localObject;
    if (jdField_a_of_type_JavaUtilArrayList == null)
    {
      localObject = null;
      return localObject;
    }
    QWalletPushManager.PCPayData localPCPayData;
    if (paramBoolean)
    {
      i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label101;
        }
        localPCPayData = (QWalletPushManager.PCPayData)jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localPCPayData != null)
        {
          localObject = localPCPayData;
          if (localPCPayData.jdField_c_of_type_Int == 0) {
            break;
          }
        }
        i -= 1;
      }
    }
    int i = 0;
    for (;;)
    {
      if (i >= jdField_a_of_type_JavaUtilArrayList.size()) {
        break label101;
      }
      localPCPayData = (QWalletPushManager.PCPayData)jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localPCPayData != null)
      {
        localObject = localPCPayData;
        if (localPCPayData.jdField_c_of_type_Int == 0) {
          break;
        }
      }
      i += 1;
    }
    label101:
    return null;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_JavaUtilArrayList == null) {}
    for (;;)
    {
      return;
      int i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
      while (i >= 0)
      {
        QWalletPushManager.PCPayData localPCPayData = (QWalletPushManager.PCPayData)jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localPCPayData == null) || (localPCPayData.jdField_c_of_type_Int == 1)) {
          jdField_a_of_type_JavaUtilArrayList.remove(i);
        }
        i -= 1;
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, QWalletPushManager.PCPayData paramPCPayData)
  {
    if ((paramQQAppInterface == null) || (jdField_a_of_type_JavaUtilArrayList == null) || (paramPCPayData == null) || (paramPCPayData.jdField_b_of_type_Int < 1) || (paramPCPayData.jdField_b_of_type_Int > 7) || (TextUtils.isEmpty(paramPCPayData.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.push", 2, "params error, pcPayDatas=" + jdField_a_of_type_JavaUtilArrayList + ",app=" + paramQQAppInterface + ",pcPayData=" + paramPCPayData);
      }
      return;
    }
    if (paramPCPayData.jdField_b_of_type_Int == 1) {
      jdField_a_of_type_Long = VACDReportUtil.a(null, "qqwallet", "pay-pcpush", "payinvoke", null, 0, null);
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilArrayList)
      {
        jdField_a_of_type_JavaUtilArrayList.add(paramPCPayData);
        if (b(paramQQAppInterface))
        {
          if (jdField_a_of_type_Long != 0L) {
            VACDReportUtil.a(jdField_a_of_type_Long, null, "startForegroundPay", null, 0, null);
          }
          b(paramQQAppInterface);
          jdField_a_of_type_Long = 0L;
          b(paramQQAppInterface, paramPCPayData);
          return;
        }
      }
      if (jdField_a_of_type_Long != 0L) {
        VACDReportUtil.a(jdField_a_of_type_Long, null, "startBackgroundPay", null, 0, null);
      }
      c(paramQQAppInterface, paramPCPayData);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = 4;
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel())
      {
        QLog.d("Q.qwallet.push", 2, "PCPayData is empty.");
        break label25;
      }
    }
    label25:
    while (paramQQAppInterface == null) {
      return;
    }
    for (;;)
    {
      int k;
      int m;
      try
      {
        paramString = new JSONObject(paramString);
        k = paramString.optInt("module", 0);
        m = paramString.optInt("action", 0);
        if ((k < 1) || (k > 8) || (m < 1) || (m > 2)) {
          break label25;
        }
        if ((k != 1) || (m != 1)) {
          break label196;
        }
        paramString = paramQQAppInterface.getApp();
        if (Build.VERSION.SDK_INT <= 10) {
          break label191;
        }
        paramString = paramString.getSharedPreferences("qwallet_multi", i);
        if (paramString == null) {
          break label452;
        }
        paramString.edit().putBoolean("is_refresh_home", true).commit();
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
      if ((i == 0) || (!QWalletHelper.isQWalletProcessExist(paramQQAppInterface.getApp()))) {
        break;
      }
      if (k == 1)
      {
        paramString = "com.qwallet.refresh.home";
        b(paramQQAppInterface, paramString);
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.qwallet.push", 2, "Parsing PCPAYDATA throws JSONException.");
        return;
        label191:
        i = 0;
        continue;
        label196:
        if ((k == 1) && (m == 2))
        {
          FileUtils.d(paramQQAppInterface.getApp().getFilesDir() + "/" + QWalletHelper.getRecommendFileName(paramQQAppInterface.getCurrentAccountUin()));
          FileUtils.d(paramQQAppInterface.getApp().getFilesDir() + "/" + QWalletHelper.getRecommendFileName(paramQQAppInterface.getCurrentAccountUin()) + "_");
          i = 1;
          continue;
        }
        if ((k == 2) && (m == 1))
        {
          paramString = paramQQAppInterface.getApp();
          i = j;
          if (Build.VERSION.SDK_INT > 10) {
            i = 4;
          }
          paramString = paramString.getSharedPreferences("qwallet_multi", i);
          if (paramString == null) {
            break label457;
          }
          paramString.edit().putBoolean("is_refresh_center", true).commit();
          break label457;
        }
        if ((k == 2) && (m == 2))
        {
          FileUtils.d(paramQQAppInterface.getApp().getFilesDir() + "/" + QWalletHelper.getPersonalInfoFileName(paramQQAppInterface.getCurrentAccountUin()));
          i = 1;
          continue;
        }
        if ((k != 8) || (m != 1)) {
          break label462;
        }
        ((QWalletConfigManager)paramQQAppInterface.getManager(244)).b(0);
        break label462;
      }
      paramString = "com.qwallet.refresh.center";
      continue;
      label452:
      i = 1;
      continue;
      label457:
      i = 1;
      continue;
      label462:
      i = 0;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.push", 2, "onQQForeground isFromGestureLock=" + paramBoolean);
    }
    if (paramQQAppInterface == null) {
      break label35;
    }
    label35:
    while (a(false) == null) {
      return;
    }
    if (paramBoolean) {}
    for (int i = 5;; i = 1000)
    {
      MqqHandler localMqqHandler = ThreadManager.getSubThreadHandler();
      if (localMqqHandler == null) {
        break;
      }
      localMqqHandler.postDelayed(new xau(paramQQAppInterface), i);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (a(paramLong1, paramInt1, paramLong2, paramInt2))) {
      label17:
      return;
    }
    int i = -1;
    Object localObject = null;
    paramInt2 = i;
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          try
          {
            paramArrayOfByte = (submsgtype0x66.MsgBody)new submsgtype0x66.MsgBody().mergeFrom(paramArrayOfByte);
            paramInt1 = i;
            paramInt2 = i;
            if (paramArrayOfByte.uint32_type.has())
            {
              paramInt2 = i;
              paramInt1 = paramArrayOfByte.uint32_type.get();
            }
            paramInt2 = paramInt1;
            if (!paramArrayOfByte.bytes_push_data.has()) {
              break label708;
            }
            paramInt2 = paramInt1;
            paramArrayOfByte = paramArrayOfByte.bytes_push_data.get();
            if (paramArrayOfByte == null) {
              break label708;
            }
            paramInt2 = paramInt1;
            paramArrayOfByte = paramArrayOfByte.toByteArray();
            if (QLog.isColorLevel()) {
              QLog.d("Q.qwallet.push", 2, "pushType = " + paramInt1);
            }
            if ((paramInt1 == -1) || (paramArrayOfByte == null)) {
              break;
            }
            switch (paramInt1)
            {
            case 4: 
            case 3: 
            case 6: 
            case 7: 
            default: 
              if (!QLog.isColorLevel()) {
                break label17;
              }
              QLog.w("Q.qwallet.push", 2, "Unknow pushType.");
              return;
            }
          }
          catch (Exception paramArrayOfByte)
          {
            for (;;)
            {
              paramArrayOfByte.printStackTrace();
              paramInt1 = paramInt2;
              paramArrayOfByte = (byte[])localObject;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.qwallet.push", 2, "Parsing Msg0x210Sub0x66 data throws Exception.");
                paramInt1 = paramInt2;
                paramArrayOfByte = (byte[])localObject;
                continue;
                try
                {
                  localObject = new String(paramArrayOfByte, "UTF-8");
                  if (TextUtils.isEmpty((CharSequence)localObject)) {
                    break;
                  }
                  paramArrayOfByte = new QWalletPushManager.PCPayData();
                  paramArrayOfByte.jdField_b_of_type_Long = System.currentTimeMillis();
                  localObject = new JSONObject((String)localObject);
                  paramArrayOfByte.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("tradeTime", 0L);
                  paramArrayOfByte.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("expTime", 0);
                  paramArrayOfByte.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("payType", 0);
                  paramArrayOfByte.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("notifyText");
                  localObject = ((JSONObject)localObject).optJSONObject("payData");
                  if (localObject != null) {
                    paramArrayOfByte.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).toString();
                  }
                  a(paramQQAppInterface, paramArrayOfByte);
                  return;
                }
                catch (Exception paramQQAppInterface) {}
              }
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("Q.qwallet.push", 2, "Coverting pushData Exception.", paramQQAppInterface);
          return;
          try
          {
            a(paramQQAppInterface, new String(paramArrayOfByte, "UTF-8"));
            return;
          }
          catch (Exception paramQQAppInterface) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("Q.qwallet.push", 2, "Coverting pushData Exception.", paramQQAppInterface);
          return;
          try
          {
            localObject = new String(paramArrayOfByte, "UTF-8");
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              break;
            }
            paramArrayOfByte = new QWalletPushManager.PCPayData();
            paramArrayOfByte.jdField_b_of_type_Long = System.currentTimeMillis();
            localObject = new JSONObject((String)localObject);
            paramArrayOfByte.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("tradeTime", 0L);
            paramArrayOfByte.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("expTime", 0);
            paramArrayOfByte.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("payType", 0);
            paramArrayOfByte.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("notifyText");
            JSONObject localJSONObject1 = new JSONObject();
            localJSONObject1.put("viewTag", "hbPackConfirm");
            localJSONObject1.put("comeForm", 2);
            localJSONObject1.put("appInfo", "appid#1344242394|bargainor_id#1000030201|channel#pc@0001");
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.putOpt("push_data", ((JSONObject)localObject).optString("key", ""));
            localJSONObject1.put("extra_data", localJSONObject2.toString());
            paramArrayOfByte.jdField_a_of_type_JavaLangString = localJSONObject1.toString();
            a(paramQQAppInterface, paramArrayOfByte);
            return;
          }
          catch (Exception paramQQAppInterface) {}
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.qwallet.push", 2, "Coverting pushData Exception.", paramQQAppInterface);
        return;
        try
        {
          paramQQAppInterface = new TroopTips0x857.GoldMsgTipsElem();
          paramQQAppInterface.mergeFrom(paramArrayOfByte);
          if ((!paramQQAppInterface.type.has()) || (paramQQAppInterface.type.get() != 3)) {
            break;
          }
          NotifyMsgManager.a(0, paramQQAppInterface, null);
          return;
        }
        catch (Exception paramQQAppInterface) {}
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      paramQQAppInterface.printStackTrace();
      return;
      label708:
      paramArrayOfByte = null;
    }
  }
  
  protected static boolean a(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    ??? = new StringBuilder(32);
    ((StringBuilder)???).append(paramLong1);
    ((StringBuilder)???).append(paramInt1);
    ((StringBuilder)???).append(paramLong2);
    ((StringBuilder)???).append(paramInt2);
    String str = ((StringBuilder)???).toString();
    if (TextUtils.isEmpty(str)) {
      return true;
    }
    paramLong1 = System.currentTimeMillis();
    synchronized (jdField_a_of_type_JavaUtilHashMap)
    {
      if (Math.abs(paramLong1 - jdField_b_of_type_Long) > 1800000L) {
        jdField_a_of_type_JavaUtilHashMap.clear();
      }
      while (!jdField_a_of_type_JavaUtilHashMap.containsKey(str))
      {
        jdField_a_of_type_JavaUtilHashMap.put(str, null);
        jdField_b_of_type_Long = paramLong1;
        return false;
      }
      return true;
    }
  }
  
  public static void b()
  {
    if (jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = false;
    if ((paramQQAppInterface == null) || (jdField_a_of_type_JavaUtilArrayList == null)) {}
    label355:
    label358:
    for (;;)
    {
      return;
      boolean bool2 = QQUtils.a(paramQQAppInterface.getApp());
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.push", 2, "startForegroundPay isScreenLock=" + bool2);
      }
      if (!bool2)
      {
        QWalletPushManager.PCPayData localPCPayData = a();
        int i;
        if (localPCPayData == null)
        {
          if (jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
            continue;
          }
          localPCPayData = (QWalletPushManager.PCPayData)jdField_a_of_type_JavaUtilArrayList.get(0);
          if (localPCPayData == null)
          {
            jdField_a_of_type_JavaUtilArrayList.remove(0);
            b(paramQQAppInterface);
            return;
          }
          i = a(localPCPayData.jdField_b_of_type_Int);
          if (i == 0)
          {
            jdField_a_of_type_JavaUtilArrayList.remove(0);
            b(paramQQAppInterface);
            return;
          }
          bool2 = PayBridgeActivity.a();
          if ((!bool2) || (QWalletHelper.isQWalletProcessExist(paramQQAppInterface.getApplication().getApplicationContext()))) {
            break label355;
          }
        }
        for (;;)
        {
          if (bool1) {
            break label358;
          }
          localPCPayData.jdField_c_of_type_Int = 1;
          try
          {
            paramQQAppInterface = new Intent(BaseApplication.getContext(), PayBridgeActivity.class);
            paramQQAppInterface.addFlags(872415232);
            paramQQAppInterface.putExtra("json", localPCPayData.jdField_a_of_type_JavaLangString);
            paramQQAppInterface.putExtra("callbackSn", "0");
            paramQQAppInterface.putExtra("payparmas_from_pcpush", true);
            paramQQAppInterface.putExtra("pay_requestcode", i);
            paramQQAppInterface.putExtra("payparmas_paytype", 2);
            paramQQAppInterface.putExtra("vacreport_key_seq", jdField_a_of_type_Long);
            BaseApplication.getContext().startActivity(paramQQAppInterface);
            return;
          }
          catch (Exception paramQQAppInterface)
          {
            localPCPayData.jdField_c_of_type_Int = 2;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("Q.qwallet.push", 2, "Starting pay throws Exception.", paramQQAppInterface);
          return;
          bool2 = PayBridgeActivity.a();
          bool1 = bool2;
          if (bool2)
          {
            bool1 = bool2;
            if (!QWalletHelper.isQWalletProcessExist(paramQQAppInterface.getApplication().getApplicationContext())) {
              bool1 = false;
            }
          }
          bool2 = bool1;
          if (bool1)
          {
            long l = System.currentTimeMillis();
            bool2 = bool1;
            if (43200L * 1000L + localPCPayData.jdField_c_of_type_Long > l) {
              bool2 = false;
            }
          }
          if (bool2) {
            break;
          }
          localPCPayData.jdField_c_of_type_Int = 2;
          b(paramQQAppInterface);
          return;
          bool1 = bool2;
        }
      }
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, QWalletPushManager.PCPayData paramPCPayData)
  {
    String str1;
    boolean bool1;
    if (QQUtils.a(paramQQAppInterface.getApp()))
    {
      ((PowerManager)paramQQAppInterface.getApp().getSystemService("power")).newWakeLock(268435462, "Q.qwallet.push").acquire(10000L);
      String str2 = String.format(BaseApplication.getContext().getString(2131432237), new Object[] { Integer.valueOf(a()) });
      if (!TextUtils.isEmpty(paramPCPayData.jdField_b_of_type_JavaLangString))
      {
        str1 = paramPCPayData.jdField_b_of_type_JavaLangString;
        Intent localIntent = new Intent(paramQQAppInterface.getApp(), QWalletLockScreenActivity.class);
        localIntent.addFlags(67108864);
        localIntent.addFlags(268435456);
        localIntent.addFlags(262144);
        localIntent.addFlags(1073741824);
        localIntent.putExtra("title", str2);
        localIntent.putExtra("content", str1);
        localIntent.putExtra("time", TimeFormatterUtils.b(BaseApplication.getContext(), paramPCPayData.jdField_b_of_type_Long));
        paramQQAppInterface.getApp().startActivity(localIntent);
      }
    }
    else
    {
      bool1 = paramQQAppInterface.h();
      bool2 = PhoneStatusTools.d(paramQQAppInterface.getApp());
      boolean bool3 = paramQQAppInterface.c();
      boolean bool4 = paramQQAppInterface.r();
      boolean bool5 = NoDisturbUtil.a(paramQQAppInterface.getApp().getApplicationContext(), paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.push", 2, "isRingerSilent=" + bool1 + ",isCalling=" + bool2 + ",isVideoChatting=" + bool3 + ",isRecordingPtt=" + bool4 + ",canDisturb=" + bool5);
      }
      if ((bool5) && (!bool2) && (!bool1) && (!bool3) && (!bool4))
      {
        if (paramQQAppInterface.c() != 0) {
          break label485;
        }
        bool1 = false;
        label327:
        if (paramQQAppInterface.d() != 0) {
          break label490;
        }
      }
    }
    label485:
    label490:
    for (boolean bool2 = false;; bool2 = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.push", 2, "canPlaySound=" + bool1 + ",canVibrator=" + bool2);
      }
      if (bool2)
      {
        paramQQAppInterface = (Vibrator)paramQQAppInterface.getApp().getSystemService("vibrator");
        if (paramQQAppInterface != null) {
          paramQQAppInterface.vibrate(jdField_a_of_type_ArrayOfLong, -1);
        }
      }
      if (bool1)
      {
        paramQQAppInterface = ThemeUtil.getThemeVoiceRootPath();
        if (paramQQAppInterface == null) {
          break label495;
        }
        paramQQAppInterface = new File(paramQQAppInterface + File.separatorChar + "message.mp3");
        if (!paramQQAppInterface.exists()) {
          break label495;
        }
        AudioUtil.a(Uri.fromFile(paramQQAppInterface), false, true);
      }
      return;
      str1 = BaseApplication.getContext().getString(2131432238);
      break;
      bool1 = true;
      break label327;
    }
    label495:
    AudioUtil.a(2131230758, false);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = new Intent(paramString);
    paramQQAppInterface.getApp().sendBroadcast(paramString);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.push", 2, "parseMsg0x210Sub0x7e,msgType0x210Bytes is null");
      }
    }
    for (;;)
    {
      return;
      if (a(paramLong1, paramInt1, paramLong2, paramInt2))
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.qwallet.push", 2, "parseMsg0x210Sub0x7e,msg repeated");
        return;
      }
      Object localObject1;
      Object localObject4;
      int i;
      Object localObject2;
      try
      {
        localObject1 = (submsgtype0x7e.MsgBody)new submsgtype0x7e.MsgBody().mergeFrom(paramArrayOfByte);
        if (!((submsgtype0x7e.MsgBody)localObject1).msg_online_push.has()) {
          continue;
        }
        localObject4 = (submsgtype0x7e.WalletMsgPush)((submsgtype0x7e.MsgBody)localObject1).msg_online_push.get();
        if (localObject4 == null) {
          continue;
        }
        paramInt1 = -1;
        paramInt2 = -1;
        localObject3 = "";
        localObject1 = "";
        i = -1;
        if (((submsgtype0x7e.WalletMsgPush)localObject4).uint32_action.has()) {
          paramInt1 = ((submsgtype0x7e.WalletMsgPush)localObject4).uint32_action.get();
        }
        if (((submsgtype0x7e.WalletMsgPush)localObject4).uint32_timestamp.has()) {
          paramInt2 = ((submsgtype0x7e.WalletMsgPush)localObject4).uint32_timestamp.get();
        }
        localObject2 = localObject3;
        if (((submsgtype0x7e.WalletMsgPush)localObject4).bytes_extend.has())
        {
          ByteStringMicro localByteStringMicro = ((submsgtype0x7e.WalletMsgPush)localObject4).bytes_extend.get();
          localObject2 = localObject3;
          if (localByteStringMicro != null) {
            localObject2 = new String(localByteStringMicro.toByteArray(), "UTF-8");
          }
        }
        if (((submsgtype0x7e.WalletMsgPush)localObject4).str_serialno.has()) {
          localObject1 = ((submsgtype0x7e.WalletMsgPush)localObject4).str_serialno.get();
        }
        if (((submsgtype0x7e.WalletMsgPush)localObject4).str_billno.has()) {
          localObject1 = ((submsgtype0x7e.WalletMsgPush)localObject4).str_billno.get();
        }
        if (((submsgtype0x7e.WalletMsgPush)localObject4).str_appinfo.has()) {
          localObject1 = ((submsgtype0x7e.WalletMsgPush)localObject4).str_appinfo.get();
        }
        if (((submsgtype0x7e.WalletMsgPush)localObject4).uint32_amount.has()) {
          i = ((submsgtype0x7e.WalletMsgPush)localObject4).uint32_amount.get();
        }
        if (((submsgtype0x7e.WalletMsgPush)localObject4).str_jumpurl.has()) {
          localObject1 = ((submsgtype0x7e.WalletMsgPush)localObject4).str_jumpurl.get();
        }
        if (paramInt1 != 100) {
          break label424;
        }
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            continue;
          }
          paramQQAppInterface = new JSONObject((String)localObject2);
          localObject1 = JtcodeIpcServiceManager.a();
          if (localObject1 != null) {
            ((JtcodeIpcServiceManager)localObject1).a(paramQQAppInterface);
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.qwallet.push", 2, "receive wlx push message,data=" + ByteBuffer.wrap(paramArrayOfByte).hashCode());
          return;
        }
        catch (Exception paramQQAppInterface) {}
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        paramQQAppInterface.printStackTrace();
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        continue;
      }
      QLog.d("Q.qwallet.push", 2, "Parsing Msg0x210Sub0x7e data throws Exception.");
      return;
      label424:
      paramArrayOfByte = new JSONObject();
      Object localObject3 = new JSONObject();
      try
      {
        localObject4 = new JSONObject((String)localObject2);
        ((JSONObject)localObject3).put("action", paramInt1);
        ((JSONObject)localObject3).put("extend", localObject4);
        paramArrayOfByte.put("userId", paramQQAppInterface.getCurrentAccountUin());
        paramArrayOfByte.put("viewTag", "pushMsg");
        paramArrayOfByte.put("appInfo", "appid#30000002|bargainor_id#0|channel#POS");
        paramArrayOfByte.put("extra_data", localObject3);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qwallet.push", 2, "parseMsg0x210Sub0x7e,json=" + paramArrayOfByte);
        }
        localObject4 = paramQQAppInterface.getApp();
        if (Build.VERSION.SDK_INT > 10)
        {
          j = 4;
          localObject4 = ((BaseApplication)localObject4).getSharedPreferences("qwallet_multi", j);
          if (localObject4 != null)
          {
            paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
            paramLong1 = ((SharedPreferences)localObject4).getLong("tenwatch_req_time_prefix_" + paramQQAppInterface, 0L);
            paramLong2 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
            if (paramLong2 < paramLong1) {
              ((SharedPreferences)localObject4).edit().putLong("tenwatch_req_time_prefix_" + paramQQAppInterface, 0L);
            }
          }
          else
          {
            paramQQAppInterface = new Bundle();
            paramQQAppInterface.putString("json", paramArrayOfByte.toString());
            paramQQAppInterface.putString("callbackSn", "0");
            localObject3 = new Intent(BaseApplication.getContext(), PayBridgeActivity.class);
            ((Intent)localObject3).addFlags(268435456);
            ((Intent)localObject3).putExtras(paramQQAppInterface);
            ((Intent)localObject3).putExtra("pay_requestcode", 5);
            BaseApplication.getContext().startActivity((Intent)localObject3);
            if (!QLog.isDevelopLevel()) {
              continue;
            }
            QLog.i("Q.qwallet.push", 4, "Receive Data, action:" + paramInt1 + " timestamp:" + paramInt2 + " extend:" + (String)localObject2 + " serialno:" + (String)localObject1 + " billno:" + "" + " appinfo:" + "" + " amount:" + i + " jumpurl:" + "" + " json:" + paramArrayOfByte.toString());
            return;
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          int j;
          if (QLog.isDevelopLevel()) {
            localException2.printStackTrace();
          }
          if (QLog.isColorLevel())
          {
            QLog.d("Q.qwallet.push", 2, "Parsing Msg0x210Sub0x7e data throws Exception.");
            continue;
            if (paramLong2 - paramLong1 < 300L)
            {
              paramQQAppInterface = new JSONObject();
              try
              {
                paramQQAppInterface.put("retCode", 0);
                paramQQAppInterface.put("retMsg", "");
                paramQQAppInterface.put("businessType", 4);
                paramQQAppInterface.put("retData", localObject3);
                paramQQAppInterface = new QQResult.QQStringResult(4, 0, paramQQAppInterface.toString());
                OpenApiManager.getInstance().onPayMsgRsp(paramQQAppInterface);
              }
              catch (Exception localException1)
              {
                for (;;)
                {
                  if (QLog.isDevelopLevel()) {
                    localException1.printStackTrace();
                  }
                }
              }
              j = 0;
            }
          }
        }
      }
    }
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = BaseApplicationImpl.getApplication();
    if (localObject1 == null) {
      return false;
    }
    boolean bool = GesturePWDUtils.getGestureLocking((Context)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.push", 2, "isQQForeground isQQLock=" + bool);
    }
    if ((paramQQAppInterface == null) || (bool)) {
      return false;
    }
    if (!paramQQAppInterface.isBackground_Pause) {
      return true;
    }
    try
    {
      Object localObject2 = (ActivityManager)((Context)localObject1).getApplicationContext().getSystemService("activity");
      if (localObject2 == null) {
        return false;
      }
      paramQQAppInterface = ((Context)localObject1).getApplicationContext().getPackageName();
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        return false;
      }
      localObject1 = ((ActivityManager)localObject2).getRunningAppProcesses();
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
        if ((((ActivityManager.RunningAppProcessInfo)localObject2).importance == 100) && (((ActivityManager.RunningAppProcessInfo)localObject2).processName != null))
        {
          if (((ActivityManager.RunningAppProcessInfo)localObject2).processName.equals(paramQQAppInterface + ":video")) {
            return false;
          }
          if (!((ActivityManager.RunningAppProcessInfo)localObject2).processName.equals(paramQQAppInterface))
          {
            bool = ((ActivityManager.RunningAppProcessInfo)localObject2).processName.startsWith(paramQQAppInterface + ":");
            if (!bool) {
              break;
            }
          }
          else
          {
            return true;
          }
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      return false;
    }
    return false;
  }
  
  private static void c(QQAppInterface paramQQAppInterface, QWalletPushManager.PCPayData paramPCPayData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.push", 2, "startBackgroundPay");
    }
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramPCPayData == null)) {}
    Object localObject1;
    do
    {
      return;
      String str = String.format(BaseApplication.getContext().getString(2131432237), new Object[] { Integer.valueOf(a()) });
      localObject1 = paramPCPayData.jdField_b_of_type_JavaLangString;
      paramPCPayData = (QWalletPushManager.PCPayData)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramPCPayData = BaseApplication.getContext().getString(2131432238);
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("callbackSn", "0");
      ((Bundle)localObject1).putBoolean("payparmas_from_pcpush", true);
      ((Bundle)localObject1).putInt("pay_requestcode", 12);
      ((Bundle)localObject1).putInt("payparmas_paytype", 2);
      ((Bundle)localObject1).putLong("vacreport_key_seq", jdField_a_of_type_Long);
      Object localObject2 = new Intent(paramQQAppInterface.getApp(), PayBridgeActivity.class);
      ((Intent)localObject2).addFlags(268435456);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      localObject2 = PendingIntent.getActivity(paramQQAppInterface.getApp(), 12, (Intent)localObject2, 1073741824);
      localObject1 = new Notification(2130839537, str, System.currentTimeMillis());
      ((Notification)localObject1).flags = 16;
      ((Notification)localObject1).setLatestEventInfo(paramQQAppInterface.getApp(), str, paramPCPayData, (PendingIntent)localObject2);
      paramQQAppInterface = new QNotificationManager(paramQQAppInterface.getApp());
    } while (paramQQAppInterface == null);
    paramQQAppInterface.cancel("Q.qwallet.push", 128);
    paramQQAppInterface.notify("Q.qwallet.push", 128, (Notification)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QWalletPushManager
 * JD-Core Version:    0.7.0.1
 */