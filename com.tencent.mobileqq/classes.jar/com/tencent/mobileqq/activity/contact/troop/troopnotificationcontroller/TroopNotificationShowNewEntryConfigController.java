package com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller;

import com.tencent.mobileqq.activity.contact.troop.TroopNotificationManager;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationManager.INewTroopNotificationUnreadCountOrConfigChangedListener;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RecentManagerFor3rdPart;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.TroopNotificationEntryConfig;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class TroopNotificationShowNewEntryConfigController
  extends ITroopNotificationController
{
  private List<TroopNotificationManager.INewTroopNotificationUnreadCountOrConfigChangedListener> a;
  
  public TroopNotificationShowNewEntryConfigController(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  }
  
  private void c()
  {
    Object localObject1 = (RecentManagerFor3rdPart)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.RECENT_MANAGER_FOR_3RDPART);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "updateRecentUserListWhenNewEntryNotShow, Recent need to create and add");
    }
    Object localObject2 = ((TroopNotificationManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER)).a();
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      localObject2 = GroupSystemMsgController.a().a();
      if (localObject2 != null)
      {
        long l = ((structmsg.StructMsg)localObject2).msg_time.get();
        ((RecentManagerFor3rdPart)localObject1).a(AppConstants.TROOP_NOTIFICATION_UIN, 9000, HardCodeUtil.a(2131691181), l, l);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
        if (localObject1 != null) {
          ((MqqHandler)localObject1).sendMessage(((MqqHandler)localObject1).obtainMessage(1009));
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 1, "updateRecentUserListWhenNewEntryNotShow, Recent be Added");
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "updateRecentUserListWhenNewEntryNotShow, structMsg is null");
      return;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "updateRecentUserListWhenNewEntryNotShow, getMessageRecordListFromCache() is null or empty");
      }
      ((RecentManagerFor3rdPart)localObject1).a(AppConstants.TROOP_NOTIFICATION_UIN, 9000);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (localObject1 != null) {
        ((MqqHandler)localObject1).sendMessage(((MqqHandler)localObject1).obtainMessage(1009));
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "updateRecentUserListWhenNewEntryNotShow, getMessageRecordListFromCache() is null or empty。 when deleteRecent");
  }
  
  private void c(TroopNotificationEntryConfig paramTroopNotificationEntryConfig)
  {
    if (QLog.isColorLevel())
    {
      if (paramTroopNotificationEntryConfig != null) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "updateRecentUserListWhenHasNewConf, newConf = " + paramTroopNotificationEntryConfig.toString());
      }
    }
    else
    {
      if ((paramTroopNotificationEntryConfig != null) && (paramTroopNotificationEntryConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        break label92;
      }
      c();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "updateRecentUserListWhenHasNewConf, call updateRecentUserListWhenNewEntryNotShow");
      }
    }
    label92:
    do
    {
      return;
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "updateRecentUserListWhenHasNewConf, newConf is null ");
      break;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "updateRecentUserListWhenHasNewConf, delete notification entry in recent");
      }
      ((RecentManagerFor3rdPart)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.RECENT_MANAGER_FOR_3RDPART)).a(AppConstants.TROOP_NOTIFICATION_UIN, 9000);
      paramTroopNotificationEntryConfig = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    } while (paramTroopNotificationEntryConfig == null);
    paramTroopNotificationEntryConfig.sendMessage(paramTroopNotificationEntryConfig.obtainMessage(1009));
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new TroopNotificationShowNewEntryConfigController.1(this, paramInt));
  }
  
  public void a(TroopNotificationManager.INewTroopNotificationUnreadCountOrConfigChangedListener paramINewTroopNotificationUnreadCountOrConfigChangedListener)
  {
    if (paramINewTroopNotificationUnreadCountOrConfigChangedListener != null) {
      this.jdField_a_of_type_JavaUtilList.add(paramINewTroopNotificationUnreadCountOrConfigChangedListener);
    }
  }
  
  public void a(TroopNotificationEntryConfig paramTroopNotificationEntryConfig)
  {
    ThreadManager.getUIHandler().post(new TroopNotificationShowNewEntryConfigController.2(this, paramTroopNotificationEntryConfig));
  }
  
  public void b()
  {
    super.b();
  }
  
  public void b(TroopNotificationManager.INewTroopNotificationUnreadCountOrConfigChangedListener paramINewTroopNotificationUnreadCountOrConfigChangedListener)
  {
    if (paramINewTroopNotificationUnreadCountOrConfigChangedListener != null) {
      this.jdField_a_of_type_JavaUtilList.remove(paramINewTroopNotificationUnreadCountOrConfigChangedListener);
    }
  }
  
  public void b(TroopNotificationEntryConfig paramTroopNotificationEntryConfig)
  {
    if (paramTroopNotificationEntryConfig == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "INewTroopNotificationUnreadCountChangedListener, newConf = " + paramTroopNotificationEntryConfig.toString());
    }
    a(paramTroopNotificationEntryConfig);
    c(paramTroopNotificationEntryConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller.TroopNotificationShowNewEntryConfigController
 * JD-Core Version:    0.7.0.1
 */