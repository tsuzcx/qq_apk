package com.tencent.avgame.config.data;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class AvGameLobbyConfBean
{
  private int a = 0;
  private int b = 0;
  private int c = 10;
  private int d = 5;
  
  public static AvGameLobbyConfBean a(QConfItem paramQConfItem)
  {
    AvGameLobbyConfBean localAvGameLobbyConfBean = new AvGameLobbyConfBean();
    if (paramQConfItem != null)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parse taskid->");
        localStringBuilder.append(paramQConfItem.a);
        localStringBuilder.append(" content->");
        localStringBuilder.append(paramQConfItem.b);
        QLog.d("AvGameLobbyConfBean", 2, localStringBuilder.toString());
      }
      try
      {
        paramQConfItem = new JSONObject(paramQConfItem.b);
        localAvGameLobbyConfBean.c(paramQConfItem.optInt("homePage_A", 0));
        localAvGameLobbyConfBean.d(paramQConfItem.optInt("roomPage_B", 0));
        localAvGameLobbyConfBean.a(paramQConfItem.optInt("matchTime", 10));
        localAvGameLobbyConfBean.b(paramQConfItem.optInt("selectTopicTime", 5));
        if (QLog.isColorLevel())
        {
          paramQConfItem = new StringBuilder();
          paramQConfItem.append("avGameLobbyConfBean ");
          paramQConfItem.append(localAvGameLobbyConfBean.toString());
          QLog.d("AvGameLobbyConfBean", 2, paramQConfItem.toString());
          return localAvGameLobbyConfBean;
        }
      }
      catch (Exception paramQConfItem)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("parse error->");
          localStringBuilder.append(paramQConfItem.toString());
          QLog.e("AvGameLobbyConfBean", 2, localStringBuilder.toString());
        }
      }
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
    return this.a;
  }
  
  public void c(int paramInt)
  {
    this.a = paramInt;
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
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("homePage_A:");
    localStringBuilder2.append(this.a);
    localStringBuilder2.append("|");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("roomPage_B:");
    localStringBuilder2.append(this.b);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("matchTime:");
    localStringBuilder1.append(this.c);
    localStringBuilder1.append("|");
    localStringBuilder1.append("selectTopicTime:");
    localStringBuilder1.append(this.d);
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.config.data.AvGameLobbyConfBean
 * JD-Core Version:    0.7.0.1
 */