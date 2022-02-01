package com.tencent.biz.qqstory.notification;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class StoryPushMsg
  implements Parcelable
{
  public static final Parcelable.Creator<StoryPushMsg> CREATOR = new StoryPushMsg.1();
  public int a;
  public String b;
  public String c;
  public long d;
  public String e;
  public String f;
  public int g = 0;
  public String h;
  public int i;
  public String j;
  public String k;
  public String l;
  public Bundle m = new Bundle();
  
  public StoryPushMsg(int paramInt1, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, int paramInt2, String paramString5, String paramString6, String paramString7)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramLong;
    this.e = paramString3;
    this.g = paramInt2;
    this.f = paramString4;
    this.h = paramString5;
    this.k = paramString6;
    this.l = paramString7;
  }
  
  public StoryPushMsg(int paramInt, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5)
  {
    this(paramInt, paramString1, paramString2, paramLong, paramString3, paramString4, 1, null, paramString5, null);
  }
  
  public StoryPushMsg(int paramInt1, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7, String paramString8)
  {
    this(paramInt1, paramString1, paramString2, paramLong, paramString3, paramString4, 1, null, paramString6, paramString7);
    this.i = paramInt2;
    this.j = paramString5;
    this.h = paramString8;
  }
  
  public StoryPushMsg(int paramInt, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this(paramInt, paramString1, paramString2, paramLong, paramString3, paramString4, 1, paramString5, paramString6, null);
  }
  
  public String a()
  {
    return this.e;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StoryPushMsg{mCommentId=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", subType='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", msgInfo='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uin=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", unionId='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", feedId='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mUnreadNum=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", mVid='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mThumbUrl='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mFeedLikeUserUnionId='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", reserveBundle=");
    localStringBuilder.append(this.m);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeLong(this.d);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.g);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.k);
    paramParcel.writeBundle(this.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.notification.StoryPushMsg
 * JD-Core Version:    0.7.0.1
 */