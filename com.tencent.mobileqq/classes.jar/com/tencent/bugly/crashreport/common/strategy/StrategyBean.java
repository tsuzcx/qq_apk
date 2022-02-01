package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.bugly.proguard.z;
import java.util.Map;

public class StrategyBean
  implements Parcelable
{
  public static final Parcelable.Creator<StrategyBean> CREATOR = new StrategyBean.1();
  public static String a = "https://android.rqd.qq.com/analytics/hsync";
  public static String b = "https://android.rqd.qq.com/analytics/hsync";
  public static String c = "https://android.rqd.qq.com/analytics/hsync";
  public long d = -1L;
  public long e = -1L;
  public boolean f;
  public boolean g;
  public boolean h;
  public boolean i;
  public boolean j;
  public boolean k;
  public boolean l;
  public boolean m;
  public boolean n;
  public long o;
  public long p;
  public String q;
  public String r;
  public String s;
  public Map<String, String> t;
  public int u;
  public long v;
  public long w;
  
  public StrategyBean()
  {
    this.f = true;
    this.g = true;
    this.h = true;
    this.i = true;
    this.j = false;
    this.k = true;
    this.l = true;
    this.m = true;
    this.n = true;
    this.p = 30000L;
    this.q = b;
    this.r = c;
    Object localObject = a;
    this.u = 10;
    this.v = 300000L;
    this.w = -1L;
    this.e = System.currentTimeMillis();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("S(@L@L");
    ((StringBuilder)localObject).append("@)");
    ((StringBuilder)localObject).toString();
    ((StringBuilder)localObject).setLength(0);
    ((StringBuilder)localObject).append("*^@K#K");
    ((StringBuilder)localObject).append("@!");
    this.s = ((StringBuilder)localObject).toString();
  }
  
  public StrategyBean(Parcel paramParcel)
  {
    boolean bool2 = true;
    this.f = true;
    this.g = true;
    this.h = true;
    this.i = true;
    this.j = false;
    this.k = true;
    this.l = true;
    this.m = true;
    this.n = true;
    this.p = 30000L;
    this.q = b;
    this.r = c;
    Object localObject = a;
    this.u = 10;
    this.v = 300000L;
    this.w = -1L;
    for (;;)
    {
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("S(@L@L");
        ((StringBuilder)localObject).append("@)");
        ((StringBuilder)localObject).toString();
        this.e = paramParcel.readLong();
        if (paramParcel.readByte() == 1)
        {
          bool1 = true;
          this.f = bool1;
          if (paramParcel.readByte() != 1) {
            break label396;
          }
          bool1 = true;
          this.g = bool1;
          if (paramParcel.readByte() != 1) {
            break label401;
          }
          bool1 = true;
          this.h = bool1;
          this.q = paramParcel.readString();
          this.r = paramParcel.readString();
          this.s = paramParcel.readString();
          this.t = z.b(paramParcel);
          if (paramParcel.readByte() != 1) {
            break label406;
          }
          bool1 = true;
          this.i = bool1;
          if (paramParcel.readByte() != 1) {
            break label411;
          }
          bool1 = true;
          this.j = bool1;
          if (paramParcel.readByte() != 1) {
            break label416;
          }
          bool1 = true;
          this.m = bool1;
          if (paramParcel.readByte() != 1) {
            break label421;
          }
          bool1 = true;
          this.n = bool1;
          this.p = paramParcel.readLong();
          if (paramParcel.readByte() != 1) {
            break label426;
          }
          bool1 = true;
          this.k = bool1;
          if (paramParcel.readByte() != 1) {
            break label431;
          }
          bool1 = bool2;
          this.l = bool1;
          this.o = paramParcel.readLong();
          this.u = paramParcel.readInt();
          this.v = paramParcel.readLong();
          this.w = paramParcel.readLong();
          return;
        }
      }
      catch (Exception paramParcel)
      {
        paramParcel.printStackTrace();
        return;
      }
      boolean bool1 = false;
      continue;
      label396:
      bool1 = false;
      continue;
      label401:
      bool1 = false;
      continue;
      label406:
      bool1 = false;
      continue;
      label411:
      bool1 = false;
      continue;
      label416:
      bool1 = false;
      continue;
      label421:
      bool1 = false;
      continue;
      label426:
      bool1 = false;
      continue;
      label431:
      bool1 = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.e);
    paramParcel.writeByte((byte)this.f);
    paramParcel.writeByte((byte)this.g);
    paramParcel.writeByte((byte)this.h);
    paramParcel.writeString(this.q);
    paramParcel.writeString(this.r);
    paramParcel.writeString(this.s);
    z.b(paramParcel, this.t);
    paramParcel.writeByte((byte)this.i);
    paramParcel.writeByte((byte)this.j);
    paramParcel.writeByte((byte)this.m);
    paramParcel.writeByte((byte)this.n);
    paramParcel.writeLong(this.p);
    paramParcel.writeByte((byte)this.k);
    paramParcel.writeByte((byte)this.l);
    paramParcel.writeLong(this.o);
    paramParcel.writeInt(this.u);
    paramParcel.writeLong(this.v);
    paramParcel.writeLong(this.w);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.bugly.crashreport.common.strategy.StrategyBean
 * JD-Core Version:    0.7.0.1
 */