import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public final class bmgj
{
  private static SharedPreferences b(Context paramContext)
  {
    return paramContext.getSharedPreferences("reader_user" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgj
 * JD-Core Version:    0.7.0.1
 */