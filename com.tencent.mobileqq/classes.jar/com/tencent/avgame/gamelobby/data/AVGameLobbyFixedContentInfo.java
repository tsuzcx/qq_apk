package com.tencent.avgame.gamelobby.data;

import androidx.annotation.NonNull;

public class AVGameLobbyFixedContentInfo
  extends AVGameBaseData
{
  private static boolean jdField_a_of_type_Boolean = false;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int c;
  private int d;
  
  public AVGameLobbyFixedContentInfo(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String[] paramArrayOfString, int paramInt4)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.d = paramInt4;
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static boolean b()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public int a()
  {
    return this.d;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
  }
  
  public boolean a()
  {
    return this.d == 1;
  }
  
  public String[] a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  @NonNull
  public int b()
  {
    return 4;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int d()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int e()
  {
    return this.c;
  }
  
  public int f()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.data.AVGameLobbyFixedContentInfo
 * JD-Core Version:    0.7.0.1
 */