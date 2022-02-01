package com.tencent.luggage.wxa.qz;

import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class ah
{
  private static ThreadLocal<XmlPullParser> a = new ThreadLocal();
  
  public static Map<String, String> a(String paramString1, String paramString2, String paramString3)
  {
    int i;
    if (paramString1 == null)
    {
      i = -1;
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<");
      ((StringBuilder)localObject).append(paramString2);
      i = paramString1.indexOf(((StringBuilder)localObject).toString());
    }
    if (i < 0)
    {
      o.b("MicroMsg.SDK.XmlParser", "can not find the tag <%s>", new Object[] { paramString2 });
      return null;
    }
    Object localObject = paramString1;
    if (i > 0) {
      localObject = paramString1.substring(i);
    }
    try
    {
      paramString1 = new ah.a((String)localObject, paramString2, paramString3).a();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      o.a("MicroMsg.SDK.XmlParser", paramString1, "[ %s ]", new Object[] { localObject });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.ah
 * JD-Core Version:    0.7.0.1
 */