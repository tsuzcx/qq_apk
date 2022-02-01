package com.tencent.biz.videostory.video;

import android.os.Build.VERSION;
import bmbx;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import zxu;
import zxw;

public class FrameVideoHelper
{
  private final long jdField_a_of_type_Long;
  private final String jdField_a_of_type_JavaLangString;
  private ArrayList<FrameVideoHelper.FrameBuffer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private zxw jdField_a_of_type_Zxw;
  private volatile boolean jdField_a_of_type_Boolean;
  private final long b;
  private long c;
  private long d;
  private long e = ((Long)VSConfigManager.getInstance().getValue("SmartCutPicWidth", Long.valueOf(224L))).longValue();
  private long f = ((Long)VSConfigManager.getInstance().getValue("SmartCutPicCount", Long.valueOf(10L))).longValue();
  private long g = ((Long)VSConfigManager.getInstance().getValue("SmartCutPicQuality_And", Long.valueOf(80L))).longValue();
  private long h = ((Long)VSConfigManager.getInstance().getValue("SmartCutPicMaxByte", Long.valueOf(90000L))).longValue();
  private long i;
  private long j;
  private long k;
  
  public FrameVideoHelper(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramInt1;
    this.d = paramInt2;
    this.jdField_a_of_type_Long = paramLong;
    long l = paramLong;
    if (paramLong > 60000L) {
      l = 60000L;
    }
    this.b = l;
  }
  
  private long a(long paramLong)
  {
    long l2 = Math.min(this.b + paramLong, this.jdField_a_of_type_Long);
    long l1 = l2 / this.f;
    paramLong = l1;
    if (l1 > 1000L) {
      paramLong = (l2 - 1000L) / this.f;
    }
    return paramLong;
  }
  
  public long a()
  {
    return this.j;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Zxw != null) {
      this.jdField_a_of_type_Zxw.a();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void a(long paramLong, zxu paramzxu)
  {
    bmbx.b("AEEditorMusicHelper", "FrameVideoHelper.start(), BEGIN");
    bmbx.b("AEEditorMusicHelper", "FrameVideoHelper.start(), videoStart=" + paramLong + ", videoDuration=" + this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (Build.VERSION.SDK_INT >= 16) {
        break;
      }
    } while (paramzxu == null);
    paramzxu.a(false, null, -1L);
    return;
    this.j = 0L;
    this.k = 0L;
    this.i = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.executeOnFileThread(new FrameVideoHelper.1(this, paramLong, paramzxu));
    bmbx.b("AEEditorMusicHelper", "FrameVideoHelper.start(), END");
  }
  
  public void a(zxu paramzxu)
  {
    a(0L, paramzxu);
  }
  
  public long b()
  {
    return this.k / 1000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.video.FrameVideoHelper
 * JD-Core Version:    0.7.0.1
 */