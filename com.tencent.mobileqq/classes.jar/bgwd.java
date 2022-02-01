import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class bgwd
  implements Manager
{
  private final QQAppInterface a;
  
  public bgwd(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public static bgwd a(QQAppInterface paramQQAppInterface)
  {
    return (bgwd)paramQQAppInterface.getManager(QQManagerFactory.UPGRADE_MANAGER);
  }
  
  public boolean a()
  {
    if (bgvx.a().a() == 4) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeManager", 2, new Object[] { "hasNewApkDownloaded: invoked. ", " hasDl: ", Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  public boolean a(UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    if ((paramUpgradeDetailWrapper == null) || (paramUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig == null) || (paramUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (paramUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog == null)) {}
    int i;
    int j;
    int k;
    long l1;
    long l2;
    do
    {
      return false;
      i = bhhr.aO(this.a.getApp(), this.a.getCurrentUin());
      j = paramUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.c;
      k = paramUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.d;
      l1 = bhhr.k(this.a.getApp(), this.a.getCurrentUin());
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeManager", 2, new Object[] { "needShowDownloadDialog: invoked. ", " downloadDialogMaxTimes: ", Integer.valueOf(j), " downloadDialogShownTimes: ", Integer.valueOf(i), " downloadDialogDayRate: ", Integer.valueOf(k), " downloadDialogShownTimestamp: ", Long.valueOf(l1), " now: ", Long.valueOf(l2) });
      }
    } while ((i >= j) || (l2 - l1 < k * 86400000L));
    return true;
  }
  
  public boolean b(UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    if ((paramUpgradeDetailWrapper == null) || (paramUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig == null) || (paramUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (paramUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog == null)) {}
    int i;
    int j;
    int k;
    long l1;
    long l2;
    do
    {
      return false;
      i = bhhr.aP(this.a.getApp(), this.a.getCurrentUin());
      j = paramUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.e;
      k = paramUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.f;
      l1 = bhhr.l(this.a.getApp(), this.a.getCurrentUin());
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeManager", 2, new Object[] { "needShowInstallDialog: invoked. ", " installDialogMaxTimes: ", Integer.valueOf(j), " installDialogShownTimes: ", Integer.valueOf(i), " installDialogDayRate: ", Integer.valueOf(k), " installDialogShownTimestamp: ", Long.valueOf(l1), " now: ", Long.valueOf(l2) });
      }
    } while ((i >= j) || (l2 - l1 < k * 86400000L));
    return true;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgwd
 * JD-Core Version:    0.7.0.1
 */