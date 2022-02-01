package com.tencent.mobileqq.armap;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aozy;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;

public class POIInfo
  implements Parcelable
{
  public static final Parcelable.Creator<POIInfo> CREATOR = new aozy();
  public double a;
  public int a;
  public long a;
  public String a;
  public ArrayList<Object> a;
  public HashMap<Long, Integer> a;
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
  
  public static BigInteger a(long paramLong)
  {
    if (!a(paramLong)) {
      return BigInteger.valueOf(paramLong);
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.order(ByteOrder.BIG_ENDIAN);
    localByteBuffer.putLong(paramLong);
    return new BigInteger(1, localByteBuffer.array());
  }
  
  public static boolean a(long paramLong)
  {
    return (paramLong & 0x0) == -9223372036854775808L;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("poiId:").append(a(this.jdField_a_of_type_Long)).append(", longitude: ").append(this.jdField_a_of_type_Double).append(", latitude: ").append(this.jdField_b_of_type_Double).append(", name: ").append(this.jdField_a_of_type_JavaLangString).append(", address: ").append(this.jdField_b_of_type_JavaLangString).append(", adcode: ").append(this.jdField_b_of_type_Long).append(", poiType: ").append(this.jdField_a_of_type_Int).append(", iconUrl: ").append(this.c).append(", bannerUrl: ").append(this.d).append(", photoUrl: ").append(this.e).append(", appid: ").append(this.jdField_b_of_type_Int).append(", taskStatus: ").append(this.jdField_a_of_type_JavaUtilHashMap.toString()).append(", mTasks: ").append(this.jdField_a_of_type_JavaUtilArrayList);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.POIInfo
 * JD-Core Version:    0.7.0.1
 */