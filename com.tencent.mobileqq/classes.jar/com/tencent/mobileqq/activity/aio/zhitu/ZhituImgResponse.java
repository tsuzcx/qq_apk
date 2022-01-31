package com.tencent.mobileqq.activity.aio.zhitu;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.util.JSONUtils.FieldName;
import wam;

public class ZhituImgResponse
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new wam();
  public String coord;
  public String md5;
  public String pass;
  public String style;
  @JSONUtils.FieldName(a="text-color")
  public String textColor;
  public String url;
  
  public ZhituImgResponse() {}
  
  public ZhituImgResponse(Parcel paramParcel)
  {
    this.url = paramParcel.readString();
    this.textColor = paramParcel.readString();
    this.md5 = paramParcel.readString();
    this.style = paramParcel.readString();
    this.coord = paramParcel.readString();
    this.pass = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (ZhituImgResponse)paramObject;
      if (this.url != null) {
        return this.url.equals(paramObject.url);
      }
    } while (paramObject.url == null);
    return false;
  }
  
  public int hashCode()
  {
    if (this.url != null) {
      return this.url.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    return "ZhituImgResponse{url='" + this.url + '\'' + ", textColor='" + this.textColor + '\'' + ", md5='" + this.md5 + '\'' + ", style='" + this.style + '\'' + ", coord='" + this.coord + '\'' + ", pass='" + this.pass + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.textColor);
    paramParcel.writeString(this.md5);
    paramParcel.writeString(this.style);
    paramParcel.writeString(this.coord);
    paramParcel.writeString(this.pass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituImgResponse
 * JD-Core Version:    0.7.0.1
 */