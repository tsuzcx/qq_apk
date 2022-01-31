package com.tencent.mobileqq.app.soso;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.LbsReportInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.servlet.ReportServlet;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import zsv;

public class LbsInfoReportManager
  implements Manager, BusinessObserver
{
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private double jdField_b_of_type_Double;
  private long jdField_b_of_type_Long;
  
  public LbsInfoReportManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private int a()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Int <= 0)
        {
          this.jdField_a_of_type_Int = (new Random().nextInt(1000000) + 100);
          int i = this.jdField_a_of_type_Int;
          return i;
        }
        if (this.jdField_a_of_type_Int >= 1000100) {
          this.jdField_a_of_type_Int = 100;
        } else {
          this.jdField_a_of_type_Int += 1;
        }
      }
      finally {}
    }
  }
  
  private LbsReportInfo a(double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(NetConnInfoCenter.getServerTime())).append("|").append(paramDouble1).append("|").append(paramDouble2).append("|").append(paramDouble3).append("|").append(paramFloat).append("|").append(paramString).append("|").append("android");
    paramString = new LbsReportInfo();
    paramString.content = localStringBuilder.toString();
    return paramString;
  }
  
  private ArrayList a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      LbsReportInfo localLbsReportInfo = (LbsReportInfo)paramArrayList.get(i);
      if ((localLbsReportInfo != null) && (!TextUtils.isEmpty(localLbsReportInfo.content))) {
        localArrayList.add("dc01864");
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void a()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(LbsReportInfo.class);
    if ((localList != null) && (!localList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(localList);
      if (QLog.isColorLevel()) {
        QLog.i("LBSReport", 2, "initLbsReportInfoFromDB info list size is: " + localList.size());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
      if (QLog.isColorLevel()) {
        QLog.i("LBSReport", 2, "initLbsReportInfoFromDB info list is empty.");
      }
    }
  }
  
  public static void a(double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat, String paramString)
  {
    int i = 1;
    if ((paramDouble1 == 0.0D) || (paramDouble2 == 0.0D)) {
      return;
    }
    if (BaseApplicationImpl.sProcessId == 1) {}
    Intent localIntent;
    for (;;)
    {
      localIntent = new Intent();
      localIntent.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      localIntent.putExtra("is_runtime", 1001);
      localIntent.putExtra("lat", paramDouble1);
      localIntent.putExtra("lng", paramDouble2);
      localIntent.putExtra("alt", paramDouble3);
      localIntent.putExtra("accuracy", paramFloat);
      localIntent.putExtra("businessTag", paramString);
      if (i == 0) {
        break label145;
      }
      paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramString == null) {
        break;
      }
      ((LbsInfoReportManager)paramString.getManager(125)).a(localIntent);
      return;
      i = 0;
    }
    label145:
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      if (QLog.isColorLevel()) {
        QLog.i("LBSReport", 2, "onReceiveLbsInfo intent is null. return.");
      }
    }
    double d1;
    double d2;
    double d3;
    float f;
    double d4;
    double d5;
    do
    {
      do
      {
        return;
        d1 = paramIntent.getDoubleExtra("lat", 0.0D);
        d2 = paramIntent.getDoubleExtra("lng", 0.0D);
        d3 = paramIntent.getDoubleExtra("alt", 0.0D);
        f = paramIntent.getFloatExtra("accuracy", 0.0F);
        paramIntent = paramIntent.getStringExtra("businessTag");
        if ((d1 != 0.0D) && (d2 != 0.0D)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("LBSReport", 2, "onReceiveLbsInfo lat or lng is 0.0d. return.");
      return;
      d4 = TencentLocationUtils.distanceBetween(d1, d2, this.jdField_a_of_type_Double, this.jdField_b_of_type_Double);
      d5 = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
      if ((d4 >= 20.0D) || (d5 >= 180000.0D)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("LBSReport", 2, "onReceiveLbsInfo distance is: " + d4 + " collectGap: " + d5);
    return;
    ThreadManager.executeOnSubThread(new zsv(this, d1, d2, d3, f, paramIntent));
  }
  
  public void a(ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt1, int paramInt2)
  {
    if ((paramArrayList1 == null) || (paramArrayList1.isEmpty()) || (paramArrayList2 == null) || (paramArrayList2.isEmpty())) {
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApp(), ReportServlet.class);
    localNewIntent.putExtra("sendType", 10);
    localNewIntent.putExtra("seqKey", paramInt1);
    localNewIntent.putExtra("tags", paramArrayList1);
    localNewIntent.putExtra("contents", paramArrayList2);
    localNewIntent.putExtra("retryTime", paramInt2 + 1);
    localNewIntent.setObserver(this);
    localQQAppInterface.startServlet(localNewIntent);
  }
  
  public void onDestroy() {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 10)
    {
      int i = paramBundle.getInt("seqKey");
      paramInt = 0;
      if (QLog.isColorLevel()) {
        QLog.d("LBSReport", 2, "OnReceive: isSuccess-" + paramBoolean + ", seqKey = " + i);
      }
      if (!paramBoolean) {
        paramInt = paramBundle.getInt("retryTime");
      }
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if ((!paramBoolean) && (paramInt < 2) && (localQQAppInterface != null)) {
        a(paramBundle.getStringArrayList("tags"), paramBundle.getStringArrayList("contents"), i, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.LbsInfoReportManager
 * JD-Core Version:    0.7.0.1
 */