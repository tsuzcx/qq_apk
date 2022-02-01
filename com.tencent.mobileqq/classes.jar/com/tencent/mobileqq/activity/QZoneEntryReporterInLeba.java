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
    if (QLog.isColorLevel()) {
      QLog.i("QZoneEntryReporterInLeba", 2, "Leba isTableModel:" + paramBoolean2);
    }
    int i2;
    int i1;
    label53:
    int k;
    int i3;
    int n;
    int m;
    Object localObject;
    label94:
    QZoneCountInfo localQZoneCountInfo2;
    label106:
    QZoneCountInfo localQZoneCountInfo1;
    label117:
    QZoneCountInfo localQZoneCountInfo3;
    label130:
    int j;
    int i;
    if (paramQZoneManagerImp != null)
    {
      i2 = paramQZoneManagerImp.a(1);
      if (paramQZoneManagerImp == null) {
        break label515;
      }
      i1 = paramQZoneManagerImp.a(2);
      String str = "";
      k = 0;
      i3 = 0;
      n = 0;
      m = 0;
      int i4 = 0;
      if ((i2 > 0) || (i1 > 0)) {
        break label927;
      }
      if (paramQZoneManagerImp == null) {
        break label521;
      }
      localObject = paramQZoneManagerImp.a(6);
      if (paramQZoneManagerImp == null) {
        break label527;
      }
      localQZoneCountInfo2 = paramQZoneManagerImp.a(61);
      if (paramQZoneManagerImp == null) {
        break label533;
      }
      localQZoneCountInfo1 = paramQZoneManagerImp.a(3);
      if (paramQZoneManagerImp == null) {
        break label539;
      }
      localQZoneCountInfo3 = paramQZoneManagerImp.a(1013);
      j = i4;
      i = n;
      paramQZoneManagerImp = str;
      if (localObject != null)
      {
        j = i4;
        i = n;
        paramQZoneManagerImp = str;
        if (((QZoneCountInfo)localObject).friendList != null)
        {
          j = i4;
          i = n;
          paramQZoneManagerImp = str;
          if (((QZoneCountInfo)localObject).friendList.size() > 0)
          {
            j = i4;
            i = n;
            paramQZoneManagerImp = str;
            if (((QZoneCountUserInfo)((QZoneCountInfo)localObject).friendList.get(0)).uin > 0L)
            {
              j = i4;
              i = n;
              paramQZoneManagerImp = str;
              if (((QZoneCountInfo)localObject).uCount > 0L)
              {
                j = i4;
                i = n;
                paramQZoneManagerImp = str;
                if (!TextUtils.isEmpty(((QZoneCountInfo)localObject).strShowMsg))
                {
                  paramQZoneManagerImp = ((QZoneCountInfo)localObject).strShowMsg;
                  j = 1;
                  i = 1;
                }
              }
            }
          }
        }
      }
      if ((j != 0) || (localQZoneCountInfo2 == null) || (localQZoneCountInfo2.friendList == null) || (localQZoneCountInfo2.friendList.size() <= 0) || (((QZoneCountUserInfo)localQZoneCountInfo2.friendList.get(0)).uin <= 0L) || (localQZoneCountInfo2.uCount <= 0L) || (TextUtils.isEmpty(localQZoneCountInfo2.strShowMsg))) {
        break label916;
      }
      paramQZoneManagerImp = localQZoneCountInfo2.strShowMsg;
      n = 1;
      j = 1;
      label348:
      m = n;
      localObject = paramQZoneManagerImp;
      k = i3;
      if (n == 0)
      {
        m = n;
        localObject = paramQZoneManagerImp;
        k = i3;
        if (LebaQzoneAndPluginPart.a(localQZoneCountInfo1))
        {
          m = n;
          localObject = paramQZoneManagerImp;
          k = i3;
          if (!TextUtils.isEmpty(localQZoneCountInfo1.strShowMsg))
          {
            localObject = localQZoneCountInfo1.strShowMsg;
            m = 1;
            k = 1;
          }
        }
      }
      if ((m != 0) || (!LebaQzoneAndPluginPart.b(localQZoneCountInfo3)) || (TextUtils.isEmpty(localQZoneCountInfo3.strShowMsg))) {
        break label889;
      }
      paramQZoneManagerImp = localQZoneCountInfo3.strShowMsg;
      i3 = 1;
      i4 = 1;
      n = i;
      m = j;
      j = i4;
      i = i3;
    }
    for (;;)
    {
      if (i == 0) {
        if (i2 <= 0) {
          if (i1 <= 0) {
            if (paramBoolean1)
            {
              i = 1;
              label488:
              if (!paramBoolean2) {
                break label550;
              }
              paramQZoneManagerImp = "1";
              label495:
              LpReportInfo_pf00064.report(637, 13, i, paramQZoneManagerImp, "0", null);
            }
          }
        }
      }
      label515:
      label521:
      label527:
      label533:
      label539:
      label550:
      label569:
      label598:
      label604:
      label747:
      do
      {
        return;
        i2 = 0;
        break;
        i1 = 0;
        break label53;
        localObject = null;
        break label94;
        localQZoneCountInfo2 = null;
        break label106;
        localQZoneCountInfo1 = null;
        break label117;
        localQZoneCountInfo3 = null;
        break label130;
        i = 2;
        break label488;
        paramQZoneManagerImp = "2";
        break label495;
        if (paramBoolean1)
        {
          i = 1;
          if (!paramBoolean2) {
            break label598;
          }
          paramQZoneManagerImp = "1";
          if (i1 <= 1) {
            break label604;
          }
        }
        for (localObject = "2";; localObject = "1")
        {
          LpReportInfo_pf00064.report(637, 11, i, paramQZoneManagerImp, (String)localObject, null);
          return;
          i = 2;
          break;
          paramQZoneManagerImp = "2";
          break label569;
        }
        if (i1 <= 0)
        {
          if (paramBoolean1)
          {
            i = 1;
            if (!paramBoolean2) {
              break label648;
            }
          }
          for (paramQZoneManagerImp = "1";; paramQZoneManagerImp = "2")
          {
            LpReportInfo_pf00064.report(637, 12, i, paramQZoneManagerImp, "0", null);
            return;
            i = 2;
            break;
          }
        }
        if (paramBoolean1)
        {
          i = 1;
          if (!paramBoolean2) {
            break label696;
          }
          paramQZoneManagerImp = "1";
          if (i1 <= 1) {
            break label702;
          }
        }
        for (localObject = "2";; localObject = "1")
        {
          LpReportInfo_pf00064.report(637, 14, i, paramQZoneManagerImp, (String)localObject, null);
          return;
          i = 2;
          break;
          paramQZoneManagerImp = "2";
          break label667;
        }
        if (k != 0)
        {
          if (paramBoolean1)
          {
            i = 1;
            if (!paramBoolean2) {
              break label747;
            }
          }
          for (localObject = "1";; localObject = "2")
          {
            LpReportInfo_pf00064.report(637, 15, i, (String)localObject, null, paramQZoneManagerImp);
            return;
            i = 2;
            break;
          }
        }
        if (n != 0)
        {
          if (paramBoolean1)
          {
            i = 1;
            if (!paramBoolean2) {
              break label792;
            }
          }
          for (localObject = "1";; localObject = "2")
          {
            LpReportInfo_pf00064.report(637, 17, i, (String)localObject, null, paramQZoneManagerImp);
            return;
            i = 2;
            break;
          }
        }
        if (m != 0)
        {
          if (paramBoolean1)
          {
            i = 1;
            if (!paramBoolean2) {
              break label837;
            }
          }
          for (localObject = "1";; localObject = "2")
          {
            LpReportInfo_pf00064.report(637, 16, i, (String)localObject, null, paramQZoneManagerImp);
            return;
            i = 2;
            break;
          }
        }
      } while (j == 0);
      label648:
      label667:
      label696:
      label702:
      label837:
      if (paramBoolean1)
      {
        i = 1;
        if (!paramBoolean2) {
          break label882;
        }
      }
      label792:
      label882:
      for (localObject = "1";; localObject = "2")
      {
        LpReportInfo_pf00064.report(637, 46, i, (String)localObject, null, paramQZoneManagerImp);
        return;
        i = 2;
        break;
      }
      label889:
      n = j;
      i3 = i;
      paramQZoneManagerImp = (QZoneManagerImp)localObject;
      j = 0;
      i = m;
      m = n;
      n = i3;
      continue;
      label916:
      n = j;
      j = m;
      break label348;
      label927:
      i = 0;
      j = 0;
      m = 0;
      n = 0;
      paramQZoneManagerImp = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QZoneEntryReporterInLeba
 * JD-Core Version:    0.7.0.1
 */