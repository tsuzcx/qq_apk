import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.utils.httputils.PkgTools;

public class aqwd
{
  public static int a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    String str;
    do
    {
      return -1;
      paramString = b(paramString);
      str = PkgTools.GetParaVal("RESPCONDITION", paramString);
      if (PkgTools.GetParaVal("RESPCONTENTTYPES", paramString).equals("PRELOAD")) {
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
  
  public static arpn a(String paramString)
  {
    arpn localarpn = new arpn();
    paramString = b(paramString);
    localarpn.a = PkgTools.Decodecgi(PkgTools.GetParaVal("DESC", paramString));
    localarpn.b = PkgTools.Decodecgi(PkgTools.GetParaVal("SUBJECT", paramString));
    localarpn.c = PkgTools.GetParaVal("RESPCONDITION", paramString);
    if ((!localarpn.c.equals("MANUAL")) && (!localarpn.c.equals("AUTO")) && (!localarpn.c.equals("SEMIAUTO"))) {
      return null;
    }
    localarpn.d = PkgTools.GetParaVal("RESPDESC", paramString);
    localarpn.e = PkgTools.GetParaVal("RESPCONTENTTYPES", paramString);
    localarpn.f = PkgTools.GetParaVal("RESPDEST", paramString);
    localarpn.g = PkgTools.GetParaVal("RESPCONTENTS", paramString);
    localarpn.d = PkgTools.Decodecgi(localarpn.d);
    localarpn.f = PkgTools.Decodecgi(localarpn.f).trim();
    localarpn.g = PkgTools.Decodecgi(localarpn.g);
    return localarpn;
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    return PkgTools.GetParaVal("RESPCONTENTTYPES", paramString);
  }
  
  public static arpn b(String paramString)
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
    return PkgTools.replace(PkgTools.replace(paramString, 0, "||QQNO||", aqwk.a()), 0, "||LICENCE||", AppSetting.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqwd
 * JD-Core Version:    0.7.0.1
 */