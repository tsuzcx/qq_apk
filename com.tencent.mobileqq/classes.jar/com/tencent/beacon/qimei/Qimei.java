package com.tencent.beacon.qimei;

import android.text.TextUtils;
import java.util.Map;

public final class Qimei
{
  private Map<String, String> qimeiMap;
  private String qimeiNew;
  private String qimeiOld;
  
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
    this.qimeiOld = str;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    this.qimeiNew = paramString1;
    this.qimeiMap = paramMap;
  }
  
  public Map<String, String> getQimeiMap()
  {
    return this.qimeiMap;
  }
  
  public String getQimeiNew()
  {
    return this.qimeiNew;
  }
  
  public String getQimeiOld()
  {
    return this.qimeiOld;
  }
  
  void setQimeiMap(Map<String, String> paramMap)
  {
    this.qimeiMap = paramMap;
  }
  
  void setQimeiNew(String paramString)
  {
    this.qimeiNew = paramString;
  }
  
  void setQimeiOld(String paramString)
  {
    this.qimeiOld = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Qimei:").append(this.qimeiOld);
    if (TextUtils.isEmpty(this.qimeiNew)) {}
    for (String str = "";; str = "\nQimei3:" + this.qimeiNew) {
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.qimei.Qimei
 * JD-Core Version:    0.7.0.1
 */