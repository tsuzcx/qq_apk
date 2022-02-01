package com.tencent.avgame.gamelogic.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.avgame.gamelogic.ITopic;
import java.util.List;

public abstract class Topic
  implements ITopic
{
  int a = 0;
  String b = "";
  String c = "";
  String[] d = new String[3];
  long e = 0L;
  boolean f = false;
  
  public int a()
  {
    return this.a;
  }
  
  public void a(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean a(ITopic paramITopic)
  {
    return (paramITopic != null) && (paramITopic.a() == a()) && (paramITopic.b() == b());
  }
  
  public String c()
  {
    return "";
  }
  
  @Nullable
  public String d()
  {
    return this.c;
  }
  
  public String e()
  {
    return this.b;
  }
  
  public int f()
  {
    return 0;
  }
  
  public String[] g()
  {
    return this.d;
  }
  
  public long h()
  {
    return this.e;
  }
  
  public List<? extends ITopic> i()
  {
    return null;
  }
  
  public abstract ITopic j();
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id");
    localStringBuilder.append("=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("|");
    localStringBuilder.append("isTopicBank");
    localStringBuilder.append("=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("|");
    localStringBuilder.append("gameType");
    localStringBuilder.append("=");
    localStringBuilder.append(b());
    localStringBuilder.append("|");
    localStringBuilder.append("content");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("|");
    localStringBuilder.append("answer");
    localStringBuilder.append("=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("|");
    localStringBuilder.append("buff type");
    localStringBuilder.append("=");
    localStringBuilder.append(this.d[0]);
    localStringBuilder.append("|");
    localStringBuilder.append("buff point");
    localStringBuilder.append("=");
    localStringBuilder.append(this.d[1]);
    localStringBuilder.append("|");
    localStringBuilder.append("buff color");
    localStringBuilder.append("=");
    localStringBuilder.append(this.d[2]);
    localStringBuilder.append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.Topic
 * JD-Core Version:    0.7.0.1
 */