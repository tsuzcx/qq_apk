package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import org.jetbrains.annotations.NotNull;
import pha;
import rin;
import tencent.im.oidb.articlesummary.articlesummary.UrlJumpInfo;

public class UrlJumpInfo
  implements Parcelable
{
  public static final Parcelable.Creator<UrlJumpInfo> CREATOR = new rin();
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public UrlJumpInfo() {}
  
  public UrlJumpInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
  }
  
  @NotNull
  public static UrlJumpInfo a(articlesummary.UrlJumpInfo paramUrlJumpInfo)
  {
    UrlJumpInfo localUrlJumpInfo = new UrlJumpInfo();
    if ((paramUrlJumpInfo != null) && (paramUrlJumpInfo.has()) && (paramUrlJumpInfo.get() != null)) {
      if (!paramUrlJumpInfo.uint32_jump_type.has()) {
        break label106;
      }
    }
    label106:
    for (int i = paramUrlJumpInfo.uint32_jump_type.get();; i = 0)
    {
      localUrlJumpInfo.jdField_a_of_type_Int = i;
      localUrlJumpInfo.c = pha.a(paramUrlJumpInfo.bytes_jump_schema);
      localUrlJumpInfo.b = pha.a(paramUrlJumpInfo.bytes_jump_bundle);
      localUrlJumpInfo.jdField_a_of_type_JavaLangString = pha.a(paramUrlJumpInfo.bytes_jump_url);
      localUrlJumpInfo.d = pha.a(paramUrlJumpInfo.bytes_clipboard_info);
      localUrlJumpInfo.e = pha.a(paramUrlJumpInfo.bytes_common_data);
      return localUrlJumpInfo;
    }
  }
  
  public articlesummary.UrlJumpInfo a()
  {
    articlesummary.UrlJumpInfo localUrlJumpInfo = new articlesummary.UrlJumpInfo();
    localUrlJumpInfo.uint32_jump_type.set(this.jdField_a_of_type_Int);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localUrlJumpInfo.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    }
    if (!TextUtils.isEmpty(this.b)) {
      localUrlJumpInfo.bytes_jump_bundle.set(ByteStringMicro.copyFromUtf8(this.b));
    }
    if (!TextUtils.isEmpty(this.c)) {
      localUrlJumpInfo.bytes_jump_schema.set(ByteStringMicro.copyFromUtf8(this.c));
    }
    if (!TextUtils.isEmpty(this.d)) {
      localUrlJumpInfo.bytes_clipboard_info.set(ByteStringMicro.copyFromUtf8(this.d));
    }
    if (!TextUtils.isEmpty(this.e)) {
      localUrlJumpInfo.bytes_common_data.set(ByteStringMicro.copyFromUtf8(this.e));
    }
    return localUrlJumpInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "UrlJumpInfo{jumpType=" + this.jdField_a_of_type_Int + ", jumpUrl='" + this.jdField_a_of_type_JavaLangString + '\'' + ", jumpBundle='" + this.b + '\'' + ", jumpSchema='" + this.c + '\'' + ", clipboardInfo='" + this.d + '\'' + ", commonData='" + this.e + "'" + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo
 * JD-Core Version:    0.7.0.1
 */