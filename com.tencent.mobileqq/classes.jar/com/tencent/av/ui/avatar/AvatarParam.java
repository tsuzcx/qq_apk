package com.tencent.av.ui.avatar;

public class AvatarParam
{
  public final int a;
  public final String a;
  public final boolean a;
  public final String b;
  
  public AvatarParam(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{uinType: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", uin: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", extraUin: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isRound: ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.avatar.AvatarParam
 * JD-Core Version:    0.7.0.1
 */