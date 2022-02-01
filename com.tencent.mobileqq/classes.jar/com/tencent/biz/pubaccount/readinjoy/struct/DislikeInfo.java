package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import java.util.ArrayList;
import rcs;
import tencent.im.oidb.articlesummary.articlesummary.DisLikeInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.DisLikeInfo;

public class DislikeInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DislikeInfo> CREATOR = new rcs();
  public int a;
  public long a;
  public String a;
  public byte[] a;
  public String b;
  
  public DislikeInfo() {}
  
  public DislikeInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
  }
  
  public static String a(ArrayList<DislikeInfo> paramArrayList)
  {
    Object localObject2;
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      localObject2 = "";
      return localObject2;
    }
    int j = paramArrayList.size();
    Object localObject1 = "";
    int i = 0;
    for (;;)
    {
      localObject2 = localObject1;
      if (i >= j) {
        break;
      }
      localObject2 = (String)localObject1 + PkgTools.toHexStr(((DislikeInfo)paramArrayList.get(i)).jdField_a_of_type_ArrayOfByte);
      localObject1 = localObject2;
      if (i != j - 1) {
        localObject1 = (String)localObject2 + "_";
      }
      i += 1;
    }
  }
  
  public static ArrayList<DislikeInfo> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.split("_");
    int i = paramString.length;
    ArrayList localArrayList = new ArrayList();
    i = 0;
    for (;;)
    {
      if (i < paramString.length)
      {
        articlesummary.DisLikeInfo localDisLikeInfo = new articlesummary.DisLikeInfo();
        DislikeInfo localDislikeInfo = new DislikeInfo();
        try
        {
          localDisLikeInfo.mergeFrom(PkgTools.hexToBytes(paramString[i]));
          localDislikeInfo.a(localDisLikeInfo);
          localArrayList.add(localDislikeInfo);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a(articlesummary.DisLikeInfo paramDisLikeInfo)
  {
    this.jdField_a_of_type_JavaLangString = paramDisLikeInfo.bytes_dislike_describe.get().toStringUtf8();
    this.jdField_a_of_type_Int = paramDisLikeInfo.type.get();
    this.b = paramDisLikeInfo.bytes_dislike_account_id.get().toStringUtf8();
    this.jdField_a_of_type_Long = paramDisLikeInfo.uint64_dislike_tagid.get();
    this.jdField_a_of_type_ArrayOfByte = paramDisLikeInfo.toByteArray();
  }
  
  public void a(oidb_0x6cf.DisLikeInfo paramDisLikeInfo)
  {
    this.jdField_a_of_type_JavaLangString = paramDisLikeInfo.bytes_dislike_describe.get().toStringUtf8();
    this.jdField_a_of_type_Int = paramDisLikeInfo.type.get();
    this.b = paramDisLikeInfo.bytes_dislike_account_id.get().toStringUtf8();
    this.jdField_a_of_type_Long = paramDisLikeInfo.uint64_dislike_tagid.get();
    this.jdField_a_of_type_ArrayOfByte = paramDisLikeInfo.toByteArray();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "DislikeInfo{type=" + this.jdField_a_of_type_Int + ", tagID=" + this.jdField_a_of_type_Long + ", describe='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo
 * JD-Core Version:    0.7.0.1
 */