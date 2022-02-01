package com.tencent.avcore.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class GlStringParser
{
  private static final String TAG = "GlStringParser";
  private Map<String, String> mMap;
  private char mend = '\t';
  private char mkey = '\r';
  
  public GlStringParser()
  {
    this.mkey = '\r';
    this.mend = '\t';
    this.mMap = new HashMap();
  }
  
  public GlStringParser(char paramChar1, char paramChar2)
  {
    this.mkey = paramChar1;
    this.mend = paramChar2;
    this.mMap = new HashMap();
  }
  
  public GlStringParser(String paramString)
  {
    this.mMap = new HashMap();
    unflatten(paramString);
  }
  
  public GlStringParser(Map<String, String> paramMap)
  {
    this.mMap = paramMap;
  }
  
  public String flatten()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.mMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(str);
      localStringBuilder.append(this.mkey);
      localStringBuilder.append((String)this.mMap.get(str));
      localStringBuilder.append(this.mend);
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    return localStringBuilder.toString();
  }
  
  public String get(String paramString)
  {
    return (String)this.mMap.get(paramString);
  }
  
  public Boolean getBoolean(String paramString)
  {
    paramString = (String)this.mMap.get(paramString);
    if ((paramString != null) && ((paramString.equals("true")) || (paramString.equals("false")))) {
      return Boolean.valueOf(paramString);
    }
    return Boolean.valueOf(false);
  }
  
  public int getInt(String paramString)
  {
    return getInt(paramString, 0);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    String str = (String)this.mMap.get(paramString);
    if (str != null) {
      try
      {
        int i = Integer.parseInt(str);
        return i;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getInt, key[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], value[");
        localStringBuilder.append(str);
        localStringBuilder.append("], def[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        AVCoreLog.e("GlStringParser", localStringBuilder.toString(), localException);
      }
    }
    return paramInt;
  }
  
  public long getLong(String paramString, long paramLong)
  {
    String str = (String)this.mMap.get(paramString);
    if (str != null) {
      try
      {
        long l = Long.parseLong(str);
        return l;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getLong, key[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], value[");
        localStringBuilder.append(str);
        localStringBuilder.append("], def[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        AVCoreLog.e("GlStringParser", localStringBuilder.toString(), localException);
      }
    }
    return paramLong;
  }
  
  public Map<String, String> getMap()
  {
    return this.mMap;
  }
  
  public void remove(String paramString)
  {
    this.mMap.remove(paramString);
  }
  
  public void set(String paramString, int paramInt)
  {
    this.mMap.put(paramString, Integer.toString(paramInt));
  }
  
  public void set(String paramString, long paramLong)
  {
    this.mMap.put(paramString, Long.toString(paramLong));
  }
  
  public void set(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.indexOf(this.mend) == -1))
    {
      if (paramString1.indexOf(this.mkey) != -1) {
        return;
      }
      if ((paramString2 != null) && (paramString2.indexOf(this.mkey) == -1))
      {
        if (paramString2.indexOf(this.mend) != -1) {
          return;
        }
        this.mMap.put(paramString1, paramString2);
      }
    }
  }
  
  public void unflatten(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.mMap.clear();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.mend);
    paramString = new StringTokenizer(paramString, ((StringBuilder)localObject).toString());
    while (paramString.hasMoreElements())
    {
      String str = paramString.nextToken();
      int i = str.indexOf(this.mkey);
      if (i != -1)
      {
        localObject = str.substring(0, i);
        str = str.substring(i + 1);
        this.mMap.put(localObject, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.util.GlStringParser
 * JD-Core Version:    0.7.0.1
 */