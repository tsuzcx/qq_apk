package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;

public class AIOShortVideoData
  extends AIORichMediaData
  implements Parcelable
{
  public String a = "I:N";
  public String b = "I:N";
  public int c;
  public int d;
  public boolean e;
  public boolean f;
  public int g;
  public int h;
  public long i;
  public int j = 0;
  public String k = "";
  public String l = "";
  public int m = 0;
  public String n = "";
  public int o = 0;
  public int p;
  public int q = 0;
  public String r;
  public String s;
  private String t = null;
  
  public String a()
  {
    return this.t;
  }
  
  public void a(Parcel paramParcel)
  {
    super.a(paramParcel);
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readLong();
    this.j = paramParcel.readInt();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readInt();
    this.n = paramParcel.readString();
    this.o = paramParcel.readInt();
    this.q = paramParcel.readInt();
    this.p = paramParcel.readInt();
    this.r = paramParcel.readString();
    this.s = paramParcel.readString();
  }
  
  public void a(String paramString)
  {
    this.t = paramString;
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
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeLong(this.i);
    paramParcel.writeInt(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeInt(this.m);
    paramParcel.writeString(this.n);
    paramParcel.writeInt(this.o);
    paramParcel.writeInt(this.q);
    paramParcel.writeInt(this.p);
    paramParcel.writeString(this.r);
    paramParcel.writeString(this.s);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData
 * JD-Core Version:    0.7.0.1
 */