package com.tencent.beacon.core.protocol.a;

public final class b
{
  public static String a(String paramString)
  {
    return "http://" + paramString + "/analytics/upload";
  }
  
  public static String a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if (paramBoolean1)
    {
      if ((paramString != null) && (!"".equals(paramString))) {
        break label144;
      }
      if (paramBoolean2) {
        paramString = "http://oth.eve.mdt.qq.com:8080/analytics/upload";
      }
    }
    label137:
    label144:
    for (;;)
    {
      if (paramBoolean3) {
        paramString = "http://183.36.108.226:8080/analytics/upload";
      }
      return paramString;
      paramString = "http://oth.str.mdt.qq.com:8080/analytics/upload";
      continue;
      if ((paramString == null) || ("".equals(paramString)))
      {
        paramString = "";
        label55:
        if (paramString != null)
        {
          str = paramString;
          if (!"".equals(paramString)) {}
        }
        else
        {
          if (!paramBoolean2) {
            break label137;
          }
        }
      }
      for (String str = "oth.eve.mdt.qq.com";; str = "oth.str.mdt.qq.com")
      {
        paramString = str;
        if (!paramBoolean3) {
          break;
        }
        return "183.36.108.226";
        int i = paramString.indexOf("http://");
        if (i == -1) {
          break label55;
        }
        int j = paramString.indexOf(":", "http://".length());
        paramString = paramString.substring("http://".length() + i, j);
        break label55;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.protocol.a.b
 * JD-Core Version:    0.7.0.1
 */