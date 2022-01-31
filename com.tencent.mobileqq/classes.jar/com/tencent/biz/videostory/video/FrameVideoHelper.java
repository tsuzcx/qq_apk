package com.tencent.biz.videostory.video;

import android.os.Build.VERSION;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import wwt;
import wyj;
import wyl;

public class FrameVideoHelper
{
  private int jdField_a_of_type_Int = 30;
  private final long jdField_a_of_type_Long;
  private final String jdField_a_of_type_JavaLangString;
  private ArrayList<FrameVideoHelper.FrameBuffer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private wyl jdField_a_of_type_Wyl;
  private volatile boolean jdField_a_of_type_Boolean;
  private long b;
  private long c;
  private long d = ((Long)wwt.a().a("SmartCutPicWidth", Long.valueOf(224L))).longValue();
  private long e = ((Long)wwt.a().a("SmartCutPicSpacing", Long.valueOf(500L))).longValue();
  private long f;
  private long g = ((Long)wwt.a().a("SmartCutPicMaxByte", Long.valueOf(90000L))).longValue();
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
    if (this.jdField_a_of_type_Wyl != null) {
      this.jdField_a_of_type_Wyl.a();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void a(long paramLong, wyj paramwyj)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (Build.VERSION.SDK_INT >= 16) {
        break;
      }
    } while (paramwyj == null);
    paramwyj.a(false, null, -1L);
    return;
    this.f = 0L;
    this.i = 0L;
    this.h = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.executeOnFileThread(new FrameVideoHelper.1(this, paramLong, paramwyj));
  }
  
  public void a(wyj paramwyj)
  {
    a(0L, paramwyj);
  }
  
  public long b()
  {
    return this.i / 1000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.video.FrameVideoHelper
 * JD-Core Version:    0.7.0.1
 */