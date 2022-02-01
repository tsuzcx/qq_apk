package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class FaceInfo
  implements Parcelable
{
  public static int A = z + 1;
  public static int B = A + 1;
  public static int C = B + 1;
  public static final Parcelable.Creator<FaceInfo> CREATOR = new FaceInfo.1();
  public static int D = C + 1;
  public static int E = D + 1;
  public static int r = 0;
  public static int s = 1;
  public static int t = 2;
  public static int u = 3;
  public static int v = 0;
  public static int w = v + 1;
  public static int x = w + 1;
  public static int y = x + 1;
  public static int z = y + 1;
  private String F;
  public boolean a;
  public int b;
  public String c;
  public int d;
  public int e;
  public byte f;
  public byte g;
  public boolean h;
  public boolean i;
  public int j;
  public String k;
  public String l;
  public String m;
  public long n;
  public long[] o = null;
  public QQHeadInfo p;
  public int q;
  
  public FaceInfo()
  {
    int i2 = 0;
    this.q = 0;
    int i1 = i2;
    if (this.o == null)
    {
      this.o = new long[E];
      i1 = i2;
    }
    while (i1 < E)
    {
      this.o[i1] = 0L;
      i1 += 1;
    }
  }
  
  public FaceInfo(int paramInt1, String paramString, boolean paramBoolean1, byte paramByte, int paramInt2, boolean paramBoolean2, int paramInt3, int paramInt4)
  {
    this.q = 0;
    a(paramInt1, paramString, paramBoolean1, paramByte, paramInt2, paramBoolean2, paramInt3, paramInt4, false, 100);
  }
  
  public FaceInfo(int paramInt1, String paramString, boolean paramBoolean1, byte paramByte, int paramInt2, boolean paramBoolean2, int paramInt3, boolean paramBoolean3, int paramInt4)
  {
    this.q = 0;
    a(paramInt1, paramString, paramBoolean1, paramByte, paramInt2, paramBoolean2, paramInt3, 0, paramBoolean3, paramInt4);
  }
  
  public static String a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    if (paramInt1 == 32)
    {
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
    }
    else if (paramInt1 == 16)
    {
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
    }
    else if (paramInt1 == 116)
    {
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
    }
    else
    {
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
    }
    return localStringBuilder.toString();
  }
  
  public static String a(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    StringBuilder localStringBuilder = new StringBuilder(16);
    if (paramInt1 != 4)
    {
      if (paramInt1 != 16)
      {
        if (paramInt1 != 32)
        {
          if (paramInt1 != 101)
          {
            if (paramInt1 != 103)
            {
              if (paramInt1 == 116)
              {
                localStringBuilder.append("apollo_");
                localStringBuilder.append(Integer.toString(paramInt4));
                localStringBuilder.append("_");
              }
            }
            else {
              localStringBuilder.append("sub_");
            }
          }
          else {
            localStringBuilder.append("dis_g_");
          }
        }
        else
        {
          localStringBuilder.append("stranger_");
          localStringBuilder.append(Integer.toString(paramInt2));
          localStringBuilder.append("_");
        }
      }
      else
      {
        localStringBuilder.append("qcall_");
        localStringBuilder.append(Integer.toString(paramInt2));
        localStringBuilder.append("_");
      }
    }
    else {
      localStringBuilder.append("troop_");
    }
    localStringBuilder.append(paramString);
    if (paramInt3 > 0)
    {
      localStringBuilder.append("_");
      localStringBuilder.append(paramInt3);
    }
    return localStringBuilder.toString();
  }
  
  public static String a(QQHeadInfo paramQQHeadInfo, int paramInt)
  {
    if ((paramQQHeadInfo != null) && (!TextUtils.isEmpty(paramQQHeadInfo.downLoadUrl)))
    {
      if (paramQQHeadInfo.dstUsrType == 116)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramQQHeadInfo.downLoadUrl);
        localStringBuilder.append("_");
        localStringBuilder.append(paramQQHeadInfo.sizeType);
        localStringBuilder.append("_");
        localStringBuilder.append(paramQQHeadInfo.uin);
        return localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramQQHeadInfo.downLoadUrl);
      localStringBuilder.append("_");
      localStringBuilder.append(paramInt);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 8: 
      return "TIME_REQ_END";
    case 7: 
      return "TIME_END_DECODE";
    case 6: 
      return "TIME_BEGIN_DECODE";
    case 5: 
      return "TIME_END_DOWNLOAD";
    case 4: 
      return "TIME_BEGIN_DOWNLOAD";
    case 3: 
      return "TIME_END_DOWNLOADINFO";
    case 2: 
      return "TIME_BEGIN_DOWNLOADINFO";
    case 1: 
      return "TIME_REQ_READY";
    }
    return "TIME_BEGINE";
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.l)) {
      this.l = a(this.b, this.c, this.d, this.e, this.j);
    }
    return this.l;
  }
  
  public void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.o;
    if (localObject == null) {
      return;
    }
    if ((paramInt1 >= 0) && (paramInt1 < E))
    {
      localObject[paramInt1] = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("markTime tag= ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append("mTimes[tag] = ");
        ((StringBuilder)localObject).append(this.o[paramInt1]);
        ((StringBuilder)localObject).append("this=");
        ((StringBuilder)localObject).append(this);
        QLog.i("FaceInfo", 2, ((StringBuilder)localObject).toString());
      }
      if ((paramInt1 == D) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder(260);
        ((StringBuilder)localObject).append("id=");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append("idType=");
        ((StringBuilder)localObject).append(this.d);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append("headType=");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append("shape=");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" ,Times={");
        paramInt1 = 0;
        long l2 = 0L;
        long l1 = 0L;
        long[] arrayOfLong;
        for (;;)
        {
          arrayOfLong = this.o;
          if (paramInt1 >= arrayOfLong.length) {
            break;
          }
          ((StringBuilder)localObject).append("[");
          ((StringBuilder)localObject).append(b(paramInt1));
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(this.o[paramInt1]);
          ((StringBuilder)localObject).append(",");
          arrayOfLong = this.o;
          if (arrayOfLong[paramInt1] > 0L)
          {
            ((StringBuilder)localObject).append(Math.abs(l1 - arrayOfLong[paramInt1]));
            ((StringBuilder)localObject).append("]");
          }
          else
          {
            ((StringBuilder)localObject).append("0");
            ((StringBuilder)localObject).append("]");
          }
          arrayOfLong = this.o;
          if (arrayOfLong[paramInt1] > 0L) {
            l1 = arrayOfLong[paramInt1];
          }
          paramInt1 += 1;
        }
        paramInt1 = D;
        l1 = l2;
        if (arrayOfLong[paramInt1] > 0L)
        {
          int i1 = v;
          l1 = l2;
          if (arrayOfLong[i1] > 0L) {
            l1 = Math.abs(arrayOfLong[paramInt1] - arrayOfLong[i1]);
          }
        }
        ((StringBuilder)localObject).append("}, cost = ");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append(", result = ");
        ((StringBuilder)localObject).append(paramInt2);
        QLog.i("FaceCost", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a(int paramInt1, String paramString, boolean paramBoolean1, byte paramByte, int paramInt2, boolean paramBoolean2, int paramInt3, int paramInt4, boolean paramBoolean3, int paramInt5)
  {
    this.a = paramBoolean3;
    this.b = paramInt1;
    this.c = paramString;
    this.h = paramBoolean1;
    this.f = paramByte;
    this.e = paramInt2;
    this.i = paramBoolean2;
    this.d = paramInt3;
    this.l = null;
    this.k = null;
    this.m = null;
    this.n = 0L;
    this.q = paramInt4;
    this.j = paramInt5;
    if (this.o == null) {
      this.o = new long[E];
    }
    paramInt1 = 0;
    while (paramInt1 < E)
    {
      this.o[paramInt1] = 0L;
      paramInt1 += 1;
    }
  }
  
  public void a(QQHeadInfo paramQQHeadInfo)
  {
    if (paramQQHeadInfo == null) {
      return;
    }
    this.p = paramQQHeadInfo;
  }
  
  public void a(Parcel paramParcel)
  {
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.j = paramParcel.readInt();
    this.f = paramParcel.readByte();
    int i1 = paramParcel.readByte();
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    this.i = bool;
    this.m = paramParcel.readString();
    this.n = paramParcel.readLong();
    this.p = ((QQHeadInfo)paramParcel.readParcelable(getClass().getClassLoader()));
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    long[] arrayOfLong = this.o;
    boolean bool2 = false;
    if (arrayOfLong == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      bool1 = bool2;
      if (paramInt < E) {
        if (arrayOfLong[paramInt] == 0L)
        {
          bool1 = bool2;
          if (QLog.isDevelopLevel())
          {
            QLog.i("FaceInfo", 2, "isTimeOut");
            return false;
          }
        }
        else
        {
          bool1 = bool2;
          if (Math.abs(System.currentTimeMillis() - this.o[paramInt]) >= paramLong) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String b()
  {
    if (TextUtils.isEmpty(this.k)) {
      this.k = a(this.b, this.c, this.d, this.j);
    }
    return this.k;
  }
  
  public String c()
  {
    if (TextUtils.isEmpty(this.F)) {
      this.F = a(this.p, this.d);
    }
    return this.F;
  }
  
  public byte d()
  {
    if (this.f != 1) {
      return 1;
    }
    return 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (FaceInfo)paramObject;
    return (this.b == paramObject.b) && (TextUtils.equals(this.c, paramObject.c)) && (this.d == paramObject.d) && (this.e == paramObject.e);
  }
  
  public int hashCode()
  {
    int i2 = this.b;
    int i1;
    if (TextUtils.isEmpty(this.c)) {
      i1 = 0;
    } else {
      i1 = this.c.hashCode();
    }
    return i2 | i1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("[");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",");
    localStringBuilder.append(this.j);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceInfo
 * JD-Core Version:    0.7.0.1
 */