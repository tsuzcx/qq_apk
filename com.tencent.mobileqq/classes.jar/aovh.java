import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aovh
{
  private int a = 1;
  
  @NonNull
  public static aovh a()
  {
    return new aovh();
  }
  
  @NonNull
  public static aovh a(@Nullable String paramString)
  {
    aovh localaovh = new aovh();
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        localaovh.a = new JSONObject(paramString).getInt("use_apm");
      }
      if (QLog.isColorLevel()) {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, " : " + localaovh.toString());
      }
      return localaovh;
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
 * Qualified Name:     aovh
 * JD-Core Version:    0.7.0.1
 */