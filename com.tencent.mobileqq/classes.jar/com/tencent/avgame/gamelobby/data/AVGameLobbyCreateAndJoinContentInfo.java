package com.tencent.avgame.gamelobby.data;

import androidx.annotation.NonNull;

public class AVGameLobbyCreateAndJoinContentInfo
  extends AVGameBaseData
{
  private int a;
  public String a;
  public boolean a;
  public String b = null;
  public String c = null;
  public String d = null;
  
  public AVGameLobbyCreateAndJoinContentInfo(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NonNull
  public int b()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.data.AVGameLobbyCreateAndJoinContentInfo
 * JD-Core Version:    0.7.0.1
 */