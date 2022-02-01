package com.tencent.biz.qqcircle.publish.model;

import FileUpload.stPoi;
import NS_MOBILE_OPERATION.LbsInfo;
import cooperation.qzone.LbsDataV2.PoiInfo;
import java.util.HashMap;
import java.util.Map;

public class QzoneMediaUploadParams
{
  public Map<String, String> A;
  public Map<String, byte[]> B;
  public Map<String, String> C;
  public Map<String, String> D;
  public Map<String, String> E;
  public Map<String, byte[]> F;
  public LbsInfo G;
  public LbsDataV2.PoiInfo H;
  public boolean I;
  public boolean J;
  public boolean K;
  public String L;
  public boolean M;
  public boolean N = false;
  public String O;
  public int a;
  public String b;
  public long c;
  public String d;
  public int e;
  public long f = 0L;
  public String g;
  public int h;
  public String i;
  public boolean j;
  public int k;
  public int l;
  public byte[] m = null;
  public HashMap<String, String> n = null;
  public boolean o;
  public String p;
  public boolean q = true;
  public boolean r = false;
  public boolean s;
  public boolean t;
  public int u = -1;
  public int v = -1;
  public stPoi w;
  public String x;
  public int y = -1;
  public QZonePreUploadInfo z;
  
  public QzoneMediaUploadParams a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public QzoneMediaUploadParams a(long paramLong)
  {
    this.c = paramLong;
    return this;
  }
  
  public QzoneMediaUploadParams a(LbsInfo paramLbsInfo)
  {
    this.G = paramLbsInfo;
    return this;
  }
  
  public QzoneMediaUploadParams a(QZonePreUploadInfo paramQZonePreUploadInfo)
  {
    this.z = paramQZonePreUploadInfo;
    return this;
  }
  
  public QzoneMediaUploadParams a(LbsDataV2.PoiInfo paramPoiInfo)
  {
    this.H = paramPoiInfo;
    return this;
  }
  
  public QzoneMediaUploadParams a(String paramString)
  {
    this.O = paramString;
    return this;
  }
  
  public QzoneMediaUploadParams a(Map<String, String> paramMap)
  {
    this.A = paramMap;
    return this;
  }
  
  public QzoneMediaUploadParams a(boolean paramBoolean)
  {
    this.q = paramBoolean;
    return this;
  }
  
  public boolean a()
  {
    return this.r;
  }
  
  public QzoneMediaUploadParams b(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public QzoneMediaUploadParams b(long paramLong)
  {
    this.f = paramLong;
    return this;
  }
  
  public QzoneMediaUploadParams b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public QzoneMediaUploadParams b(Map<String, byte[]> paramMap)
  {
    this.B = paramMap;
    return this;
  }
  
  public QzoneMediaUploadParams b(boolean paramBoolean)
  {
    this.t = paramBoolean;
    return this;
  }
  
  public QzoneMediaUploadParams c(int paramInt)
  {
    this.h = paramInt;
    return this;
  }
  
  public QzoneMediaUploadParams c(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public QzoneMediaUploadParams c(Map<String, String> paramMap)
  {
    this.C = paramMap;
    return this;
  }
  
  public QzoneMediaUploadParams c(boolean paramBoolean)
  {
    this.I = paramBoolean;
    return this;
  }
  
  public QzoneMediaUploadParams d(int paramInt)
  {
    this.k = paramInt;
    return this;
  }
  
  public QzoneMediaUploadParams d(String paramString)
  {
    this.L = paramString;
    return this;
  }
  
  public QzoneMediaUploadParams d(boolean paramBoolean)
  {
    this.K = paramBoolean;
    return this;
  }
  
  public QzoneMediaUploadParams e(int paramInt)
  {
    this.l = paramInt;
    return this;
  }
  
  public QzoneMediaUploadParams e(boolean paramBoolean)
  {
    this.M = paramBoolean;
    return this;
  }
  
  public QzoneMediaUploadParams f(int paramInt)
  {
    this.y = paramInt;
    return this;
  }
  
  public QzoneMediaUploadParams f(boolean paramBoolean)
  {
    this.N = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.model.QzoneMediaUploadParams
 * JD-Core Version:    0.7.0.1
 */