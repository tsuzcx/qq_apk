package com.tencent.biz.qqcircle.publish.uploader.report;

import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneThreadHelper;
import cooperation.qqcircle.utils.NetworkState;
import java.util.ArrayList;
import java.util.Random;

public class QcirclrBusinessReport
{
  private static Random a = new Random();
  private static final Object[] b = new Object[16];
  private static long c = SystemClock.uptimeMillis();
  private static SparseArray<ArrayList<ReportObj>> d = new SparseArray(16);
  private static boolean e = true;
  
  public static void a()
  {
    int i = 0;
    if (i < 16)
    {
      if ((i != 1) && (i != 11)) {}
      try
      {
        d.append(i, new ArrayList());
      }
      finally
      {
        for (;;)
        {
          throw localObject;
        }
        i += 1;
      }
      d.append(i, e());
    }
    for (;;)
    {
      if (i < b.length)
      {
        b[i] = new Object();
        i += 1;
      }
      else
      {
        e = false;
        return;
        break;
        i = 0;
      }
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (e) {
      a();
    }
    if (!a(paramInt1)) {
      return;
    }
    if (!b(paramInt2)) {
      return;
    }
    if (!NetworkState.isNetSupport()) {
      return;
    }
    int i = paramInt1 + paramInt2;
    ArrayList localArrayList1 = (ArrayList)d.get(i);
    synchronized (b[i])
    {
      ArrayList localArrayList2 = new ArrayList(localArrayList1);
      if ((i != 1) && (i != 11)) {
        d.setValueAt(i, new ArrayList());
      } else {
        d.setValueAt(i, e());
      }
      localArrayList1.clear();
      c = SystemClock.uptimeMillis();
      QCircleHostQzoneThreadHelper.postReportThreadThread(new QcirclrBusinessReport.ReportRunnable(localArrayList2, paramInt1, paramInt2));
      return;
    }
  }
  
  public static void a(ReportObj paramReportObj, int paramInt1, int paramInt2)
  {
    if (paramReportObj == null) {
      return;
    }
    if (e) {
      a();
    }
    if (!a(paramInt1)) {
      return;
    }
    if (!b(paramInt2)) {
      return;
    }
    if (paramReportObj.o >= 0L)
    {
      if (paramReportObj.p > 900000L) {
        return;
      }
      int i = paramInt1 + paramInt2;
      long l1 = SystemClock.uptimeMillis();
      long l2 = c;
      ArrayList localArrayList = (ArrayList)d.get(i);
      if (localArrayList == null) {
        return;
      }
      synchronized (b[i])
      {
        localArrayList.add(paramReportObj);
        switch (i)
        {
        case 13: 
        default: 
          return;
        case 5: 
          a(paramInt1, paramInt2);
          return;
        case 1: 
        case 7: 
        case 11: 
          if ((localArrayList.size() >= 10) || (l1 - l2 >= 600000L)) {
            a(paramInt1, paramInt2);
          }
          break;
        }
        return;
      }
    }
  }
  
  private static boolean a(int paramInt)
  {
    return (paramInt % 2 == 0) && (paramInt >= 0) && (paramInt < 16);
  }
  
  private static boolean b(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private static boolean d()
  {
    return false;
  }
  
  private static ArrayList<ReportObj> e()
  {
    return new QcirclrBusinessReport.1();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.uploader.report.QcirclrBusinessReport
 * JD-Core Version:    0.7.0.1
 */