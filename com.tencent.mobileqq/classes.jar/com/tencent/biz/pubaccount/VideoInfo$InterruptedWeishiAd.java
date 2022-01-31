package com.tencent.biz.pubaccount;

import ajjy;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import java.util.Arrays;
import nem;

public class VideoInfo$InterruptedWeishiAd
  implements Parcelable
{
  public static final Parcelable.Creator<InterruptedWeishiAd> CREATOR = new nem();
  public int a;
  public UrlJumpInfo a;
  public String a;
  public boolean a;
  public int[] a;
  public int b;
  public String b;
  public boolean b;
  public String c;
  public String d;
  public String e;
  
  public VideoInfo$InterruptedWeishiAd()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public VideoInfo$InterruptedWeishiAd(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfInt = paramParcel.createIntArray();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label109;
      }
    }
    label109:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_b_of_type_Boolean = bool1;
      this.jdField_a_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_JavaLangString = paramParcel.readString();
      this.jdField_b_of_type_Int = paramParcel.readInt();
      this.d = paramParcel.readString();
      this.e = paramParcel.readString();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
      return;
      bool1 = false;
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    String str = null;
    StringBuilder localStringBuilder;
    if (this.jdField_b_of_type_Int == 0)
    {
      str = "弹出式web页面";
      localStringBuilder = new StringBuilder().append("InterruptedWeishiAd{showPositon=").append(Arrays.toString(this.jdField_a_of_type_ArrayOfInt)).append(", isShowInSwitch=").append(this.jdField_a_of_type_Boolean).append(", isShowInPlayEnd=").append(this.jdField_b_of_type_Boolean).append(", showAfterPlayTime=").append(this.jdField_a_of_type_Int).append(", adUrl='").append(this.jdField_a_of_type_JavaLangString).append('\'').append(", type=").append(str).append(", downloadBtnText=").append(this.d).append(", openBtnText=").append(this.e).append(", appInfo=");
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {
        break label167;
      }
    }
    label167:
    for (str = "null";; str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.toString())
    {
      return str + '}';
      if (this.jdField_b_of_type_Int != 1) {
        break;
      }
      str = ajjy.a(2131650491);
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    paramParcel.writeIntArray(this.jdField_a_of_type_ArrayOfInt);
    if (this.jdField_a_of_type_Boolean)
    {
      i = 1;
      paramParcel.writeByte((byte)i);
      if (!this.jdField_b_of_type_Boolean) {
        break label97;
      }
    }
    label97:
    for (int i = j;; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      paramParcel.writeString(this.d);
      paramParcel.writeString(this.e);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo, paramInt);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoInfo.InterruptedWeishiAd
 * JD-Core Version:    0.7.0.1
 */