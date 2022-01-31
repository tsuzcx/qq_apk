import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.font.FontManager;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class amuc
  implements EIPCResultCallback
{
  public amuc(FontManager paramFontManager) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "startFontSoDownload download so success");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amuc
 * JD-Core Version:    0.7.0.1
 */