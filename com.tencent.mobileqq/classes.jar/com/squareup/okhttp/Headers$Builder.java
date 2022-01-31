package com.squareup.okhttp;

import java.util.ArrayList;
import java.util.List;

public final class Headers$Builder
{
  private final List<String> namesAndValues = new ArrayList(20);
  
  private void checkNameAndValue(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("name == null");
    }
    if (paramString1.isEmpty()) {
      throw new IllegalArgumentException("name is empty");
    }
    int j = paramString1.length();
    int i = 0;
    int k;
    while (i < j)
    {
      k = paramString1.charAt(i);
      if ((k <= 31) || (k >= 127)) {
        throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header name: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramString1 }));
      }
      i += 1;
    }
    if (paramString2 == null) {
      throw new IllegalArgumentException("value == null");
    }
    j = paramString2.length();
    i = 0;
    while (i < j)
    {
      k = paramString2.charAt(i);
      if ((k <= 31) || (k >= 127)) {
        throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header value: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramString2 }));
      }
      i += 1;
    }
  }
  
  public Builder add(String paramString)
  {
    int i = paramString.indexOf(":");
    if (i == -1) {
      throw new IllegalArgumentException("Unexpected header: " + paramString);
    }
    return add(paramString.substring(0, i).trim(), paramString.substring(i + 1));
  }
  
  public Builder add(String paramString1, String paramString2)
  {
    checkNameAndValue(paramString1, paramString2);
    return addLenient(paramString1, paramString2);
  }
  
  Builder addLenient(String paramString)
  {
    int i = paramString.indexOf(":", 1);
    if (i != -1) {
      return addLenient(paramString.substring(0, i), paramString.substring(i + 1));
    }
    if (paramString.startsWith(":")) {
      return addLenient("", paramString.substring(1));
    }
    return addLenient("", paramString);
  }
  
  Builder addLenient(String paramString1, String paramString2)
  {
    this.namesAndValues.add(paramString1);
    this.namesAndValues.add(paramString2.trim());
    return this;
  }
  
  public Headers build()
  {
    return new Headers(this, null);
  }
  
  public String get(String paramString)
  {
    int i = this.namesAndValues.size() - 2;
    while (i >= 0)
    {
      if (paramString.equalsIgnoreCase((String)this.namesAndValues.get(i))) {
        return (String)this.namesAndValues.get(i + 1);
      }
      i -= 2;
    }
    return null;
  }
  
  public Builder removeAll(String paramString)
  {
    int j;
    for (int i = 0; i < this.namesAndValues.size(); i = j + 2)
    {
      j = i;
      if (paramString.equalsIgnoreCase((String)this.namesAndValues.get(i)))
      {
        this.namesAndValues.remove(i);
        this.namesAndValues.remove(i);
        j = i - 2;
      }
    }
    return this;
  }
  
  public Builder set(String paramString1, String paramString2)
  {
    checkNameAndValue(paramString1, paramString2);
    removeAll(paramString1);
    addLenient(paramString1, paramString2);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.Headers.Builder
 * JD-Core Version:    0.7.0.1
 */