package com.tencent.mobileqq.activity.aio;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SessionInfo
  extends BaseSessionInfo
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<SessionInfo> CREATOR = new SessionInfo.1();
  public ChatBackground H;
  
  public SessionInfo() {}
  
  protected SessionInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.t = paramParcel.readInt();
    a(paramParcel.readString());
    b(paramParcel.readString());
    a(paramParcel.readBundle(getClass().getClassLoader()));
  }
  
  public SessionInfo(BaseSessionInfo paramBaseSessionInfo)
  {
    super(paramBaseSessionInfo);
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeInt(this.t);
    paramParcel.writeString(c());
    paramParcel.writeString(d());
    paramParcel.writeBundle(b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.SessionInfo
 * JD-Core Version:    0.7.0.1
 */