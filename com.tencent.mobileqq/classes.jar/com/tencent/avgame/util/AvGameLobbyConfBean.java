package com.tencent.avgame.util;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class AvGameLobbyConfBean
{
  private int a;
  private int b = 0;
  private int c = 10;
  private int d = 5;
  
  public AvGameLobbyConfBean()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public static AvGameLobbyConfBean a(QConfItem paramQConfItem)
  {
    AvGameLobbyConfBean localAvGameLobbyConfBean = new AvGameLobbyConfBean();
    if (paramQConfItem != null) {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameLobbyConfBean", 2, "parse taskid->" + paramQConfItem.jdField_a_of_type_Int + " content->" + paramQConfItem.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramQConfItem = new JSONObject(paramQConfItem.jdField_a_of_type_JavaLangString);
      localAvGameLobbyConfBean.c(paramQConfItem.optInt("homePage_A", 0));
      localAvGameLobbyConfBean.d(paramQConfItem.optInt("roomPage_B", 0));
      localAvGameLobbyConfBean.a(paramQConfItem.optInt("matchTime", 10));
      localAvGameLobbyConfBean.b(paramQConfItem.optInt("selectTopicTime", 5));
      if (QLog.isColorLevel()) {
        QLog.d("AvGameLobbyConfBean", 2, "avGameLobbyConfBean " + localAvGameLobbyConfBean.toString());
      }
      return localAvGameLobbyConfBean;
    }
    catch (Exception paramQConfItem)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AvGameLobbyConfBean", 2, "parse error->" + paramQConfItem.toString());
    }
    return localAvGameLobbyConfBean;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int d()
  {
    return this.b;
  }
  
  public void d(int paramInt)
  {
    this.b = paramInt;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("homePage_A:" + this.jdField_a_of_type_Int + "|").append("roomPage_B:" + this.b);
    localStringBuilder.append("matchTime:").append(this.c).append("|");
    localStringBuilder.append("selectTopicTime:").append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.util.AvGameLobbyConfBean
 * JD-Core Version:    0.7.0.1
 */