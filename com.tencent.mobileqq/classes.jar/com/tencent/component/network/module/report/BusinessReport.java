package com.tencent.component.network.module.report;

import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.module.base.Config;
import java.util.ArrayList;
import java.util.Random;

public class BusinessReport
{
  private static final int APP_OP_COUNT = 12;
  private static final int MAX_COUNT = 10;
  private static final int MAX_TIME = 600000;
  private static final int RADOM_PERCENT = 5;
  private static final String TAG = "BusinessReport";
  private static SparseArray<ArrayList<ReportObj>> appReportLists = new SparseArray(12);
  private static final Object init_lock;
  private static volatile boolean inited;
  private static final Object[] locks;
  private static CommonTaskThread mTaskThread = new CommonTaskThread("BusinessReport");
  private static Random r = new Random();
  private static long startTime;
  
  static
  {
    locks = new Object[12];
    init_lock = new Object();
    inited = false;
    startTime = SystemClock.uptimeMillis();
  }
  
  private static ArrayList<ReportObj> createRamdomArrayList()
  {
    return new BusinessReport.1();
  }
  
  private static int getReportPercent()
  {
    int i = 100;
    int j = Config.getReportPercent();
    if (j < 0) {
      i = 5;
    }
    while (j > 100) {
      return i;
    }
    return j;
  }
  
  public static void init()
  {
    int k = 0;
    if (inited) {
      return;
    }
    synchronized (init_lock)
    {
      if (inited) {
        return;
      }
    }
    inited = true;
    int j = 0;
    break label100;
    appReportLists.append(j, createRamdomArrayList());
    break label122;
    label53:
    appReportLists.append(j, new ArrayList());
    break label122;
    label70:
    int i;
    while (i < locks.length)
    {
      locks[i] = new Object();
      i += 1;
    }
    return;
    for (;;)
    {
      label100:
      i = k;
      if (j >= 12) {
        break label70;
      }
      if (j == 1) {
        break;
      }
      if (j != 11) {
        break label53;
      }
      break;
      label122:
      j += 1;
    }
  }
  
  public static void uploadReport(ReportObj paramReportObj, int paramInt1, int paramInt2)
  {
    if (((paramInt1 < 0) || (paramInt1 > 9)) && (paramInt1 % 2 != 0)) {}
    for (;;)
    {
      return;
      if ((paramInt2 == 0) || (paramInt2 == 1))
      {
        int i = paramInt1 + paramInt2;
        long l1 = SystemClock.uptimeMillis();
        long l2 = startTime;
        ArrayList localArrayList = (ArrayList)appReportLists.get(i);
        synchronized (locks[i])
        {
          localArrayList.add(paramReportObj);
          switch (i)
          {
          case 0: 
          case 2: 
          case 3: 
          case 4: 
          case 6: 
          case 8: 
          case 9: 
          case 10: 
          default: 
            return;
          case 1: 
          case 7: 
          case 11: 
            if ((localArrayList.size() >= 10) || (l1 - l2 >= 600000L))
            {
              uploadReportImmediately(paramInt1, paramInt2);
              return;
            }
            break;
          }
        }
      }
    }
    uploadReportImmediately(paramInt1, paramInt2);
  }
  
  public static void uploadReportImmediately(int paramInt1, int paramInt2)
  {
    if (((paramInt1 < 0) || (paramInt1 > 11)) && (paramInt1 % 2 != 0)) {}
    int i;
    ArrayList localArrayList1;
    do
    {
      do
      {
        return;
      } while (((paramInt2 != 0) && (paramInt2 != 1)) || (!NetworkManager.isNetworkAvailable()));
      i = paramInt1 + paramInt2;
      localArrayList1 = (ArrayList)appReportLists.get(i);
    } while (localArrayList1.isEmpty());
    synchronized (locks[i])
    {
      ArrayList localArrayList2 = new ArrayList(localArrayList1);
      if ((i == 1) || (i == 11))
      {
        appReportLists.setValueAt(i, createRamdomArrayList());
        localArrayList1.clear();
        startTime = SystemClock.uptimeMillis();
        mTaskThread.post(new BusinessReport.ReportRunnable(localArrayList2, paramInt1, paramInt2));
        return;
      }
      appReportLists.setValueAt(i, new ArrayList());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.report.BusinessReport
 * JD-Core Version:    0.7.0.1
 */