package com.tencent.biz.qqcircle.publish.task.report;

import android.os.Build;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.publish.account.LoginData;
import java.util.Vector;

public class TaskReportInfo
{
  public long a = LoginData.a().b();
  public String b = Build.MODEL;
  public String c = HostDataTransUtils.getQUA3();
  public int d = 0;
  public int e = 0;
  public int f;
  public int g;
  public long h;
  public long i;
  public long j;
  public Vector<TaskReportInfo.MediaReportInfo> k;
  public int l;
  public long m;
  public long n;
  public long o;
  public Vector<TaskReportInfo.MediaReportInfo> p;
  
  public void a(TaskReportInfo.MediaReportInfo paramMediaReportInfo)
  {
    if (paramMediaReportInfo == null) {
      return;
    }
    try
    {
      int i1 = paramMediaReportInfo.a;
      if (i1 != 0) {
        if (i1 != 1)
        {
          if (i1 == 2)
          {
            if (this.k == null) {
              this.k = new Vector();
            }
            this.k.add(paramMediaReportInfo);
            this.f += 1;
            this.g += 1;
            this.h += paramMediaReportInfo.c;
            this.i += paramMediaReportInfo.d;
            this.j += paramMediaReportInfo.a();
          }
        }
        else
        {
          if (this.p == null) {
            this.p = new Vector();
          }
          this.p.add(paramMediaReportInfo);
          this.f += 1;
          this.l += 1;
          this.m += paramMediaReportInfo.c;
          this.n += paramMediaReportInfo.d;
          this.o += paramMediaReportInfo.a();
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.task.report.TaskReportInfo
 * JD-Core Version:    0.7.0.1
 */