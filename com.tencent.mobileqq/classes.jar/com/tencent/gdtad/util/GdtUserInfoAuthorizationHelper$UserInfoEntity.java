package com.tencent.gdtad.util;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.widget.AuthorizationItem;
import com.tencent.widget.AuthorizationItem.ItemType;

public class GdtUserInfoAuthorizationHelper$UserInfoEntity
{
  public int a;
  public final String a;
  public final String b;
  public final String c;
  
  private GdtUserInfoAuthorizationHelper$UserInfoEntity(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2, paramString3, 0);
  }
  
  private GdtUserInfoAuthorizationHelper$UserInfoEntity(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private static UserInfoEntity b()
  {
    return new UserInfoEntity("", "", "", 1);
  }
  
  public String a(String paramString)
  {
    if (TextUtils.equals(paramString, AuthorizationItem.a.b)) {
      return this.jdField_a_of_type_JavaLangString;
    }
    if (TextUtils.equals(paramString, AuthorizationItem.b.b)) {
      return this.b;
    }
    if (TextUtils.equals(paramString, AuthorizationItem.c.b)) {
      return this.c;
    }
    return "";
  }
  
  @NonNull
  public String toString()
  {
    return "UserInfoEntity : [name -> " + this.jdField_a_of_type_JavaLangString + ", phone -> " + this.b + ", city -> " + this.c + ", errCode -> " + this.jdField_a_of_type_Int + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtUserInfoAuthorizationHelper.UserInfoEntity
 * JD-Core Version:    0.7.0.1
 */