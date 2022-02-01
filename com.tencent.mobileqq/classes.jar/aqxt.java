import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqxt
{
  private int a = 1;
  
  @NonNull
  public static aqxt a()
  {
    return new aqxt();
  }
  
  @NonNull
  public static aqxt a(@Nullable String paramString)
  {
    aqxt localaqxt = new aqxt();
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        localaqxt.a = new JSONObject(paramString).getInt("use_apm");
      }
      if (QLog.isColorLevel()) {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, " : " + localaqxt.toString());
      }
      return localaqxt;
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
 * Qualified Name:     aqxt
 * JD-Core Version:    0.7.0.1
 */