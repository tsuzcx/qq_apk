package com.tencent.mm.plugin.appbrand.page;

public class v
{
  public static String a(String paramString)
  {
    int i = paramString.indexOf("<page>");
    int j = paramString.indexOf("</page>");
    if ((i != -1) && (j != -i)) {
      return paramString.substring(i + 6, j);
    }
    return "";
  }
  
  public static String b(String paramString)
  {
    int i = paramString.indexOf("<style>");
    int j = paramString.indexOf("</style>");
    if ((i != -1) && (j != -i)) {
      return paramString.substring(i + 7, j);
    }
    return "";
  }
  
  public static String c(String paramString)
  {
    int i = 0;
    String str = "";
    for (;;)
    {
      int j = paramString.indexOf("<script>", i);
      int k = paramString.indexOf("</script>", i);
      if ((j == -1) || (k == -1) || (k <= j)) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      if (i > 0) {
        str = ";";
      } else {
        str = "";
      }
      localStringBuilder.append(str);
      localStringBuilder.append(paramString.substring(j + 8, k));
      str = localStringBuilder.toString();
      i = k + 9;
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.v
 * JD-Core Version:    0.7.0.1
 */