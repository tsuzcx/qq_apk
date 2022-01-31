package com.tencent.biz.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import neb;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.NegFeedback;

public class VideoAdInfo$NegFeedback
  implements Parcelable
{
  public static final Parcelable.Creator<NegFeedback> CREATOR = new neb();
  public long a;
  public String a;
  
  public VideoAdInfo$NegFeedback() {}
  
  public VideoAdInfo$NegFeedback(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
  }
  
  public VideoAdInfo$NegFeedback(oidb_0x6cf.NegFeedback paramNegFeedback)
  {
    this.jdField_a_of_type_Long = paramNegFeedback.uint64_type_id.get();
    this.jdField_a_of_type_JavaLangString = paramNegFeedback.bytes_type_desc.get().toStringUtf8();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoAdInfo.NegFeedback
 * JD-Core Version:    0.7.0.1
 */