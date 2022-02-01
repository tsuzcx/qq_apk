package com.bumptech.glide.load;

import android.content.Context;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.Iterator;

public class MultiTransformation<T>
  implements Transformation<T>
{
  private final Collection<? extends Transformation<T>> b;
  
  @NonNull
  public Resource<T> a(@NonNull Context paramContext, @NonNull Resource<T> paramResource, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.b.iterator();
    Resource localResource;
    for (Object localObject = paramResource; localIterator.hasNext(); localObject = localResource)
    {
      localResource = ((Transformation)localIterator.next()).a(paramContext, (Resource)localObject, paramInt1, paramInt2);
      if ((localObject != null) && (!localObject.equals(paramResource)) && (!localObject.equals(localResource))) {
        ((Resource)localObject).f();
      }
    }
    return localObject;
  }
  
  public void a(@NonNull MessageDigest paramMessageDigest)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((Transformation)localIterator.next()).a(paramMessageDigest);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof MultiTransformation))
    {
      paramObject = (MultiTransformation)paramObject;
      return this.b.equals(paramObject.b);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.MultiTransformation
 * JD-Core Version:    0.7.0.1
 */