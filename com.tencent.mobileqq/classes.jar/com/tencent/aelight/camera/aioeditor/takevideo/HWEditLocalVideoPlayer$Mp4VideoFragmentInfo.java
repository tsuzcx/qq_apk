package com.tencent.aelight.camera.aioeditor.takevideo;

import android.graphics.Bitmap;

public class HWEditLocalVideoPlayer$Mp4VideoFragmentInfo
  extends VideoFragmentInfo
{
  public String a;
  public String b;
  public boolean c = false;
  private long f = 0L;
  private long g = 0L;
  private int h = 0;
  private boolean i = false;
  private Bitmap j = null;
  private boolean k = false;
  private boolean l = false;
  private Bitmap m;
  
  public HWEditLocalVideoPlayer$Mp4VideoFragmentInfo(int paramInt, Bitmap paramBitmap)
  {
    super(paramInt, paramBitmap);
    this.m = paramBitmap;
  }
  
  public Mp4VideoFragmentInfo a(Bitmap paramBitmap)
  {
    paramBitmap = new Mp4VideoFragmentInfo(this.d, paramBitmap);
    paramBitmap.m = this.m;
    paramBitmap.f = this.f;
    paramBitmap.g = this.g;
    paramBitmap.h = this.h;
    paramBitmap.i = this.i;
    paramBitmap.j = this.j;
    paramBitmap.a = this.a;
    paramBitmap.b = this.b;
    this.k = false;
    this.l = false;
    this.c = false;
    return paramBitmap;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Mp4VideoFragmentInfo{index=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", bitmap=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", startTime=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", endTime=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", mRevertFailed=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.HWEditLocalVideoPlayer.Mp4VideoFragmentInfo
 * JD-Core Version:    0.7.0.1
 */