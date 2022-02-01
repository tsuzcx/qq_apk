package com.tencent.mobileqq.ar.arengine;

import android.content.Context;
import com.tencent.mobileqq.ar.arcloud.ARCloudImageFilter;
import com.tencent.mobileqq.ocr.data.OcrDpc;
import com.tencent.qphone.base.util.QLog;

public class ARCloudImageSelect
{
  public static int a = 0;
  public static int b = 1;
  Context jdField_a_of_type_AndroidContentContext = null;
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private boolean jdField_b_of_type_Boolean = false;
  private byte[] jdField_b_of_type_ArrayOfByte = null;
  public int c;
  private byte[] c;
  public int d;
  private byte[] d;
  private int e;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private int j = 10;
  private int k = 170;
  private int l = 640;
  private int m = 480;
  private int n = 0;
  
  public ARCloudImageSelect(int paramInt)
  {
    this.jdField_c_of_type_ArrayOfByte = null;
    this.jdField_d_of_type_ArrayOfByte = null;
    this.jdField_c_of_type_Int = -2147483648;
    this.jdField_d_of_type_Int = -2147483648;
    this.e = paramInt;
    if ((paramInt == jdField_a_of_type_Int) && (OcrDpc.a() != null))
    {
      this.j = OcrDpc.a().g;
      this.k = OcrDpc.a().h;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("init args ocr bestImgThreshold:");
        localStringBuilder.append(this.j);
        localStringBuilder.append(",sameSceneDiff:");
        localStringBuilder.append(this.k);
        QLog.d("AREngine_ARCloudImageSelect", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      ARCloudImageFilter.nativeUninit();
      this.jdField_a_of_type_Boolean = false;
    }
    this.f = 0;
    this.g = 0;
    this.j = 10;
    this.k = 170;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.h = 0;
    this.jdField_b_of_type_ArrayOfByte = null;
    this.i = 0;
    this.l = 0;
    this.m = 0;
    this.jdField_c_of_type_ArrayOfByte = null;
    this.n = 0;
    this.jdField_d_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return false;
    }
    Object localObject;
    if (this.e == jdField_a_of_type_Int)
    {
      System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, this.h);
    }
    else if ((this.f == this.l) && (this.g == this.m))
    {
      System.arraycopy(paramArrayOfByte, 0, this.jdField_c_of_type_ArrayOfByte, 0, this.n);
    }
    else
    {
      int i2 = (this.f - this.l) / 2;
      int i3 = (this.g - this.m) / 2;
      int i1 = 0;
      while (i1 < this.m)
      {
        int i4 = this.f;
        localObject = this.jdField_c_of_type_ArrayOfByte;
        int i5 = this.l;
        System.arraycopy(paramArrayOfByte, (i1 + i3) * i4 + i2, localObject, i1 * i5, i5);
        i1 += 1;
      }
    }
    try
    {
      boolean bool;
      if (this.e == jdField_a_of_type_Int) {
        bool = ARCloudImageFilter.nativeIsSameScene(this.jdField_a_of_type_ArrayOfByte, this.jdField_d_of_type_ArrayOfByte);
      } else {
        bool = ARCloudImageFilter.nativeIsSameScene(this.jdField_c_of_type_ArrayOfByte, this.jdField_d_of_type_ArrayOfByte);
      }
      return bool;
    }
    catch (Exception paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ARCloudImageFilter.nativeIsSameScene()");
      ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
      QLog.i("AREngine_ARCloudImageSelect", 1, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public byte[] a()
  {
    return this.jdField_b_of_type_ArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudImageSelect
 * JD-Core Version:    0.7.0.1
 */