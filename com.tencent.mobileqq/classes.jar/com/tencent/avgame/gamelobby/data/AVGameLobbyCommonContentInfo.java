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
    localStringBuilder.append("actionId:").append(this.jdField_a_of_type_Int).append("|");
    localStringBuilder.append("titleUrl:").append(this.jdField_a_of_type_JavaLangString).append("|");
    localStringBuilder.append("backgroudUrl:").append(this.jdField_b_of_type_JavaLangString).append("|");
    localStringBuilder.append("playUserNum:").append(this.jdField_b_of_type_Int).append("|");
    localStringBuilder.append("playerList:").append(this.jdField_a_of_type_JavaUtilList).append("|");
    localStringBuilder.append("colorStart:").append(this.c).append("|");
    localStringBuilder.append("colorEnd:").append(this.d).append("|");
    localStringBuilder.append("itemType:").append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.data.AVGameLobbyCommonContentInfo
 * JD-Core Version:    0.7.0.1
 */