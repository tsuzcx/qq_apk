package com.tencent.biz.qqcircle.publish.model;

import com.tencent.biz.qqcircle.publish.queue.util.NeedParcel;
import com.tencent.biz.qqcircle.publish.queue.util.SmartParcelable;

public class VideoInfo
  implements SmartParcelable
{
  @NeedParcel
  public String a;
  @NeedParcel
  public VideoUrl b;
  @NeedParcel
  public PictureUrl c;
  @NeedParcel
  public int d;
  @NeedParcel
  public String e;
  @NeedParcel
  public VideoUrl f;
  @NeedParcel
  public VideoUrl g;
  @NeedParcel
  public VideoUrl h;
  @NeedParcel
  public int i;
  @NeedParcel
  public long j;
  @NeedParcel
  public int k;
  @NeedParcel
  public int l;
  @NeedParcel
  public long m;
  @NeedParcel
  public int n;
  @NeedParcel
  public int o = 0;
  @NeedParcel
  public boolean p = false;
  @NeedParcel
  public boolean q = true;
  @NeedParcel
  public boolean r = true;
  @NeedParcel
  public long s = -1L;
  @NeedParcel
  public int t = 0;
  @NeedParcel
  public int u = 0;
  @NeedParcel
  public int v = 0;
  @NeedParcel
  public int w = 0;
  @NeedParcel
  public String x = "";
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoInfo [videoId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", videoUrl=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", bigUrl=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", actionType=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", actionUrl=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", highBrUrl=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", lowBrUrl=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", fileType=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", videoType=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(",videoShowType=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", videoTime=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", videoStatus=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", originVideoUrl=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", originVideoSize=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", currentVideoRate=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", videoForm=");
    localStringBuilder.append(this.v);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.model.VideoInfo
 * JD-Core Version:    0.7.0.1
 */