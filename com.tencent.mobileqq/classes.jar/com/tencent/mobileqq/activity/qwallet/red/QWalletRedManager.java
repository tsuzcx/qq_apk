package com.tencent.mobileqq.activity.qwallet.red;

import Wallet.RedInfoSyncReq;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonServlet;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfig.ConfigInfo;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager.ConfigUpdateListener;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.manager.Manager;
import xgp;
import xgq;

public class QWalletRedManager
  implements QWalletConfigManager.ConfigUpdateListener, Manager
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
    ThreadManager.executeOnSubThread(new xgp(this));
  }
  
  public QWalletRedManager.ShowInfo a(String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedQWRedConfig.getShowInfoByPath(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("QWalletRedManager", 2, "getShowInfo" + paramString);
    }
    return paramString;
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
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      QWRedConfig.RedInfo localRedInfo = (QWRedConfig.RedInfo)localIterator.next();
      if (localRedInfo.doClick()) {
        paramString.add(localRedInfo);
      }
    }
    if (paramString.size() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedQWRedConfig.saveConfig();
      QWalletCommonServlet.a(RedInfoSyncReq.createReq(paramString), new xgq(this));
    }
    if (localList.size() > 0) {
      VACDReportUtil.a(null, "QWalletStat", "QWalletRedShow", "QWalletRedShow", QWRedConfig.RedInfo.transToReportStr(localList), 0, null);
    }
  }
  
  public void a(String paramString1, String paramString2, QWalletConfig.ConfigInfo paramConfigInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedQWRedConfig.parseConfig(paramConfigInfo);
  }
  
  public void a(List paramList)
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
    VACDReportUtil.a(null, "QWalletStat", "QWalletRedClick", "QWalletRedClick", QWRedConfig.RedInfo.transToReportStr(localLinkedList), 0, null);
  }
  
  public void b(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramString);
    a(localLinkedList);
  }
  
  public void onDestroy()
  {
    QWalletConfigManager localQWalletConfigManager = (QWalletConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(244);
    if (localQWalletConfigManager != null) {
      localQWalletConfigManager.b("redPoint", this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager
 * JD-Core Version:    0.7.0.1
 */