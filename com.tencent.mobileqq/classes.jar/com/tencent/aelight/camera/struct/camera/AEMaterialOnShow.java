package com.tencent.aelight.camera.struct.camera;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.utils.StringUtil;

public class AEMaterialOnShow
{
  private String a;
  private String b;
  
  public AEMaterialOnShow(@Nullable String paramString1, @Nullable String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  @Nullable
  public String a()
  {
    return this.a;
  }
  
  @Nullable
  public String b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    if ((paramObject != null) && (!(paramObject instanceof AEMaterialOnShow))) {
      return false;
    }
    paramObject = (AEMaterialOnShow)paramObject;
    boolean bool1 = bool2;
    if (!StringUtil.a(this.a))
    {
      bool1 = bool2;
      if (!StringUtil.a(this.b))
      {
        if (paramObject == null) {
          return false;
        }
        bool1 = bool2;
        if (this.a.equals(paramObject.a()))
        {
          bool1 = bool2;
          if (this.b.equals(paramObject.b())) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    String str = this.b;
    int j = 0;
    int i;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    }
    str = this.a;
    if (str != null) {
      j = str.hashCode();
    }
    return (527 + i) * 31 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.struct.camera.AEMaterialOnShow
 * JD-Core Version:    0.7.0.1
 */