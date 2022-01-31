import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.api.ITPModuleLoader;
import org.jetbrains.annotations.NotNull;

class bbvv
  implements ITPModuleLoader
{
  bbvv(bbvt parambbvt) {}
  
  public void loadLibrary(@NotNull String paramString1, @NotNull String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[VideoPlatForm]VideoPlaySDKManager", 2, "loadLibrary, libName = " + paramString1 + " , apkSoVer = " + paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbvv
 * JD-Core Version:    0.7.0.1
 */