package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;

public class AIOLightVideoData
  extends AIORichMediaData
  implements Parcelable
{
  public String a = "I:N";
  public String b = "I:N";
  public int c;
  public int d;
  public int e;
  public int f;
  public long g;
  
  public void a(Parcel paramParcel)
  {
    super.a(paramParcel);
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readLong();
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return false;
      }
      return this.b.equals("I:N") ^ true;
    }
    return this.a.equals("I:N") ^ true;
  }
  
  public String b(int paramInt)
  {
    String str;
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        str = null;
      } else {
        str = this.b;
      }
    }
    else {
      str = this.a;
    }
    if ((str != null) && (!str.equals("I:N")))
    {
      if (!str.startsWith("/"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("file:/");
        localStringBuilder.append(str);
        return localStringBuilder.toString();
      }
      if (str.startsWith("//"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("file:");
        localStringBuilder.append(str);
        return localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file:");
      localStringBuilder.append(str);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public File c(int paramInt)
  {
    Object localObject;
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        localObject = null;
      } else {
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
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeLong(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOLightVideoData
 * JD-Core Version:    0.7.0.1
 */