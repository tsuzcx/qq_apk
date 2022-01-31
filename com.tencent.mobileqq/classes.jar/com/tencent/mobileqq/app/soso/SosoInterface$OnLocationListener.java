package com.tencent.mobileqq.app.soso;

import android.os.SystemClock;
import android.util.AndroidRuntimeException;

public abstract class SosoInterface$OnLocationListener
{
  private boolean a;
  private boolean b;
  public int c;
  public String c;
  public int d;
  public long d;
  public long e;
  public boolean e;
  public long f;
  public boolean f;
  public long g;
  public boolean g;
  public long h;
  public boolean h;
  
  public SosoInterface$OnLocationListener(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    this.jdField_d_of_type_Int = 3;
    if ((paramInt == 0) || (paramInt == 1) || (paramInt == 3) || (paramInt == 4))
    {
      this.jdField_c_of_type_JavaLangString = paramString;
      this.jdField_c_of_type_Int = paramInt;
      this.h = paramBoolean2;
      this.g = paramBoolean1;
      this.f = paramBoolean4;
      this.jdField_e_of_type_Boolean = paramBoolean3;
      this.jdField_e_of_type_Long = paramLong;
      this.jdField_d_of_type_Long = SystemClock.elapsedRealtime();
      return;
    }
    throw new AndroidRuntimeException("invalid level=" + paramInt);
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public abstract void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo);
  
  public void a(String paramString1, int paramInt, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener
 * JD-Core Version:    0.7.0.1
 */