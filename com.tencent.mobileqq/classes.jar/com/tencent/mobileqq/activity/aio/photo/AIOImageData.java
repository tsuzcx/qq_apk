package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class AIOImageData
  extends AIORichMediaData
{
  public String A;
  public String B;
  public boolean C = false;
  public int D;
  public boolean E;
  public String F;
  public boolean G;
  public String H;
  public String I;
  public String J;
  public String K;
  public String a = "I:N";
  public String b = "I:N";
  public String c = "I:N";
  public String d = "I:N";
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  public boolean h;
  public int i;
  public boolean j;
  public boolean k;
  public long l;
  public long m;
  public String n = "I:N";
  public long o;
  public long p;
  public String q;
  public int r = 0;
  public Object s;
  public boolean t = false;
  public long u;
  public String v;
  public String w;
  public int x;
  public int y;
  public String z;
  
  public int a(String paramString)
  {
    int i1 = 0;
    if (paramString == null) {
      return 0;
    }
    if (paramString.contains(this.a)) {
      return 1;
    }
    if (paramString.contains(this.b)) {
      return 2;
    }
    if (paramString.contains(this.c)) {
      i1 = 4;
    }
    return i1;
  }
  
  public void a(Parcel paramParcel)
  {
    super.a(paramParcel);
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.n = paramParcel.readString();
    this.o = paramParcel.readLong();
    this.p = paramParcel.readLong();
    this.l = paramParcel.readLong();
    this.m = paramParcel.readLong();
    int i1 = paramParcel.readByte();
    boolean bool2 = false;
    if (i1 != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.h = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.j = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.k = bool1;
    this.i = paramParcel.readInt();
    this.r = paramParcel.readInt();
    try
    {
      this.s = paramParcel.readValue(null);
    }
    catch (Exception localException)
    {
      label167:
      break label167;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AIOImageData", 2, "readValue exception");
    }
    this.s = new byte[0];
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.t = bool1;
    this.u = paramParcel.readLong();
    this.v = paramParcel.readString();
    this.w = paramParcel.readString();
    this.x = paramParcel.readInt();
    this.y = paramParcel.readInt();
    this.z = paramParcel.readString();
    this.q = paramParcel.readString();
    this.A = paramParcel.readString();
    this.B = paramParcel.readString();
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.C = bool1;
    this.D = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.E = bool1;
    this.F = paramParcel.readString();
    boolean bool1 = bool2;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    }
    this.G = bool1;
    this.H = paramParcel.readString();
    this.I = paramParcel.readString();
    this.J = paramParcel.readString();
    this.K = paramParcel.readString();
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4) {
          return false;
        }
        if (this.r == 3) {
          return true;
        }
        return this.c.equals("I:N") ^ true;
      }
      return this.b.equals("I:N") ^ true;
    }
    return this.a.equals("I:N") ^ true;
  }
  
  public String b(int paramInt)
  {
    Object localObject;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4)
        {
          if (paramInt != 8) {
            localObject = null;
          } else {
            localObject = this.d;
          }
        }
        else {
          localObject = this.c;
        }
      }
      else {
        localObject = this.b;
      }
    }
    else {
      localObject = this.a;
    }
    if ((localObject != null) && (!((String)localObject).equals("I:N")))
    {
      if (this.r == 3)
      {
        localObject = new File((String)localObject);
        try
        {
          localObject = ((File)localObject).toURI().toURL().toString();
          return localObject;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localMalformedURLException.printStackTrace();
          return null;
        }
      }
      if (!localMalformedURLException.startsWith("/"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("file:/");
        localStringBuilder.append(localMalformedURLException);
        return localStringBuilder.toString();
      }
      if (localMalformedURLException.startsWith("//"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("file:");
        localStringBuilder.append(localMalformedURLException);
        return localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file:");
      localStringBuilder.append(localMalformedURLException);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public File c(int paramInt)
  {
    Object localObject;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4)
        {
          if (paramInt != 8) {
            localObject = null;
          } else {
            localObject = this.d;
          }
        }
        else {
          localObject = this.c;
        }
      }
      else {
        localObject = this.b;
      }
    }
    else {
      localObject = this.a;
    }
    if ((localObject != null) && (!((String)localObject).equals("I:N")))
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {
        return localObject;
      }
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageData
 * JD-Core Version:    0.7.0.1
 */