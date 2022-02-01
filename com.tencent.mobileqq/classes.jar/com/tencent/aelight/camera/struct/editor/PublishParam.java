package com.tencent.aelight.camera.struct.editor;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public class PublishParam
  implements Parcelable
{
  public static final Parcelable.Creator<PublishParam> CREATOR = new PublishParam.1();
  public static final String a = "com.tencent.aelight.camera.struct.editor.PublishParam";
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
  public final String n;
  
  protected PublishParam(Parcel paramParcel)
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
    this.jdField_j_of_type_JavaLangString = paramParcel.readString();
    this.jdField_k_of_type_JavaLangString = paramParcel.readString();
    this.jdField_l_of_type_JavaLangString = paramParcel.readString();
    this.jdField_m_of_type_JavaLangString = paramParcel.readString();
    this.jdField_j_of_type_Int = paramParcel.readInt();
    this.jdField_k_of_type_Int = paramParcel.readInt();
    this.n = paramParcel.readString();
    this.jdField_l_of_type_Int = paramParcel.readInt();
    this.jdField_m_of_type_Int = paramParcel.readInt();
    paramParcel = a();
    if (paramParcel == null) {
      return;
    }
    throw new RuntimeException(paramParcel);
  }
  
  public PublishParam(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString7, String paramString8, int paramInt8, int paramInt9, String paramString9, String paramString10, String paramString11, String paramString12, int paramInt10, boolean paramBoolean, String paramString13, int paramInt11, int paramInt12) {}
  
  protected String a()
  {
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
      return null;
    }
    return "both fakeVid and thumbPath should not be empty";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PublishParam{fakeVid='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", thumbPath='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", doodlePath='");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoLabel='");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoDoodleDescription='");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoAddress='");
    localStringBuilder.append(this.jdField_g_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoWidth=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", videoHeight=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", videoDuration=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", videoMaxrate=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", videoMinrate=");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(", isEdited=");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append(", saveMode=");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append(", recordFrames=");
    localStringBuilder.append(this.jdField_g_of_type_Int);
    localStringBuilder.append(", atDoodlePath='");
    localStringBuilder.append(this.jdField_h_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", atJsonData='");
    localStringBuilder.append(this.jdField_i_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", hwEncodeRecordVideo='");
    localStringBuilder.append(this.jdField_i_of_type_Int);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoFilePath='");
    localStringBuilder.append(this.jdField_j_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", audioFilePath='");
    localStringBuilder.append(this.jdField_k_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mosaicFilePath='");
    localStringBuilder.append(this.jdField_m_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoCount=");
    localStringBuilder.append(this.jdField_j_of_type_Int);
    localStringBuilder.append("', videoLocateDescription='");
    localStringBuilder.append(this.n);
    localStringBuilder.append('\'');
    localStringBuilder.append(", localVideoLongitude='");
    localStringBuilder.append(this.jdField_l_of_type_Int);
    localStringBuilder.append('\'');
    localStringBuilder.append(", localVideoLatitude=");
    localStringBuilder.append(this.jdField_m_of_type_Int);
    localStringBuilder.append("'");
    localStringBuilder.append('}');
    return localStringBuilder.toString();
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
    paramParcel.writeString(this.jdField_j_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_k_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_l_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_m_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_j_of_type_Int);
    paramParcel.writeInt(this.jdField_k_of_type_Int);
    paramParcel.writeString(this.n);
    paramParcel.writeInt(this.jdField_l_of_type_Int);
    paramParcel.writeInt(this.jdField_m_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.struct.editor.PublishParam
 * JD-Core Version:    0.7.0.1
 */