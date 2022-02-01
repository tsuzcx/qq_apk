package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;

public class QZoneEntryReporterInLeba
{
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneEntryReporterInLeba", 2, "leba 曝光上报");
    }
    QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
    localReportInfo.actionType = "637";
    localReportInfo.subactionType = "10";
    QZoneClickReport.report(paramQQAppInterface.getAccount(), localReportInfo, true);
  }
  
  public static void a(QZoneManagerImp paramQZoneManagerImp, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = QLog.isColorLevel();
    int n = 2;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Leba isTableModel:");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.i("QZoneEntryReporterInLeba", 2, ((StringBuilder)localObject).toString());
    }
    int i3 = 0;
    int i2;
    if (paramQZoneManagerImp != null) {
      i2 = paramQZoneManagerImp.a(1);
    } else {
      i2 = 0;
    }
    int i1;
    if (paramQZoneManagerImp != null) {
      i1 = paramQZoneManagerImp.a(2);
    } else {
      i1 = 0;
    }
    String str = "";
    int m;
    int i;
    int j;
    int k;
    if ((i2 <= 0) && (i1 <= 0))
    {
      localObject = null;
      QZoneCountInfo localQZoneCountInfo1;
      if (paramQZoneManagerImp != null) {
        localQZoneCountInfo1 = paramQZoneManagerImp.a(6);
      } else {
        localQZoneCountInfo1 = null;
      }
      QZoneCountInfo localQZoneCountInfo2;
      if (paramQZoneManagerImp != null) {
        localQZoneCountInfo2 = paramQZoneManagerImp.a(61);
      } else {
        localQZoneCountInfo2 = null;
      }
      QZoneCountInfo localQZoneCountInfo3;
      if (paramQZoneManagerImp != null) {
        localQZoneCountInfo3 = paramQZoneManagerImp.a(3);
      } else {
        localQZoneCountInfo3 = null;
      }
      if (paramQZoneManagerImp != null) {
        localObject = paramQZoneManagerImp.a(1013);
      }
      if ((localQZoneCountInfo1 != null) && (localQZoneCountInfo1.friendList != null) && (localQZoneCountInfo1.friendList.size() > 0) && (((QZoneCountUserInfo)localQZoneCountInfo1.friendList.get(0)).uin > 0L) && (localQZoneCountInfo1.uCount > 0L) && (!TextUtils.isEmpty(localQZoneCountInfo1.strShowMsg)))
      {
        paramQZoneManagerImp = localQZoneCountInfo1.strShowMsg;
        m = 1;
        i = 1;
      }
      else
      {
        m = 0;
        i = 0;
        paramQZoneManagerImp = str;
      }
      if ((m == 0) && (localQZoneCountInfo2 != null) && (localQZoneCountInfo2.friendList != null) && (localQZoneCountInfo2.friendList.size() > 0) && (((QZoneCountUserInfo)localQZoneCountInfo2.friendList.get(0)).uin > 0L) && (localQZoneCountInfo2.uCount > 0L) && (!TextUtils.isEmpty(localQZoneCountInfo2.strShowMsg)))
      {
        paramQZoneManagerImp = localQZoneCountInfo2.strShowMsg;
        m = 1;
        j = 1;
      }
      else
      {
        j = 0;
      }
      if ((m == 0) && (LebaQzoneAndPluginPart.a(localQZoneCountInfo3)) && (!TextUtils.isEmpty(localQZoneCountInfo3.strShowMsg)))
      {
        paramQZoneManagerImp = localQZoneCountInfo3.strShowMsg;
        m = 1;
        k = 1;
      }
      else
      {
        k = 0;
      }
      if ((m == 0) && (LebaQzoneAndPluginPart.b((QZoneCountInfo)localObject)) && (!TextUtils.isEmpty(((QZoneCountInfo)localObject).strShowMsg)))
      {
        paramQZoneManagerImp = ((QZoneCountInfo)localObject).strShowMsg;
        m = 1;
        i3 = 1;
      }
    }
    else
    {
      paramQZoneManagerImp = "";
      m = 0;
      k = 0;
      i = 0;
      j = 0;
    }
    Object localObject = "1";
    if (m == 0)
    {
      if (i2 <= 0)
      {
        if (i1 <= 0)
        {
          if (paramBoolean1) {
            i = 1;
          } else {
            i = 2;
          }
          if (paramBoolean2) {
            paramQZoneManagerImp = "1";
          } else {
            paramQZoneManagerImp = "2";
          }
          LpReportInfo_pf00064.report(637, 13, i, paramQZoneManagerImp, "0", null);
          return;
        }
        if (paramBoolean1) {
          n = 1;
        }
        if (paramBoolean2) {
          paramQZoneManagerImp = "1";
        } else {
          paramQZoneManagerImp = "2";
        }
        if (i1 > 1) {
          localObject = "2";
        } else {
          localObject = "1";
        }
        LpReportInfo_pf00064.report(637, 11, n, paramQZoneManagerImp, (String)localObject, null);
        return;
      }
      if (i1 <= 0)
      {
        if (paramBoolean1) {
          i = 1;
        } else {
          i = 2;
        }
        if (paramBoolean2) {
          paramQZoneManagerImp = "1";
        } else {
          paramQZoneManagerImp = "2";
        }
        LpReportInfo_pf00064.report(637, 12, i, paramQZoneManagerImp, "0", null);
        return;
      }
      if (paramBoolean1) {
        n = 1;
      }
      if (paramBoolean2) {
        paramQZoneManagerImp = "1";
      } else {
        paramQZoneManagerImp = "2";
      }
      if (i1 > 1) {
        localObject = "2";
      }
      LpReportInfo_pf00064.report(637, 14, n, paramQZoneManagerImp, (String)localObject, null);
      return;
    }
    if (k != 0)
    {
      if (paramBoolean1) {
        i = 1;
      } else {
        i = 2;
      }
      if (paramBoolean2) {
        localObject = "1";
      } else {
        localObject = "2";
      }
      LpReportInfo_pf00064.report(637, 15, i, (String)localObject, null, paramQZoneManagerImp);
      return;
    }
    if (i != 0)
    {
      if (paramBoolean1) {
        i = 1;
      } else {
        i = 2;
      }
      if (paramBoolean2) {
        localObject = "1";
      } else {
        localObject = "2";
      }
      LpReportInfo_pf00064.report(637, 17, i, (String)localObject, null, paramQZoneManagerImp);
      return;
    }
    if (j != 0)
    {
      if (paramBoolean1) {
        i = 1;
      } else {
        i = 2;
      }
      if (paramBoolean2) {
        localObject = "1";
      } else {
        localObject = "2";
      }
      LpReportInfo_pf00064.report(637, 16, i, (String)localObject, null, paramQZoneManagerImp);
      return;
    }
    if (i3 != 0)
    {
      if (paramBoolean1) {
        i = 1;
      } else {
        i = 2;
      }
      if (paramBoolean2) {
        localObject = "1";
      } else {
        localObject = "2";
      }
      LpReportInfo_pf00064.report(637, 46, i, (String)localObject, null, paramQZoneManagerImp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QZoneEntryReporterInLeba
 * JD-Core Version:    0.7.0.1
 */