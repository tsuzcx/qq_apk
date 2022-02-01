package com.tencent.luggage.wxa.k;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.ao.x;
import java.util.Arrays;
import java.util.UUID;

public final class a$a
  implements Parcelable
{
  public static final Parcelable.Creator<a> CREATOR = new a.a.1();
  @Nullable
  public final String a;
  public final String b;
  public final byte[] c;
  public final boolean d;
  private int e;
  private final UUID f;
  
  a$a(Parcel paramParcel)
  {
    this.f = new UUID(paramParcel.readLong(), paramParcel.readLong());
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.createByteArray();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.d = bool;
  }
  
  public a$a(UUID paramUUID, @Nullable String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    this(paramUUID, paramString1, paramString2, paramArrayOfByte, false);
  }
  
  public a$a(UUID paramUUID, @Nullable String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    this.f = ((UUID)a.a(paramUUID));
    this.a = paramString1;
    this.b = ((String)a.a(paramString2));
    this.c = ((byte[])a.a(paramArrayOfByte));
    this.d = paramBoolean;
  }
  
  public a a(String paramString)
  {
    if (x.a(this.a, paramString)) {
      return this;
    }
    return new a(this.f, paramString, this.b, this.c, this.d);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof a)) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    paramObject = (a)paramObject;
    return (this.b.equals(paramObject.b)) && (x.a(this.f, paramObject.f)) && (x.a(this.a, paramObject.a)) && (Arrays.equals(this.c, paramObject.c));
  }
  
  public int hashCode()
  {
    if (this.e == 0)
    {
      int j = this.f.hashCode();
      String str = this.a;
      int i;
      if (str == null) {
        i = 0;
      } else {
        i = str.hashCode();
      }
      this.e = (((j * 31 + i) * 31 + this.b.hashCode()) * 31 + Arrays.hashCode(this.c));
    }
    return this.e;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.f.getMostSignificantBits());
    paramParcel.writeLong(this.f.getLeastSignificantBits());
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeByteArray(this.c);
    paramParcel.writeByte((byte)this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.k.a.a
 * JD-Core Version:    0.7.0.1
 */