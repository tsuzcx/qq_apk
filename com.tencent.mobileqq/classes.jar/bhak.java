import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.sdk.ITSoLoader;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.manager.InstalledEngine;
import java.io.File;

public class bhak
  implements ITSoLoader
{
  private InstalledEngine jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine;
  private String jdField_a_of_type_JavaLangString;
  
  public bhak(InstalledEngine paramInstalledEngine)
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
    if ((!TextUtils.isEmpty(str)) && (new File(str, paramString).exists())) {}
    for (boolean bool = true;; bool = false)
    {
      bhaj.a().i("GameSoLoader", "[MiniEng] load so [" + paramString + "] from " + this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine + ", isSoFileExits = " + bool);
      if (!bool)
      {
        MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
        if ((!TextUtils.isEmpty(localMiniAppProxy.getSoPath())) && (new File(localMiniAppProxy.getSoPath(), paramString).exists()))
        {
          str = localMiniAppProxy.getSoPath();
          bool = true;
          bhaj.a().i("GameSoLoader", "[MiniEng] load so [" + paramString + "] from " + localMiniAppProxy.getSoPath() + ", isSoFileExits = " + bool);
        }
      }
      for (;;)
      {
        if (!bool)
        {
          if (paramString.contains("png-armeabi-v7a"))
          {
            paramString = AppLoaderFactory.g().getMiniAppEnv().getContext().getFilesDir().getParent() + "/txlib/libpng-armeabi-v7a.so";
            if (new File(paramString).exists()) {
              return paramString;
            }
            return null;
          }
          return null;
        }
        return str + "/" + paramString;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhak
 * JD-Core Version:    0.7.0.1
 */