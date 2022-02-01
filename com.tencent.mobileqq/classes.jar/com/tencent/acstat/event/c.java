package com.tencent.acstat.event;

import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

public class c
{
  public String a;
  public JSONArray b;
  public JSONObject c = null;
  
  public c() {}
  
  public c(String paramString, String[] paramArrayOfString, Properties paramProperties)
  {
    this.a = paramString;
    if (paramProperties != null) {}
    for (paramString = new JSONObject(paramProperties);; paramString = new JSONObject())
    {
      this.c = paramString;
      return;
      if (paramArrayOfString != null)
      {
        this.b = new JSONArray();
        int j = paramArrayOfString.length;
        int i = 0;
        while (i < j)
        {
          paramString = paramArrayOfString[i];
          this.b.put(paramString);
          i += 1;
        }
        return;
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof c))
    {
      paramObject = (c)paramObject;
      return toString().equals(paramObject.toString());
    }
    return false;
  }
  
  public int hashCode()
  {
    return toString().hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append(this.a);
    localStringBuilder.append(",");
    Object localObject = this.b;
    if (localObject != null) {
      localStringBuilder.append(((JSONArray)localObject).toString());
    }
    localObject = this.c;
    if (localObject != null) {
      localStringBuilder.append(((JSONObject)localObject).toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.event.c
 * JD-Core Version:    0.7.0.1
 */