package com.tencent.mobileqq.activity.aio.zhitu;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.util.JSONUtils.GenericType;
import java.util.List;
import wjs;

public class ZhituResponse
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new wjs();
  public String cat;
  public String cookie;
  public int hasMore;
  @JSONUtils.GenericType(a=ZhituImgResponse.class)
  public List list;
  @JSONUtils.GenericType(a=String.class)
  public List tokens;
  
  public ZhituResponse() {}
  
  public ZhituResponse(Parcel paramParcel)
  {
    this.cat = paramParcel.readString();
    this.list = paramParcel.createTypedArrayList(ZhituImgResponse.CREATOR);
    this.tokens = paramParcel.createStringArrayList();
    this.cookie = paramParcel.readString();
    this.hasMore = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "ZhituResponse{cat='" + this.cat + '\'' + ", list=" + this.list + ", cookie='" + this.cookie + '\'' + ", hasMore=" + this.hasMore + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.cat);
    paramParcel.writeTypedList(this.list);
    paramParcel.writeStringList(this.tokens);
    paramParcel.writeString(this.cookie);
    paramParcel.writeInt(this.hasMore);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituResponse
 * JD-Core Version:    0.7.0.1
 */