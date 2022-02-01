package com.tencent.aelight.camera.ae.data;

public class AEGiftMaterial
{
  long a;
  String b;
  AEARCakeMaterial c;
  String d;
  
  public String a()
  {
    return this.b;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public AEARCakeMaterial c()
  {
    return this.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AEGiftMaterial{giftuin=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", materialInfo=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.data.AEGiftMaterial
 * JD-Core Version:    0.7.0.1
 */