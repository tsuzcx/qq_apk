package com.tencent.ark.open;

import com.tencent.ark.ArkViewModelBase.TimeRecord;
import com.tencent.ark.Logger;
import com.tencent.ark.StringUtil;
import com.tencent.ark.open.internal.ArkAppReport;

public class ArkAppInfo$TimeRecord
{
  public long beginOfGetApp = 0L;
  public long endOfGetApp = 0L;
  public boolean getAppFromLocal = false;
  public ArkViewModelBase.TimeRecord mRecord;
  
  public ArkAppInfo$TimeRecord(ArkViewModelBase.TimeRecord paramTimeRecord)
  {
    this.mRecord = paramTimeRecord;
  }
  
  private boolean isValid()
  {
    return (this.endOfGetApp != 0L) && (this.beginOfGetApp != 0L) && (this.mRecord.endOfCreateView != 0L) && (this.mRecord.beginOfCreateView != 0L) && (this.mRecord.endOfDisplyView != 0L) && (this.mRecord.beginOfDisplyView != 0L);
  }
  
  public void doExtraTimeReport()
  {
    int i = (int)(this.mRecord.beginOfCreateContext - this.mRecord.endOfDisplyView);
    int j = (int)(this.mRecord.endOfCreateDrawTarget - this.mRecord.beginOfCreateContext);
    int k = (int)(this.mRecord.endOfFirstDraw - this.mRecord.beginOfFirstDraw);
    int m = (int)(this.mRecord.endOfFirstDraw - this.mRecord.beginOfDisplyView);
    String str1 = this.mRecord.appName;
    String str2 = this.mRecord.view;
    Logger.logI("ArkApp.ArkAppInfo", StringUtil.format("TimeRecord.appName.%s.view.%s.surfaceprepare.%d.createcontext.%d.firstdraw.%d.totalcost.%d.", new Object[] { str1, str2, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) }));
    if (str1 != null)
    {
      if (str2 == null) {
        return;
      }
      ArkAppReport.legacyReport(str1, "PerfSurfacePrepare", 0, 0, i, 0L, 0L, str2, "");
      ArkAppReport.legacyReport(str1, "PerfCreateContext", 0, 0, j, 0L, 0L, str2, "");
      ArkAppReport.legacyReport(str1, "PerfFirstDraw", 0, 0, k, 0L, 0L, str2, "");
      ArkAppReport.legacyReport(str1, "PerfDisplayTotalCost", 0, 0, m, 0L, 0L, str2, "");
    }
  }
  
  public void doReport()
  {
    if (!isValid()) {
      return;
    }
    int j = (int)(this.endOfGetApp - this.beginOfGetApp);
    int k = (int)(this.mRecord.endOfCreateView - this.mRecord.beginOfCreateView);
    int m = (int)(this.mRecord.endOfDisplyView - this.mRecord.beginOfDisplyView);
    int n = (int)(this.mRecord.endOfFirstDraw - this.mRecord.beginOfFirstDraw);
    String str1 = this.mRecord.appName;
    String str2 = this.mRecord.view;
    Logger.logI("ArkApp.ArkAppInfo", StringUtil.format("TimeRecord.appName.%s.view:%s.getapp.%d.createview.%d.dispview.%d.", new Object[] { str1, str2, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) }));
    if (str1 != null)
    {
      if (str2 == null) {
        return;
      }
      int i;
      if (this.getAppFromLocal) {
        i = 1;
      } else {
        i = 2;
      }
      ArkAppReport.legacyReport(str1, "PerfGetApp", 0, i, j, 0L, 0L, str2, "");
      ArkAppReport.legacyReport(str1, "PerfCreateView", 0, 0, k, 0L, 0L, str2, "");
      ArkAppReport.legacyReport(str1, "PerfDisplayView", 0, 0, m, 0L, 0L, str2, "");
      ArkAppReport.reportDisplayView(str1, str2, true, 100, m, n);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppInfo.TimeRecord
 * JD-Core Version:    0.7.0.1
 */