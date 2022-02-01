package com.tencent.luggage.wxa.eo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.cx.u;
import com.tencent.luggage.wxa.do.c;
import com.tencent.luggage.wxa.qw.bd;
import java.io.IOException;

public class a
  extends c
  implements Parcelable
{
  public static final Parcelable.Creator<a> CREATOR = new a.1();
  public bd A;
  public String B;
  private a.a C;
  public String w;
  public boolean x;
  public boolean y;
  public int z;
  
  public a(Parcel paramParcel)
  {
    super(paramParcel);
    boolean bool2 = false;
    this.x = false;
    this.y = false;
    this.z = 0;
    this.A = u.b.a();
    this.w = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.x = bool1;
    this.B = paramParcel.readString();
    this.C = a.a.values()[paramParcel.readInt()];
    boolean bool1 = bool2;
    if (paramParcel.readByte() > 0) {
      bool1 = true;
    }
    this.y = bool1;
    int i = paramParcel.readInt();
    byte[] arrayOfByte;
    if (i > 0)
    {
      arrayOfByte = new byte[i];
      paramParcel.readByteArray(arrayOfByte);
    }
    try
    {
      this.A = ((bd)new bd().a(arrayOfByte));
    }
    catch (IOException localIOException)
    {
      label139:
      break label139;
    }
    this.A = null;
    this.e = paramParcel.readString();
  }
  
  public void a(int paramInt)
  {
    this.C = a.a.values()[paramInt];
  }
  
  public a o()
  {
    Parcel localParcel = p();
    a locala = new a(localParcel);
    localParcel.recycle();
    return locala;
  }
  
  public Parcel p()
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    return localParcel;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.w);
    paramParcel.writeByte((byte)this.x);
    paramParcel.writeString(this.B);
    Object localObject1 = this.C;
    if (localObject1 == null) {
      paramParcel.writeInt(a.a.a.ordinal());
    } else {
      paramParcel.writeInt(((a.a)localObject1).ordinal());
    }
    paramParcel.writeByte((byte)this.y);
    byte[] arrayOfByte = new byte[0];
    localObject1 = arrayOfByte;
    try
    {
      if (this.A != null) {
        localObject1 = this.A.b();
      }
      paramParcel.writeInt(localObject1.length);
      if (localObject1.length > 0) {
        paramParcel.writeByteArray((byte[])localObject1);
      }
      paramParcel.writeString(this.e);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Object localObject2 = arrayOfByte;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.eo.a
 * JD-Core Version:    0.7.0.1
 */