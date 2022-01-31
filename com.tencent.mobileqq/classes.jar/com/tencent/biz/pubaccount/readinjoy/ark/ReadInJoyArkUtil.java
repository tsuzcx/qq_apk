package com.tencent.biz.pubaccount.readinjoy.ark;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArkAppFeedsInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import cooperation.readinjoy.ReadInJoyHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import lfw;
import lfz;

public class ReadInJoyArkUtil
{
  private static ConcurrentHashMap a;
  public static AtomicBoolean a;
  
  public static ArkLocalAppMgr a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localQQAppInterface != null) {
      return ((ArkAppCenter)localQQAppInterface.getManager(120)).a();
    }
    return null;
  }
  
  public static ArkAppMessage a(ArkAppFeedsInfo paramArkAppFeedsInfo)
  {
    if (paramArkAppFeedsInfo == null) {
      return null;
    }
    ArkAppMessage localArkAppMessage = new ArkAppMessage();
    localArkAppMessage.appName = paramArkAppFeedsInfo.a;
    localArkAppMessage.appView = paramArkAppFeedsInfo.b;
    localArkAppMessage.appMinVersion = paramArkAppFeedsInfo.e;
    localArkAppMessage.metaList = paramArkAppFeedsInfo.f;
    return localArkAppMessage;
  }
  
  public static void a()
  {
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArkUtil", 2, "No need to show ArkApp, do not pre download after login.");
      }
      return;
    }
    a(new lfz(), 5);
  }
  
  public static void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyArkUtil", 2, new Object[] { "pauseFeedItemCellArk, channelId: ", Integer.valueOf(paramInt) });
    }
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      ArrayList localArrayList = (ArrayList)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        paramInt = 0;
        while (paramInt < localArrayList.size())
        {
          FeedItemCellArk localFeedItemCellArk = (FeedItemCellArk)((WeakReference)localArrayList.get(paramInt)).get();
          if (localFeedItemCellArk != null) {
            localFeedItemCellArk.a();
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public static void a(int paramInt, long paramLong)
  {
    Object localObject = (QQAppInterface)ReadInJoyUtils.a();
    if (localObject != null)
    {
      localObject = (ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(162);
      if (localObject != null) {
        ((ReadInJoyLogicManager)localObject).a().a(paramInt, paramLong);
      }
    }
  }
  
  public static void a(View paramView)
  {
    if (paramView == null) {}
    AbsListView.LayoutParams localLayoutParams;
    do
    {
      do
      {
        return;
        if (paramView.getVisibility() != 0) {
          paramView.setVisibility(0);
        }
      } while (!(paramView.getLayoutParams() instanceof AbsListView.LayoutParams));
      localLayoutParams = (AbsListView.LayoutParams)paramView.getLayoutParams();
    } while (localLayoutParams.height == -2);
    localLayoutParams.height = -2;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  public static void a(FeedItemCellArk paramFeedItemCellArk, int paramInt)
  {
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    ArrayList localArrayList2 = (ArrayList)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localArrayList1);
    }
    localArrayList1.add(new WeakReference(paramFeedItemCellArk));
  }
  
  public static void a(ArkAppMessage paramArkAppMessage)
  {
    if (QLog.isColorLevel())
    {
      if (paramArkAppMessage != null) {
        QLog.d("ReadInJoyArkUtil", 2, new Object[] { "arkAppMessage, appName: ", paramArkAppMessage.appName, ", appView: ", paramArkAppMessage.appView, ", appMinVersion: ", paramArkAppMessage.appMinVersion, ", metaList: ", paramArkAppMessage.metaList });
      }
    }
    else {
      return;
    }
    QLog.d("ReadInJoyArkUtil", 2, "arkAppMessage is null");
  }
  
  public static void a(ArkAppMessage paramArkAppMessage, int paramInt)
  {
    if (paramInt >= 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArkUtil", 2, new Object[] { "Do not retry download again. Retry times is max. retryTimes: ", Integer.valueOf(paramInt) });
      }
      return;
    }
    a(new lfw(paramArkAppMessage, paramInt), 5);
  }
  
  public static void a(Runnable paramRunnable, int paramInt)
  {
    ThreadManager.post(paramRunnable, paramInt, null, true);
  }
  
  public static boolean a()
  {
    boolean bool;
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean == null)
    {
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
      bool = ReadInJoyHelper.e(ReadInJoyUtils.a());
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(bool);
      if (QLog.isColorLevel()) {
        if (!bool) {
          break label75;
        }
      }
    }
    label75:
    for (String str = "1";; str = "0")
    {
      QLog.d("ReadInJoyArkUtil", 2, new Object[] { "isShowArkApp: ", str });
      return bool;
      bool = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
      break;
    }
  }
  
  public static boolean a(ArkAppMessage paramArkAppMessage)
  {
    int i = 0;
    boolean bool1;
    if (b(paramArkAppMessage))
    {
      ArkLocalAppMgr localArkLocalAppMgr = a();
      if (localArkLocalAppMgr != null)
      {
        paramArkAppMessage = localArkLocalAppMgr.a(paramArkAppMessage.appName, paramArkAppMessage.appMinVersion);
        if (paramArkAppMessage != null)
        {
          bool1 = true;
          bool2 = bool1;
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyArkUtil", 2, new Object[] { "Ark appPath: ", paramArkAppMessage });
          }
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = false)
    {
      if (QLog.isColorLevel())
      {
        if (bool2) {
          i = 1;
        }
        QLog.d("ReadInJoyArkUtil", 2, new Object[] { "isArkAppLocalExist: ", Integer.valueOf(i) });
      }
      return bool2;
      bool1 = false;
      break;
    }
  }
  
  public static void b()
  {
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  public static void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyArkUtil", 2, new Object[] { "resumeFeedItemCellArk, channelId: ", Integer.valueOf(paramInt) });
    }
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      ArrayList localArrayList = (ArrayList)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        paramInt = 0;
        while (paramInt < localArrayList.size())
        {
          FeedItemCellArk localFeedItemCellArk = (FeedItemCellArk)((WeakReference)localArrayList.get(paramInt)).get();
          if (localFeedItemCellArk != null) {
            localFeedItemCellArk.b();
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public static void b(View paramView)
  {
    if (paramView == null) {}
    AbsListView.LayoutParams localLayoutParams;
    do
    {
      do
      {
        return;
        if (paramView.getVisibility() != 8) {
          paramView.setVisibility(8);
        }
      } while (!(paramView.getLayoutParams() instanceof AbsListView.LayoutParams));
      localLayoutParams = (AbsListView.LayoutParams)paramView.getLayoutParams();
    } while (localLayoutParams.height == 1);
    localLayoutParams.height = 1;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  public static boolean b(ArkAppMessage paramArkAppMessage)
  {
    int i = 0;
    boolean bool;
    if (paramArkAppMessage != null) {
      if ((!TextUtils.isEmpty(paramArkAppMessage.appName)) && (!TextUtils.isEmpty(paramArkAppMessage.appView)) && (!TextUtils.isEmpty(paramArkAppMessage.appMinVersion)) && (!TextUtils.isEmpty(paramArkAppMessage.metaList))) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        if (bool) {
          i = 1;
        }
        QLog.d("ReadInJoyArkUtil", 2, new Object[] { "ArkAppMessage isValid: ", Integer.valueOf(i) });
        a(paramArkAppMessage);
      }
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkUtil
 * JD-Core Version:    0.7.0.1
 */