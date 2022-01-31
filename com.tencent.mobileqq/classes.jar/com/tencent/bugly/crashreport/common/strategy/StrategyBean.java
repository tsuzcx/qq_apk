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
  public static String a = "http://rqd.uu.qq.com/rqd/sync";
  public static String b = "http://android.bugly.qq.com/rqd/async";
  public static String c = "http://android.bugly.qq.com/rqd/async";
  public static String d;
  public long e = -1L;
  public long f = -1L;
  public boolean g = true;
  public boolean h = true;
  public boolean i = true;
  public boolean j = true;
  public boolean k = false;
  public boolean l = true;
  public boolean m = true;
  public boolean n = true;
  public boolean o = true;
  public long p;
  public long q = 30000L;
  public String r = b;
  public String s = c;
  public String t = a;
  public String u;
  public Map<String, String> v;
  public int w = 10;
  public long x = 300000L;
  public long y = -1L;
  
  public StrategyBean()
  {
    this.f = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("S(@L@L").append("@)");
    d = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("*^@K#K").append("@!");
    this.u = localStringBuilder.toString();
  }
  
  public StrategyBean(Parcel paramParcel)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("S(@L@L").append("@)");
      d = localStringBuilder.toString();
      this.f = paramParcel.readLong();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.g = bool1;
        if (paramParcel.readByte() != 1) {
          break label364;
        }
        bool1 = true;
        label176:
        this.h = bool1;
        if (paramParcel.readByte() != 1) {
          break label369;
        }
        bool1 = true;
        label191:
        this.i = bool1;
        this.r = paramParcel.readString();
        this.s = paramParcel.readString();
        this.u = paramParcel.readString();
        this.v = z.b(paramParcel);
        if (paramParcel.readByte() != 1) {
          break label374;
        }
        bool1 = true;
        label238:
        this.j = bool1;
        if (paramParcel.readByte() != 1) {
          break label379;
        }
        bool1 = true;
        label253:
        this.k = bool1;
        if (paramParcel.readByte() != 1) {
          break label384;
        }
        bool1 = true;
        label268:
        this.n = bool1;
        if (paramParcel.readByte() != 1) {
          break label389;
        }
        bool1 = true;
        label283:
        this.o = bool1;
        this.q = paramParcel.readLong();
        if (paramParcel.readByte() != 1) {
          break label394;
        }
        bool1 = true;
        label306:
        this.l = bool1;
        if (paramParcel.readByte() != 1) {
          break label399;
        }
      }
      label384:
      label389:
      label394:
      label399:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.m = bool1;
        this.p = paramParcel.readLong();
        this.w = paramParcel.readInt();
        this.x = paramParcel.readLong();
        this.y = paramParcel.readLong();
        return;
        bool1 = false;
        break;
        label364:
        bool1 = false;
        break label176;
        label369:
        bool1 = false;
        break label191;
        label374:
        bool1 = false;
        break label238;
        label379:
        bool1 = false;
        break label253;
        bool1 = false;
        break label268;
        bool1 = false;
        break label283;
        bool1 = false;
        break label306;
      }
      return;
    }
    catch (Exception paramParcel)
    {
      paramParcel.printStackTrace();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
    paramParcel.writeLong(this.f);
    if (this.g)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.h) {
        break label223;
      }
      paramInt = 1;
      label34:
      paramParcel.writeByte((byte)paramInt);
      if (!this.i) {
        break label228;
      }
      paramInt = 1;
      label49:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.r);
      paramParcel.writeString(this.s);
      paramParcel.writeString(this.u);
      z.b(paramParcel, this.v);
      if (!this.j) {
        break label233;
      }
      paramInt = 1;
      label96:
      paramParcel.writeByte((byte)paramInt);
      if (!this.k) {
        break label238;
      }
      paramInt = 1;
      label111:
      paramParcel.writeByte((byte)paramInt);
      if (!this.n) {
        break label243;
      }
      paramInt = 1;
      label126:
      paramParcel.writeByte((byte)paramInt);
      if (!this.o) {
        break label248;
      }
      paramInt = 1;
      label141:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.q);
      if (!this.l) {
        break label253;
      }
      paramInt = 1;
      label164:
      paramParcel.writeByte((byte)paramInt);
      if (!this.m) {
        break label258;
      }
    }
    label258:
    for (paramInt = i1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.p);
      paramParcel.writeInt(this.w);
      paramParcel.writeLong(this.x);
      paramParcel.writeLong(this.y);
      return;
      paramInt = 0;
      break;
      label223:
      paramInt = 0;
      break label34;
      label228:
      paramInt = 0;
      break label49;
      label233:
      paramInt = 0;
      break label96;
      label238:
      paramInt = 0;
      break label111;
      label243:
      paramInt = 0;
      break label126;
      label248:
      paramInt = 0;
      break label141;
      label253:
      paramInt = 0;
      break label164;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.common.strategy.StrategyBean
 * JD-Core Version:    0.7.0.1
 */