package com.tencent.ilivesdk.avpreloadplayerservice.report;

import android.os.Build;
import android.os.Build.VERSION;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class AVPreloadReport
  extends AVBaseReport
{
  private AVPreloadReport.ReportData c;
  
  private String a(long paramLong)
  {
    if (paramLong == 0L) {
      return " ";
    }
    Date localDate = new Date();
    localDate.setTime(paramLong);
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss_SSS").format(localDate);
  }
  
  private float c()
  {
    return (float)(Runtime.getRuntime().totalMemory() / 1048576L);
  }
  
  public void a()
  {
    if (this.c == null) {
      return;
    }
    this.a.put("attaid", "01000048340");
    this.a.put("token", "9298697425");
    this.a.put("terminal", "android");
    this.a.put("mode", Build.MODEL);
    this.a.put("clienttype", this.c.b);
    this.a.put("network", this.c.m);
    this.a.put("vistorsrc", this.c.a);
    this.a.put("bundle", this.c.h);
    this.a.put("roomid", this.c.c);
    this.a.put("name", this.c.d);
    this.a.put("userid", this.c.e);
    this.a.put("guid", this.c.f);
    this.a.put("anchorid", this.c.g);
    this.a.put("playtime", a(this.c.i));
    Object localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(a(this.c.j));
    ((Map)localObject1).put("clipstarttime", ((StringBuilder)localObject2).toString());
    localObject1 = this.a;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(a(this.c.k));
    ((Map)localObject1).put("clipfinishtime", ((StringBuilder)localObject2).toString());
    localObject1 = this.a;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(a(this.c.l));
    ((Map)localObject1).put("playstoptime", ((StringBuilder)localObject2).toString());
    localObject1 = this.a;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.c.o);
    ((Map)localObject1).put("snapshot", ((StringBuilder)localObject2).toString());
    localObject1 = this.a;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.c.p);
    ((Map)localObject1).put("firstframe", ((StringBuilder)localObject2).toString());
    localObject1 = this.a;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.c.q);
    ((Map)localObject1).put("clipduration", ((StringBuilder)localObject2).toString());
    localObject1 = this.a;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.c.r);
    ((Map)localObject1).put("clipsize", ((StringBuilder)localObject2).toString());
    localObject1 = this.a;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.c.s);
    ((StringBuilder)localObject2).append("x");
    ((StringBuilder)localObject2).append(this.c.t);
    ((StringBuilder)localObject2).append("@");
    ((StringBuilder)localObject2).append(this.c.u);
    ((StringBuilder)localObject2).append("@");
    ((StringBuilder)localObject2).append(this.c.v);
    ((Map)localObject1).put("mediainfo", ((StringBuilder)localObject2).toString());
    this.a.put("url", this.c.w);
    Object localObject3 = this.a;
    boolean bool = this.c.x;
    localObject2 = "0";
    if (bool) {
      localObject1 = "0";
    } else {
      localObject1 = "1";
    }
    ((Map)localObject3).put("ismiss", localObject1);
    localObject3 = this.a;
    if (this.c.y) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    ((Map)localObject3).put("chaseframe", localObject1);
    localObject1 = this.a;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(this.c.z);
    ((Map)localObject1).put("errorcode", ((StringBuilder)localObject3).toString());
    this.a.put("eventid", this.c.A);
    localObject1 = this.a;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(this.c.B);
    ((Map)localObject1).put("netspeed", ((StringBuilder)localObject3).toString());
    localObject1 = this.a;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(this.c.n);
    ((Map)localObject1).put("cpurate", ((StringBuilder)localObject3).toString());
    localObject1 = this.a;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(c());
    ((Map)localObject1).put("memorysize", ((StringBuilder)localObject3).toString());
    localObject1 = this.a;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(this.c.C);
    ((Map)localObject1).put("framegaptime", ((StringBuilder)localObject3).toString());
    localObject3 = this.a;
    if (this.c.D) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    ((Map)localObject3).put("isplayconnect", localObject1);
    this.a.put("taskid", this.c.E);
    localObject1 = this.a;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(this.c.F);
    ((Map)localObject1).put("showsnapshottime", ((StringBuilder)localObject3).toString());
    localObject1 = this.a;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(this.c.G);
    ((Map)localObject1).put("avgnetspeed", ((StringBuilder)localObject3).toString());
    this.a.put("osversion", Build.VERSION.RELEASE);
    localObject1 = this.a;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(this.c.H);
    ((Map)localObject1).put("devicememorysize", ((StringBuilder)localObject3).toString());
    localObject3 = this.a;
    localObject1 = localObject2;
    if (this.c.I) {
      localObject1 = "1";
    }
    ((Map)localObject3).put("isswitchroom", localObject1);
  }
  
  public void a(AVPreloadReport.ReportData paramReportData)
  {
    this.c = paramReportData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadplayerservice.report.AVPreloadReport
 * JD-Core Version:    0.7.0.1
 */