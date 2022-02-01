import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class appl
  extends aptq<appm>
{
  private static boolean a;
  private static boolean b;
  
  public static boolean a()
  {
    appm localappm = (appm)apub.a().a(579);
    if ((localappm != null) && (!TextUtils.isEmpty(localappm.a))) {
      a = "1".equals(localappm.a);
    }
    return a;
  }
  
  public static boolean b()
  {
    appm localappm = (appm)apub.a().a(579);
    if ((localappm != null) && (!TextUtils.isEmpty(localappm.b))) {
      b = "1".equals(localappm.b);
    }
    return b;
  }
  
  @NonNull
  public appm a(int paramInt)
  {
    return new appm();
  }
  
  public appm a(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("IsImageImmersiveEnable");
      localObject = ((JSONObject)localObject).optString("IsVideoImmersiveEnable");
      if (QLog.isColorLevel()) {
        QLog.e("ImmersiveConfProcessor", 2, "ImmersiveConfBean, isImgEnable:" + paramString + ", isVdoEnable:" + (String)localObject);
      }
      paramString = new appm(paramString.trim(), ((String)localObject).trim());
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  @Nullable
  public appm a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      appm localappm = a(paramArrayOfaptx[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ImmersiveConfProcessor", 2, "onParsed " + paramArrayOfaptx[0].a);
      }
      return localappm;
    }
    return new appm();
  }
  
  public void a(appm paramappm)
  {
    if (paramappm != null)
    {
      if (TextUtils.isEmpty(paramappm.a)) {
        a = "1".equals(paramappm.a);
      }
      if (TextUtils.isEmpty(paramappm.b)) {
        b = "1".equals(paramappm.b);
      }
    }
  }
  
  public Class<appm> clazz()
  {
    return appm.class;
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
 * Qualified Name:     appl
 * JD-Core Version:    0.7.0.1
 */