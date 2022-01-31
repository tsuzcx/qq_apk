import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public final class bixb
{
  private static SharedPreferences b(Context paramContext)
  {
    return paramContext.getSharedPreferences("reader_user" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bixb
 * JD-Core Version:    0.7.0.1
 */