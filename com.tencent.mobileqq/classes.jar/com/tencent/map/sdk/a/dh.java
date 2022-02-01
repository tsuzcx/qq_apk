package com.tencent.map.sdk.a;

public final class dh
{
  public static String a(String... paramVarArgs)
  {
    Object localObject = "";
    if (paramVarArgs != null)
    {
      String str = "category=";
      int i = 0;
      localObject = str;
      if (i < paramVarArgs.length)
      {
        if (i == 0) {}
        for (str = str + paramVarArgs[i];; str = str + "," + paramVarArgs[i])
        {
          i += 1;
          break;
        }
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.dh
 * JD-Core Version:    0.7.0.1
 */