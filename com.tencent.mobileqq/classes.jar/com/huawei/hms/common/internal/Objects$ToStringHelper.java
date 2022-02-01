package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.List;

public final class Objects$ToStringHelper
{
  private final List<String> a;
  private final Object b;
  
  private Objects$ToStringHelper(Object paramObject)
  {
    this.b = Preconditions.checkNotNull(paramObject);
    this.a = new ArrayList();
  }
  
  public final ToStringHelper add(String paramString, Object paramObject)
  {
    paramString = (String)Preconditions.checkNotNull(paramString);
    paramObject = String.valueOf(paramObject);
    paramString = paramString.length() + paramObject.length() + 1 + paramString + "=" + paramObject;
    this.a.add(paramString);
    return this;
  }
  
  public final String toString()
  {
    Object localObject = this.b.getClass().getSimpleName();
    localObject = new StringBuilder(100).append((String)localObject).append('{');
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject).append((String)this.a.get(i));
      if (i < j - 1) {
        ((StringBuilder)localObject).append(", ");
      }
      i += 1;
    }
    return '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.Objects.ToStringHelper
 * JD-Core Version:    0.7.0.1
 */