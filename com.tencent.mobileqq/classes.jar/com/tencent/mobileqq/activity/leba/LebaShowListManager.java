package com.tencent.mobileqq.activity.leba;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.app.LebaUtil;
import com.tencent.mobileqq.app.LebaUtil.LebaItemComparator;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RedTouchHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.campuscircle.CampusLebaEntryChecker;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.wholepeople.WholePeopleLebaEntryChecker;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import wvc;

public class LebaShowListManager
{
  public static volatile int a;
  private static volatile LebaShowListManager jdField_a_of_type_ComTencentMobileqqActivityLebaLebaShowListManager;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public HashMap a;
  protected List a;
  public boolean a;
  
  private LebaShowListManager()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_Int = 0;
  }
  
  public static LebaShowListManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityLebaLebaShowListManager == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityLebaLebaShowListManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityLebaLebaShowListManager = new LebaShowListManager();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityLebaLebaShowListManager;
    }
  }
  
  public LebaViewItem a(long paramLong)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
      if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId == paramLong) {
        return localLebaViewItem;
      }
    }
    return null;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      LebaViewItem localLebaViewItem;
      boolean bool;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break label190;
        }
        localLebaViewItem = (LebaViewItem)localIterator.next();
        if ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId == 905L)) {
          continue;
        }
        if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId == 6005L)
        {
          AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
          if (!(localAppRuntime instanceof QQAppInterface)) {
            break label194;
          }
          bool = ((QQAppInterface)localAppRuntime).a().a();
          break label196;
        }
        if (("看点".equals(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName)) && (ReadInJoyHelper.h()))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.lebatab.mgr", 2, "getLebaMgrList hide leba kandian");
        }
      }
      if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.cDataType != 1)
      {
        localList2.add(localLebaViewItem);
        continue;
        label190:
        return localList2;
        label194:
        bool = false;
        label196:
        if (!bool) {}
      }
    }
  }
  
  public List a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.lebatab.mgr", 4, String.format(Locale.getDefault(), "reloadLebaItems [%s, %s, %s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), paramContext, paramQQAppInterface }));
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramQQAppInterface.a();
    if (localObject1 != null)
    {
      CampusLebaEntryChecker localCampusLebaEntryChecker = paramQQAppInterface.a().jdField_a_of_type_ComTencentMobileqqCampuscircleCampusLebaEntryChecker;
      if ((localCampusLebaEntryChecker == null) && (QLog.isDevelopLevel())) {
        QLog.i("Q.lebatab.mgr", 4, "reloadLebaItems campusLebaEntryChecker is null");
      }
      WholePeopleLebaEntryChecker localWholePeopleLebaEntryChecker = paramQQAppInterface.a().jdField_a_of_type_ComTencentMobileqqWholepeopleWholePeopleLebaEntryChecker;
      if ((localWholePeopleLebaEntryChecker == null) && (QLog.isDevelopLevel())) {
        QLog.i("Q.lebatab.mgr", 4, "reloadLebaItems wholePeopleChecker is null");
      }
      Object localObject2 = new ArrayList((Collection)localObject1);
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      boolean bool1 = false;
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (ResourcePluginInfo)((Iterator)localObject2).next();
        if ((localObject3 != null) && (((ResourcePluginInfo)localObject3).cLocalState != 0)) {
          if ((((ResourcePluginInfo)localObject3).uiResId == 4086L) && (localCampusLebaEntryChecker != null) && (!localCampusLebaEntryChecker.jdField_a_of_type_Boolean))
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("Q.lebatab.mgr", 4, "reloadLebaItems camps entry switch is off ");
            }
          }
          else if ((((ResourcePluginInfo)localObject3).uiResId == 770L) && (!((ResourcePluginInfo)localObject3).isAllowFlag(1)) && (localWholePeopleLebaEntryChecker != null) && (!localWholePeopleLebaEntryChecker.jdField_a_of_type_Boolean))
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("Q.lebatab.mgr", 4, "reloadLebaItems wholePeople entry switch is off ");
            }
          }
          else
          {
            boolean bool2 = bool1;
            if (((ResourcePluginInfo)localObject3).uiResId == 770L) {
              bool2 = true;
            }
            LebaViewItem localLebaViewItem = new LebaViewItem();
            try
            {
              localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo = ((ResourcePluginInfo)localObject3);
              if (((ResourcePluginInfo)localObject3).cDataType != 1)
              {
                localObject4 = JumpParser.a(paramQQAppInterface, paramContext, ((ResourcePluginInfo)localObject3).strGotoUrl);
                if ((localObject4 != null) && ("app".equals(((JumpAction)localObject4).a())))
                {
                  localObject3 = ((JumpAction)localObject4).a("cmp");
                  String str = ((JumpAction)localObject4).a("pkg");
                  if ((localObject3 != null) && (((String)localObject3).compareTo("cooperation.readinjoy.ReadInJoyProxyActivity") == 0))
                  {
                    bool1 = bool2;
                    if (!ReadInJoyHelper.a()) {
                      continue;
                    }
                  }
                  if ((localObject3 != null) && (str != null))
                  {
                    localObject4 = paramContext.getPackageManager();
                    localObject3 = new ComponentName(str, (String)localObject3);
                  }
                }
              }
            }
            catch (Exception localException)
            {
              try
              {
                Object localObject4;
                ((PackageManager)localObject4).getActivityInfo((ComponentName)localObject3, 32);
                if (!LebaUtil.a(localLebaViewItem)) {
                  break label512;
                }
                this.jdField_a_of_type_JavaUtilHashMap.put(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName, localLebaViewItem);
                bool1 = bool2;
              }
              catch (PackageManager.NameNotFoundException localNameNotFoundException)
              {
                localNameNotFoundException.printStackTrace();
                bool1 = bool2;
              }
              localException = localException;
              bool1 = bool2;
            }
            if (QLog.isColorLevel())
            {
              bool1 = bool2;
              if (localException != null)
              {
                QLog.d("Q.lebatab.mgr", 2, localException.toString());
                bool1 = bool2;
                continue;
                continue;
                label512:
                if (localNameNotFoundException.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.cDataType == 0)
                {
                  bool1 = bool2;
                  if (localNameNotFoundException.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId == 826L) {}
                }
                else
                {
                  ((List)localObject1).add(localNameNotFoundException);
                  bool1 = bool2;
                }
              }
            }
          }
        }
      }
      if (localWholePeopleLebaEntryChecker != null) {
        localWholePeopleLebaEntryChecker.a(bool1);
      }
      Collections.sort((List)localObject1, new LebaUtil.LebaItemComparator());
      paramContext = (RedTouchManager)paramQQAppInterface.getManager(35);
      if (paramContext != null) {
        break label617;
      }
    }
    label617:
    for (paramContext = null;; paramContext = paramContext.b())
    {
      a(paramQQAppInterface, (List)localObject1, paramContext);
      LebaUtil.a(localArrayList, a(paramQQAppInterface));
      return localArrayList;
    }
  }
  
  public List a(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    char c = paramQQAppInterface.getApp().getSharedPreferences("now_tab_sp", 0).getString("now_show_key" + paramQQAppInterface.getCurrentAccountUin(), "00100").charAt(2);
    for (;;)
    {
      LebaViewItem localLebaViewItem;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localLebaViewItem = (LebaViewItem)localIterator.next();
        if ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId == 905L)) {
          continue;
        }
        if (("看点".equals(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName)) && (ReadInJoyHelper.h()))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.lebatab.mgr", 2, "hide leba kandian");
        }
      }
      if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId == 6005L)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("getLebaShowList isNowTabAdded:");
          paramQQAppInterface.a();
          QLog.d("Q.qqstory.fourTab", 2, NowLiveManager.c + "  isNowTabShow:" + paramQQAppInterface.a().jdField_a_of_type_Boolean + " plan:" + c + "  isSDKAPISupportStory:" + QQStoryManager.j());
        }
        if ((!paramQQAppInterface.a().a()) || (localLebaViewItem.jdField_a_of_type_Byte == 1)) {}
      }
      else if ((localLebaViewItem.jdField_a_of_type_Byte == 0) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId == 0L))
      {
        localArrayList.add(localLebaViewItem);
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      jdField_a_of_type_Int = 0;
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = a();
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)((Iterator)localObject).next();
        if (localLebaViewItem != null) {
          if (localLebaViewItem.jdField_a_of_type_Byte == 0)
          {
            if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null) {
              ReportController.b(paramQQAppInterface, "CliStatus", "", "", "trends_tab", "Clk_plug_in_s", 0, 0, "1", String.valueOf(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId), "", "");
            }
          }
          else if ((localLebaViewItem.jdField_a_of_type_Byte == 1) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null)) {
            ReportController.b(paramQQAppInterface, "CliStatus", "", "", "trends_tab", "Clk_plug_in_s", 0, 0, "0", String.valueOf(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId), "", "");
          }
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
          if ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId != paramLong1)) {
            continue;
          }
          if (paramBoolean)
          {
            i = 0;
            localLebaViewItem.jdField_a_of_type_Byte = ((byte)i);
            if (paramLong3 == -9223372036854775808L)
            {
              localLebaViewItem.jdField_a_of_type_Long = paramLong2;
              i = 1;
              if ((paramQQAppInterface != null) && (i == 1)) {
                ThreadManager.post(new wvc(this, (RedTouchManager)paramQQAppInterface.getManager(35), paramLong1, paramBoolean, paramLong3, paramLong2), 5, null, true);
              }
              if (QLog.isDevelopLevel()) {
                QLog.i("Q.lebatab.mgr", 4, "updateAppSetting, ret = " + i);
              }
            }
          }
          else
          {
            i = 1;
            continue;
          }
          if (paramLong2 != localLebaViewItem.jdField_a_of_type_Long) {
            break label222;
          }
          localLebaViewItem.jdField_a_of_type_Long = paramLong3;
          i = 1;
        }
      }
      int i = 1;
      continue;
      label222:
      i = -2147483648;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, List paramList1, List paramList2)
  {
    int i;
    if (QLog.isDevelopLevel())
    {
      ??? = new StringBuilder().append("setAllLebaList, ");
      if (paramList1 != null) {
        break label111;
      }
      i = 0;
    }
    for (;;)
    {
      QLog.i("Q.lebatab.mgr", 4, i);
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        if (paramList1 != null) {
          this.jdField_a_of_type_JavaUtilList.addAll(paramList1);
        }
        a(paramList2);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = (RedTouchHandler)paramQQAppInterface.a(31);
          if (paramQQAppInterface != null) {
            paramQQAppInterface.a(1, true, null);
          }
        }
        return;
        label111:
        i = paramList1.size();
      }
    }
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
        continue;
        if (!localIterator1.hasNext()) {
          break;
        }
        LebaViewItem localLebaViewItem = (LebaViewItem)localIterator1.next();
        if ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null)) {
          continue;
        }
        long l = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId;
        if (l == 0L) {
          continue;
        }
        Iterator localIterator2 = paramList.iterator();
        if (!localIterator2.hasNext()) {
          continue;
        }
        BusinessInfoCheckUpdate.AppSetting localAppSetting = (BusinessInfoCheckUpdate.AppSetting)localIterator2.next();
        if ((localAppSetting == null) || (localAppSetting.appid.get() != l)) {
          continue;
        }
        if (localAppSetting.setting.get())
        {
          b = 0;
          localLebaViewItem.jdField_a_of_type_Byte = b;
          localLebaViewItem.jdField_a_of_type_Long = localAppSetting.modify_ts.get();
        }
      }
      byte b = 1;
    }
  }
  
  public boolean a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
        if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId == 905L)) {
          return true;
        }
      }
      return false;
    }
  }
  
  public List b()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
        if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId != 905L) && ((localLebaViewItem.jdField_a_of_type_Byte == 0) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId == 0L))) {
          localArrayList.add(localLebaViewItem);
        }
      }
    }
    return localList2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.leba.LebaShowListManager
 * JD-Core Version:    0.7.0.1
 */