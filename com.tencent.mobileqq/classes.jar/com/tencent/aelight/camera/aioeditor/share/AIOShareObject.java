package com.tencent.aelight.camera.aioeditor.share;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

public class AIOShareObject
{
  private int jdField_a_of_type_Int = -1;
  @NonNull
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  @Nullable
  private String jdField_b_of_type_JavaLangString;
  private int c;
  private int d;
  private int e;
  
  private AIOShareObject(int paramInt, @NonNull String paramString)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static AIOShareObject a(@NonNull String paramString)
  {
    return new AIOShareObject(0, paramString);
  }
  
  public static AIOShareObject b(@NonNull String paramString)
  {
    return new AIOShareObject(1, paramString);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public AIOShareObject a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public AIOShareObject a(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    return this;
  }
  
  @NotNull
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Int == 0;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public AIOShareObject b(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  @Nullable
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Int == 1;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public AIOShareObject c(@Nullable String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public int d()
  {
    return this.e;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[type : ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", path : ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", requestCode : ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", thumbPath : ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", width : ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", height : ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", duration: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.share.AIOShareObject
 * JD-Core Version:    0.7.0.1
 */