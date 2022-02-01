package com.tencent.featuretoggle.hltxkg.common.a;

import android.text.TextUtils;
import com.tencent.featuretoggle.hltxkg.common.e.c;

public final class a
{
  private byte jdField_a_of_type_Byte;
  public int a;
  private String jdField_a_of_type_JavaLangString = "";
  private byte b;
  public int b;
  private int c = -1;
  
  public a()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_Byte = 1;
  }
  
  public a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_Byte = 1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramInt;
  }
  
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a(byte paramByte)
  {
    this.jdField_a_of_type_Byte = paramByte;
  }
  
  public final boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i;
    if (paramString.startsWith("["))
    {
      if (paramString.contains("]"))
      {
        Object localObject = paramString.split("]");
        if (localObject.length != 2) {
          return false;
        }
        if (!localObject[1].startsWith(":")) {
          return false;
        }
        paramString = localObject[0].substring(1);
        if (!i.c(paramString)) {
          return false;
        }
        try
        {
          i = Integer.parseInt(localObject[1].substring(1));
          if (i >= 0)
          {
            if (i > 65535) {
              return false;
            }
            localObject = new StringBuilder("[");
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append("]");
            this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
            this.c = i;
            return true;
          }
          return false;
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
        }
      }
      return false;
    }
    paramString = paramString.split(":");
    if (paramString.length != 2) {
      return false;
    }
    this.jdField_a_of_type_JavaLangString = paramString[0];
    if (!c.d(this.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    try
    {
      this.c = Integer.parseInt(paramString[1]);
      if (this.c >= 0)
      {
        i = this.c;
        return i <= 65535;
      }
      return false;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public final byte b()
  {
    return this.jdField_a_of_type_Byte;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public final String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(":");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
  
  public final boolean e()
  {
    return this.jdField_a_of_type_Byte == 3;
  }
  
  public final boolean f()
  {
    int i = this.jdField_a_of_type_Byte;
    return (i != 3) && (i != 4);
  }
  
  public final boolean g()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.charAt(0) == '['))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      if (str.charAt(str.length() - 1) == ']') {
        return true;
      }
    }
    return false;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(":");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",protocalType:");
    localStringBuilder.append(this.jdField_b_of_type_Byte);
    localStringBuilder.append(",ipType:");
    localStringBuilder.append(this.jdField_a_of_type_Byte);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.a.a
 * JD-Core Version:    0.7.0.1
 */