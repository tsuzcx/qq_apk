public final class axkq
{
  public static final String a(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    int i = paramString1.indexOf("?");
    Object localObject1 = localObject2;
    if (i != -1)
    {
      i = paramString1.indexOf(paramString2 + "=", i + 1);
      localObject1 = localObject2;
      if (i != -1)
      {
        int j = paramString1.indexOf("&", paramString2.length() + i + 1);
        if (j == -1) {
          break label93;
        }
        localObject1 = paramString1.substring(i + paramString2.length() + 1, j);
      }
    }
    return localObject1;
    label93:
    return paramString1.substring(paramString2.length() + i + 1);
  }
  
  public static final String a(String paramString1, String paramString2, String paramString3)
  {
    int i = paramString1.indexOf("?");
    if (i != -1)
    {
      i = paramString1.indexOf(paramString2 + "=", i + 1);
      if (i != -1)
      {
        int j = paramString1.indexOf("&", paramString2.length() + i + 1);
        if (j != -1) {
          return paramString1.substring(0, i) + paramString2 + "=" + paramString3 + paramString1.substring(j);
        }
        return paramString1.substring(0, i) + paramString2 + "=" + paramString3;
      }
      if (paramString1.lastIndexOf("&") == paramString1.length() - 1) {
        return paramString1 + paramString2 + "=" + paramString3;
      }
      return paramString1 + "&" + paramString2 + "=" + paramString3;
    }
    return paramString1 + "?" + paramString2 + "=" + paramString3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axkq
 * JD-Core Version:    0.7.0.1
 */