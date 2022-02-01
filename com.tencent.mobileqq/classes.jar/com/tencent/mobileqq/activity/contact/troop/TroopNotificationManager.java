package com.tencent.mobileqq.activity.contact.troop;

import com.tencent.mobileqq.activity.contact.troop.generalgroupnotifyparser.GeneralGroupNotifyParser;
import com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller.ITroopNotificationController;
import com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller.TroopNotificationApplicantInfoController;
import com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller.TroopNotificationGeneralGroupNotifyParserController;
import com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller.TroopNotificationRecordMessageController;
import com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller.TroopNotificationShowNewEntryConfigController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.config.TroopNotificationEntryConfig;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;

public class TroopNotificationManager
  implements Manager
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Object jdField_a_of_type_JavaLangObject = new Object();
  private final String jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  Map<Class, ITroopNotificationController> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  public TroopNotificationManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private <T extends ITroopNotificationController> T a(Class<T> paramClass)
  {
    Object localObject1 = (ITroopNotificationController)this.jdField_a_of_type_JavaUtilMap.get(paramClass);
    if (localObject1 == null) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        ITroopNotificationController localITroopNotificationController = (ITroopNotificationController)this.jdField_a_of_type_JavaUtilMap.get(paramClass);
        localObject1 = localITroopNotificationController;
        if (localITroopNotificationController == null)
        {
          localObject1 = b(paramClass);
          if (localObject1 != null)
          {
            QLog.i(this.jdField_a_of_type_JavaLangString, 1, "Controller name:" + paramClass.getSimpleName() + " is not null");
            this.jdField_a_of_type_JavaUtilMap.put(paramClass, localObject1);
          }
        }
        else
        {
          return localObject1;
        }
        QLog.i(this.jdField_a_of_type_JavaLangString, 1, "Controller name:" + paramClass.getSimpleName() + " is null");
      }
    }
    return localObject1;
  }
  
  private void a(Exception paramException)
  {
    if ((paramException instanceof NoSuchMethodException))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "genController getDeclaredConstructor throw NoSuchMethodException e:" + paramException.getMessage());
      return;
    }
    if ((paramException instanceof SecurityException))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "genController getDeclaredConstructor or setAccessible throw SecurityException e:" + paramException.getMessage());
      return;
    }
    if (((paramException instanceof IllegalAccessException)) || ((paramException instanceof IllegalArgumentException)) || ((paramException instanceof InstantiationException)) || ((paramException instanceof InvocationTargetException)))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "genController newInstance throw Exception e:" + paramException.getMessage() + "Exception name:" + paramException.getClass().getSimpleName());
      return;
    }
    QLog.e(this.jdField_a_of_type_JavaLangString, 1, "genController throw other Exception e:" + paramException.getMessage() + "Exception name:" + paramException.getClass().getSimpleName());
  }
  
  private ITroopNotificationController b(Class paramClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredConstructor(new Class[] { QQAppInterface.class });
      paramClass.setAccessible(true);
      paramClass = (ITroopNotificationController)paramClass.newInstance(new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface });
      return paramClass;
    }
    catch (Exception paramClass)
    {
      paramClass.printStackTrace();
      a(paramClass);
    }
    return null;
  }
  
  private void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      ITroopNotificationController localITroopNotificationController = (ITroopNotificationController)localIterator.next();
      if (localITroopNotificationController != null) {
        localITroopNotificationController.b();
      }
    }
  }
  
  private void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      ITroopNotificationController localITroopNotificationController = (ITroopNotificationController)localIterator.next();
      if (localITroopNotificationController != null) {
        localITroopNotificationController.a();
      }
    }
  }
  
  public TroopNotifyApplicantInfo a(Long paramLong)
  {
    return ((TroopNotificationApplicantInfoController)a(TroopNotificationApplicantInfoController.class)).a(paramLong);
  }
  
  public GeneralGroupNotifyParser a(int paramInt)
  {
    return ((TroopNotificationGeneralGroupNotifyParserController)a(TroopNotificationGeneralGroupNotifyParserController.class)).a(paramInt);
  }
  
  public List<MessageRecord> a()
  {
    return ((TroopNotificationRecordMessageController)a(TroopNotificationRecordMessageController.class)).a();
  }
  
  public List<MessageRecord> a(int paramInt)
  {
    return ((TroopNotificationRecordMessageController)a(TroopNotificationRecordMessageController.class)).a(paramInt);
  }
  
  public List<MessageRecord> a(ThreadExcutor.IThreadListener paramIThreadListener)
  {
    return ((TroopNotificationRecordMessageController)a(TroopNotificationRecordMessageController.class)).a(paramIThreadListener);
  }
  
  public List<Long> a(String paramString)
  {
    return ((TroopNotificationApplicantInfoController)a(TroopNotificationApplicantInfoController.class)).a(paramString);
  }
  
  public List<Long> a(List<oidb_0x5eb.UdcUinData> paramList)
  {
    return ((TroopNotificationApplicantInfoController)a(TroopNotificationApplicantInfoController.class)).a(paramList);
  }
  
  public void a()
  {
    ((TroopNotificationApplicantInfoController)a(TroopNotificationApplicantInfoController.class)).c();
  }
  
  public void a(int paramInt)
  {
    ((TroopNotificationShowNewEntryConfigController)a(TroopNotificationShowNewEntryConfigController.class)).a(paramInt);
  }
  
  public void a(long paramLong, int paramInt)
  {
    ((TroopNotificationApplicantInfoController)a(TroopNotificationApplicantInfoController.class)).a(paramLong, paramInt);
  }
  
  public void a(long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    ((TroopNotificationRecordMessageController)a(TroopNotificationRecordMessageController.class)).a(paramLong, paramString, paramInt, paramBoolean);
  }
  
  public void a(TroopNotificationManager.INewTroopNotificationUnreadCountOrConfigChangedListener paramINewTroopNotificationUnreadCountOrConfigChangedListener)
  {
    ((TroopNotificationShowNewEntryConfigController)a(TroopNotificationShowNewEntryConfigController.class)).a(paramINewTroopNotificationUnreadCountOrConfigChangedListener);
  }
  
  public void a(TroopNotificationEntryConfig paramTroopNotificationEntryConfig)
  {
    ((TroopNotificationShowNewEntryConfigController)a(TroopNotificationShowNewEntryConfigController.class)).b(paramTroopNotificationEntryConfig);
  }
  
  public void a(Long paramLong)
  {
    ((TroopNotificationApplicantInfoController)a(TroopNotificationApplicantInfoController.class)).a(paramLong, 0, "OidbSvc.0x5eb_troopnotifycation");
  }
  
  public void a(List<Long> paramList)
  {
    ((TroopNotificationApplicantInfoController)a(TroopNotificationApplicantInfoController.class)).a("OidbSvc.0x5eb_troopnotifycation", paramList);
  }
  
  public void a(List<MessageRecord> paramList, int paramInt)
  {
    ((TroopNotificationRecordMessageController)a(TroopNotificationRecordMessageController.class)).a(paramList, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    ((TroopNotificationRecordMessageController)a(TroopNotificationRecordMessageController.class)).a(paramBoolean);
  }
  
  public boolean a()
  {
    return ((TroopNotificationRecordMessageController)a(TroopNotificationRecordMessageController.class)).a();
  }
  
  public void b()
  {
    c();
  }
  
  public void b(TroopNotificationManager.INewTroopNotificationUnreadCountOrConfigChangedListener paramINewTroopNotificationUnreadCountOrConfigChangedListener)
  {
    ((TroopNotificationShowNewEntryConfigController)a(TroopNotificationShowNewEntryConfigController.class)).b(paramINewTroopNotificationUnreadCountOrConfigChangedListener);
  }
  
  public void b(Long paramLong)
  {
    ((TroopNotificationApplicantInfoController)a(TroopNotificationApplicantInfoController.class)).a(paramLong, 0, "OidbSvc.0x668");
  }
  
  public void b(List<Long> paramList)
  {
    ((TroopNotificationApplicantInfoController)a(TroopNotificationApplicantInfoController.class)).a("OidbSvc.0x668", paramList);
  }
  
  public void c(List<Long> paramList)
  {
    ((TroopNotificationApplicantInfoController)a(TroopNotificationApplicantInfoController.class)).a(paramList, "OidbSvc.0x5eb_troopnotifycation");
  }
  
  public void d(List<Long> paramList)
  {
    ((TroopNotificationApplicantInfoController)a(TroopNotificationApplicantInfoController.class)).a(paramList, "OidbSvc.0x668");
  }
  
  public void onDestroy()
  {
    d();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotificationManager
 * JD-Core Version:    0.7.0.1
 */