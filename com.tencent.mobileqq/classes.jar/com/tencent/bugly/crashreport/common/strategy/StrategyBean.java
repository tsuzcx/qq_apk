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
  public boolean f = true;
  public boolean g = true;
  public boolean h = true;
  public boolean i = true;
  public boolean j = false;
  public boolean k = true;
  public boolean l = true;
  public boolean m = true;
  public boolean n = true;
  public long o;
  public long p = 30000L;
  public String q = b;
  public String r = c;
  public String s;
  public Map<String, String> t;
  public int u;
  public long v;
  public long w;
  
  public StrategyBean()
  {
    Object localObject = a;
    this.u = 10;
    this.v = 300000L;
    this.w = -1L;
    this.e = System.currentTimeMillis();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("S(@L@L").append("@)");
    ((StringBuilder)localObject).toString();
    ((StringBuilder)localObject).setLength(0);
    ((StringBuilder)localObject).append("*^@K#K").append("@!");
    this.s = ((StringBuilder)localObject).toString();
  }
  
  public StrategyBean(Parcel paramParcel)
  {
    Object localObject = a;
    this.u = 10;
    this.v = 300000L;
    this.w = -1L;
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("S(@L@L").append("@)");
      ((StringBuilder)localObject).toString();
      this.e = paramParcel.readLong();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.f = bool1;
        if (paramParcel.readByte() != 1) {
          break label360;
        }
        bool1 = true;
        label172:
        this.g = bool1;
        if (paramParcel.readByte() != 1) {
          break label365;
        }
        bool1 = true;
        label187:
        this.h = bool1;
        this.q = paramParcel.readString();
        this.r = paramParcel.readString();
        this.s = paramParcel.readString();
        this.t = z.b(paramParcel);
        if (paramParcel.readByte() != 1) {
          break label370;
        }
        bool1 = true;
        label234:
        this.i = bool1;
        if (paramParcel.readByte() != 1) {
          break label375;
        }
        bool1 = true;
        label249:
        this.j = bool1;
        if (paramParcel.readByte() != 1) {
          break label380;
        }
        bool1 = true;
        label264:
        this.m = bool1;
        if (paramParcel.readByte() != 1) {
          break label385;
        }
        bool1 = true;
        label279:
        this.n = bool1;
        this.p = paramParcel.readLong();
        if (paramParcel.readByte() != 1) {
          break label390;
        }
        bool1 = true;
        label302:
        this.k = bool1;
        if (paramParcel.readByte() != 1) {
          break label395;
        }
      }
      label385:
      label390:
      label395:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.l = bool1;
        this.o = paramParcel.readLong();
        this.u = paramParcel.readInt();
        this.v = paramParcel.readLong();
        this.w = paramParcel.readLong();
        return;
        bool1 = false;
        break;
        label360:
        bool1 = false;
        break label172;
        label365:
        bool1 = false;
        break label187;
        label370:
        bool1 = false;
        break label234;
        label375:
        bool1 = false;
        break label249;
        label380:
        bool1 = false;
        break label264;
        bool1 = false;
        break label279;
        bool1 = false;
        break label302;
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
    paramParcel.writeLong(this.e);
    if (this.f)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.g) {
        break label223;
      }
      paramInt = 1;
      label34:
      paramParcel.writeByte((byte)paramInt);
      if (!this.h) {
        break label228;
      }
      paramInt = 1;
      label49:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.q);
      paramParcel.writeString(this.r);
      paramParcel.writeString(this.s);
      z.b(paramParcel, this.t);
      if (!this.i) {
        break label233;
      }
      paramInt = 1;
      label96:
      paramParcel.writeByte((byte)paramInt);
      if (!this.j) {
        break label238;
      }
      paramInt = 1;
      label111:
      paramParcel.writeByte((byte)paramInt);
      if (!this.m) {
        break label243;
      }
      paramInt = 1;
      label126:
      paramParcel.writeByte((byte)paramInt);
      if (!this.n) {
        break label248;
      }
      paramInt = 1;
      label141:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.p);
      if (!this.k) {
        break label253;
      }
      paramInt = 1;
      label164:
      paramParcel.writeByte((byte)paramInt);
      if (!this.l) {
        break label258;
      }
    }
    label258:
    for (paramInt = i1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.o);
      paramParcel.writeInt(this.u);
      paramParcel.writeLong(this.v);
      paramParcel.writeLong(this.w);
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