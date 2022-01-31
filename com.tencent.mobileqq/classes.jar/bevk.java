import android.content.SharedPreferences;
import com.tencent.qqmini.sdk.manager.EngineVersion;
import com.tencent.qqmini.sdk.minigame.GameRuntimeLoader;

public class bevk
{
  private static volatile bevk jdField_a_of_type_Bevk;
  private String jdField_a_of_type_JavaLangString;
  
  public static bevk a()
  {
    if (jdField_a_of_type_Bevk == null) {}
    try
    {
      if (jdField_a_of_type_Bevk == null) {
        jdField_a_of_type_Bevk = new bevk();
      }
      return jdField_a_of_type_Bevk;
    }
    finally {}
  }
  
  private static String a(String paramString1, String paramString2)
  {
    boolean bool1 = besn.a().c(paramString1);
    boolean bool2 = besn.a().c(paramString2);
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
    String str1 = bfgv.a().getString("downloadUrl", "mini");
    String str2 = bfgv.a().getString("version", "1.12.1.00001");
    str2 = besn.a().b(str1, str2);
    String str3 = besn.a().b("mini", "1.12.1.00001");
    str1 = null;
    if ((bepo.a().a() instanceof GameRuntimeLoader)) {
      str1 = ((GameRuntimeLoader)bepo.a().a()).getBaseEnginePath();
    }
    str1 = a(str1, a(str2, str3));
    if (str1 != null) {
      a(EngineVersion.a(str1));
    }
    bewt.a().i("GameLibVersionManager", "[MiniEng]getBaseEnginePath, [本次启动使用的小游戏基础库版本]retPath:" + str1);
    return str1;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bevk
 * JD-Core Version:    0.7.0.1
 */