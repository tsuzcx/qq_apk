package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import obz;
import psb;
import tencent.im.oidb.articlesummary.articlesummary.VideoColumnInfo;

public class VideoColumnInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VideoColumnInfo> CREATOR = new psb();
  public int a;
  public long a;
  public UrlJumpInfo a;
  public String a;
  public boolean a;
  public int b;
  public UrlJumpInfo b;
  public String b;
  public int c;
  public UrlJumpInfo c;
  public String c;
  public int d;
  public UrlJumpInfo d;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  public VideoColumnInfo() {}
  
  public VideoColumnInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_c_of_type_JavaLangString = paramParcel.readString();
      this.jdField_d_of_type_JavaLangString = paramParcel.readString();
      this.e = paramParcel.readString();
      this.f = paramParcel.readString();
      this.g = paramParcel.readString();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
      this.jdField_d_of_type_Int = paramParcel.readInt();
      this.h = paramParcel.readString();
      this.i = paramParcel.readString();
      return;
    }
  }
  
  public static VideoColumnInfo a(articlesummary.VideoColumnInfo paramVideoColumnInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramVideoColumnInfo != null)
    {
      localObject1 = localObject2;
      if (paramVideoColumnInfo.has())
      {
        localObject1 = localObject2;
        if (paramVideoColumnInfo.get() != null)
        {
          localObject1 = new VideoColumnInfo();
          ((VideoColumnInfo)localObject1).jdField_a_of_type_Int = paramVideoColumnInfo.uint32_column_id.get();
          ((VideoColumnInfo)localObject1).jdField_a_of_type_JavaLangString = obz.a(paramVideoColumnInfo.bytes_column_name);
          ((VideoColumnInfo)localObject1).jdField_b_of_type_JavaLangString = obz.a(paramVideoColumnInfo.bytes_column_icon_url);
          ((VideoColumnInfo)localObject1).jdField_a_of_type_Long = paramVideoColumnInfo.uint64_last_update_time.get();
          ((VideoColumnInfo)localObject1).jdField_b_of_type_Int = paramVideoColumnInfo.uint32_video_count.get();
          ((VideoColumnInfo)localObject1).jdField_c_of_type_Int = paramVideoColumnInfo.uint32_subscribe_count.get();
          if (paramVideoColumnInfo.uint32_is_subscribed.get() <= 0) {
            break label251;
          }
        }
      }
    }
    label251:
    for (boolean bool = true;; bool = false)
    {
      ((VideoColumnInfo)localObject1).jdField_a_of_type_Boolean = bool;
      ((VideoColumnInfo)localObject1).jdField_c_of_type_JavaLangString = obz.a(paramVideoColumnInfo.bytes_column_card_bg_url);
      ((VideoColumnInfo)localObject1).jdField_d_of_type_JavaLangString = obz.a(paramVideoColumnInfo.bytes_column_card_bg_color);
      ((VideoColumnInfo)localObject1).e = obz.a(paramVideoColumnInfo.bytes_column_card_icon_url);
      ((VideoColumnInfo)localObject1).f = obz.a(paramVideoColumnInfo.bytes_app_name);
      ((VideoColumnInfo)localObject1).g = obz.a(paramVideoColumnInfo.bytes_app_icon_url);
      ((VideoColumnInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = UrlJumpInfo.a(paramVideoColumnInfo.default_jump_info);
      ((VideoColumnInfo)localObject1).jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = UrlJumpInfo.a(paramVideoColumnInfo.video_jump_info);
      ((VideoColumnInfo)localObject1).jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = UrlJumpInfo.a(paramVideoColumnInfo.subscribe_jump_info);
      ((VideoColumnInfo)localObject1).jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = UrlJumpInfo.a(paramVideoColumnInfo.app_jump_info);
      ((VideoColumnInfo)localObject1).jdField_d_of_type_Int = paramVideoColumnInfo.uin32_column_card_bg_style.get();
      ((VideoColumnInfo)localObject1).h = obz.a(paramVideoColumnInfo.bytes_from_txt);
      ((VideoColumnInfo)localObject1).i = obz.a(paramVideoColumnInfo.bytes_column_name_color);
      return localObject1;
    }
  }
  
  public String a()
  {
    return "#" + this.jdField_a_of_type_JavaLangString;
  }
  
  public byte[] a()
  {
    articlesummary.VideoColumnInfo localVideoColumnInfo = new articlesummary.VideoColumnInfo();
    localVideoColumnInfo.uint32_column_id.set(this.jdField_a_of_type_Int);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localVideoColumnInfo.bytes_column_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localVideoColumnInfo.bytes_column_icon_url.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
    }
    localVideoColumnInfo.uint64_last_update_time.set(this.jdField_a_of_type_Long);
    localVideoColumnInfo.uint32_video_count.set(this.jdField_b_of_type_Int);
    localVideoColumnInfo.uint32_subscribe_count.set(this.jdField_c_of_type_Int);
    PBUInt32Field localPBUInt32Field = localVideoColumnInfo.uint32_is_subscribed;
    if (this.jdField_a_of_type_Boolean) {}
    for (int j = 1;; j = 0)
    {
      localPBUInt32Field.set(j);
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        localVideoColumnInfo.bytes_column_card_bg_url.set(ByteStringMicro.copyFromUtf8(this.jdField_c_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(this.e)) {
        localVideoColumnInfo.bytes_column_card_icon_url.set(ByteStringMicro.copyFromUtf8(this.e));
      }
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        localVideoColumnInfo.bytes_column_card_bg_color.set(ByteStringMicro.copyFromUtf8(this.jdField_d_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(this.f)) {
        localVideoColumnInfo.bytes_app_name.set(ByteStringMicro.copyFromUtf8(this.f));
      }
      if (!TextUtils.isEmpty(this.g)) {
        localVideoColumnInfo.bytes_app_icon_url.set(ByteStringMicro.copyFromUtf8(this.g));
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {
        localVideoColumnInfo.default_jump_info = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.a();
      }
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {
        localVideoColumnInfo.video_jump_info = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.a();
      }
      if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {
        localVideoColumnInfo.subscribe_jump_info = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.a();
      }
      if (this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {
        localVideoColumnInfo.app_jump_info = this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.a();
      }
      localVideoColumnInfo.uin32_column_card_bg_style.set(this.jdField_d_of_type_Int);
      if (!TextUtils.isEmpty(this.h)) {
        localVideoColumnInfo.bytes_from_txt.set(ByteStringMicro.copyFromUtf8(this.h));
      }
      if (!TextUtils.isEmpty(this.i)) {
        localVideoColumnInfo.bytes_column_name_color.set(ByteStringMicro.copyFromUtf8(this.i));
      }
      return localVideoColumnInfo.toByteArray();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "VideoColumnInfo{columnId=" + this.jdField_a_of_type_Int + ", columnName='" + this.jdField_a_of_type_JavaLangString + '\'' + ", cardIconUrl=" + this.jdField_b_of_type_JavaLangString + '\'' + ", lastUpdateTime=" + this.jdField_a_of_type_Long + '\'' + ", videoCount=" + this.jdField_b_of_type_Int + '\'' + ", subscribeCount='" + this.jdField_c_of_type_Int + '\'' + ", isSubscribed='" + this.jdField_a_of_type_Boolean + '\'' + ", cardBgUrl=" + this.jdField_c_of_type_JavaLangString + '\'' + ", cardBgColor=" + this.jdField_d_of_type_JavaLangString + '\'' + ", cardIconUrl=" + this.e + '\'' + ", appName=" + this.f + ", appIconUrl='" + this.g + '\'' + ", defaultJumpInfo=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo + ", videoJumpInfo=" + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo + ", subscribeJumpInfo=" + this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo + ", appJumpInfo='" + this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo + '\'' + ", cardBgStyle='" + this.jdField_d_of_type_Int + '\'' + ", fromText='" + this.h + '\'' + ", columnNameColor='" + this.i + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {}
    for (int j = 1;; j = 0)
    {
      paramParcel.writeByte((byte)j);
      paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
      paramParcel.writeString(this.e);
      paramParcel.writeString(this.f);
      paramParcel.writeString(this.g);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo, paramInt);
      paramParcel.writeParcelable(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo, paramInt);
      paramParcel.writeParcelable(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo, paramInt);
      paramParcel.writeParcelable(this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo, paramInt);
      paramParcel.writeInt(this.jdField_d_of_type_Int);
      paramParcel.writeString(this.h);
      paramParcel.writeString(this.i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo
 * JD-Core Version:    0.7.0.1
 */