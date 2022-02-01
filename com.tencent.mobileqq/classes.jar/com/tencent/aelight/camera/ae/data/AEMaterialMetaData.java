package com.tencent.aelight.camera.ae.data;

import android.support.annotation.Nullable;
import com.tencent.aelight.camera.ae.AEPath.CAMERA.FILES;
import java.io.File;

public class AEMaterialMetaData
{
  public static final AEMaterialMetaData a;
  public String A;
  public String B;
  public String C;
  public String D;
  public long a;
  public boolean a;
  public int b;
  public long b;
  public boolean b;
  public int c;
  public boolean c = false;
  public int d;
  public boolean d;
  public int e;
  public boolean e;
  public int f;
  public boolean f;
  public int g;
  public boolean g;
  public int h = 0;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  public String t;
  public String u;
  public String v = "";
  public String w;
  public String x;
  public String y;
  public String z;
  
  static
  {
    jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData = a();
  }
  
  public AEMaterialMetaData()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
  }
  
  private static AEMaterialMetaData a()
  {
    AEMaterialMetaData localAEMaterialMetaData = new AEMaterialMetaData();
    localAEMaterialMetaData.k = "0";
    localAEMaterialMetaData.jdField_b_of_type_Int = 0;
    return localAEMaterialMetaData;
  }
  
  public static boolean a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData == null) {
      return false;
    }
    paramAEMaterialMetaData = paramAEMaterialMetaData.k;
    return (paramAEMaterialMetaData == null) || (paramAEMaterialMetaData.equals("0"));
  }
  
  public static boolean b(@Nullable AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData != null)
    {
      int i = paramAEMaterialMetaData.h;
      if ((i == 0) || (i == 4) || (i == 5) || (i == 6) || (i == 7)) {
        return true;
      }
    }
    return false;
  }
  
  public int a()
  {
    int i = this.jdField_e_of_type_Int;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return -1;
          }
          return 2064056678;
        }
        return 2064056679;
      }
      return 2064056677;
    }
    return 2064056676;
  }
  
  public String a()
  {
    File localFile = new File(AEPath.CAMERA.FILES.i);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(new File(localFile.getPath(), this.k).getPath());
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (!equals(jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData))
    {
      this.jdField_e_of_type_Boolean = paramAEMaterialMetaData.jdField_e_of_type_Boolean;
      this.f = paramAEMaterialMetaData.f;
      this.jdField_a_of_type_Boolean = paramAEMaterialMetaData.jdField_a_of_type_Boolean;
    }
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Int == 12;
  }
  
  public String b()
  {
    File localFile = new File(AEPath.CAMERA.FILES.i);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localFile.getPath());
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public boolean b()
  {
    return this.jdField_e_of_type_Int != 0;
  }
  
  public String c()
  {
    return new File(AEMaterialManager.c(), this.k).getPath();
  }
  
  public boolean c()
  {
    String str = this.k;
    return (str == null) || (str.equals("0"));
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof AEMaterialMetaData)) {
      return false;
    }
    paramObject = (AEMaterialMetaData)paramObject;
    if ((paramObject.k == null) && (this.k == null)) {
      return true;
    }
    if ((paramObject.k == null) && (this.k != null)) {
      return false;
    }
    if ((paramObject.k != null) && (this.k == null)) {
      return false;
    }
    return paramObject.k.equals(this.k);
  }
  
  public int hashCode()
  {
    String str = this.k;
    int i;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    }
    return 31 + i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.data.AEMaterialMetaData
 * JD-Core Version:    0.7.0.1
 */