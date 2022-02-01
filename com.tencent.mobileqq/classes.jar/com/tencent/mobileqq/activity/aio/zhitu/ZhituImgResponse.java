package com.tencent.mobileqq.activity.aio.zhitu;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.util.JSONUtils.FieldName;

public class ZhituImgResponse
  implements Parcelable
{
  public static final Parcelable.Creator<ZhituImgResponse> CREATOR = new ZhituImgResponse.1();
  public String coord;
  public String md5;
  public String pass;
  public String style;
  @JSONUtils.FieldName(a="text-color")
  public String textColor;
  public String url;
  
  public ZhituImgResponse() {}
  
  protected ZhituImgResponse(Parcel paramParcel)
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
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (ZhituImgResponse)paramObject;
      String str = this.url;
      if (str != null) {
        return str.equals(paramObject.url);
      }
      return paramObject.url == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.url;
    if (str != null) {
      return str.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ZhituImgResponse{url='");
    localStringBuilder.append(this.url);
    localStringBuilder.append('\'');
    localStringBuilder.append(", textColor='");
    localStringBuilder.append(this.textColor);
    localStringBuilder.append('\'');
    localStringBuilder.append(", md5='");
    localStringBuilder.append(this.md5);
    localStringBuilder.append('\'');
    localStringBuilder.append(", style='");
    localStringBuilder.append(this.style);
    localStringBuilder.append('\'');
    localStringBuilder.append(", coord='");
    localStringBuilder.append(this.coord);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pass='");
    localStringBuilder.append(this.pass);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituImgResponse
 * JD-Core Version:    0.7.0.1
 */