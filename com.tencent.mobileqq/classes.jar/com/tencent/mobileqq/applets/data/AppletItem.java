package com.tencent.mobileqq.applets.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AppletItem
  implements Parcelable
{
  public static final Parcelable.Creator<AppletItem> CREATOR = new AppletItem.1();
  private long a;
  private String b;
  private String c;
  private int d;
  private int e;
  private String f;
  
  private AppletItem(long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    this.a = paramLong;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = paramString3;
  }
  
  protected AppletItem(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readString();
  }
  
  public long a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public String f()
  {
    return this.f;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppletItem:[");
    localStringBuilder.append("id = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", name = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" icon = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", type = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("(1:开, 0:关) ");
    localStringBuilder.append(", value = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("] ");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeString(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.applets.data.AppletItem
 * JD-Core Version:    0.7.0.1
 */