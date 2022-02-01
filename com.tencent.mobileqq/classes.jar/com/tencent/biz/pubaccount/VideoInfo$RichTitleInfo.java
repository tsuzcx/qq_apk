package com.tencent.biz.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class VideoInfo$RichTitleInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RichTitleInfo> CREATOR = new VideoInfo.RichTitleInfo.1();
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public VideoInfo$RichTitleInfo()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  protected VideoInfo$RichTitleInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
  }
  
  public VideoInfo$RichTitleInfo(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("bytes_biu_comments");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("msg_jump_info");
    if (localJSONObject != null)
    {
      this.b = localJSONObject.optString("uint64_id");
      this.c = localJSONObject.optString("bytes_wording");
      this.d = localJSONObject.optString("bytes_jump_url");
    }
    this.jdField_a_of_type_Int = paramJSONObject.optInt("op_type", 0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "RichTitleInfo{normalWords='" + this.jdField_a_of_type_JavaLangString + '\'' + ", topicId='" + this.b + '\'' + ", topicName='" + this.c + '\'' + ", jumpUrl='" + this.d + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoInfo.RichTitleInfo
 * JD-Core Version:    0.7.0.1
 */