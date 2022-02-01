package com.tencent.gdtad.util;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.widget.AuthorizationItem;
import com.tencent.widget.AuthorizationItem.ItemType;

public class GdtUserInfoAuthorizationHelper$UserInfoEntity
{
  public final String a;
  public final String b;
  public final String c;
  public int d;
  
  private GdtUserInfoAuthorizationHelper$UserInfoEntity(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2, paramString3, 0);
  }
  
  private GdtUserInfoAuthorizationHelper$UserInfoEntity(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramInt;
  }
  
  private static UserInfoEntity b()
  {
    return new UserInfoEntity("", "", "", 1);
  }
  
  public String a(String paramString)
  {
    if (TextUtils.equals(paramString, AuthorizationItem.a.b)) {
      return this.a;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UserInfoEntity : [name -> ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", phone -> ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", city -> ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", errCode -> ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtUserInfoAuthorizationHelper.UserInfoEntity
 * JD-Core Version:    0.7.0.1
 */