package com.tencent.avgame.gamelobby.data;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public class AVGameLobbyCommonContentInfo
  extends AVGameBaseData
{
  public int a;
  public String a;
  public List<Long> a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public int e;
  private int f;
  
  public AVGameLobbyCommonContentInfo(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.f = paramInt;
  }
  
  public int a()
  {
    return this.f;
  }
  
  @NonNull
  public int b()
  {
    return 2;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("actionId:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("|");
    localStringBuilder.append("titleUrl:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuilder.append("backgroudUrl:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuilder.append("playUserNum:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("|");
    localStringBuilder.append("playerList:");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append("|");
    localStringBuilder.append("colorStart:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("|");
    localStringBuilder.append("colorEnd:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("|");
    localStringBuilder.append("itemType:");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.data.AVGameLobbyCommonContentInfo
 * JD-Core Version:    0.7.0.1
 */