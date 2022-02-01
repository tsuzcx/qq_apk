package com.tencent.mobileqq.activity.aio;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SessionInfo
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<SessionInfo> CREATOR = new SessionInfo.1();
  public int a;
  public long a;
  private Bundle a;
  public ChatBackground a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public boolean e;
  public int f;
  public String f;
  public boolean f = false;
  public int g;
  public String g;
  public boolean g;
  public String h;
  public boolean h = false;
  public String i;
  public boolean i;
  private String j;
  public boolean j;
  private String k;
  public boolean k;
  public boolean l;
  public boolean m;
  public boolean n;
  
  public SessionInfo()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 3999;
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_j_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = false;
  }
  
  public SessionInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 3999;
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_j_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_k_of_type_JavaLangString = paramParcel.readString();
    this.jdField_j_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_AndroidOsBundle = paramParcel.readBundle(getClass().getClassLoader());
  }
  
  public SessionInfo(SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 3999;
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_j_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramSessionInfo.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramSessionInfo.jdField_b_of_type_JavaLangString;
    this.jdField_d_of_type_JavaLangString = paramSessionInfo.jdField_d_of_type_JavaLangString;
    this.jdField_e_of_type_JavaLangString = paramSessionInfo.jdField_e_of_type_JavaLangString;
    this.jdField_d_of_type_Int = paramSessionInfo.jdField_d_of_type_Int;
    this.jdField_k_of_type_JavaLangString = paramSessionInfo.jdField_k_of_type_JavaLangString;
    this.jdField_j_of_type_JavaLangString = paramSessionInfo.jdField_j_of_type_JavaLangString;
    if (paramSessionInfo.jdField_a_of_type_AndroidOsBundle != null) {
      this.jdField_a_of_type_AndroidOsBundle = new Bundle(paramSessionInfo.jdField_a_of_type_AndroidOsBundle);
    }
  }
  
  public Bundle a()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public String a()
  {
    return this.jdField_k_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.l = false;
    this.jdField_i_of_type_JavaLangString = null;
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(String paramString)
  {
    this.jdField_k_of_type_JavaLangString = paramString;
  }
  
  public String b()
  {
    return this.jdField_j_of_type_JavaLangString;
  }
  
  public void b(String paramString)
  {
    this.jdField_j_of_type_JavaLangString = paramString;
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeString(this.jdField_k_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_j_of_type_JavaLangString);
    paramParcel.writeBundle(this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.SessionInfo
 * JD-Core Version:    0.7.0.1
 */