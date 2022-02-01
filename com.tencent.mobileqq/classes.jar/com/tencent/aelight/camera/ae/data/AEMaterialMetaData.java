package com.tencent.aelight.camera.ae.data;

import android.support.annotation.Nullable;
import com.tencent.aelight.camera.ae.AEPath.CAMERA.FILES;
import java.io.File;

public class AEMaterialMetaData
{
  public static final AEMaterialMetaData l = ;
  public boolean A;
  public boolean B;
  public int C;
  public long D;
  public long E;
  public String F;
  public String G;
  public String H;
  public String I;
  public String J;
  public String K;
  public boolean L;
  public int M;
  public String N = "";
  public String O;
  public int P = 0;
  public String Q;
  public String R;
  public String S;
  public String T;
  public String U;
  public String V;
  public String W;
  public String X;
  public int Y;
  public boolean Z;
  public String aa;
  public String ab;
  public String m;
  public int n;
  public String o;
  public int p;
  public String q;
  public String r;
  public String s;
  public String t;
  public boolean u;
  public boolean v = false;
  public boolean w = false;
  public boolean x = false;
  public int y = 0;
  public int z = 0;
  
  public static boolean a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData == null) {
      return false;
    }
    paramAEMaterialMetaData = paramAEMaterialMetaData.m;
    return (paramAEMaterialMetaData == null) || (paramAEMaterialMetaData.equals("0"));
  }
  
  public static boolean c(@Nullable AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData != null)
    {
      int i = paramAEMaterialMetaData.P;
      if ((i == 0) || (i == 4) || (i == 5) || (i == 6) || (i == 7)) {
        return true;
      }
    }
    return false;
  }
  
  private static AEMaterialMetaData h()
  {
    AEMaterialMetaData localAEMaterialMetaData = new AEMaterialMetaData();
    localAEMaterialMetaData.m = "0";
    localAEMaterialMetaData.n = 0;
    localAEMaterialMetaData.t = "";
    localAEMaterialMetaData.q = "";
    return localAEMaterialMetaData;
  }
  
  public boolean a()
  {
    return this.y == 12;
  }
  
  public void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (!equals(l))
    {
      this.A = paramAEMaterialMetaData.A;
      this.B = paramAEMaterialMetaData.B;
      this.u = paramAEMaterialMetaData.u;
    }
  }
  
  public boolean b()
  {
    return this.z != 0;
  }
  
  public int c()
  {
    int i = this.z;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return -1;
          }
          return 2063925643;
        }
        return 2063925644;
      }
      return 2063925642;
    }
    return 2063925641;
  }
  
  public boolean d()
  {
    String str = this.m;
    return (str == null) || (str.equals("0"));
  }
  
  public String e()
  {
    File localFile = new File(AEPath.CAMERA.FILES.i);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(new File(localFile.getPath(), this.m).getPath());
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
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
    if ((paramObject.m == null) && (this.m == null)) {
      return true;
    }
    if ((paramObject.m == null) && (this.m != null)) {
      return false;
    }
    if ((paramObject.m != null) && (this.m == null)) {
      return false;
    }
    return paramObject.m.equals(this.m);
  }
  
  public String f()
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
  
  public String g()
  {
    return new File(AEMaterialManager.q(), this.m).getPath();
  }
  
  public int hashCode()
  {
    String str = this.m;
    int i;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    }
    return 31 + i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.data.AEMaterialMetaData
 * JD-Core Version:    0.7.0.1
 */