package com.tencent.av.wtogether.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.HexUtil;
import trpc.qq_av_together.common.WTogetherCommon.DirectUrlInfo;
import trpc.qq_av_together.common.WTogetherCommon.ForwardReq;
import trpc.qq_av_together.common.WTogetherCommon.VideoInfoReq;

public class ChooseFileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ChooseFileInfo> CREATOR = new ChooseFileInfo.1();
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public int d;
  public long d;
  public String d;
  public int e;
  public String e;
  public String f = null;
  public String g = null;
  
  public ChooseFileInfo(int paramInt)
  {
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  protected ChooseFileInfo(Parcel paramParcel)
  {
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.jdField_d_of_type_Long = paramParcel.readLong();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_Int = paramParcel.readInt();
  }
  
  public int a()
  {
    int i = this.jdField_b_of_type_Int;
    if (i == 0) {
      return 1;
    }
    if (i == 1) {
      return 2;
    }
    return 3;
  }
  
  public String a()
  {
    int i = this.jdField_b_of_type_Int;
    if (i == 0) {
      return this.jdField_d_of_type_JavaLangString;
    }
    if (i == 1) {
      return this.jdField_d_of_type_JavaLangString;
    }
    if (i == 4) {
      return this.jdField_d_of_type_JavaLangString;
    }
    return "";
  }
  
  public WTogetherCommon.VideoInfoReq a()
  {
    WTogetherCommon.VideoInfoReq localVideoInfoReq = new WTogetherCommon.VideoInfoReq();
    int i = this.jdField_b_of_type_Int;
    if ((i != 0) && (i != 1))
    {
      if (i == 2)
      {
        localObject = new WTogetherCommon.DirectUrlInfo();
        if (this.jdField_d_of_type_JavaLangString != null) {
          ((WTogetherCommon.DirectUrlInfo)localObject).file_name.set(this.jdField_d_of_type_JavaLangString);
        }
        if (this.jdField_e_of_type_JavaLangString != null) {
          ((WTogetherCommon.DirectUrlInfo)localObject).url.set(this.jdField_e_of_type_JavaLangString);
        }
        if (this.f != null) {
          ((WTogetherCommon.DirectUrlInfo)localObject).cookie.set(this.f);
        }
        ((WTogetherCommon.DirectUrlInfo)localObject).media_format.set(this.jdField_e_of_type_Int);
        localVideoInfoReq.video_src_type.set(1);
        localVideoInfoReq.direct_url_info.set((MessageMicro)localObject);
        return localVideoInfoReq;
      }
      localVideoInfoReq.video_src_type.set(2);
      localVideoInfoReq.online_resource_id.set(this.g);
      return localVideoInfoReq;
    }
    Object localObject = new WTogetherCommon.ForwardReq();
    ((WTogetherCommon.ForwardReq)localObject).src_uin.set(this.jdField_a_of_type_Long);
    ((WTogetherCommon.ForwardReq)localObject).src_group.set(this.jdField_b_of_type_Long);
    ((WTogetherCommon.ForwardReq)localObject).src_svcid.set(this.jdField_c_of_type_Int);
    if (this.jdField_a_of_type_JavaLangString != null) {
      ((WTogetherCommon.ForwardReq)localObject).src_parentfolder.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_JavaLangString.getBytes()));
    }
    if (this.jdField_b_of_type_JavaLangString != null) {
      ((WTogetherCommon.ForwardReq)localObject).src_uuid.set(ByteStringMicro.copyFrom(this.jdField_b_of_type_JavaLangString.getBytes()));
    }
    if (this.jdField_c_of_type_JavaLangString != null) {
      ((WTogetherCommon.ForwardReq)localObject).file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.jdField_c_of_type_JavaLangString)));
    }
    ((WTogetherCommon.ForwardReq)localObject).dst_uin.set(this.jdField_c_of_type_Long);
    ((WTogetherCommon.ForwardReq)localObject).file_size.set(this.jdField_d_of_type_Long);
    if (this.jdField_d_of_type_JavaLangString != null) {
      ((WTogetherCommon.ForwardReq)localObject).file_name.set(this.jdField_d_of_type_JavaLangString);
    }
    ((WTogetherCommon.ForwardReq)localObject).client_type.set(104);
    localVideoInfoReq.video_src_type.set(0);
    localVideoInfoReq.forward_req.set((MessageMicro)localObject);
    return localVideoInfoReq;
  }
  
  public String b()
  {
    int i = this.jdField_b_of_type_Int;
    if (i == 0) {
      return this.jdField_b_of_type_JavaLangString;
    }
    if (i == 1) {
      return this.jdField_b_of_type_JavaLangString;
    }
    if (i == 4) {
      return this.g;
    }
    return "";
  }
  
  public String c()
  {
    if ((this.jdField_b_of_type_Int == 4) && (!TextUtils.isEmpty(this.g)))
    {
      localObject = this.g.split("@");
      if (localObject.length >= 2)
      {
        localObject = localObject[(localObject.length - 1)];
        break label47;
      }
    }
    Object localObject = "0";
    label47:
    if (TextUtils.isDigitsOnly((CharSequence)localObject)) {
      return localObject;
    }
    return "0";
  }
  
  public String d()
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 1) {
      return "1";
    }
    if (i == 3) {
      return "2";
    }
    if (i == 4) {
      return "3";
    }
    return "0";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof ChooseFileInfo))
    {
      paramObject = (ChooseFileInfo)paramObject;
      if (paramObject == this) {}
      int i;
      do
      {
        return true;
        i = this.jdField_b_of_type_Int;
      } while ((i == paramObject.jdField_b_of_type_Int) && ((i != 0) && (i != 1) ? i == 2 ? (!TextUtils.equals(this.jdField_e_of_type_JavaLangString, paramObject.jdField_e_of_type_JavaLangString)) || (!TextUtils.equals(this.f, paramObject.f)) || (!TextUtils.equals(this.jdField_d_of_type_JavaLangString, paramObject.jdField_d_of_type_JavaLangString)) : i == 4 ? (!TextUtils.equals(this.g, paramObject.g)) || (!TextUtils.equals(this.jdField_d_of_type_JavaLangString, paramObject.jdField_d_of_type_JavaLangString)) : (TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString)) || (TextUtils.equals(this.jdField_d_of_type_JavaLangString, paramObject.jdField_d_of_type_JavaLangString)) || (TextUtils.equals(this.jdField_e_of_type_JavaLangString, paramObject.jdField_e_of_type_JavaLangString)) || (TextUtils.equals(this.f, paramObject.f)) || (TextUtils.equals(this.g, paramObject.g)) : (TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString)) && (TextUtils.equals(this.jdField_d_of_type_JavaLangString, paramObject.jdField_d_of_type_JavaLangString))));
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChooseFile{entrance: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", type: ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", srcUin: ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", srcGroup: ");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", busId: ");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", parentFolder: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", uuid: ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", fileMD5: ");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(", destUin: ");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append(", fileSize: ");
    localStringBuilder.append(this.jdField_d_of_type_Long);
    localStringBuilder.append(", fileName: ");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(", url: ");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append(", cookie: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", matchId: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", isPay: ");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(", mediaFormat: ");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.data.ChooseFileInfo
 * JD-Core Version:    0.7.0.1
 */