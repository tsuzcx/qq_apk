package com.tencent.biz.qqstory.takevideo.publish;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import zfd;

public class PublishParam
  implements Parcelable
{
  public static final Parcelable.Creator<PublishParam> CREATOR = new zfd();
  public static final String a;
  public final int a;
  public final long a;
  public final int b;
  public final String b;
  public final int c;
  public final String c;
  public final int d;
  public final String d;
  public final int e;
  public final String e;
  public final int f;
  public final String f;
  public final int g;
  public final String g;
  public final int h;
  public final String h;
  public final int i;
  public final String i;
  public final int j;
  public final String j;
  public final int k;
  public final String k;
  public final int l;
  public final String l;
  public final int m;
  public final String m;
  public int n;
  
  static
  {
    jdField_a_of_type_JavaLangString = PublishParam.class.getName();
  }
  
  public PublishParam(Parcel paramParcel)
  {
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.jdField_g_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.jdField_g_of_type_Int = paramParcel.readInt();
    this.jdField_h_of_type_JavaLangString = paramParcel.readString();
    this.jdField_i_of_type_JavaLangString = paramParcel.readString();
    this.jdField_h_of_type_Int = paramParcel.readInt();
    this.jdField_i_of_type_Int = paramParcel.readInt();
    this.jdField_j_of_type_Int = paramParcel.readInt();
    this.jdField_j_of_type_JavaLangString = paramParcel.readString();
    this.jdField_k_of_type_JavaLangString = paramParcel.readString();
    this.jdField_l_of_type_JavaLangString = paramParcel.readString();
    this.jdField_m_of_type_JavaLangString = paramParcel.readString();
    this.jdField_k_of_type_Int = paramParcel.readInt();
    this.jdField_l_of_type_Int = paramParcel.readInt();
    this.jdField_m_of_type_Int = paramParcel.readInt();
    this.n = paramParcel.readInt();
    paramParcel = a();
    if (paramParcel != null) {
      throw new RuntimeException(paramParcel);
    }
  }
  
  public PublishParam(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString7, String paramString8, int paramInt8, int paramInt9, int paramInt10, String paramString9, String paramString10, String paramString11, String paramString12, int paramInt11, boolean paramBoolean, int paramInt12, int paramInt13)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_d_of_type_JavaLangString = paramString3;
    this.jdField_e_of_type_JavaLangString = paramString4;
    this.jdField_f_of_type_JavaLangString = paramString5;
    this.jdField_g_of_type_JavaLangString = paramString6;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_d_of_type_Int = paramInt4;
    this.jdField_e_of_type_Int = paramInt5;
    this.jdField_f_of_type_Int = paramInt6;
    this.jdField_g_of_type_Int = paramInt7;
    this.jdField_h_of_type_JavaLangString = paramString7;
    this.jdField_i_of_type_JavaLangString = paramString8;
    this.jdField_h_of_type_Int = paramInt8;
    this.jdField_i_of_type_Int = paramInt9;
    this.jdField_j_of_type_Int = paramInt10;
    this.jdField_j_of_type_JavaLangString = paramString9;
    this.jdField_k_of_type_JavaLangString = paramString10;
    this.jdField_l_of_type_JavaLangString = paramString11;
    this.jdField_m_of_type_JavaLangString = paramString12;
    this.jdField_k_of_type_Int = paramInt11;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      this.jdField_l_of_type_Int = paramInt1;
      this.jdField_m_of_type_Int = paramInt12;
      this.n = paramInt13;
      paramString1 = a();
      if (paramString1 == null) {
        break;
      }
      throw new RuntimeException(paramString1);
    }
  }
  
  protected String a()
  {
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
      return "both fakeVid and thumbPath should not be empty";
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "PublishParam{fakeVid='" + this.jdField_b_of_type_JavaLangString + '\'' + ", thumbPath='" + this.jdField_c_of_type_JavaLangString + '\'' + ", doodlePath='" + this.jdField_d_of_type_JavaLangString + '\'' + ", videoLabel='" + this.jdField_e_of_type_JavaLangString + '\'' + ", videoDoodleDescription='" + this.jdField_f_of_type_JavaLangString + '\'' + ", videoAddress='" + this.jdField_g_of_type_JavaLangString + '\'' + ", videoWidth=" + this.jdField_a_of_type_Int + ", videoHeight=" + this.jdField_b_of_type_Int + ", videoDuration=" + this.jdField_a_of_type_Long + ", videoMaxrate=" + this.jdField_c_of_type_Int + ", videoMinrate=" + this.jdField_d_of_type_Int + ", isEdited=" + this.jdField_e_of_type_Int + ", saveMode=" + this.jdField_f_of_type_Int + ", recordFrames=" + this.jdField_g_of_type_Int + ", atDoodlePath='" + this.jdField_h_of_type_JavaLangString + '\'' + ", atJsonData='" + this.jdField_i_of_type_JavaLangString + '\'' + ", needSyncToStory='" + this.jdField_i_of_type_Int + '\'' + ", hwEncodeRecordVideo='" + this.jdField_j_of_type_Int + '\'' + ", videoFilePath='" + this.jdField_j_of_type_JavaLangString + '\'' + ", audioFilePath='" + this.jdField_k_of_type_JavaLangString + '\'' + ", mosaicFilePath='" + this.jdField_m_of_type_JavaLangString + '\'' + ", videoCount=" + this.jdField_k_of_type_Int + "', redBagType=" + this.jdField_m_of_type_Int + "', specialVideoType=" + this.n + "'" + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
    paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_i_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_h_of_type_Int);
    paramParcel.writeInt(this.jdField_i_of_type_Int);
    paramParcel.writeInt(this.jdField_j_of_type_Int);
    paramParcel.writeString(this.jdField_j_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_k_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_l_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_m_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_k_of_type_Int);
    paramParcel.writeInt(this.jdField_l_of_type_Int);
    paramParcel.writeInt(this.jdField_m_of_type_Int);
    paramParcel.writeInt(this.n);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.publish.PublishParam
 * JD-Core Version:    0.7.0.1
 */