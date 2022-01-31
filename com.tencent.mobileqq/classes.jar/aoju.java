import com.tencent.common.config.AppSetting;

public class aoju
{
  public static int a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    String str;
    do
    {
      return -1;
      paramString = b(paramString);
      str = bdqa.a("RESPCONDITION", paramString);
      if (bdqa.a("RESPCONTENTTYPES", paramString).equals("PRELOAD")) {
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
  
  public static aozp a(String paramString)
  {
    aozp localaozp = new aozp();
    paramString = b(paramString);
    localaozp.a = bdqa.a(bdqa.a("DESC", paramString));
    localaozp.b = bdqa.a(bdqa.a("SUBJECT", paramString));
    localaozp.c = bdqa.a("RESPCONDITION", paramString);
    if ((!localaozp.c.equals("MANUAL")) && (!localaozp.c.equals("AUTO")) && (!localaozp.c.equals("SEMIAUTO"))) {
      return null;
    }
    localaozp.d = bdqa.a("RESPDESC", paramString);
    localaozp.e = bdqa.a("RESPCONTENTTYPES", paramString);
    localaozp.f = bdqa.a("RESPDEST", paramString);
    localaozp.g = bdqa.a("RESPCONTENTS", paramString);
    localaozp.d = bdqa.a(localaozp.d);
    localaozp.f = bdqa.a(localaozp.f).trim();
    localaozp.g = bdqa.a(localaozp.g);
    return localaozp;
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    return bdqa.a("RESPCONTENTTYPES", paramString);
  }
  
  public static aozp b(String paramString)
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
    return bdqa.a(bdqa.a(paramString, 0, "||QQNO||", aokb.a()), 0, "||LICENCE||", AppSetting.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoju
 * JD-Core Version:    0.7.0.1
 */