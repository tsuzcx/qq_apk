package com.tencent.mobileqq.activity.qwallet.red;

import Wallet.RedInfo;
import Wallet.RedInfoSyncReq;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonServlet;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigApi.ConfigInfo;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService.ConfigUpdateListener;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.manager.Manager;

public class QWalletRedManager
  implements IQWalletConfigService.ConfigUpdateListener, Manager
{
  private QWRedConfig jdField_a_of_type_ComTencentMobileqqActivityQwalletRedQWRedConfig;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public QWalletRedManager(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletRedManager", 2, "QWalletRedManager init");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedQWRedConfig = QWRedConfig.readConfig(paramQQAppInterface);
    a();
  }
  
  private void a()
  {
    ThreadManager.executeOnSubThread(new QWalletRedManager.1(this));
  }
  
  public QWalletRedManager.ShowInfo a(String paramString)
  {
    QWalletRedManager.ShowInfo localShowInfo = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedQWRedConfig.getShowInfoByPath(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("QWalletRedManager", 2, "getShowInfo path=" + paramString + ",res=" + localShowInfo);
    }
    return localShowInfo;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedQWRedConfig.getNotShowListStr();
  }
  
  public void a(String paramString)
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedQWRedConfig.getCurShowRedInfosByPath(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("QWalletRedManager", 2, "doClick" + paramString + "|" + localList);
    }
    paramString = new LinkedList();
    Object localObject = localList.iterator();
    QWRedConfig.RedInfo localRedInfo;
    while (((Iterator)localObject).hasNext())
    {
      localRedInfo = (QWRedConfig.RedInfo)((Iterator)localObject).next();
      if (localRedInfo.doClick()) {
        paramString.add(localRedInfo);
      }
    }
    if (paramString.size() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedQWRedConfig.saveConfig();
      localObject = new ArrayList();
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        localRedInfo = (QWRedConfig.RedInfo)paramString.next();
        ((ArrayList)localObject).add(new RedInfo(localRedInfo.path, localRedInfo.taskId, localRedInfo.isShow));
      }
      QWalletCommonServlet.a(new RedInfoSyncReq(1, DeviceInfoUtil.c(), DeviceInfoUtil.e(), DeviceInfoUtil.i(), (ArrayList)localObject), new QWalletRedManager.2(this));
    }
    if (localList.size() > 0) {
      VACDReportUtil.a(null, "QWalletStat", "QWalletRedClick", "QWalletRedClick", QWRedConfig.RedInfo.transToReportStr(localList), 0, null);
    }
  }
  
  public void a(List<String> paramList)
  {
    if (paramList == null) {}
    LinkedList localLinkedList;
    do
    {
      return;
      localLinkedList = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        localLinkedList.addAll(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedQWRedConfig.getCurShowRedInfosByPath(str));
      }
    } while (localLinkedList.size() <= 0);
    VACDReportUtil.a(null, "QWalletStat", "QWalletRedShow", "QWalletRedShow", QWRedConfig.RedInfo.transToReportStr(localLinkedList), 0, null);
  }
  
  public void b(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramString);
    a(localLinkedList);
  }
  
  public void onDestroy()
  {
    QWalletConfigManager localQWalletConfigManager = (QWalletConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
    if (localQWalletConfigManager != null) {
      localQWalletConfigManager.d("redPoint", this);
    }
  }
  
  public void onUpdate(String paramString1, String paramString2, IQWalletConfigApi.ConfigInfo paramConfigInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedQWRedConfig.parseConfig(paramConfigInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager
 * JD-Core Version:    0.7.0.1
 */