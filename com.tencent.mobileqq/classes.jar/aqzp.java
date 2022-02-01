import com.tencent.common.config.AppSetting;

public class aqzp
{
  public static int a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    String str;
    do
    {
      return -1;
      paramString = b(paramString);
      str = bhvd.a("RESPCONDITION", paramString);
      if (bhvd.a("RESPCONTENTTYPES", paramString).equals("PRELOAD")) {
        return 3;
      }
      if (str.equals("MANUAL")) {
        return 0;
      }
      if (str.equals("AUTO")) {
        return 1;
      }
    } while (!str.equals("SEMIAUTO"));
    return 2;
  }
  
  public static arse a(String paramString)
  {
    arse localarse = new arse();
    paramString = b(paramString);
    localarse.a = bhvd.a(bhvd.a("DESC", paramString));
    localarse.b = bhvd.a(bhvd.a("SUBJECT", paramString));
    localarse.c = bhvd.a("RESPCONDITION", paramString);
    if ((!localarse.c.equals("MANUAL")) && (!localarse.c.equals("AUTO")) && (!localarse.c.equals("SEMIAUTO"))) {
      return null;
    }
    localarse.d = bhvd.a("RESPDESC", paramString);
    localarse.e = bhvd.a("RESPCONTENTTYPES", paramString);
    localarse.f = bhvd.a("RESPDEST", paramString);
    localarse.g = bhvd.a("RESPCONTENTS", paramString);
    localarse.d = bhvd.a(localarse.d);
    localarse.f = bhvd.a(localarse.f).trim();
    localarse.g = bhvd.a(localarse.g);
    return localarse;
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    return bhvd.a("RESPCONTENTTYPES", paramString);
  }
  
  public static arse b(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {}
    do
    {
      return paramString;
      if (paramString.c.equals("MANUAL"))
      {
        paramString.a(false);
        return paramString;
      }
      if (paramString.c.equals("AUTO"))
      {
        paramString.a();
        return paramString;
      }
    } while (!paramString.c.equals("SEMIAUTO"));
    paramString.a();
    return paramString;
  }
  
  private static String b(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "";
    }
    return bhvd.a(bhvd.a(paramString, 0, "||QQNO||", aqzw.a()), 0, "||LICENCE||", AppSetting.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqzp
 * JD-Core Version:    0.7.0.1
 */