package com.tencent.map.sdk.a;

public final class dh
{
  public static String a(String... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      int i = 0;
      String str = "category=";
      for (;;)
      {
        localObject = str;
        if (i >= paramVarArgs.length) {
          break;
        }
        if (i == 0)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(paramVarArgs[i]);
          str = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(paramVarArgs[i]);
          str = ((StringBuilder)localObject).toString();
        }
        i += 1;
      }
    }
    Object localObject = "";
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.dh
 * JD-Core Version:    0.7.0.1
 */