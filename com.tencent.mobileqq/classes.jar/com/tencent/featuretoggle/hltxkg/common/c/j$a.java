package com.tencent.featuretoggle.hltxkg.common.c;

import android.os.Bundle;

public final class j$a
{
  private int a;
  public String a;
  public boolean b = false;
  public boolean c = false;
  public String d = "";
  public Bundle e;
  
  public j$a(int paramInt, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, Bundle paramBundle)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramString2;
    this.e = paramBundle;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("appid:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.c.j.a
 * JD-Core Version:    0.7.0.1
 */