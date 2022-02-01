import com.tencent.common.config.AppSetting;

public class aqkm
{
  public static int a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    String str;
    do
    {
      return -1;
      paramString = b(paramString);
      str = bgva.a("RESPCONDITION", paramString);
      if (bgva.a("RESPCONTENTTYPES", paramString).equals("PRELOAD")) {
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
  
  public static arcp a(String paramString)
  {
    arcp localarcp = new arcp();
    paramString = b(paramString);
    localarcp.a = bgva.a(bgva.a("DESC", paramString));
    localarcp.b = bgva.a(bgva.a("SUBJECT", paramString));
    localarcp.c = bgva.a("RESPCONDITION", paramString);
    if ((!localarcp.c.equals("MANUAL")) && (!localarcp.c.equals("AUTO")) && (!localarcp.c.equals("SEMIAUTO"))) {
      return null;
    }
    localarcp.d = bgva.a("RESPDESC", paramString);
    localarcp.e = bgva.a("RESPCONTENTTYPES", paramString);
    localarcp.f = bgva.a("RESPDEST", paramString);
    localarcp.g = bgva.a("RESPCONTENTS", paramString);
    localarcp.d = bgva.a(localarcp.d);
    localarcp.f = bgva.a(localarcp.f).trim();
    localarcp.g = bgva.a(localarcp.g);
    return localarcp;
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    return bgva.a("RESPCONTENTTYPES", paramString);
  }
  
  public static arcp b(String paramString)
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
    return bgva.a(bgva.a(paramString, 0, "||QQNO||", aqkt.a()), 0, "||LICENCE||", AppSetting.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqkm
 * JD-Core Version:    0.7.0.1
 */