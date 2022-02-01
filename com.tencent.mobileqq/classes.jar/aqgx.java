import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqgx
  extends aqkz<aqgy>
{
  private static boolean a;
  
  public static boolean a()
  {
    aqgy localaqgy = (aqgy)aqlk.a().a(576);
    if ((localaqgy != null) && (!TextUtils.isEmpty(localaqgy.a))) {
      a = "1".equals(localaqgy.a);
    }
    return a;
  }
  
  @NonNull
  public aqgy a(int paramInt)
  {
    return new aqgy();
  }
  
  public aqgy a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("IsDanmuEnable");
      if (QLog.isColorLevel()) {
        QLog.e("DanmuConfProcessor", 2, "parse conf, IsDanmuEnable:" + paramString);
      }
      paramString = new aqgy(paramString.trim());
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  @Nullable
  public aqgy a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      aqgy localaqgy = a(paramArrayOfaqlg[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("DanmuConfProcessor", 2, "onParsed " + paramArrayOfaqlg[0].a);
      }
      return localaqgy;
    }
    return new aqgy();
  }
  
  public void a(aqgy paramaqgy)
  {
    if ((paramaqgy != null) && (!TextUtils.isEmpty(paramaqgy.a)))
    {
      a = "1".equals(paramaqgy.a);
      if (QLog.isColorLevel()) {
        QLog.e("DanmuConfProcessor", 2, "onUpdate, isDanmuEnable:" + a);
      }
    }
  }
  
  public Class<aqgy> clazz()
  {
    return aqgy.class;
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
 * Qualified Name:     aqgx
 * JD-Core Version:    0.7.0.1
 */