import android.text.TextUtils;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;

class bnwm
  extends almn
{
  private bnwm(bnwk parambnwk) {}
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if ((paramBoolean) && (auog.a(this.c)))
    {
      String str = QzoneZipCacheHelper.getBasePath("qboss_banner", String.valueOf(this.a.h.hashCode()));
      File localFile = new File(this.c);
      QzoneZipCacheHelper.unzipFile(localFile.getAbsolutePath(), str);
      if (localFile.exists()) {
        auog.a(localFile);
      }
      this.c = str;
      if (QZLog.isColorLevel()) {
        QZLog.i("QbossADBannerConfigInfo", 2, "zip success = pathDir = " + str);
      }
    }
  }
  
  public boolean a()
  {
    if ((TextUtils.isEmpty(this.c)) || (TextUtils.isEmpty(this.a.h))) {}
    String str;
    Object localObject;
    do
    {
      do
      {
        return false;
        str = QzoneZipCacheHelper.getBasePath("qboss_banner", String.valueOf(this.a.h.hashCode()));
        localObject = new File(str);
      } while ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()));
      localObject = ((File)localObject).listFiles();
    } while ((localObject == null) || (localObject.length <= 0));
    this.c = str;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnwm
 * JD-Core Version:    0.7.0.1
 */