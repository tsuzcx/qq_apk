package com.tencent.beacon.qimei;

import android.text.TextUtils;
import java.util.Map;

public final class Qimei
{
  private String a;
  private String b;
  private Map<String, String> c;
  
  public Qimei()
  {
    this("", "", null);
  }
  
  public Qimei(String paramString)
  {
    this(paramString, "", null);
  }
  
  public Qimei(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    this.a = str;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    this.b = paramString1;
    this.c = paramMap;
  }
  
  void a(String paramString)
  {
    this.b = paramString;
  }
  
  void a(Map<String, String> paramMap)
  {
    this.c = paramMap;
  }
  
  void b(String paramString)
  {
    this.a = paramString;
  }
  
  public Map<String, String> getQimeiMap()
  {
    return this.c;
  }
  
  public String getQimeiNew()
  {
    return this.b;
  }
  
  public String getQimeiOld()
  {
    return this.a;
  }
  
  public boolean isEmpty()
  {
    Map localMap = this.c;
    return (localMap == null) || (localMap.isEmpty());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Qimei:");
    localStringBuilder.append(this.a);
    Object localObject;
    if (TextUtils.isEmpty(this.b))
    {
      localObject = "";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("\nQimei3:");
      ((StringBuilder)localObject).append(this.b);
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.qimei.Qimei
 * JD-Core Version:    0.7.0.1
 */