import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aoqy
{
  private int a = 1;
  
  @NonNull
  public static aoqy a()
  {
    return new aoqy();
  }
  
  @NonNull
  public static aoqy a(@Nullable String paramString)
  {
    aoqy localaoqy = new aoqy();
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        localaoqy.a = new JSONObject(paramString).getInt("use_apm");
      }
      if (QLog.isColorLevel()) {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, " : " + localaoqy.toString());
      }
      return localaoqy;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, "json parse error:" + paramString);
      }
    }
  }
  
  public String toString()
  {
    return "QVipPerfLevelConfig{use_apm=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoqy
 * JD-Core Version:    0.7.0.1
 */