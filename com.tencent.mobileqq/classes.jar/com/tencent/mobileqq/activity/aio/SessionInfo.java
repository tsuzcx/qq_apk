package com.tencent.mobileqq.activity.aio;

import aggu;
import agkn;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SessionInfo
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<SessionInfo> CREATOR = new agkn();
  public int a;
  public long a;
  public aggu a;
  private Bundle a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c = 0;
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
  public boolean f;
  public int g;
  public String g = "";
  public boolean g;
  public String h;
  public boolean h;
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
    this.jdField_d_of_type_Int = 3999;
  }
  
  public SessionInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_d_of_type_Int = 3999;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.e = paramParcel.readString();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.k = paramParcel.readString();
    this.j = paramParcel.readString();
    this.jdField_a_of_type_AndroidOsBundle = paramParcel.readBundle(getClass().getClassLoader());
  }
  
  public SessionInfo(SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_d_of_type_Int = 3999;
    this.jdField_a_of_type_Int = paramSessionInfo.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
    this.b = paramSessionInfo.b;
    this.jdField_d_of_type_JavaLangString = paramSessionInfo.jdField_d_of_type_JavaLangString;
    this.e = paramSessionInfo.e;
    this.jdField_d_of_type_Int = paramSessionInfo.jdField_d_of_type_Int;
    this.k = paramSessionInfo.k;
    this.j = paramSessionInfo.j;
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
    return this.k;
  }
  
  public void a()
  {
    this.l = false;
    this.i = null;
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(String paramString)
  {
    this.k = paramString;
  }
  
  public String b()
  {
    return this.j;
  }
  
  public void b(String paramString)
  {
    this.j = paramString;
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
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.j);
    paramParcel.writeBundle(this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.SessionInfo
 * JD-Core Version:    0.7.0.1
 */