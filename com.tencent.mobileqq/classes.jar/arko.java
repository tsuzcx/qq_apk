import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arko
{
  private int a = 1;
  
  @NonNull
  public static arko a()
  {
    return new arko();
  }
  
  @NonNull
  public static arko a(@Nullable String paramString)
  {
    arko localarko = new arko();
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        localarko.a = new JSONObject(paramString).getInt("use_apm");
      }
      if (QLog.isColorLevel()) {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, " : " + localarko.toString());
      }
      return localarko;
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
 * Qualified Name:     arko
 * JD-Core Version:    0.7.0.1
 */