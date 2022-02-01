import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import java.io.File;

class bnjg
  implements ModuleDownloadListener
{
  bnjg(bnje parambnje) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString) {}
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("pictureMarkerSo.zip")) {}
    do
    {
      return;
      localObject = bnje.a.getPath();
      paramString = new File(QzoneModuleManager.getInstance().getModuleFilePath(paramString));
    } while (!paramString.exists());
    Object localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    bnjl.b(paramString, (File)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnjg
 * JD-Core Version:    0.7.0.1
 */