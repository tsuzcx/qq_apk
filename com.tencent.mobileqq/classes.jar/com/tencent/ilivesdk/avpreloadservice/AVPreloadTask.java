package com.tencent.ilivesdk.avpreloadservice;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface.AVPreloadState;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface.TaskReportInfo;

public class AVPreloadTask
  implements AVPreloadTaskInterface, Comparable<AVPreloadTask>
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private AVPreloadTaskInterface.AVPreloadState jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface$AVPreloadState = AVPreloadTaskInterface.AVPreloadState.PRELOAD_UNKNOWN;
  private AVPreloadTaskInterface.TaskReportInfo jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface$TaskReportInfo;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private int jdField_f_of_type_Int = 60;
  private long jdField_f_of_type_Long;
  private int jdField_g_of_type_Int;
  private long jdField_g_of_type_Long;
  private long h;
  private long i;
  private long j;
  private long k;
  private long l = 0L;
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int a(AVPreloadTask paramAVPreloadTask)
  {
    int m = paramAVPreloadTask.jdField_a_of_type_Int;
    return m - m;
  }
  
  public long a()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public AVPreloadTaskInterface.TaskReportInfo a()
  {
    return this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface$TaskReportInfo;
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return b();
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(" clear--isBitmapUsed=");
    ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
    Log.d("AVPreload|PreloadTask", ((StringBuilder)localObject).toString());
    if (!this.jdField_d_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        Log.d("AVPreload|PreloadTask", "clear--preFirstFrameBitmap.recycle()");
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      Log.d("AVPreload|PreloadTask", "clear--setPreFirstFrameBitmap.recycle()");
      Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        Log.d("AVPreload|PreloadTask", "clear--setPreFirstFrameBitmap finished");
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void a(AVPreloadTaskInterface.AVPreloadState paramAVPreloadState)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface$AVPreloadState = paramAVPreloadState;
  }
  
  public void a(AVPreloadTaskInterface.TaskReportInfo paramTaskReportInfo)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface$TaskReportInfo = paramTaskReportInfo;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long b()
  {
    return this.jdField_d_of_type_Long;
  }
  
  public String b()
  {
    String str2 = this.jdField_b_of_type_JavaLangString;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public void b(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.jdField_d_of_type_Long = paramLong;
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      AVPreloadLog.c("AVPreload|Core", "set url is empty.", new Object[0]);
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public long c()
  {
    return this.jdField_e_of_type_Long;
  }
  
  public String c()
  {
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      return this.jdField_b_of_type_JavaLangString;
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void c(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void c(long paramLong)
  {
    this.jdField_e_of_type_Long = paramLong;
  }
  
  public void c(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int d()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public long d()
  {
    return this.jdField_f_of_type_Long;
  }
  
  public void d(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void d(long paramLong)
  {
    this.jdField_f_of_type_Long = paramLong;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int e()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public long e()
  {
    return this.h;
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void e(long paramLong)
  {
    this.j = paramLong;
  }
  
  public int f()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long f()
  {
    return this.j;
  }
  
  public void f(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
  }
  
  public void f(long paramLong)
  {
    this.k = paramLong;
  }
  
  public int g()
  {
    return this.jdField_g_of_type_Int;
  }
  
  public long g()
  {
    return this.k;
  }
  
  public void g(long paramLong)
  {
    this.h = paramLong;
  }
  
  public long h()
  {
    return this.i;
  }
  
  public void h(long paramLong)
  {
    this.i = paramLong;
  }
  
  public long i()
  {
    return this.jdField_g_of_type_Long;
  }
  
  public void i(long paramLong)
  {
    this.jdField_g_of_type_Long = paramLong;
  }
  
  public long j()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void j(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public long k()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public void k(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public long l()
  {
    return this.l;
  }
  
  public void l(long paramLong)
  {
    this.l = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadTask
 * JD-Core Version:    0.7.0.1
 */