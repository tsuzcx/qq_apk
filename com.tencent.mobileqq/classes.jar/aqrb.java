import android.app.Activity;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class aqrb
{
  public static boolean a;
  public Activity a;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  private aqrb(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public static boolean a(Activity paramActivity, String paramString, Bundle paramBundle)
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL]. >>>gotoDownload. url:" + paramString);
    if ((paramActivity == null) || (paramString == null) || (paramBundle == null))
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL]. gotoDownload. param error:");
      return false;
    }
    new aqrb(paramActivity).a(paramString, paramBundle);
    return true;
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    arpg.a(paramString, new aqrc(this, paramBundle, paramString, paramBundle.getLong("_filesize"), paramBundle.getLong("_buttontype", 0L)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqrb
 * JD-Core Version:    0.7.0.1
 */