package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.ocr.ARCloudReqOcrInfo;

public class ARCloudReqInfo
{
  public String a = "";
  public ARCloudReqFileInfo b;
  public int c = 0;
  public int d = 0;
  public long e = 0L;
  public int f = -1;
  public ARCloudReqMarkerInfo g;
  public ARCloudRecogReqObjectClassifyInfo h;
  public ARCloudRecogReqFaceInfo i;
  public ARCloudRecogReqPreOcrInfo j;
  public ARCloudRecogReqObjectClassifyInfo k;
  public ARCloudRecogReqSceneRecogInfo l;
  public ARCloudReqOcrInfo m;
  public ARCloudReqTranslateInfo n;
  public String o = "";
  public long p = 0L;
  public long q;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARCloudReqInfo{sessionId = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", fileInfo = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", longitude = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", latitude = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", recogType = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", businessType = ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", markerInfo = ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", objectClassifyInfo = ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", preOcrInfo = ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", sceneRecogInfo = ");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", ocrInfo = ");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", appid = ");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", uin = ");
    localStringBuilder.append(this.p);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudReqInfo
 * JD-Core Version:    0.7.0.1
 */