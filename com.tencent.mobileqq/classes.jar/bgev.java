import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import java.io.File;

class bgev
  implements ModuleDownloadListener
{
  bgev(bget parambget) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString) {}
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("pictureMarkerSo.zip")) {}
    do
    {
      return;
      localObject = bget.a.getPath();
      paramString = new File(QzoneModuleManager.getInstance().getModuleFilePath(paramString));
    } while (!paramString.exists());
    Object localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    bgfb.b(paramString, (File)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgev
 * JD-Core Version:    0.7.0.1
 */