import com.tencent.common.config.AppSetting;

public class aofl
{
  public static int a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    String str;
    do
    {
      return -1;
      paramString = b(paramString);
      str = bdlr.a("RESPCONDITION", paramString);
      if (bdlr.a("RESPCONTENTTYPES", paramString).equals("PRELOAD")) {
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
  
  public static aovg a(String paramString)
  {
    aovg localaovg = new aovg();
    paramString = b(paramString);
    localaovg.a = bdlr.a(bdlr.a("DESC", paramString));
    localaovg.b = bdlr.a(bdlr.a("SUBJECT", paramString));
    localaovg.c = bdlr.a("RESPCONDITION", paramString);
    if ((!localaovg.c.equals("MANUAL")) && (!localaovg.c.equals("AUTO")) && (!localaovg.c.equals("SEMIAUTO"))) {
      return null;
    }
    localaovg.d = bdlr.a("RESPDESC", paramString);
    localaovg.e = bdlr.a("RESPCONTENTTYPES", paramString);
    localaovg.f = bdlr.a("RESPDEST", paramString);
    localaovg.g = bdlr.a("RESPCONTENTS", paramString);
    localaovg.d = bdlr.a(localaovg.d);
    localaovg.f = bdlr.a(localaovg.f).trim();
    localaovg.g = bdlr.a(localaovg.g);
    return localaovg;
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    return bdlr.a("RESPCONTENTTYPES", paramString);
  }
  
  public static aovg b(String paramString)
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
    return bdlr.a(bdlr.a(paramString, 0, "||QQNO||", aofs.a()), 0, "||LICENCE||", AppSetting.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aofl
 * JD-Core Version:    0.7.0.1
 */