import android.content.SharedPreferences;
import com.tencent.qqmini.sdk.manager.EngineVersion;
import com.tencent.qqmini.sdk.minigame.GameRuntimeLoader;

public class bewb
{
  private static volatile bewb jdField_a_of_type_Bewb;
  private String jdField_a_of_type_JavaLangString;
  
  public static bewb a()
  {
    if (jdField_a_of_type_Bewb == null) {}
    try
    {
      if (jdField_a_of_type_Bewb == null) {
        jdField_a_of_type_Bewb = new bewb();
      }
      return jdField_a_of_type_Bewb;
    }
    finally {}
  }
  
  private static String a(String paramString1, String paramString2)
  {
    boolean bool1 = bete.a().c(paramString1);
    boolean bool2 = bete.a().c(paramString2);
    if ((bool1) && (bool2))
    {
      localEngineVersion1 = EngineVersion.a(paramString1);
      localEngineVersion2 = EngineVersion.a(paramString2);
      if ((localEngineVersion1 != null) && (localEngineVersion2 != null)) {
        if (EngineVersion.a(localEngineVersion1.b, localEngineVersion2.b) < 0) {}
      }
    }
    while (bool1)
    {
      EngineVersion localEngineVersion1;
      EngineVersion localEngineVersion2;
      do
      {
        return paramString1;
        return paramString2;
      } while ((localEngineVersion1 != null) || (localEngineVersion2 == null));
      return paramString2;
    }
    if (bool2) {
      return paramString2;
    }
    return null;
  }
  
  private void a(EngineVersion paramEngineVersion)
  {
    if ((paramEngineVersion != null) && (paramEngineVersion.b != null)) {
      this.jdField_a_of_type_JavaLangString = paramEngineVersion.b.replace("/", "");
    }
  }
  
  public String a()
  {
    String str1 = bfhm.a().getString("downloadUrl", "mini");
    String str2 = bfhm.a().getString("version", "1.13.0.00013");
    str2 = bete.a().b(str1, str2);
    String str3 = bete.a().b("mini", "1.13.0.00013");
    str1 = null;
    if ((beqf.a().a() instanceof GameRuntimeLoader)) {
      str1 = ((GameRuntimeLoader)beqf.a().a()).getBaseEnginePath();
    }
    str1 = a(str1, a(str2, str3));
    if (str1 != null) {
      a(EngineVersion.a(str1));
    }
    bexk.a().i("GameLibVersionManager", "[MiniEng]getBaseEnginePath, [本次启动使用的小游戏基础库版本]retPath:" + str1);
    return str1;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bewb
 * JD-Core Version:    0.7.0.1
 */