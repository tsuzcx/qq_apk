package com.tencent.mobileqq.activity.aio.photo;

import agxs;
import agxt;
import ahap;
import ajqd;
import ajqi;
import android.content.Context;
import android.os.Parcel;
import android.text.TextUtils;
import android.view.View;
import aszg;
import aszt;
import ataw;
import com.tencent.mobileqq.filemanager.util.FileUtil;
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
  
  private void a(Context paramContext, ajqd paramajqd)
  {
    paramajqd = new agxs(this, paramContext, paramajqd);
    aszg.a(paramContext, paramContext.getString(2131692374), paramContext.getString(2131692376), paramajqd);
  }
  
  private boolean c()
  {
    if (this.jdField_e_of_type_Boolean) {}
    do
    {
      do
      {
        return false;
      } while (!aszt.a());
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_h_of_type_Long > 0L) && (this.jdField_h_of_type_Long > this.jdField_a_of_type_Long)) {
        return true;
      }
    } while (this.jdField_h_of_type_Long <= 1048576L);
    return true;
  }
  
  public ajqi a(boolean paramBoolean)
  {
    boolean bool = false;
    ajqi localajqi = new ajqi();
    localajqi.jdField_a_of_type_ArrayOfJavaLangString = new String[] { this.jdField_d_of_type_JavaLangString };
    localajqi.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    localajqi.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_e_of_type_JavaLangString);
    if (!a()) {
      bool = true;
    }
    localajqi.jdField_a_of_type_Boolean = bool;
    if (localajqi.jdField_a_of_type_Boolean) {}
    for (String str = this.jdField_f_of_type_JavaLangString;; str = this.jdField_c_of_type_JavaLangString)
    {
      localajqi.jdField_a_of_type_JavaLangString = str;
      localajqi.jdField_c_of_type_Long = this.jdField_c_of_type_Long;
      localajqi.jdField_b_of_type_Boolean = true;
      localajqi.jdField_b_of_type_Long = this.jdField_h_of_type_Long;
      localajqi.jdField_a_of_type_Long = this.jdField_f_of_type_Long;
      localajqi.jdField_b_of_type_Int = this.jdField_f_of_type_Int;
      localajqi.jdField_e_of_type_Boolean = paramBoolean;
      return localajqi;
    }
  }
  
  public File a(int paramInt)
  {
    if (!FileUtil.fileExistsAndNotEmpty(this.jdField_b_of_type_JavaLangString)) {
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
  
  public void a(View paramView, ajqd paramajqd)
  {
    if (c())
    {
      if (ataw.a(paramView.getContext(), false, new agxt(this, paramajqd, paramView))) {
        a(paramView.getContext(), paramajqd);
      }
      return;
    }
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_f_of_type_Boolean = false;
      paramajqd.a(paramView, a(false));
    }
    paramajqd.b();
    paramajqd.f();
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
    return FileUtil.fileExistsAndNotEmpty(this.jdField_b_of_type_JavaLangString);
  }
  
  public boolean a(ahap paramahap)
  {
    if (a()) {}
    while ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))) {
      return false;
    }
    paramahap.a(this.jdField_f_of_type_Long, this.jdField_f_of_type_Int, 16842753);
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