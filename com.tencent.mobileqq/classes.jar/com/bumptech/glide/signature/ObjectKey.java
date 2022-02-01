package com.bumptech.glide.signature;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

public final class ObjectKey
  implements Key
{
  private final Object b;
  
  public ObjectKey(@NonNull Object paramObject)
  {
    this.b = Preconditions.a(paramObject);
  }
  
  public void a(@NonNull MessageDigest paramMessageDigest)
  {
    paramMessageDigest.update(this.b.toString().getBytes(a));
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof ObjectKey))
    {
      paramObject = (ObjectKey)paramObject;
      return this.b.equals(paramObject.b);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ObjectKey{object=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.signature.ObjectKey
 * JD-Core Version:    0.7.0.1
 */