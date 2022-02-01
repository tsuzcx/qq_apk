package com.tencent.aelight.camera.aioeditor.share;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

public class AIOShareObject
{
  private int a = -1;
  private int b;
  @NonNull
  private String c;
  @Nullable
  private String d;
  private int e;
  private int f;
  private int g;
  
  private AIOShareObject(int paramInt, @NonNull String paramString)
  {
    this.b = paramInt;
    this.c = paramString;
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
    return this.a;
  }
  
  public AIOShareObject a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public AIOShareObject a(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    return this;
  }
  
  public AIOShareObject b(int paramInt)
  {
    this.g = paramInt;
    return this;
  }
  
  @NotNull
  public String b()
  {
    return this.c;
  }
  
  public AIOShareObject c(@Nullable String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  @Nullable
  public String c()
  {
    return this.d;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public int e()
  {
    return this.f;
  }
  
  public int f()
  {
    return this.g;
  }
  
  public boolean g()
  {
    return this.b == 0;
  }
  
  public boolean h()
  {
    return this.b == 1;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[type : ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", path : ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", requestCode : ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", thumbPath : ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", width : ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", height : ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", duration: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.share.AIOShareObject
 * JD-Core Version:    0.7.0.1
 */