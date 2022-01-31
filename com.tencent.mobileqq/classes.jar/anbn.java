import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.font.FontManager;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class anbn
  implements EIPCResultCallback
{
  public anbn(FontManager paramFontManager) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "startFontSoDownload download so success");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbn
 * JD-Core Version:    0.7.0.1
 */