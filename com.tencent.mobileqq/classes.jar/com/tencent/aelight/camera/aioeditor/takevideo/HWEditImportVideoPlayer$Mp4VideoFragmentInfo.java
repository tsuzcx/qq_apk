package com.tencent.aelight.camera.aioeditor.takevideo;

import android.graphics.Bitmap;

public class HWEditImportVideoPlayer$Mp4VideoFragmentInfo
  extends VideoFragmentInfo
{
  public String a;
  public String b;
  private long c = 0L;
  private long f = 0L;
  private int g = 0;
  private boolean h = false;
  private Bitmap i = null;
  private boolean j = false;
  private boolean k = false;
  private Bitmap l;
  
  public HWEditImportVideoPlayer$Mp4VideoFragmentInfo(int paramInt, Bitmap paramBitmap)
  {
    super(paramInt, paramBitmap);
    this.l = paramBitmap;
  }
  
  public Mp4VideoFragmentInfo a(Bitmap paramBitmap)
  {
    paramBitmap = new Mp4VideoFragmentInfo(this.d, paramBitmap);
    paramBitmap.l = this.l;
    paramBitmap.c = this.c;
    paramBitmap.f = this.f;
    paramBitmap.g = this.g;
    paramBitmap.h = this.h;
    paramBitmap.i = this.i;
    paramBitmap.a = this.a;
    paramBitmap.b = this.b;
    this.j = false;
    this.k = false;
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
    localStringBuilder.append(this.c);
    localStringBuilder.append(", endTime=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.HWEditImportVideoPlayer.Mp4VideoFragmentInfo
 * JD-Core Version:    0.7.0.1
 */