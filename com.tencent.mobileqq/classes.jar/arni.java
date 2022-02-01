import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arni
{
  private int a = 1;
  
  @NonNull
  public static arni a()
  {
    return new arni();
  }
  
  @NonNull
  public static arni a(@Nullable String paramString)
  {
    arni localarni = new arni();
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        localarni.a = new JSONObject(paramString).getInt("use_apm");
      }
      if (QLog.isColorLevel()) {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, " : " + localarni.toString());
      }
      return localarni;
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
 * Qualified Name:     arni
 * JD-Core Version:    0.7.0.1
 */