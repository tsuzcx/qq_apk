package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.List;

public final class Objects$ToStringHelper
{
  public final List<String> a;
  public final Object b;
  
  public Objects$ToStringHelper(Object paramObject)
  {
    this.b = Preconditions.checkNotNull(paramObject);
    this.a = new ArrayList();
  }
  
  public final ToStringHelper add(String paramString, Object paramObject)
  {
    paramString = (String)Preconditions.checkNotNull(paramString);
    paramObject = String.valueOf(paramObject);
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + paramObject.length() + 1);
    localStringBuilder.append(paramString);
    localStringBuilder.append("=");
    localStringBuilder.append(paramObject);
    paramString = localStringBuilder.toString();
    this.a.add(paramString);
    return this;
  }
  
  public final String toString()
  {
    String str = this.b.getClass().getSimpleName();
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(str);
    localStringBuilder.append('{');
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append((String)this.a.get(i));
      if (i < j - 1) {
        localStringBuilder.append(", ");
      }
      i += 1;
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.common.internal.Objects.ToStringHelper
 * JD-Core Version:    0.7.0.1
 */