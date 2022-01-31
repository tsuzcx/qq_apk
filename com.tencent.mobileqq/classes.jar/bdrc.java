import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.sdk.ITSoLoader;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.manager.InstalledEngine;
import java.io.File;

public class bdrc
  implements ITSoLoader
{
  private InstalledEngine jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine;
  private String jdField_a_of_type_JavaLangString;
  
  public bdrc(InstalledEngine paramInstalledEngine)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine = paramInstalledEngine;
    this.jdField_a_of_type_JavaLangString = a(this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine);
  }
  
  private String a(InstalledEngine paramInstalledEngine)
  {
    if ((paramInstalledEngine != null) && (paramInstalledEngine.a)) {
      return paramInstalledEngine.b;
    }
    return null;
  }
  
  public String getSoPath(String paramString)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str))
    {
      bool1 = bool2;
      if (new File(str, paramString).exists()) {
        bool1 = true;
      }
    }
    bdrb.a().i("GameSoLoader", "[MiniEng] load so [" + paramString + "] from " + this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine + ", isSoFileExits = " + bool1);
    if (!bool1)
    {
      if (paramString.contains("png-armeabi-v7a"))
      {
        paramString = MiniAppEnv.g().getContext().getFilesDir().getParent() + "/txlib/libpng-armeabi-v7a.so";
        if (new File(paramString).exists()) {
          return paramString;
        }
        return null;
      }
      return null;
    }
    return str + "/" + paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdrc
 * JD-Core Version:    0.7.0.1
 */