import com.tencent.qphone.base.util.QLog;
import com.tencent.tbs.one.TBSOneCallback;
import java.io.File;

class audl
  extends TBSOneCallback<File>
{
  audl(audj paramaudj) {}
  
  public void a(File paramFile)
  {
    QLog.i("LocalTbsViewManager<FileAssistant>", 1, "tbs reader engine download complete.");
    audj.a(this.a);
    bdll.b(null, "dc00898", "", "", "0X800B00A", "0X800B00A", 1, 0, "", "", "", "");
  }
  
  public void onError(int paramInt, String paramString)
  {
    QLog.i("LocalTbsViewManager<FileAssistant>", 1, "tbs reader engine download error. code[" + paramInt + "] msg[" + paramString + "]");
    bdll.b(null, "dc00898", "", "", "0X800B00A", "0X800B00A", 2, 0, "" + paramInt, "", "", "");
  }
  
  public void onProgressChanged(int paramInt1, int paramInt2)
  {
    QLog.i("LocalTbsViewManager<FileAssistant>", 1, "tbs progress: oldProgress[" + paramInt1 + "] newProgress[" + paramInt2 + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     audl
 * JD-Core Version:    0.7.0.1
 */