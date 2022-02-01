import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqhg
{
  private int a = 1;
  
  @NonNull
  public static aqhg a()
  {
    return new aqhg();
  }
  
  @NonNull
  public static aqhg a(@Nullable String paramString)
  {
    aqhg localaqhg = new aqhg();
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        localaqhg.a = new JSONObject(paramString).getInt("use_apm");
      }
      if (QLog.isColorLevel()) {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, " : " + localaqhg.toString());
      }
      return localaqhg;
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
 * Qualified Name:     aqhg
 * JD-Core Version:    0.7.0.1
 */