import android.text.TextUtils;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;

class bkce
  extends ajdz
{
  private bkce(bkcc parambkcc) {}
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if ((paramBoolean) && (arof.a(this.c)))
    {
      String str = QzoneZipCacheHelper.getBasePath("qboss_banner", String.valueOf(this.a.f.hashCode()));
      File localFile = new File(this.c);
      QzoneZipCacheHelper.unzipFile(localFile.getAbsolutePath(), str);
      if (localFile.exists()) {
        arof.a(localFile);
      }
      this.c = str;
      if (QZLog.isColorLevel()) {
        QZLog.i("QbossADBannerConfigInfo", 2, "zip success = pathDir = " + str);
      }
    }
  }
  
  public boolean a()
  {
    if ((TextUtils.isEmpty(this.c)) || (TextUtils.isEmpty(this.a.f))) {}
    String str;
    Object localObject;
    do
    {
      do
      {
        return false;
        str = QzoneZipCacheHelper.getBasePath("qboss_banner", String.valueOf(this.a.f.hashCode()));
        localObject = new File(str);
      } while ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()));
      localObject = ((File)localObject).listFiles();
    } while ((localObject == null) || (localObject.length <= 0));
    this.c = str;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkce
 * JD-Core Version:    0.7.0.1
 */