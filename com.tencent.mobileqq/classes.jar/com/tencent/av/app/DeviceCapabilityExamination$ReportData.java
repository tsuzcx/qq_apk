package com.tencent.av.app;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.mediacodec.AndroidCodec;
import com.tencent.av.mediacodec.AndroidCodecUtil;
import com.tencent.qphone.base.util.QLog;

public class DeviceCapabilityExamination$ReportData
{
  public int A = 0;
  public int B = 0;
  public int C = 0;
  public int D = 0;
  public String a = Build.HARDWARE;
  public String b = Build.MANUFACTURER;
  public String c = Build.MODEL;
  public String d = Build.PRODUCT;
  public String e = Build.FINGERPRINT;
  public String f = VcSystemInfo.getCpuModel();
  public int g = Build.VERSION.SDK_INT;
  public long h = 0L;
  public int i = 0;
  public String j = "";
  public String k = "";
  public int l = 0;
  public int m = 0;
  public int n = 0;
  public int o = 0;
  public int p = 0;
  public int q = 0;
  public int r = 0;
  public int s = 0;
  public String t = "";
  public int u = 0;
  public long v = 0L;
  public long w = 0L;
  public int x = 0;
  public int y = 0;
  public int z = 0;
  
  public String a()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(this.a);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.b);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.c);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.d);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.e);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.f);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.g);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.h);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.i);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.j);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.k);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.l);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.m);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.n);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.o);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.p);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.q);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.r);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.s);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.t);
    localStringBuilder1.append("|");
    this.u = VcSystemInfo.getNumCores();
    this.v = (VcSystemInfo.getMaxCpuFreq() / 1024L);
    this.w = (VcSystemInfo.getMemoryTotal() / 1024L);
    this.x = AndroidCodec.getHwDetectOutputFormatForReport();
    this.y = AndroidCodecUtil.b;
    this.z = AndroidCodecUtil.c;
    this.A = AndroidCodecUtil.d;
    this.B = AndroidCodecUtil.e;
    this.C = AndroidCodecUtil.f;
    this.D = AndroidCodecUtil.g;
    localStringBuilder1.append(this.u);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.v);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.w);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.x);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.y);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.z);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.A);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.B);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.C);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.D);
    localStringBuilder1.append("|");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("ReportData:");
    localStringBuilder2.append(localStringBuilder1.toString());
    QLog.i("DeviceCapabilityExamination", 1, localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.DeviceCapabilityExamination.ReportData
 * JD-Core Version:    0.7.0.1
 */