import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public abstract class axca
{
  public String a = "MsgBackup." + getClass().getSimpleName();
  
  public void a(String paramString)
  {
    if (axcw.a) {
      QLog.d(this.a, 2, paramString);
    }
  }
  
  protected boolean a(String paramString)
  {
    return FileUtils.fileExists(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axca
 * JD-Core Version:    0.7.0.1
 */