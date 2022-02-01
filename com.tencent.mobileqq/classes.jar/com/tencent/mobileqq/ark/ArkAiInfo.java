package com.tencent.mobileqq.ark;

import java.util.LinkedHashMap;

public class ArkAiInfo
{
  public String a = "";
  public String b = "";
  public String c = "1.0.0.1";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public LinkedHashMap<String, String> i = new LinkedHashMap();
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof ArkAiInfo;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (ArkAiInfo)paramObject;
    bool1 = bool2;
    if (this.a.equals(paramObject.a))
    {
      bool1 = bool2;
      if (this.b.equals(paramObject.b))
      {
        bool1 = bool2;
        if (this.g.equals(paramObject.g))
        {
          bool1 = bool2;
          if (this.i.equals(paramObject.i)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiInfo
 * JD-Core Version:    0.7.0.1
 */