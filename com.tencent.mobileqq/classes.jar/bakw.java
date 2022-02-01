import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qassistant.core.ViewCommandModelCheck.1;
import com.tencent.mobileqq.qassistant.core.ViewCommandModelCheck.2;
import mqq.os.MqqHandler;

public class bakw
{
  private static int a;
  
  public bakw()
  {
    b();
  }
  
  public static void a()
  {
    a += 1;
    ThreadManager.getFileThreadHandler().post(new ViewCommandModelCheck.2());
  }
  
  public static boolean a()
  {
    return a < 3;
  }
  
  private int b()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("view_command_count_file", 0).getInt("view_command_count", 0);
  }
  
  private void b()
  {
    ThreadManager.getFileThreadHandler().post(new ViewCommandModelCheck.1(this));
  }
  
  private static void b(int paramInt)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("view_command_count_file", 0).edit().putInt("view_command_count", paramInt).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bakw
 * JD-Core Version:    0.7.0.1
 */