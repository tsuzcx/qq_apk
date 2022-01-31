import com.tencent.qphone.base.util.QLog;
import java.io.File;

class binc
  implements bime
{
  binc(bina parambina) {}
  
  public void a(File paramFile1, File paramFile2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "dex2Oat onStart " + paramFile1.getAbsolutePath() + " o" + paramFile2.getAbsolutePath());
    }
  }
  
  public void a(File paramFile1, File paramFile2, File paramFile3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "dex2Oat onSuccess " + paramFile1.getAbsolutePath() + " o" + paramFile2.getAbsolutePath());
    }
  }
  
  public void a(File paramFile1, File paramFile2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "preDex2Oat onFailed " + paramFile1.getAbsolutePath() + " o" + paramFile2.getAbsolutePath());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     binc
 * JD-Core Version:    0.7.0.1
 */