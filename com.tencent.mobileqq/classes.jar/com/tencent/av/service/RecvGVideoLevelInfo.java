package com.tencent.av.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class RecvGVideoLevelInfo
  implements Parcelable, Cloneable, Comparable<RecvGVideoLevelInfo>
{
  public static final Parcelable.Creator<RecvGVideoLevelInfo> CREATOR = new RecvGVideoLevelInfo.1();
  public int a;
  public long a;
  public String a;
  public List<RecvGVideoLevelInfo.Medal> a;
  public int b;
  public long b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  
  public RecvGVideoLevelInfo(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString, List<RecvGVideoLevelInfo.Medal> paramList)
  {
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
    this.g = paramInt7;
    this.h = paramInt8;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public RecvGVideoLevelInfo(Parcel paramParcel)
  {
    this.jdField_b_of_type_Long = 0L;
    a(paramParcel);
  }
  
  public int a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return 0;
      }
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (RecvGVideoLevelInfo.Medal)this.jdField_a_of_type_JavaUtilList.get(i);
        if (((RecvGVideoLevelInfo.Medal)localObject).c == 1) {
          return ((RecvGVideoLevelInfo.Medal)localObject).jdField_b_of_type_Int;
        }
        i += 1;
      }
    }
    return 0;
  }
  
  public int a(RecvGVideoLevelInfo paramRecvGVideoLevelInfo)
  {
    int i = a();
    int j = paramRecvGVideoLevelInfo.a();
    if (i != j) {
      return i - j;
    }
    i = this.h;
    j = paramRecvGVideoLevelInfo.h;
    if (i != j) {
      return i - j;
    }
    return 0;
  }
  
  public void a(Parcel paramParcel)
  {
    try
    {
      this.jdField_a_of_type_Long = paramParcel.readLong();
      this.jdField_a_of_type_Int = paramParcel.readInt();
      this.jdField_b_of_type_Int = paramParcel.readInt();
      this.c = paramParcel.readInt();
      this.d = paramParcel.readInt();
      this.e = paramParcel.readInt();
      this.f = paramParcel.readInt();
      this.g = paramParcel.readInt();
      this.h = paramParcel.readInt();
      this.jdField_a_of_type_JavaLangString = paramParcel.readString();
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramParcel.readTypedList(this.jdField_a_of_type_JavaUtilList, RecvGVideoLevelInfo.Medal.CREATOR);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecvGVideoLevelInfo", 2, "readFromParcel RuntimeException", paramParcel);
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      paramParcel.writeInt(this.c);
      paramParcel.writeInt(this.d);
      paramParcel.writeInt(this.e);
      paramParcel.writeInt(this.f);
      paramParcel.writeInt(this.g);
      paramParcel.writeInt(this.h);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilList);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecvGVideoLevelInfo", 2, "writeToParcel RuntimeException", paramParcel);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.RecvGVideoLevelInfo
 * JD-Core Version:    0.7.0.1
 */