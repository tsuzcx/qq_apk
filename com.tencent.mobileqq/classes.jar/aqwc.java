import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqwc
  extends arac<aqwd>
{
  private static boolean a;
  private static boolean b;
  
  public static boolean a()
  {
    aqwd localaqwd = (aqwd)aran.a().a(579);
    if ((localaqwd != null) && (!TextUtils.isEmpty(localaqwd.a))) {
      a = "1".equals(localaqwd.a);
    }
    return a;
  }
  
  public static boolean b()
  {
    aqwd localaqwd = (aqwd)aran.a().a(579);
    if ((localaqwd != null) && (!TextUtils.isEmpty(localaqwd.b))) {
      b = "1".equals(localaqwd.b);
    }
    return b;
  }
  
  @NonNull
  public aqwd a(int paramInt)
  {
    return new aqwd();
  }
  
  public aqwd a(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("IsImageImmersiveEnable");
      localObject = ((JSONObject)localObject).optString("IsVideoImmersiveEnable");
      if (QLog.isColorLevel()) {
        QLog.e("ImmersiveConfProcessor", 2, "ImmersiveConfBean, isImgEnable:" + paramString + ", isVdoEnable:" + (String)localObject);
      }
      paramString = new aqwd(paramString.trim(), ((String)localObject).trim());
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  @Nullable
  public aqwd a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      aqwd localaqwd = a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ImmersiveConfProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localaqwd;
    }
    return new aqwd();
  }
  
  public void a(aqwd paramaqwd)
  {
    if (paramaqwd != null)
    {
      if (TextUtils.isEmpty(paramaqwd.a)) {
        a = "1".equals(paramaqwd.a);
      }
      if (TextUtils.isEmpty(paramaqwd.b)) {
        b = "1".equals(paramaqwd.b);
      }
    }
  }
  
  public Class<aqwd> clazz()
  {
    return aqwd.class;
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
    return 579;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqwc
 * JD-Core Version:    0.7.0.1
 */