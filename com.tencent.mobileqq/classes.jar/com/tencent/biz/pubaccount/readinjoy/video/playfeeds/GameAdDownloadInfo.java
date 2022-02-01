package com.tencent.biz.pubaccount.readinjoy.video.playfeeds;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class GameAdDownloadInfo
  implements Parcelable
{
  public static final Parcelable.Creator<GameAdDownloadInfo> CREATOR = new GameAdDownloadInfo.1();
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  protected GameAdDownloadInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
  }
  
  public GameAdDownloadInfo(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("sGameDownloadUrl");
    this.b = paramJSONObject.optString("lGameSize");
    this.c = paramJSONObject.optString("sApkMd5");
    this.d = paramJSONObject.optString("sVersionCode");
    this.jdField_a_of_type_Int = paramJSONObject.optInt("iGameType");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdDownloadInfo
 * JD-Core Version:    0.7.0.1
 */