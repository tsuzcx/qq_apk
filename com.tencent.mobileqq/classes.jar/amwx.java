import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.paster.QIMInformationPasterManager;
import dov.com.qq.im.capture.paster.QIMInformationPasterManager.IInformationPasterResDownloaderCallback;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage.Item;

public class amwx
  implements QIMInformationPasterManager.IInformationPasterResDownloaderCallback
{
  public amwx(QIMInformationPasterManager paramQIMInformationPasterManager) {}
  
  public void a(float paramFloat, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString, InfomationFacePackage.Item paramItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "preload:" + paramString + " item:" + paramItem.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amwx
 * JD-Core Version:    0.7.0.1
 */