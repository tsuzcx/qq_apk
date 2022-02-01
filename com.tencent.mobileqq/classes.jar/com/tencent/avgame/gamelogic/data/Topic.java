package com.tencent.avgame.gamelogic.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.avgame.gamelogic.ITopic;
import java.util.List;

public abstract class Topic
  implements ITopic
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  String jdField_a_of_type_JavaLangString = "";
  boolean jdField_a_of_type_Boolean = false;
  String[] jdField_a_of_type_ArrayOfJavaLangString = new String[3];
  String b = "";
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public abstract ITopic a();
  
  public String a()
  {
    return "";
  }
  
  public List<? extends ITopic> a()
  {
    return null;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(ITopic paramITopic)
  {
    return (paramITopic != null) && (paramITopic.a() == a()) && (paramITopic.b() == b());
  }
  
  public String[] a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  @Nullable
  public String b()
  {
    return this.b;
  }
  
  public int c()
  {
    return 0;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("|");
    localStringBuilder.append("isTopicBank");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("|");
    localStringBuilder.append("gameType");
    localStringBuilder.append("=");
    localStringBuilder.append(b());
    localStringBuilder.append("|");
    localStringBuilder.append("content");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuilder.append("answer");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("|");
    localStringBuilder.append("buff type");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_ArrayOfJavaLangString[0]);
    localStringBuilder.append("|");
    localStringBuilder.append("buff point");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_ArrayOfJavaLangString[1]);
    localStringBuilder.append("|");
    localStringBuilder.append("buff color");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_ArrayOfJavaLangString[2]);
    localStringBuilder.append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.Topic
 * JD-Core Version:    0.7.0.1
 */