import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.util.SystemUtil;
import java.io.File;

public class auyr
{
  public static String a = new File(BaseApplicationImpl.getApplication().getFilesDir(), "ListenTogether_v828").getAbsolutePath();
  
  static
  {
    if (SystemUtil.isExistSDCard())
    {
      a = new File(AppConstants.SDCARD_PATH, "ListenTogether_v828").getAbsolutePath();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auyr
 * JD-Core Version:    0.7.0.1
 */