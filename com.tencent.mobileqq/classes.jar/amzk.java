import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amzk
{
  private int a = 1;
  
  @NonNull
  public static amzk a()
  {
    return new amzk();
  }
  
  @NonNull
  public static amzk a(@Nullable String paramString)
  {
    amzk localamzk = new amzk();
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        localamzk.a = new JSONObject(paramString).getInt("use_apm");
      }
      if (QLog.isColorLevel()) {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, " : " + localamzk.toString());
      }
      return localamzk;
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
 * Qualified Name:     amzk
 * JD-Core Version:    0.7.0.1
 */