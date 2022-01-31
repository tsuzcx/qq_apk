package com.tencent.biz.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import nsp;
import slk;

public class VideoInfo$EntranceDownloadInfo
  implements Parcelable, slk
{
  public static final Parcelable.Creator<EntranceDownloadInfo> CREATOR = new nsp();
  public UrlJumpInfo a;
  public String a;
  public boolean a;
  public String b;
  public String c;
  
  public VideoInfo$EntranceDownloadInfo() {}
  
  public VideoInfo$EntranceDownloadInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.c = paramParcel.readString();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
      return;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean c()
  {
    return !TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
  }
  
  public String d()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean d()
  {
    return !TextUtils.isEmpty(this.b);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.b;
  }
  
  public String toString()
  {
    return "EntranceDownloadInfo{iconUrl='" + this.jdField_a_of_type_JavaLangString + '\'' + ", smallIconUrl='" + this.b + '\'' + ", isUseGif='" + this.jdField_a_of_type_Boolean + '\'' + ", commonData='" + this.c + '\'' + ", jumpInfo='" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.c);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoInfo.EntranceDownloadInfo
 * JD-Core Version:    0.7.0.1
 */