import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amzr
{
  private int a = 1;
  
  @NonNull
  public static amzr a()
  {
    return new amzr();
  }
  
  @NonNull
  public static amzr a(@Nullable String paramString)
  {
    amzr localamzr = new amzr();
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        localamzr.a = new JSONObject(paramString).getInt("use_apm");
      }
      if (QLog.isColorLevel()) {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, " : " + localamzr.toString());
      }
      return localamzr;
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
 * Qualified Name:     amzr
 * JD-Core Version:    0.7.0.1
 */