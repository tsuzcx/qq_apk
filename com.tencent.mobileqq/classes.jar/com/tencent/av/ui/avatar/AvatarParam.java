package com.tencent.av.ui.avatar;

public class AvatarParam
{
  public final int a;
  public final String b;
  public final String c;
  public final boolean d;
  
  public AvatarParam(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{uinType: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", uin: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", extraUin: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", isRound: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.avatar.AvatarParam
 * JD-Core Version:    0.7.0.1
 */