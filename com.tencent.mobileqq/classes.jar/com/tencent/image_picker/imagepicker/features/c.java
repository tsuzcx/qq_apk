package com.tencent.image_picker.imagepicker.features;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.av.a;
import java.io.File;
import java.util.ArrayList;

public class c
  extends a
  implements Parcelable
{
  public static final Parcelable.Creator<c> CREATOR = new c.1();
  private ArrayList<com.tencent.luggage.wxa.az.b> a;
  private ArrayList<File> b;
  private String c;
  private String d;
  private String e;
  private int f = -1;
  private int g;
  private int h;
  private int i;
  private boolean j;
  private boolean k;
  private boolean l;
  private com.tencent.luggage.wxa.aw.b m;
  private transient String n;
  
  public c() {}
  
  protected c(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.createTypedArrayList(com.tencent.luggage.wxa.az.b.CREATOR);
    int i1 = paramParcel.readByte();
    boolean bool2 = true;
    if (i1 != 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      this.b = new ArrayList();
      paramParcel.readList(this.b, File.class.getClassLoader());
    }
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readInt();
    boolean bool1;
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
    if (paramParcel.readByte() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.l = bool1;
    this.m = ((com.tencent.luggage.wxa.aw.b)paramParcel.readSerializable());
  }
  
  public int a()
  {
    return this.f;
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(com.tencent.luggage.wxa.aw.b paramb)
  {
    this.m = paramb;
  }
  
  public void a(ArrayList<com.tencent.luggage.wxa.az.b> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public int b()
  {
    return this.g;
  }
  
  public void b(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public int c()
  {
    return this.h;
  }
  
  public boolean d()
  {
    return this.l;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean e()
  {
    return this.k;
  }
  
  public String f()
  {
    return this.c;
  }
  
  public String g()
  {
    return this.d;
  }
  
  public String h()
  {
    return this.e;
  }
  
  public ArrayList<com.tencent.luggage.wxa.az.b> i()
  {
    return this.a;
  }
  
  public ArrayList<File> j()
  {
    return this.b;
  }
  
  public boolean k()
  {
    return this.j;
  }
  
  public int l()
  {
    return this.i;
  }
  
  public com.tencent.luggage.wxa.aw.b m()
  {
    return this.m;
  }
  
  public String n()
  {
    return this.n;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image_picker.imagepicker.features.c
 * JD-Core Version:    0.7.0.1
 */