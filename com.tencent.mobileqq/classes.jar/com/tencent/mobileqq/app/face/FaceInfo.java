package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import aopd;
import axxb;
import com.tencent.qphone.base.util.QLog;

public class FaceInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FaceInfo> CREATOR = new aopd();
  public static int f;
  public static int g = 1;
  public static int h = 2;
  public static int i = 3;
  public static int j;
  public static int k = j + 1;
  public static int l = k + 1;
  public static int m = l + 1;
  public static int n = m + 1;
  public static int o = n + 1;
  public static int p = o + 1;
  public static int q = p + 1;
  public static int r = q + 1;
  public static int s = r + 1;
  public byte a;
  public int a;
  public long a;
  public QQHeadInfo a;
  public String a;
  public boolean a;
  public long[] a;
  public byte b;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public int e;
  private String e;
  
  public FaceInfo()
  {
    if (this.jdField_a_of_type_ArrayOfLong == null) {
      this.jdField_a_of_type_ArrayOfLong = new long[s];
    }
    int i1 = 0;
    while (i1 < s)
    {
      this.jdField_a_of_type_ArrayOfLong[i1] = 0L;
      i1 += 1;
    }
  }
  
  public FaceInfo(int paramInt1, String paramString, boolean paramBoolean1, byte paramByte, int paramInt2, boolean paramBoolean2, int paramInt3)
  {
    a(paramInt1, paramString, paramBoolean1, paramByte, paramInt2, paramBoolean2, paramInt3, 0, false, 100);
  }
  
  public FaceInfo(int paramInt1, String paramString, boolean paramBoolean1, byte paramByte, int paramInt2, boolean paramBoolean2, int paramInt3, boolean paramBoolean3, int paramInt4)
  {
    a(paramInt1, paramString, paramBoolean1, paramByte, paramInt2, paramBoolean2, paramInt3, 0, paramBoolean3, paramInt4);
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return "TIME_BEGINE";
    case 1: 
      return "TIME_REQ_READY";
    case 2: 
      return "TIME_BEGIN_DOWNLOADINFO";
    case 3: 
      return "TIME_END_DOWNLOADINFO";
    case 4: 
      return "TIME_BEGIN_DOWNLOAD";
    case 5: 
      return "TIME_END_DOWNLOAD";
    case 6: 
      return "TIME_BEGIN_DECODE";
    case 7: 
      return "TIME_END_DECODE";
    }
    return "TIME_REQ_END";
  }
  
  public static String a(int paramInt1, String paramString, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    if (paramInt1 == 32) {
      localStringBuilder.append(paramInt1).append("_").append(paramInt2).append("_").append(paramString);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (paramInt1 == 16) {
        localStringBuilder.append(paramInt1).append("_").append(paramInt2).append("_").append(paramString);
      } else {
        localStringBuilder.append(paramInt1).append("_").append(paramString);
      }
    }
  }
  
  public static String a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder(16);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localStringBuilder.append(paramString);
      if (paramInt3 > 0) {
        localStringBuilder.append("_").append(paramInt3);
      }
      return localStringBuilder.toString();
      localStringBuilder.append("dis_g_");
      continue;
      localStringBuilder.append("troop_");
      continue;
      localStringBuilder.append("sub_");
      continue;
      localStringBuilder.append("stranger_").append(Integer.toString(paramInt2)).append("_");
      continue;
      localStringBuilder.append("qcall_").append(Integer.toString(paramInt2)).append("_");
    }
  }
  
  public static String a(QQHeadInfo paramQQHeadInfo, int paramInt)
  {
    String str2 = "";
    String str1 = str2;
    if (paramQQHeadInfo != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(paramQQHeadInfo.downLoadUrl)) {
        str1 = paramQQHeadInfo.downLoadUrl + "_" + paramInt;
      }
    }
    return str1;
  }
  
  public byte a()
  {
    switch (this.jdField_a_of_type_Byte)
    {
    default: 
      return 1;
    }
    return 0;
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      this.jdField_c_of_type_JavaLangString = a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    long l2 = 0L;
    if (this.jdField_a_of_type_ArrayOfLong == null) {}
    do
    {
      do
      {
        return;
      } while ((paramInt1 < 0) || (paramInt1 >= s));
      this.jdField_a_of_type_ArrayOfLong[paramInt1] = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        axxb.a(FaceInfo.class.getSimpleName(), "markTime", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(this.jdField_a_of_type_ArrayOfLong[paramInt1]), this });
      }
    } while ((paramInt1 != r) || (!QLog.isColorLevel()));
    StringBuilder localStringBuilder = new StringBuilder(260);
    localStringBuilder.append("id=").append(this.jdField_a_of_type_JavaLangString).append(",").append("idType=").append(this.jdField_b_of_type_Int).append(",").append("headType=").append(this.jdField_a_of_type_Int).append(",").append("shape=").append(this.jdField_c_of_type_Int).append(" ,Times={");
    long l1 = 0L;
    paramInt1 = i1;
    if (paramInt1 < this.jdField_a_of_type_ArrayOfLong.length)
    {
      localStringBuilder.append("[").append(a(paramInt1)).append(",");
      localStringBuilder.append(this.jdField_a_of_type_ArrayOfLong[paramInt1]).append(",");
      if (this.jdField_a_of_type_ArrayOfLong[paramInt1] > 0L) {
        localStringBuilder.append(Math.abs(l1 - this.jdField_a_of_type_ArrayOfLong[paramInt1])).append("]");
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ArrayOfLong[paramInt1] > 0L) {
          l1 = this.jdField_a_of_type_ArrayOfLong[paramInt1];
        }
        paramInt1 += 1;
        break;
        localStringBuilder.append("0").append("]");
      }
    }
    l1 = l2;
    if (this.jdField_a_of_type_ArrayOfLong[r] > 0L)
    {
      l1 = l2;
      if (this.jdField_a_of_type_ArrayOfLong[j] > 0L) {
        l1 = Math.abs(this.jdField_a_of_type_ArrayOfLong[r] - this.jdField_a_of_type_ArrayOfLong[j]);
      }
    }
    localStringBuilder.append("}, cost = ").append(l1).append(", result = ").append(paramInt2);
    QLog.i("FaceCost", 2, localStringBuilder.toString());
  }
  
  public void a(int paramInt1, String paramString, boolean paramBoolean1, byte paramByte, int paramInt2, boolean paramBoolean2, int paramInt3, int paramInt4, boolean paramBoolean3, int paramInt5)
  {
    this.jdField_a_of_type_Boolean = paramBoolean3;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Byte = paramByte;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_c_of_type_Boolean = paramBoolean2;
    this.jdField_b_of_type_Int = paramInt3;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_e_of_type_Int = paramInt4;
    this.jdField_d_of_type_Int = paramInt5;
    if (this.jdField_a_of_type_ArrayOfLong == null) {
      this.jdField_a_of_type_ArrayOfLong = new long[s];
    }
    paramInt1 = 0;
    while (paramInt1 < s)
    {
      this.jdField_a_of_type_ArrayOfLong[paramInt1] = 0L;
      paramInt1 += 1;
    }
  }
  
  public void a(Parcel paramParcel)
  {
    boolean bool = true;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Byte = paramParcel.readByte();
    if (paramParcel.readByte() == 1) {}
    for (;;)
    {
      this.jdField_c_of_type_Boolean = bool;
      this.jdField_d_of_type_JavaLangString = paramParcel.readString();
      this.jdField_a_of_type_Long = paramParcel.readLong();
      this.jdField_a_of_type_AvatarInfoQQHeadInfo = ((QQHeadInfo)paramParcel.readParcelable(getClass().getClassLoader()));
      return;
      bool = false;
    }
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ArrayOfLong == null) {}
    do
    {
      do
      {
        return false;
      } while ((paramInt < 0) || (paramInt >= s));
      if (this.jdField_a_of_type_ArrayOfLong[paramInt] != 0L) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    axxb.a(FaceInfo.class.getSimpleName(), "isTimeOut", new Object[] { Integer.valueOf(paramInt) });
    return false;
    if (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_ArrayOfLong[paramInt]) >= paramLong) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public String b()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int);
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String c()
  {
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      this.jdField_e_of_type_JavaLangString = a(this.jdField_a_of_type_AvatarInfoQQHeadInfo, this.jdField_b_of_type_Int);
    }
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (FaceInfo)paramObject;
    return (this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && (this.jdField_b_of_type_Int == paramObject.jdField_b_of_type_Int) && (this.jdField_c_of_type_Int == paramObject.jdField_c_of_type_Int);
  }
  
  public int hashCode()
  {
    int i2 = this.jdField_a_of_type_Int;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    for (int i1 = 0;; i1 = this.jdField_a_of_type_JavaLangString.hashCode()) {
      return i1 | i2;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("[").append(this.jdField_a_of_type_Int).append(",").append(this.jdField_b_of_type_Int).append(",").append(this.jdField_a_of_type_JavaLangString).append(",").append(this.jdField_c_of_type_Int).append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeByte(this.jdField_a_of_type_Byte);
    if (this.jdField_c_of_type_Boolean) {}
    for (byte b1 = 1;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      paramParcel.writeParcelable(this.jdField_a_of_type_AvatarInfoQQHeadInfo, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceInfo
 * JD-Core Version:    0.7.0.1
 */