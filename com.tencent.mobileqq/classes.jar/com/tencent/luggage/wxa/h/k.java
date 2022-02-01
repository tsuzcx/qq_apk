package com.tencent.luggage.wxa.h;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.ap.b;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class k
  implements Parcelable
{
  public static final Parcelable.Creator<k> CREATOR = new k.1();
  private int A;
  public final String a;
  public final int b;
  public final String c;
  public final com.tencent.luggage.wxa.v.a d;
  public final String e;
  public final String f;
  public final int g;
  public final List<byte[]> h;
  public final com.tencent.luggage.wxa.k.a i;
  public final int j;
  public final int k;
  public final float l;
  public final int m;
  public final float n;
  public final int o;
  public final byte[] p;
  public final b q;
  public final int r;
  public final int s;
  public final int t;
  public final int u;
  public final int v;
  public final long w;
  public final int x;
  public final String y;
  public final int z;
  
  k(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.c = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.j = paramParcel.readInt();
    this.k = paramParcel.readInt();
    this.l = paramParcel.readFloat();
    this.m = paramParcel.readInt();
    this.n = paramParcel.readFloat();
    int i1 = paramParcel.readInt();
    int i2 = 0;
    if (i1 != 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    byte[] arrayOfByte;
    if (i1 != 0) {
      arrayOfByte = paramParcel.createByteArray();
    } else {
      arrayOfByte = null;
    }
    this.p = arrayOfByte;
    this.o = paramParcel.readInt();
    this.q = ((b)paramParcel.readParcelable(b.class.getClassLoader()));
    this.r = paramParcel.readInt();
    this.s = paramParcel.readInt();
    this.t = paramParcel.readInt();
    this.u = paramParcel.readInt();
    this.v = paramParcel.readInt();
    this.x = paramParcel.readInt();
    this.y = paramParcel.readString();
    this.z = paramParcel.readInt();
    this.w = paramParcel.readLong();
    int i3 = paramParcel.readInt();
    this.h = new ArrayList(i3);
    i1 = i2;
    while (i1 < i3)
    {
      this.h.add(paramParcel.createByteArray());
      i1 += 1;
    }
    this.i = ((com.tencent.luggage.wxa.k.a)paramParcel.readParcelable(com.tencent.luggage.wxa.k.a.class.getClassLoader()));
    this.d = ((com.tencent.luggage.wxa.v.a)paramParcel.readParcelable(com.tencent.luggage.wxa.v.a.class.getClassLoader()));
  }
  
  k(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, int paramInt5, float paramFloat2, byte[] paramArrayOfByte, int paramInt6, b paramb, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, String paramString5, int paramInt13, long paramLong, List<byte[]> paramList, com.tencent.luggage.wxa.k.a parama, com.tencent.luggage.wxa.v.a parama1)
  {
    this.a = paramString1;
    this.e = paramString2;
    this.f = paramString3;
    this.c = paramString4;
    this.b = paramInt1;
    this.g = paramInt2;
    this.j = paramInt3;
    this.k = paramInt4;
    this.l = paramFloat1;
    this.m = paramInt5;
    this.n = paramFloat2;
    this.p = paramArrayOfByte;
    this.o = paramInt6;
    this.q = paramb;
    this.r = paramInt7;
    this.s = paramInt8;
    this.t = paramInt9;
    this.u = paramInt10;
    this.v = paramInt11;
    this.x = paramInt12;
    this.y = paramString5;
    this.z = paramInt13;
    this.w = paramLong;
    if (paramList == null) {
      paramList = Collections.emptyList();
    }
    this.h = paramList;
    this.i = parama;
    this.d = parama1;
  }
  
  public static k a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    return a(paramString1, paramString2, paramInt, paramString3, null);
  }
  
  public static k a(String paramString1, String paramString2, int paramInt, String paramString3, com.tencent.luggage.wxa.k.a parama)
  {
    return a(paramString1, paramString2, null, -1, paramInt, paramString3, -1, parama, 9223372036854775807L, Collections.emptyList());
  }
  
  public static k a(String paramString1, String paramString2, long paramLong)
  {
    return new k(paramString1, null, paramString2, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, paramLong, null, null, null);
  }
  
  public static k a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, List<byte[]> paramList, int paramInt5, float paramFloat2, com.tencent.luggage.wxa.k.a parama)
  {
    return a(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, paramFloat1, paramList, paramInt5, paramFloat2, null, -1, null, parama);
  }
  
  public static k a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, List<byte[]> paramList, int paramInt5, float paramFloat2, byte[] paramArrayOfByte, int paramInt6, b paramb, com.tencent.luggage.wxa.k.a parama)
  {
    return new k(paramString1, null, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, paramFloat1, paramInt5, paramFloat2, paramArrayOfByte, paramInt6, paramb, -1, -1, -1, -1, -1, 0, null, -1, 9223372036854775807L, paramList, parama, null);
  }
  
  public static k a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, List<byte[]> paramList, com.tencent.luggage.wxa.k.a parama, int paramInt8, String paramString4, com.tencent.luggage.wxa.v.a parama1)
  {
    return new k(paramString1, null, paramString2, paramString3, paramInt1, paramInt2, -1, -1, -1.0F, -1, -1.0F, null, -1, null, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramString4, -1, 9223372036854775807L, paramList, parama, parama1);
  }
  
  public static k a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, List<byte[]> paramList, com.tencent.luggage.wxa.k.a parama, int paramInt6, String paramString4)
  {
    return a(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, -1, -1, paramList, parama, paramInt6, paramString4, null);
  }
  
  public static k a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<byte[]> paramList, com.tencent.luggage.wxa.k.a parama, int paramInt5, String paramString4)
  {
    return a(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, -1, paramList, parama, paramInt5, paramString4);
  }
  
  public static k a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3, com.tencent.luggage.wxa.k.a parama)
  {
    return a(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramInt3, parama, 9223372036854775807L, Collections.emptyList());
  }
  
  public static k a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3, com.tencent.luggage.wxa.k.a parama, long paramLong, List<byte[]> paramList)
  {
    return new k(paramString1, null, paramString2, paramString3, paramInt1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt2, paramString4, paramInt3, paramLong, paramList, parama, null);
  }
  
  public static k a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, com.tencent.luggage.wxa.k.a parama, long paramLong)
  {
    return a(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, -1, parama, paramLong, Collections.emptyList());
  }
  
  public static k a(String paramString1, String paramString2, String paramString3, int paramInt, com.tencent.luggage.wxa.k.a parama)
  {
    return new k(paramString1, null, paramString2, paramString3, paramInt, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, 9223372036854775807L, null, parama, null);
  }
  
  public static k a(String paramString1, String paramString2, String paramString3, int paramInt, List<byte[]> paramList, String paramString4, com.tencent.luggage.wxa.k.a parama)
  {
    return new k(paramString1, null, paramString2, paramString3, paramInt, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, paramString4, -1, 9223372036854775807L, paramList, parama, null);
  }
  
  public static k a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, float paramFloat, List<byte[]> paramList, int paramInt4)
  {
    return new k(paramString1, paramString2, paramString3, paramString4, paramInt1, -1, paramInt2, paramInt3, paramFloat, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt4, null, -1, 9223372036854775807L, paramList, null, null);
  }
  
  public static k a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, List<byte[]> paramList, int paramInt4, String paramString5)
  {
    return new k(paramString1, paramString2, paramString3, paramString4, paramInt1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, paramInt2, paramInt3, -1, -1, -1, paramInt4, paramString5, -1, 9223372036854775807L, paramList, null, null);
  }
  
  public static k a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5)
  {
    return a(paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2, paramString5, -1);
  }
  
  public static k a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, int paramInt3)
  {
    return new k(paramString1, paramString2, paramString3, paramString4, paramInt1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt2, paramString5, paramInt3, 9223372036854775807L, null, null, null);
  }
  
  public static String a(k paramk)
  {
    if (paramk == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id=");
    localStringBuilder.append(paramk.a);
    localStringBuilder.append(", mimeType=");
    localStringBuilder.append(paramk.f);
    if (paramk.b != -1)
    {
      localStringBuilder.append(", bitrate=");
      localStringBuilder.append(paramk.b);
    }
    if ((paramk.j != -1) && (paramk.k != -1))
    {
      localStringBuilder.append(", res=");
      localStringBuilder.append(paramk.j);
      localStringBuilder.append("x");
      localStringBuilder.append(paramk.k);
    }
    if (paramk.l != -1.0F)
    {
      localStringBuilder.append(", fps=");
      localStringBuilder.append(paramk.l);
    }
    if (paramk.r != -1)
    {
      localStringBuilder.append(", channels=");
      localStringBuilder.append(paramk.r);
    }
    if (paramk.s != -1)
    {
      localStringBuilder.append(", sample_rate=");
      localStringBuilder.append(paramk.s);
    }
    if (paramk.y != null)
    {
      localStringBuilder.append(", language=");
      localStringBuilder.append(paramk.y);
    }
    return localStringBuilder.toString();
  }
  
  @TargetApi(24)
  private static void a(MediaFormat paramMediaFormat, b paramb)
  {
    if (paramb == null) {
      return;
    }
    a(paramMediaFormat, "color-transfer", paramb.c);
    a(paramMediaFormat, "color-standard", paramb.a);
    a(paramMediaFormat, "color-range", paramb.b);
    a(paramMediaFormat, "hdr-static-info", paramb.d);
  }
  
  @TargetApi(16)
  private static void a(MediaFormat paramMediaFormat, String paramString, float paramFloat)
  {
    if (paramFloat != -1.0F) {
      paramMediaFormat.setFloat(paramString, paramFloat);
    }
  }
  
  @TargetApi(16)
  private static void a(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    if (paramInt != -1) {
      paramMediaFormat.setInteger(paramString, paramInt);
    }
  }
  
  @TargetApi(16)
  private static void a(MediaFormat paramMediaFormat, String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      paramMediaFormat.setString(paramString1, paramString2);
    }
  }
  
  @TargetApi(16)
  private static void a(MediaFormat paramMediaFormat, String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      paramMediaFormat.setByteBuffer(paramString, ByteBuffer.wrap(paramArrayOfByte));
    }
  }
  
  public static k b(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5)
  {
    return new k(paramString1, paramString2, paramString3, paramString4, paramInt1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt2, paramString5, -1, 9223372036854775807L, null, null, null);
  }
  
  public int a()
  {
    int i2 = this.j;
    int i1 = -1;
    if (i2 != -1)
    {
      i1 = this.k;
      if (i1 == -1) {
        return -1;
      }
      i1 = i2 * i1;
    }
    return i1;
  }
  
  public k a(int paramInt)
  {
    return new k(this.a, this.e, this.f, this.c, this.b, paramInt, this.j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, this.u, this.v, this.x, this.y, this.z, this.w, this.h, this.i, this.d);
  }
  
  public k a(int paramInt1, int paramInt2)
  {
    return new k(this.a, this.e, this.f, this.c, this.b, this.g, this.j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, paramInt1, paramInt2, this.x, this.y, this.z, this.w, this.h, this.i, this.d);
  }
  
  public k a(long paramLong)
  {
    return new k(this.a, this.e, this.f, this.c, this.b, this.g, this.j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, this.u, this.v, this.x, this.y, this.z, paramLong, this.h, this.i, this.d);
  }
  
  public k a(com.tencent.luggage.wxa.k.a parama)
  {
    return new k(this.a, this.e, this.f, this.c, this.b, this.g, this.j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, this.u, this.v, this.x, this.y, this.z, this.w, this.h, parama, this.d);
  }
  
  public k a(com.tencent.luggage.wxa.v.a parama)
  {
    return new k(this.a, this.e, this.f, this.c, this.b, this.g, this.j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, this.u, this.v, this.x, this.y, this.z, this.w, this.h, this.i, parama);
  }
  
  public k a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3)
  {
    return new k(paramString1, this.e, this.f, paramString2, paramInt1, this.g, paramInt2, paramInt3, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, this.u, this.v, paramInt4, paramString3, this.z, this.w, this.h, this.i, this.d);
  }
  
  @SuppressLint({"InlinedApi"})
  @TargetApi(16)
  public final MediaFormat b()
  {
    MediaFormat localMediaFormat = new MediaFormat();
    localMediaFormat.setString("mime", this.f);
    a(localMediaFormat, "language", this.y);
    a(localMediaFormat, "max-input-size", this.g);
    a(localMediaFormat, "width", this.j);
    a(localMediaFormat, "height", this.k);
    a(localMediaFormat, "frame-rate", this.l);
    a(localMediaFormat, "rotation-degrees", this.m);
    a(localMediaFormat, "channel-count", this.r);
    a(localMediaFormat, "sample-rate", this.s);
    a(localMediaFormat, "encoder-delay", this.u);
    a(localMediaFormat, "encoder-padding", this.v);
    int i1 = 0;
    while (i1 < this.h.size())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("csd-");
      localStringBuilder.append(i1);
      localMediaFormat.setByteBuffer(localStringBuilder.toString(), ByteBuffer.wrap((byte[])this.h.get(i1)));
      i1 += 1;
    }
    a(localMediaFormat, this.q);
    return localMediaFormat;
  }
  
  public int describeContents()
  {
    return 0;
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
      paramObject = (k)paramObject;
      if ((this.b == paramObject.b) && (this.g == paramObject.g) && (this.j == paramObject.j) && (this.k == paramObject.k) && (this.l == paramObject.l) && (this.m == paramObject.m) && (this.n == paramObject.n) && (this.o == paramObject.o) && (this.r == paramObject.r) && (this.s == paramObject.s) && (this.t == paramObject.t) && (this.u == paramObject.u) && (this.v == paramObject.v) && (this.w == paramObject.w) && (this.x == paramObject.x) && (x.a(this.a, paramObject.a)) && (x.a(this.y, paramObject.y)) && (this.z == paramObject.z) && (x.a(this.e, paramObject.e)) && (x.a(this.f, paramObject.f)) && (x.a(this.c, paramObject.c)) && (x.a(this.i, paramObject.i)) && (x.a(this.d, paramObject.d)) && (x.a(this.q, paramObject.q)) && (Arrays.equals(this.p, paramObject.p)))
      {
        if (this.h.size() != paramObject.h.size()) {
          return false;
        }
        int i1 = 0;
        while (i1 < this.h.size())
        {
          if (!Arrays.equals((byte[])this.h.get(i1), (byte[])paramObject.h.get(i1))) {
            return false;
          }
          i1 += 1;
        }
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    if (this.A == 0)
    {
      Object localObject = this.a;
      int i7 = 0;
      int i1;
      if (localObject == null) {
        i1 = 0;
      } else {
        i1 = ((String)localObject).hashCode();
      }
      localObject = this.e;
      int i2;
      if (localObject == null) {
        i2 = 0;
      } else {
        i2 = ((String)localObject).hashCode();
      }
      localObject = this.f;
      int i3;
      if (localObject == null) {
        i3 = 0;
      } else {
        i3 = ((String)localObject).hashCode();
      }
      localObject = this.c;
      int i4;
      if (localObject == null) {
        i4 = 0;
      } else {
        i4 = ((String)localObject).hashCode();
      }
      int i8 = this.b;
      int i9 = this.j;
      int i10 = this.k;
      int i11 = this.r;
      int i12 = this.s;
      localObject = this.y;
      int i5;
      if (localObject == null) {
        i5 = 0;
      } else {
        i5 = ((String)localObject).hashCode();
      }
      int i13 = this.z;
      localObject = this.i;
      int i6;
      if (localObject == null) {
        i6 = 0;
      } else {
        i6 = ((com.tencent.luggage.wxa.k.a)localObject).hashCode();
      }
      localObject = this.d;
      if (localObject != null) {
        i7 = ((com.tencent.luggage.wxa.v.a)localObject).hashCode();
      }
      this.A = (((((((((((((527 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + i5) * 31 + i13) * 31 + i6) * 31 + i7);
    }
    return this.A;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Format(");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.y);
    localStringBuilder.append(", [");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.l);
    localStringBuilder.append("], [");
    localStringBuilder.append(this.r);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.s);
    localStringBuilder.append("])");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.j);
    paramParcel.writeInt(this.k);
    paramParcel.writeFloat(this.l);
    paramParcel.writeInt(this.m);
    paramParcel.writeFloat(this.n);
    if (this.p != null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    paramParcel.writeInt(i1);
    byte[] arrayOfByte = this.p;
    if (arrayOfByte != null) {
      paramParcel.writeByteArray(arrayOfByte);
    }
    paramParcel.writeInt(this.o);
    paramParcel.writeParcelable(this.q, paramInt);
    paramParcel.writeInt(this.r);
    paramParcel.writeInt(this.s);
    paramParcel.writeInt(this.t);
    paramParcel.writeInt(this.u);
    paramParcel.writeInt(this.v);
    paramParcel.writeInt(this.x);
    paramParcel.writeString(this.y);
    paramParcel.writeInt(this.z);
    paramParcel.writeLong(this.w);
    int i1 = this.h.size();
    paramParcel.writeInt(i1);
    paramInt = 0;
    while (paramInt < i1)
    {
      paramParcel.writeByteArray((byte[])this.h.get(paramInt));
      paramInt += 1;
    }
    paramParcel.writeParcelable(this.i, 0);
    paramParcel.writeParcelable(this.d, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.h.k
 * JD-Core Version:    0.7.0.1
 */