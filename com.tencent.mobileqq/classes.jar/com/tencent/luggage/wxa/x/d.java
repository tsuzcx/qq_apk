package com.tencent.luggage.wxa.x;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ao.x;
import java.util.Arrays;

public final class d
  extends h
{
  public static final Parcelable.Creator<d> CREATOR = new d.1();
  public final String a;
  public final boolean b;
  public final boolean c;
  public final String[] d;
  private final h[] e;
  
  d(Parcel paramParcel)
  {
    super("CTOC");
    this.a = paramParcel.readString();
    int j = paramParcel.readByte();
    boolean bool2 = true;
    int i = 0;
    boolean bool1;
    if (j != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.b = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.c = bool1;
    this.d = paramParcel.createStringArray();
    j = paramParcel.readInt();
    this.e = new h[j];
    while (i < j)
    {
      this.e[i] = ((h)paramParcel.readParcelable(h.class.getClassLoader()));
      i += 1;
    }
  }
  
  public d(String paramString, boolean paramBoolean1, boolean paramBoolean2, String[] paramArrayOfString, h[] paramArrayOfh)
  {
    super("CTOC");
    this.a = paramString;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramArrayOfString;
    this.e = paramArrayOfh;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (d)paramObject;
      return (this.b == paramObject.b) && (this.c == paramObject.c) && (x.a(this.a, paramObject.a)) && (Arrays.equals(this.d, paramObject.d)) && (Arrays.equals(this.e, paramObject.e));
    }
    return false;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeByte((byte)this.b);
    paramParcel.writeByte((byte)this.c);
    paramParcel.writeStringArray(this.d);
    paramParcel.writeInt(this.e.length);
    paramInt = 0;
    for (;;)
    {
      h[] arrayOfh = this.e;
      if (paramInt >= arrayOfh.length) {
        break;
      }
      paramParcel.writeParcelable(arrayOfh[paramInt], 0);
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.x.d
 * JD-Core Version:    0.7.0.1
 */