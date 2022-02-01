package com.tencent.mobileqq.ar.arengine;

import android.content.Context;
import com.tencent.mobileqq.ar.arcloud.ARCloudImageFilter;
import com.tencent.mobileqq.ocr.data.OcrDpc;
import com.tencent.qphone.base.util.QLog;

public class ARCloudImageSelect
{
  public static int a = 0;
  public static int b = 1;
  Context c = null;
  public int d = -2147483648;
  public int e = -2147483648;
  private int f;
  private int g = 0;
  private int h = 0;
  private byte[] i = null;
  private int j = 0;
  private byte[] k = null;
  private int l = 0;
  private boolean m = false;
  private int n = 10;
  private int o = 170;
  private int p = 640;
  private int q = 480;
  private byte[] r = null;
  private int s = 0;
  private byte[] t = null;
  private boolean u = false;
  
  public ARCloudImageSelect(int paramInt)
  {
    this.f = paramInt;
    if ((paramInt == a) && (OcrDpc.b() != null))
    {
      this.n = OcrDpc.b().i;
      this.o = OcrDpc.b().j;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("init args ocr bestImgThreshold:");
        localStringBuilder.append(this.n);
        localStringBuilder.append(",sameSceneDiff:");
        localStringBuilder.append(this.o);
        QLog.d("AREngine_ARCloudImageSelect", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    if (!this.u) {
      return false;
    }
    Object localObject;
    if (this.f == a)
    {
      System.arraycopy(paramArrayOfByte, 0, this.i, 0, this.j);
    }
    else if ((this.g == this.p) && (this.h == this.q))
    {
      System.arraycopy(paramArrayOfByte, 0, this.r, 0, this.s);
    }
    else
    {
      int i2 = (this.g - this.p) / 2;
      int i3 = (this.h - this.q) / 2;
      int i1 = 0;
      while (i1 < this.q)
      {
        int i4 = this.g;
        localObject = this.r;
        int i5 = this.p;
        System.arraycopy(paramArrayOfByte, (i1 + i3) * i4 + i2, localObject, i1 * i5, i5);
        i1 += 1;
      }
    }
    try
    {
      boolean bool;
      if (this.f == a) {
        bool = ARCloudImageFilter.nativeIsSameScene(this.i, this.t);
      } else {
        bool = ARCloudImageFilter.nativeIsSameScene(this.r, this.t);
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
    return this.k;
  }
  
  public void b()
  {
    if (this.m)
    {
      ARCloudImageFilter.nativeUninit();
      this.m = false;
    }
    this.g = 0;
    this.h = 0;
    this.n = 10;
    this.o = 170;
    this.i = null;
    this.j = 0;
    this.k = null;
    this.l = 0;
    this.p = 0;
    this.q = 0;
    this.r = null;
    this.s = 0;
    this.t = null;
    this.u = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudImageSelect
 * JD-Core Version:    0.7.0.1
 */