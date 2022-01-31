package com.tencent.mobileqq.activity.aio.photo;

import aegd;
import aege;
import aejb;
import agqv;
import agra;
import android.content.Context;
import android.os.Parcel;
import android.text.TextUtils;
import android.view.View;
import aptt;
import apug;
import apvd;
import apvm;
import java.io.File;

public class AIOFileVideoData
  extends AIORichMediaData
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public long c;
  public String c;
  public boolean c;
  public String d;
  public boolean d;
  public String e;
  public boolean e;
  public String f;
  private boolean f;
  public String g;
  private String h;
  
  public AIOFileVideoData() {}
  
  public AIOFileVideoData(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  private void a(Context paramContext, agqv paramagqv)
  {
    paramagqv = new aegd(this, paramContext, paramagqv);
    aptt.a(paramContext, paramContext.getString(2131692673), paramContext.getString(2131692675), paramagqv);
  }
  
  private boolean c()
  {
    if (this.jdField_e_of_type_Boolean) {}
    do
    {
      do
      {
        return false;
      } while (!apug.a());
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_h_of_type_Long > 0L) && (this.jdField_h_of_type_Long > this.jdField_a_of_type_Long)) {
        return true;
      }
    } while (this.jdField_h_of_type_Long <= 1048576L);
    return true;
  }
  
  public agra a(boolean paramBoolean)
  {
    boolean bool = false;
    agra localagra = new agra();
    localagra.jdField_a_of_type_ArrayOfJavaLangString = new String[] { this.d };
    localagra.jdField_b_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    if (!a()) {
      bool = true;
    }
    localagra.jdField_a_of_type_Boolean = bool;
    if (localagra.jdField_a_of_type_Boolean) {}
    for (String str = this.jdField_f_of_type_JavaLangString;; str = this.jdField_c_of_type_JavaLangString)
    {
      localagra.jdField_a_of_type_JavaLangString = str;
      localagra.jdField_c_of_type_Long = this.jdField_c_of_type_Long;
      localagra.jdField_b_of_type_Boolean = true;
      localagra.jdField_b_of_type_Long = this.jdField_h_of_type_Long;
      localagra.jdField_a_of_type_Long = this.jdField_f_of_type_Long;
      localagra.jdField_b_of_type_Int = this.jdField_f_of_type_Int;
      localagra.jdField_e_of_type_Boolean = paramBoolean;
      return localagra;
    }
  }
  
  public File a(int paramInt)
  {
    if (!apvd.b(this.jdField_b_of_type_JavaLangString)) {
      return null;
    }
    return new File(this.jdField_b_of_type_JavaLangString);
  }
  
  public String a()
  {
    return this.jdField_h_of_type_JavaLangString;
  }
  
  public String a(int paramInt)
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      return "";
    }
    if (!this.jdField_b_of_type_JavaLangString.startsWith("/")) {
      return "file:/" + this.jdField_b_of_type_JavaLangString;
    }
    if (this.jdField_b_of_type_JavaLangString.startsWith("//")) {
      return "file:" + this.jdField_b_of_type_JavaLangString;
    }
    return "file:" + this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = true;
  }
  
  public void a(Parcel paramParcel)
  {
    boolean bool = true;
    super.a(paramParcel);
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.jdField_c_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  public void a(View paramView, agqv paramagqv)
  {
    if (c())
    {
      if (apvm.a(paramView.getContext(), false, new aege(this, paramagqv, paramView))) {
        a(paramView.getContext(), paramagqv);
      }
      return;
    }
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_f_of_type_Boolean = false;
      paramagqv.a(paramView, a(false));
    }
    paramagqv.b();
    paramagqv.f();
  }
  
  public void a(String paramString)
  {
    this.jdField_h_of_type_JavaLangString = paramString;
  }
  
  public boolean a()
  {
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      return true;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    return apvd.b(this.jdField_b_of_type_JavaLangString);
  }
  
  public boolean a(aejb paramaejb)
  {
    if (a()) {}
    while ((!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))) {
      return false;
    }
    paramaejb.a(this.jdField_f_of_type_Long, this.jdField_f_of_type_Int, 16842753);
    return true;
  }
  
  public boolean b()
  {
    return !TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    if (this.jdField_c_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData
 * JD-Core Version:    0.7.0.1
 */