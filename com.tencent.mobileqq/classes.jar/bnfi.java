import java.util.HashMap;

public class bnfi
{
  public static int a = 0;
  
  public static void a(int paramInt, String paramString1, String paramString2, HashMap<String, String> paramHashMap)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    String str1 = paramString2;
    String str2;
    String str3;
    if (paramHashMap != null)
    {
      str2 = (String)paramHashMap.get("cameraType");
      str3 = (String)paramHashMap.get("isTemplateMode");
      paramHashMap = (String)paramHashMap.get("templateId");
      if ((!String.valueOf(2).equals(str2)) || ((!String.valueOf(false).equals(str3)) && (paramHashMap != null))) {
        break label99;
      }
      str1 = "0X8007819";
    }
    for (;;)
    {
      a(paramString1, str1);
      return;
      label99:
      if ((String.valueOf(2).equals(str2)) && (String.valueOf(true).equals(str3)) && (paramHashMap != null))
      {
        str1 = "0X800781A";
      }
      else if ((String.valueOf(1).equals(str2)) && ((String.valueOf(false).equals(str3)) || (paramHashMap == null)))
      {
        str1 = "0X800781B";
      }
      else
      {
        str1 = paramString2;
        if (String.valueOf(1).equals(str2))
        {
          str1 = paramString2;
          if (String.valueOf(true).equals(str3))
          {
            str1 = paramString2;
            if (paramHashMap != null) {
              str1 = "0X800781C";
            }
          }
        }
      }
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, "");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    azqs.b(null, "dc00898", paramString1, "", paramString2, paramString2, a, 0, paramString3, "", "", "");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    azqs.b(null, "dc00898", paramString1, "", paramString2, paramString2, a, 0, paramString3, paramString4, paramString5, paramString6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnfi
 * JD-Core Version:    0.7.0.1
 */