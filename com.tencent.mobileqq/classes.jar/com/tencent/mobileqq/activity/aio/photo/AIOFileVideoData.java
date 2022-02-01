package com.tencent.mobileqq.activity.aio.photo;

import aibc;
import aibd;
import aidz;
import aksn;
import akss;
import android.content.Context;
import android.os.Parcel;
import android.text.TextUtils;
import android.view.View;
import aumw;
import aunj;
import auog;
import auoo;
import java.io.File;
import java.util.ArrayList;

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
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public String e;
  public boolean e;
  public String f;
  private boolean f;
  public String g;
  public String h;
  public String i;
  public String j;
  private String k;
  
  public AIOFileVideoData() {}
  
  public AIOFileVideoData(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  private void a(Context paramContext, aksn paramaksn)
  {
    paramaksn = new aibc(this, paramContext, paramaksn);
    aumw.a(paramContext, paramContext.getString(2131692326), paramContext.getString(2131692328), paramaksn);
  }
  
  private boolean c()
  {
    if (this.jdField_e_of_type_Boolean) {}
    do
    {
      do
      {
        return false;
      } while (!aunj.a());
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_h_of_type_Long > 0L) && (this.jdField_h_of_type_Long > this.jdField_a_of_type_Long)) {
        return true;
      }
    } while (this.jdField_h_of_type_Long <= 1048576L);
    return true;
  }
  
  public akss a(boolean paramBoolean)
  {
    boolean bool = false;
    akss localakss = new akss();
    localakss.jdField_a_of_type_ArrayOfJavaLangString = new String[] { this.jdField_d_of_type_JavaLangString };
    localakss.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    localakss.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_e_of_type_JavaLangString);
    if (!a()) {
      bool = true;
    }
    localakss.jdField_a_of_type_Boolean = bool;
    if (localakss.jdField_a_of_type_Boolean) {}
    for (String str = this.jdField_f_of_type_JavaLangString;; str = this.jdField_c_of_type_JavaLangString)
    {
      localakss.jdField_a_of_type_JavaLangString = str;
      localakss.jdField_c_of_type_Long = this.jdField_c_of_type_Long;
      localakss.jdField_b_of_type_Boolean = true;
      localakss.jdField_b_of_type_Long = this.jdField_h_of_type_Long;
      localakss.jdField_a_of_type_Long = this.jdField_f_of_type_Long;
      localakss.jdField_b_of_type_Int = this.jdField_f_of_type_Int;
      localakss.jdField_e_of_type_Boolean = paramBoolean;
      return localakss;
    }
  }
  
  public File a(int paramInt)
  {
    if (!auog.b(this.jdField_b_of_type_JavaLangString)) {
      return null;
    }
    return new File(this.jdField_b_of_type_JavaLangString);
  }
  
  public String a()
  {
    return this.k;
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
      this.jdField_h_of_type_JavaLangString = paramParcel.readString();
      this.jdField_c_of_type_Int = paramParcel.readInt();
      this.jdField_d_of_type_Int = paramParcel.readInt();
      this.i = paramParcel.readString();
      this.j = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public void a(View paramView, aksn paramaksn)
  {
    if (c())
    {
      if (auoo.a(paramView.getContext(), false, new aibd(this, paramaksn, paramView))) {
        a(paramView.getContext(), paramaksn);
      }
      return;
    }
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_f_of_type_Boolean = false;
      paramaksn.a(paramView, a(false));
    }
    paramaksn.b();
    paramaksn.f();
  }
  
  public void a(String paramString)
  {
    this.k = paramString;
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
    return auog.b(this.jdField_b_of_type_JavaLangString);
  }
  
  public boolean a(aidz paramaidz)
  {
    if (a()) {}
    while ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))) {
      return false;
    }
    paramaidz.a(this.jdField_f_of_type_Long, this.jdField_f_of_type_Int, 16842753);
    return true;
  }
  
  public boolean b()
  {
    return !TextUtils.isEmpty(this.k);
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
      paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_c_of_type_Int);
      paramParcel.writeInt(this.jdField_d_of_type_Int);
      paramParcel.writeString(this.i);
      paramParcel.writeString(this.j);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData
 * JD-Core Version:    0.7.0.1
 */