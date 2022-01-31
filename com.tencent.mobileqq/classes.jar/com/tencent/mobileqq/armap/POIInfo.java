package com.tencent.mobileqq.armap;

import aavz;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.armap.utils.MapLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.HashMap;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.PoiInfo;

public class POIInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new aavz();
  public double a;
  public int a;
  public long a;
  public String a;
  public ArrayList a;
  public HashMap a;
  public double b;
  public int b;
  public long b;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public POIInfo()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public POIInfo(long paramLong, double paramDouble1, double paramDouble2)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Double = paramDouble1;
    this.jdField_b_of_type_Double = paramDouble2;
  }
  
  public POIInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Double = paramParcel.readDouble();
    this.jdField_b_of_type_Double = paramParcel.readDouble();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
  }
  
  public static POIInfo a(oidb_0x7bb.PoiInfo paramPoiInfo)
  {
    long l2 = 0L;
    int j = 0;
    double d2 = 0.0D;
    if (paramPoiInfo == null) {
      return new POIInfo();
    }
    POIInfo localPOIInfo = new POIInfo();
    long l1;
    double d1;
    label74:
    int i;
    if (paramPoiInfo.poi_id.has())
    {
      l1 = paramPoiInfo.poi_id.get();
      localPOIInfo.jdField_a_of_type_Long = l1;
      if (!paramPoiInfo.lat.has()) {
        break label347;
      }
      d1 = paramPoiInfo.lat.get();
      localPOIInfo.jdField_b_of_type_Double = d1;
      d1 = d2;
      if (paramPoiInfo.lng.has()) {
        d1 = paramPoiInfo.lng.get();
      }
      localPOIInfo.jdField_a_of_type_Double = d1;
      if (!paramPoiInfo.name.has()) {
        break label352;
      }
      str = paramPoiInfo.name.get().toStringUtf8();
      label129:
      localPOIInfo.jdField_a_of_type_JavaLangString = str;
      if (!paramPoiInfo.addr.has()) {
        break label359;
      }
      str = paramPoiInfo.addr.get().toStringUtf8();
      label158:
      localPOIInfo.jdField_b_of_type_JavaLangString = str;
      l1 = l2;
      if (paramPoiInfo.adcode.has()) {
        l1 = paramPoiInfo.adcode.get();
      }
      localPOIInfo.jdField_b_of_type_Long = l1;
      if (!paramPoiInfo.type.has()) {
        break label366;
      }
      i = paramPoiInfo.type.get();
      label214:
      localPOIInfo.jdField_a_of_type_Int = i;
      if (!paramPoiInfo.icon.has()) {
        break label372;
      }
      str = paramPoiInfo.icon.get().toStringUtf8();
      label243:
      localPOIInfo.c = str;
      if (!paramPoiInfo.banner.has()) {
        break label379;
      }
      str = paramPoiInfo.banner.get().toStringUtf8();
      label272:
      localPOIInfo.d = str;
      if (!paramPoiInfo.photo.has()) {
        break label386;
      }
    }
    label386:
    for (String str = paramPoiInfo.photo.get().toStringUtf8();; str = "")
    {
      localPOIInfo.e = str;
      i = j;
      if (paramPoiInfo.appid.has()) {
        i = paramPoiInfo.appid.get();
      }
      localPOIInfo.jdField_b_of_type_Int = i;
      return localPOIInfo;
      l1 = 0L;
      break;
      label347:
      d1 = 0.0D;
      break label74;
      label352:
      str = "";
      break label129;
      label359:
      str = "";
      break label158;
      label366:
      i = 0;
      break label214;
      label372:
      str = "";
      break label243;
      label379:
      str = "";
      break label272;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("poiId:").append(MapLog.toUnsignedLongValue(this.jdField_a_of_type_Long)).append(", longitude: ").append(this.jdField_a_of_type_Double).append(", latitude: ").append(this.jdField_b_of_type_Double).append(", name: ").append(this.jdField_a_of_type_JavaLangString).append(", address: ").append(this.jdField_b_of_type_JavaLangString).append(", adcode: ").append(this.jdField_b_of_type_Long).append(", poiType: ").append(this.jdField_a_of_type_Int).append(", iconUrl: ").append(this.c).append(", bannerUrl: ").append(this.d).append(", photoUrl: ").append(this.e).append(", appid: ").append(this.jdField_b_of_type_Int).append(", taskStatus: ").append(this.jdField_a_of_type_JavaUtilHashMap.toString()).append(", mTasks: ").append(this.jdField_a_of_type_JavaUtilArrayList);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeDouble(this.jdField_a_of_type_Double);
    paramParcel.writeDouble(this.jdField_b_of_type_Double);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.POIInfo
 * JD-Core Version:    0.7.0.1
 */