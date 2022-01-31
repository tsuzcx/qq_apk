package com.tencent.biz.qqstory.storyHome.discover.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.CardVideoInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import wlj;

public class CardItem$CardVideoInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CardVideoInfo> CREATOR = new wlj();
  private qqstory_struct.CardVideoInfo a;
  
  public CardItem$CardVideoInfo(Parcel paramParcel)
  {
    try
    {
      this.a = new qqstory_struct.CardVideoInfo();
      this.a.mergeFrom(paramParcel.createByteArray());
      return;
    }
    catch (InvalidProtocolBufferMicroException paramParcel) {}
  }
  
  public CardItem$CardVideoInfo(qqstory_struct.CardVideoInfo paramCardVideoInfo)
  {
    this.a = paramCardVideoInfo;
  }
  
  public String a()
  {
    return this.a.feed_id.get().toStringUtf8();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByteArray(this.a.toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.model.CardItem.CardVideoInfo
 * JD-Core Version:    0.7.0.1
 */