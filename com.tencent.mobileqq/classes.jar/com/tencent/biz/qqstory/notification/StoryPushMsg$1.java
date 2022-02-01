package com.tencent.biz.qqstory.notification;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class StoryPushMsg$1
  implements Parcelable.Creator
{
  public StoryPushMsg a(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    Object localObject = paramParcel.readString();
    String str1 = paramParcel.readString();
    long l = paramParcel.readLong();
    String str2 = paramParcel.readString();
    String str3 = paramParcel.readString();
    int j = paramParcel.readInt();
    String str4 = paramParcel.readString();
    String str5 = paramParcel.readString();
    String str6 = paramParcel.readString();
    paramParcel = paramParcel.readBundle();
    localObject = new StoryPushMsg(i, (String)localObject, str1, l, str3, str4, j, str5, str6, str2);
    ((StoryPushMsg)localObject).m = paramParcel;
    return localObject;
  }
  
  public StoryPushMsg[] a(int paramInt)
  {
    return new StoryPushMsg[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.notification.StoryPushMsg.1
 * JD-Core Version:    0.7.0.1
 */