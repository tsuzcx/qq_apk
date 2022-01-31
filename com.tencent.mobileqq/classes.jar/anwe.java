import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.CaptureComboText;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.IDynamicTextResDownloadCallback;

public class anwe
  implements DynamicTextConfigManager.IDynamicTextResDownloadCallback
{
  public anwe(CaptureComboText paramCaptureComboText) {}
  
  public void a(float paramFloat, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QComboDText", 2, "CaptureComboText onUpdateProgress, progress is : " + paramFloat);
    }
    CaptureComboText.a(this.a, paramFloat);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QComboDText", 2, "CaptureComboText onDownloadFinish, success: " + paramBoolean);
    }
    if (paramBoolean)
    {
      CaptureComboText.a(this.a, 3);
      this.a.b();
      return;
    }
    CaptureComboText.a(this.a, 2);
    this.a.a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anwe
 * JD-Core Version:    0.7.0.1
 */