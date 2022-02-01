package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class AIOImageData
  extends AIORichMediaData
{
  public int a;
  public long a;
  public Object a;
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
  public long d;
  public String d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public boolean e;
  public String f;
  public boolean f;
  public String g;
  public boolean g;
  public String h;
  public boolean h;
  public String i;
  public boolean i;
  public String j;
  public boolean j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  
  public AIOImageData()
  {
    this.jdField_a_of_type_JavaLangString = "I:N";
    this.jdField_b_of_type_JavaLangString = "I:N";
    this.jdField_c_of_type_JavaLangString = "I:N";
    this.jdField_d_of_type_JavaLangString = "I:N";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_JavaLangString = "I:N";
    this.jdField_b_of_type_Int = 0;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
  }
  
  public int a(String paramString)
  {
    int i1 = 0;
    if (paramString == null) {
      return 0;
    }
    if (paramString.contains(this.jdField_a_of_type_JavaLangString)) {
      return 1;
    }
    if (paramString.contains(this.jdField_b_of_type_JavaLangString)) {
      return 2;
    }
    if (paramString.contains(this.jdField_c_of_type_JavaLangString)) {
      i1 = 4;
    }
    return i1;
  }
  
  public File a(int paramInt)
  {
    Object localObject;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4)
        {
          if (paramInt != 8) {
            localObject = null;
          } else {
            localObject = this.jdField_d_of_type_JavaLangString;
          }
        }
        else {
          localObject = this.jdField_c_of_type_JavaLangString;
        }
      }
      else {
        localObject = this.jdField_b_of_type_JavaLangString;
      }
    }
    else {
      localObject = this.jdField_a_of_type_JavaLangString;
    }
    if ((localObject != null) && (!((String)localObject).equals("I:N")))
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {
        return localObject;
      }
    }
    return null;
  }
  
  public String a(int paramInt)
  {
    Object localObject;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4)
        {
          if (paramInt != 8) {
            localObject = null;
          } else {
            localObject = this.jdField_d_of_type_JavaLangString;
          }
        }
        else {
          localObject = this.jdField_c_of_type_JavaLangString;
        }
      }
      else {
        localObject = this.jdField_b_of_type_JavaLangString;
      }
    }
    else {
      localObject = this.jdField_a_of_type_JavaLangString;
    }
    if ((localObject != null) && (!((String)localObject).equals("I:N")))
    {
      if (this.jdField_b_of_type_Int == 3)
      {
        localObject = new File((String)localObject);
        try
        {
          localObject = ((File)localObject).toURI().toURL().toString();
          return localObject;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localMalformedURLException.printStackTrace();
          return null;
        }
      }
      if (!localMalformedURLException.startsWith("/"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("file:/");
        localStringBuilder.append(localMalformedURLException);
        return localStringBuilder.toString();
      }
      if (localMalformedURLException.startsWith("//"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("file:");
        localStringBuilder.append(localMalformedURLException);
        return localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file:");
      localStringBuilder.append(localMalformedURLException);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public void a(Parcel paramParcel)
  {
    super.a(paramParcel);
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.jdField_d_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    int i1 = paramParcel.readByte();
    boolean bool2 = false;
    if (i1 != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_d_of_type_Boolean = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_e_of_type_Boolean = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_f_of_type_Boolean = bool1;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    try
    {
      this.jdField_a_of_type_JavaLangObject = paramParcel.readValue(null);
    }
    catch (Exception localException)
    {
      label167:
      break label167;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AIOImageData", 2, "readValue exception");
    }
    this.jdField_a_of_type_JavaLangObject = new byte[0];
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_g_of_type_Boolean = bool1;
    this.jdField_e_of_type_Long = paramParcel.readLong();
    this.jdField_g_of_type_JavaLangString = paramParcel.readString();
    this.jdField_h_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_i_of_type_JavaLangString = paramParcel.readString();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.jdField_j_of_type_JavaLangString = paramParcel.readString();
    this.k = paramParcel.readString();
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_h_of_type_Boolean = bool1;
    this.jdField_e_of_type_Int = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_i_of_type_Boolean = bool1;
    this.l = paramParcel.readString();
    boolean bool1 = bool2;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    }
    this.jdField_j_of_type_Boolean = bool1;
    this.m = paramParcel.readString();
    this.n = paramParcel.readString();
    this.o = paramParcel.readString();
    this.p = paramParcel.readString();
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4) {
          return false;
        }
        if (this.jdField_b_of_type_Int == 3) {
          return true;
        }
        return this.jdField_c_of_type_JavaLangString.equals("I:N") ^ true;
      }
      return this.jdField_b_of_type_JavaLangString.equals("I:N") ^ true;
    }
    return this.jdField_a_of_type_JavaLangString.equals("I:N") ^ true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageData
 * JD-Core Version:    0.7.0.1
 */