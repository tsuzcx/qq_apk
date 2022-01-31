import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amjg
{
  private int a = 1;
  
  @NonNull
  public static amjg a()
  {
    return new amjg();
  }
  
  @NonNull
  public static amjg a(@Nullable String paramString)
  {
    amjg localamjg = new amjg();
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        localamjg.a = new JSONObject(paramString).getInt("use_apm");
      }
      if (QLog.isColorLevel()) {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, " : " + localamjg.toString());
      }
      return localamjg;
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
 * Qualified Name:     amjg
 * JD-Core Version:    0.7.0.1
 */