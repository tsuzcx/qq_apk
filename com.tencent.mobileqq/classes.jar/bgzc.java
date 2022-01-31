import android.content.SharedPreferences;
import com.tencent.qqmini.sdk.manager.EngineVersion;
import com.tencent.qqmini.sdk.utils.StorageUtil;

public class bgzc
{
  private String a;
  
  private static String a(String paramString1, String paramString2)
  {
    boolean bool1 = bgvs.a().c(paramString1);
    boolean bool2 = bgvs.a().c(paramString2);
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
      this.a = paramEngineVersion.b.replace("/", "");
    }
  }
  
  public String a()
  {
    String str1 = StorageUtil.getPreference().getString("downloadUrl", "mini");
    String str2 = StorageUtil.getPreference().getString("version", "1.14.0.00225");
    str1 = bgvs.a().b(str1, str2);
    str2 = bgvs.a().b("mini", "1.14.0.00225");
    String str3 = a(null, a(str1, str2));
    if (str3 != null) {
      a(EngineVersion.a(str3));
    }
    bhaj.a().i("GameLibVersionManager", "[MiniEng]getBaseEnginePath, appBaseLibPath:" + str1);
    bhaj.a().i("GameLibVersionManager", "[MiniEng]getBaseEnginePath, innerBaseLibPath:" + str2);
    bhaj.a().i("GameLibVersionManager", "[MiniEng]getBaseEnginePath, gameBaseLibPath:" + null);
    bhaj.a().i("GameLibVersionManager", "[MiniEng]getBaseEnginePath, [本次启动使用的小游戏基础库版本]retPath:" + str3);
    return str3;
  }
  
  public String b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgzc
 * JD-Core Version:    0.7.0.1
 */