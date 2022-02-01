import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class appj
  extends aptq<appk>
{
  private static boolean a;
  
  public static boolean a()
  {
    appk localappk = (appk)apub.a().a(576);
    if ((localappk != null) && (!TextUtils.isEmpty(localappk.a))) {
      a = "1".equals(localappk.a);
    }
    return a;
  }
  
  @NonNull
  public appk a(int paramInt)
  {
    return new appk();
  }
  
  public appk a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("IsDanmuEnable");
      if (QLog.isColorLevel()) {
        QLog.e("DanmuConfProcessor", 2, "parse conf, IsDanmuEnable:" + paramString);
      }
      paramString = new appk(paramString.trim());
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  @Nullable
  public appk a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      appk localappk = a(paramArrayOfaptx[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("DanmuConfProcessor", 2, "onParsed " + paramArrayOfaptx[0].a);
      }
      return localappk;
    }
    return new appk();
  }
  
  public void a(appk paramappk)
  {
    if ((paramappk != null) && (!TextUtils.isEmpty(paramappk.a)))
    {
      a = "1".equals(paramappk.a);
      if (QLog.isColorLevel()) {
        QLog.e("DanmuConfProcessor", 2, "onUpdate, isDanmuEnable:" + a);
      }
    }
  }
  
  public Class<appk> clazz()
  {
    return appk.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 576;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appj
 * JD-Core Version:    0.7.0.1
 */