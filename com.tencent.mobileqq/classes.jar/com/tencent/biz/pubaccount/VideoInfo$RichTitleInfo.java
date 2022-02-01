package com.tencent.biz.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import odi;
import org.json.JSONObject;

public class VideoInfo$RichTitleInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RichTitleInfo> CREATOR = new odi();
  public String a;
  public String b;
  public String c;
  public String d;
  
  public VideoInfo$RichTitleInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
  }
  
  public VideoInfo$RichTitleInfo(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("bytes_biu_comments");
    paramJSONObject = paramJSONObject.optJSONObject("msg_jump_info");
    if (paramJSONObject != null)
    {
      this.b = paramJSONObject.optString("uint64_id");
      this.c = paramJSONObject.optString("bytes_wording");
      this.d = paramJSONObject.optString("bytes_jump_url");
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "RichTitleInfo{normalWords='" + this.a + '\'' + ", topicId='" + this.b + '\'' + ", topicName='" + this.c + '\'' + ", jumpUrl='" + this.d + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoInfo.RichTitleInfo
 * JD-Core Version:    0.7.0.1
 */