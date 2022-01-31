import com.tencent.common.config.AppSetting;

public class amoo
{
  public static int a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    String str;
    do
    {
      return -1;
      paramString = b(paramString);
      str = bbmj.a("RESPCONDITION", paramString);
      if (bbmj.a("RESPCONTENTTYPES", paramString).equals("PRELOAD")) {
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
  
  public static andu a(String paramString)
  {
    andu localandu = new andu();
    paramString = b(paramString);
    localandu.a = bbmj.a(bbmj.a("DESC", paramString));
    localandu.b = bbmj.a(bbmj.a("SUBJECT", paramString));
    localandu.c = bbmj.a("RESPCONDITION", paramString);
    if ((!localandu.c.equals("MANUAL")) && (!localandu.c.equals("AUTO")) && (!localandu.c.equals("SEMIAUTO"))) {
      return null;
    }
    localandu.d = bbmj.a("RESPDESC", paramString);
    localandu.e = bbmj.a("RESPCONTENTTYPES", paramString);
    localandu.f = bbmj.a("RESPDEST", paramString);
    localandu.g = bbmj.a("RESPCONTENTS", paramString);
    localandu.d = bbmj.a(localandu.d);
    localandu.f = bbmj.a(localandu.f).trim();
    localandu.g = bbmj.a(localandu.g);
    return localandu;
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    return bbmj.a("RESPCONTENTTYPES", paramString);
  }
  
  public static andu b(String paramString)
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
    return bbmj.a(bbmj.a(paramString, 0, "||QQNO||", amov.a()), 0, "||LICENCE||", AppSetting.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amoo
 * JD-Core Version:    0.7.0.1
 */