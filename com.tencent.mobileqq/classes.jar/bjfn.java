import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class bjfn
  implements EIPCResultCallback
{
  bjfn(bjfl parambjfl) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "startFontSoDownload download so success");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjfn
 * JD-Core Version:    0.7.0.1
 */