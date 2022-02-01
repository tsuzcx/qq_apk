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
import myn;
import trpc.qq_av_together.common.WTogetherCommon.DirectUrlInfo;
import trpc.qq_av_together.common.WTogetherCommon.ForwardReq;
import trpc.qq_av_together.common.WTogetherCommon.VideoInfoReq;

public class ChooseFileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ChooseFileInfo> CREATOR = new myn();
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public long d;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public ChooseFileInfo(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public ChooseFileInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.jdField_d_of_type_Long = paramParcel.readLong();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.jdField_c_of_type_Int = paramParcel.readInt();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return 1;
    }
    if (this.jdField_a_of_type_Int == 1) {
      return 2;
    }
    if (this.jdField_a_of_type_Int == 4) {
      return 3;
    }
    return 3;
  }
  
  public String a()
  {
    String str = "";
    if (this.jdField_a_of_type_Int == 0) {
      str = this.jdField_d_of_type_JavaLangString;
    }
    do
    {
      return str;
      if (this.jdField_a_of_type_Int == 1) {
        return this.jdField_d_of_type_JavaLangString;
      }
    } while (this.jdField_a_of_type_Int != 4);
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public WTogetherCommon.VideoInfoReq a()
  {
    WTogetherCommon.VideoInfoReq localVideoInfoReq = new WTogetherCommon.VideoInfoReq();
    Object localObject;
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1))
    {
      localObject = new WTogetherCommon.ForwardReq();
      ((WTogetherCommon.ForwardReq)localObject).src_uin.set(this.jdField_a_of_type_Long);
      ((WTogetherCommon.ForwardReq)localObject).src_group.set(this.jdField_b_of_type_Long);
      ((WTogetherCommon.ForwardReq)localObject).src_svcid.set(this.jdField_b_of_type_Int);
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
    if (this.jdField_a_of_type_Int == 2)
    {
      localObject = new WTogetherCommon.DirectUrlInfo();
      if (this.jdField_d_of_type_JavaLangString != null) {
        ((WTogetherCommon.DirectUrlInfo)localObject).file_name.set(this.jdField_d_of_type_JavaLangString);
      }
      if (this.e != null) {
        ((WTogetherCommon.DirectUrlInfo)localObject).url.set(this.e);
      }
      if (this.f != null) {
        ((WTogetherCommon.DirectUrlInfo)localObject).cookie.set(this.f);
      }
      ((WTogetherCommon.DirectUrlInfo)localObject).media_format.set(this.jdField_c_of_type_Int);
      localVideoInfoReq.video_src_type.set(1);
      localVideoInfoReq.direct_url_info.set((MessageMicro)localObject);
      return localVideoInfoReq;
    }
    localVideoInfoReq.video_src_type.set(2);
    localVideoInfoReq.online_resource_id.set(this.g);
    return localVideoInfoReq;
  }
  
  public String b()
  {
    String str = "";
    if (this.jdField_a_of_type_Int == 0) {
      str = this.jdField_b_of_type_JavaLangString;
    }
    do
    {
      return str;
      if (this.jdField_a_of_type_Int == 1) {
        return this.jdField_b_of_type_JavaLangString;
      }
    } while (this.jdField_a_of_type_Int != 4);
    return this.g;
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
      do
      {
        do
        {
          do
          {
            do
            {
              return true;
              if (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) {
                break label237;
              }
              if ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != 1)) {
                break;
              }
            } while ((TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString)) && (TextUtils.equals(this.jdField_d_of_type_JavaLangString, paramObject.jdField_d_of_type_JavaLangString)));
            return false;
            if (this.jdField_a_of_type_Int != 2) {
              break;
            }
          } while ((TextUtils.equals(this.e, paramObject.e)) && (TextUtils.equals(this.f, paramObject.f)) && (TextUtils.equals(this.jdField_d_of_type_JavaLangString, paramObject.jdField_d_of_type_JavaLangString)));
          return false;
          if (this.jdField_a_of_type_Int != 4) {
            break;
          }
        } while ((TextUtils.equals(this.g, paramObject.g)) && (TextUtils.equals(this.jdField_d_of_type_JavaLangString, paramObject.jdField_d_of_type_JavaLangString)));
        return false;
      } while ((TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString)) && (TextUtils.equals(this.jdField_d_of_type_JavaLangString, paramObject.jdField_d_of_type_JavaLangString)) && (TextUtils.equals(this.e, paramObject.e)) && (TextUtils.equals(this.f, paramObject.f)) && (TextUtils.equals(this.g, paramObject.g)));
      return false;
    }
    label237:
    return false;
  }
  
  public String toString()
  {
    return "ChooseFile{type: " + this.jdField_a_of_type_Int + ", srcUin: " + this.jdField_a_of_type_Long + ", srcGroup: " + this.jdField_b_of_type_Long + ", busId: " + this.jdField_b_of_type_Int + ", parentFolder: " + this.jdField_a_of_type_JavaLangString + ", uuid: " + this.jdField_b_of_type_JavaLangString + ", fileMD5: " + this.jdField_c_of_type_JavaLangString + ", destUin: " + this.jdField_c_of_type_Long + ", fileSize: " + this.jdField_d_of_type_Long + ", fileName: " + this.jdField_d_of_type_JavaLangString + ", url: " + this.e + ", matchId:" + this.g + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.wtogether.data.ChooseFileInfo
 * JD-Core Version:    0.7.0.1
 */