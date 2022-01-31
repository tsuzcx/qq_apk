package com.tencent.biz.videostory.video;

import android.os.Build.VERSION;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import yuh;
import yvz;
import ywb;

public class FrameVideoHelper
{
  private int jdField_a_of_type_Int = 30;
  private final long jdField_a_of_type_Long;
  private final String jdField_a_of_type_JavaLangString;
  private ArrayList<FrameVideoHelper.FrameBuffer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ywb jdField_a_of_type_Ywb;
  private volatile boolean jdField_a_of_type_Boolean;
  private long b;
  private long c;
  private long d = ((Long)yuh.a().a("SmartCutPicWidth", Long.valueOf(224L))).longValue();
  private long e = ((Long)yuh.a().a("SmartCutPicSpacing", Long.valueOf(500L))).longValue();
  private long f;
  private long g = ((Long)yuh.a().a("SmartCutPicMaxByte", Long.valueOf(90000L))).longValue();
  private long h;
  private long i;
  
  public FrameVideoHelper(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
    long l = paramLong;
    if (paramLong > 60000L) {
      l = 60000L;
    }
    this.jdField_a_of_type_Long = l;
  }
  
  public long a()
  {
    return this.f;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ywb != null) {
      this.jdField_a_of_type_Ywb.a();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void a(long paramLong, yvz paramyvz)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (Build.VERSION.SDK_INT >= 16) {
        break;
      }
    } while (paramyvz == null);
    paramyvz.a(false, null, -1L);
    return;
    this.f = 0L;
    this.i = 0L;
    this.h = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.executeOnFileThread(new FrameVideoHelper.1(this, paramLong, paramyvz));
  }
  
  public void a(yvz paramyvz)
  {
    a(0L, paramyvz);
  }
  
  public long b()
  {
    return this.i / 1000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.video.FrameVideoHelper
 * JD-Core Version:    0.7.0.1
 */