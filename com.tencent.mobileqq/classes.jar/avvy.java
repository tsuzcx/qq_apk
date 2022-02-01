import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public abstract class avvy
{
  public String a = "MsgBackup." + getClass().getSimpleName();
  
  public void a(String paramString)
  {
    if (avwu.a) {
      QLog.d(this.a, 2, paramString);
    }
  }
  
  protected boolean a(String paramString)
  {
    return FileUtils.fileExists(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avvy
 * JD-Core Version:    0.7.0.1
 */