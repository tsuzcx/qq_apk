package com.tencent.avgame.gamelobby.data;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public class AVGameLobbyRandomMatchContentInfo
  extends AVGameBaseData
{
  public int a;
  public String a;
  public List<Long> a;
  public int b;
  public String b;
  public int c;
  public String c;
  private int d;
  
  public AVGameLobbyRandomMatchContentInfo(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_c_of_type_Int = 0;
    this.d = paramInt;
  }
  
  public int a()
  {
    return this.d;
  }
  
  @NonNull
  public int b()
  {
    return 7;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("titleUrl:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuilder.append("backgroudUrl:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuilder.append("playersNum:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("|");
    localStringBuilder.append("playerList:");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append("|");
    localStringBuilder.append("itemType:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.data.AVGameLobbyRandomMatchContentInfo
 * JD-Core Version:    0.7.0.1
 */