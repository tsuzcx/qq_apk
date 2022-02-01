package com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend;

import aiki;
import aikk;
import aikl;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import bctj;
import bgsp;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class ScenesRecommendManager
  extends BroadcastReceiver
  implements Manager
{
  aikk jdField_a_of_type_Aikk;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  List<aiki> jdField_a_of_type_JavaUtilList = null;
  
  public ScenesRecommendManager() {}
  
  public ScenesRecommendManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface = new IntentFilter("mqq.scenesrecommendemo.notify.action");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().registerReceiver(this, paramQQAppInterface);
    a();
  }
  
  public static ScenesRecommendManager a(QQAppInterface paramQQAppInterface)
  {
    return (ScenesRecommendManager)paramQQAppInterface.getManager(364);
  }
  
  private void a(aiki paramaiki)
  {
    QLog.i("ScenesRecommendManager", 0, "doScenesEmotionRecommend ScenesRecommendItem is " + paramaiki.a());
    if (this.jdField_a_of_type_Aikk == null) {
      return;
    }
    this.jdField_a_of_type_Aikk.a(paramaiki);
  }
  
  private boolean a(String paramString)
  {
    if (this.jdField_a_of_type_Aikk == null) {
      return false;
    }
    return this.jdField_a_of_type_Aikk.a(paramString);
  }
  
  private aiki b(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    aiki localaiki;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localaiki = (aiki)localIterator.next();
    } while ((localaiki.d() == null) || (!localaiki.d().equalsIgnoreCase(paramString)));
    for (paramString = localaiki;; paramString = null) {
      return paramString;
    }
  }
  
  public aiki a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    aiki localaiki;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localaiki = (aiki)localIterator.next();
    } while ((localaiki.a() == null) || (!localaiki.a().equalsIgnoreCase(paramString)));
    for (paramString = localaiki;; paramString = null) {
      return paramString;
    }
  }
  
  public void a()
  {
    String str = aikl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    QLog.i("ScenesRecommendManager", 0, "loadConfigFromLoacl config is " + str);
    a(str);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScenesRecommendManager", 2, "reportScenesRecNotifyError result: " + paramInt);
    }
    HashMap localHashMap = new HashMap();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localHashMap.put("kov", str);
    localHashMap.put("result", paramInt + "");
    paramString = bctj.a(BaseApplication.getContext());
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.a(null, "scenes_rec_emo_monitor", bool, 0L, 0L, localHashMap, null);
      return;
    }
  }
  
  public void a(aikk paramaikk)
  {
    this.jdField_a_of_type_Aikk = paramaikk;
  }
  
  public void a(String paramString)
  {
    if (bgsp.a(paramString)) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      paramString = aikl.a(paramString);
      if (paramString == null) {
        break;
      }
      this.jdField_a_of_type_JavaUtilList.addAll(paramString);
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    int i;
    if ((!paramBoolean) || (a(paramString2))) {
      i = 1;
    }
    while (i != 0)
    {
      paramString2 = b(paramString1);
      if (paramString2 != null)
      {
        a(paramString2);
        a(0, paramString1);
        return;
        i = 0;
      }
      else
      {
        a(1, paramString1);
        return;
      }
    }
    a(2, paramString1);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().unregisterReceiver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction() == "mqq.scenesrecommendemo.notify.action")
    {
      paramContext = paramIntent.getStringExtra("scenes_kov");
      boolean bool = paramIntent.getBooleanExtra("need_check_uin", true);
      paramIntent = paramIntent.getStringExtra("check_uin");
      QLog.i("ScenesRecommendManager", 0, "onReceive NOTIFY_SCENES_RECOMMEND_EMO_ACTION is " + paramContext + "|" + bool + "|" + paramIntent);
      a(paramContext, bool, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendManager
 * JD-Core Version:    0.7.0.1
 */