import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.utils.httputils.PkgTools;

public class apta
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
  
  public static aqmc a(String paramString)
  {
    aqmc localaqmc = new aqmc();
    paramString = b(paramString);
    localaqmc.a = PkgTools.Decodecgi(PkgTools.GetParaVal("DESC", paramString));
    localaqmc.b = PkgTools.Decodecgi(PkgTools.GetParaVal("SUBJECT", paramString));
    localaqmc.c = PkgTools.GetParaVal("RESPCONDITION", paramString);
    if ((!localaqmc.c.equals("MANUAL")) && (!localaqmc.c.equals("AUTO")) && (!localaqmc.c.equals("SEMIAUTO"))) {
      return null;
    }
    localaqmc.d = PkgTools.GetParaVal("RESPDESC", paramString);
    localaqmc.e = PkgTools.GetParaVal("RESPCONTENTTYPES", paramString);
    localaqmc.f = PkgTools.GetParaVal("RESPDEST", paramString);
    localaqmc.g = PkgTools.GetParaVal("RESPCONTENTS", paramString);
    localaqmc.d = PkgTools.Decodecgi(localaqmc.d);
    localaqmc.f = PkgTools.Decodecgi(localaqmc.f).trim();
    localaqmc.g = PkgTools.Decodecgi(localaqmc.g);
    return localaqmc;
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    return PkgTools.GetParaVal("RESPCONTENTTYPES", paramString);
  }
  
  public static aqmc b(String paramString)
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
    return PkgTools.replace(PkgTools.replace(paramString, 0, "||QQNO||", apth.a()), 0, "||LICENCE||", AppSetting.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apta
 * JD-Core Version:    0.7.0.1
 */