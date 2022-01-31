package com.tencent.mobileqq.armap.wealthgod;

import abbz;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x84c.oidb_0x84c.CAdcodeInfo;

public class WealthGodInfo
  implements Parcelable, Comparable
{
  public static final Parcelable.Creator CREATOR = new abbz();
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public long c;
  public String c;
  public long d;
  public String d;
  public String e;
  
  public WealthGodInfo() {}
  
  public WealthGodInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.jdField_d_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.e = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public WealthGodInfo(oidb_0x84c.CAdcodeInfo paramCAdcodeInfo, int paramInt1, int paramInt2)
  {
    long l1;
    label51:
    label80:
    String str;
    if (paramCAdcodeInfo.adcode.has())
    {
      l1 = paramCAdcodeInfo.adcode.get();
      this.jdField_a_of_type_Long = l1;
      if (!paramCAdcodeInfo.redpack_num.has()) {
        break label248;
      }
      l1 = paramCAdcodeInfo.redpack_num.get();
      this.jdField_b_of_type_Long = l1;
      if (!paramCAdcodeInfo.begtime.has()) {
        break label254;
      }
      l1 = paramCAdcodeInfo.begtime.get() * 1000L;
      this.jdField_c_of_type_Long = l1;
      l1 = l2;
      if (paramCAdcodeInfo.endtime.has()) {
        l1 = paramCAdcodeInfo.endtime.get() * 1000L;
      }
      this.jdField_d_of_type_Long = l1;
      if (!paramCAdcodeInfo.cityname.has()) {
        break label260;
      }
      str = paramCAdcodeInfo.cityname.get().toStringUtf8();
      label141:
      this.jdField_a_of_type_JavaLangString = str;
      if (!paramCAdcodeInfo.adname.has()) {
        break label267;
      }
      str = paramCAdcodeInfo.adname.get().toStringUtf8();
      label169:
      this.jdField_b_of_type_JavaLangString = str;
      if (!paramCAdcodeInfo.icon.has()) {
        break label274;
      }
      str = paramCAdcodeInfo.icon.get().toStringUtf8();
      label197:
      this.jdField_c_of_type_JavaLangString = str;
      if (!paramCAdcodeInfo.merchant_name.has()) {
        break label281;
      }
    }
    label260:
    label267:
    label274:
    label281:
    for (paramCAdcodeInfo = paramCAdcodeInfo.merchant_name.get().toStringUtf8();; paramCAdcodeInfo = "")
    {
      this.jdField_d_of_type_JavaLangString = paramCAdcodeInfo;
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      return;
      l1 = -1L;
      break;
      label248:
      l1 = 0L;
      break label51;
      label254:
      l1 = 0L;
      break label80;
      str = "";
      break label141;
      str = "";
      break label169;
      str = "";
      break label197;
    }
  }
  
  public int a()
  {
    long l = MessageCache.a() * 1000L;
    if (l > this.jdField_d_of_type_Long) {
      return 0;
    }
    if ((l > this.jdField_c_of_type_Long) && (l < this.jdField_d_of_type_Long)) {
      return 2;
    }
    return 1;
  }
  
  public int a(WealthGodInfo paramWealthGodInfo)
  {
    int i = a();
    int j = paramWealthGodInfo.a();
    if (i == j)
    {
      if (i == 0) {
        return (int)(this.jdField_d_of_type_Long - paramWealthGodInfo.jdField_d_of_type_Long);
      }
      if (i == 2) {
        return (int)(this.jdField_d_of_type_Long - paramWealthGodInfo.jdField_d_of_type_Long);
      }
      return (int)(paramWealthGodInfo.jdField_c_of_type_Long - this.jdField_c_of_type_Long);
    }
    return i - j;
  }
  
  public String a()
  {
    String str = this.jdField_a_of_type_Long + "_" + this.jdField_c_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("WealthGodInfo", 2, "getShownKey,result =  " + str);
    }
    return str;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("adcode:").append(this.jdField_a_of_type_Long).append(", redpactCount:").append(this.jdField_b_of_type_Long).append(", beginTime:").append(this.jdField_c_of_type_Long).append(", endTime:").append(this.jdField_d_of_type_Long).append(", cityName:").append(this.jdField_a_of_type_JavaLangString).append(", adName:").append(this.jdField_b_of_type_JavaLangString).append(", iconUrl:").append(this.jdField_c_of_type_JavaLangString).append(", busiName:").append(this.jdField_d_of_type_JavaLangString).append(", enterMapFlag:").append(this.jdField_a_of_type_Int).append(", countDownTime:").append(this.jdField_b_of_type_Int).append(", displayCloudWhenCount0:").append(this.jdField_a_of_type_Boolean);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.e);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.wealthgod.WealthGodInfo
 * JD-Core Version:    0.7.0.1
 */