import com.tencent.common.config.AppSetting;

public class amon
{
  public static int a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    String str;
    do
    {
      return -1;
      paramString = b(paramString);
      str = bbmx.a("RESPCONDITION", paramString);
      if (bbmx.a("RESPCONTENTTYPES", paramString).equals("PRELOAD")) {
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
  
  public static andz a(String paramString)
  {
    andz localandz = new andz();
    paramString = b(paramString);
    localandz.a = bbmx.a(bbmx.a("DESC", paramString));
    localandz.b = bbmx.a(bbmx.a("SUBJECT", paramString));
    localandz.c = bbmx.a("RESPCONDITION", paramString);
    if ((!localandz.c.equals("MANUAL")) && (!localandz.c.equals("AUTO")) && (!localandz.c.equals("SEMIAUTO"))) {
      return null;
    }
    localandz.d = bbmx.a("RESPDESC", paramString);
    localandz.e = bbmx.a("RESPCONTENTTYPES", paramString);
    localandz.f = bbmx.a("RESPDEST", paramString);
    localandz.g = bbmx.a("RESPCONTENTS", paramString);
    localandz.d = bbmx.a(localandz.d);
    localandz.f = bbmx.a(localandz.f).trim();
    localandz.g = bbmx.a(localandz.g);
    return localandz;
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    return bbmx.a("RESPCONTENTTYPES", paramString);
  }
  
  public static andz b(String paramString)
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
    return bbmx.a(bbmx.a(paramString, 0, "||QQNO||", amou.a()), 0, "||LICENCE||", AppSetting.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amon
 * JD-Core Version:    0.7.0.1
 */