package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Face2FaceFriendInfo
{
  public String a;
  public String b;
  public int c;
  
  public boolean a()
  {
    return this.c != 1;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof Face2FaceFriendInfo))
    {
      paramObject = (Face2FaceFriendInfo)paramObject;
      return this.a.equals(paramObject.a);
    }
    return super.equals(paramObject);
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Face2FaceFriendInfo uin:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" nick:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" type:");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceFriendInfo
 * JD-Core Version:    0.7.0.1
 */