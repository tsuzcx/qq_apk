import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqsn
  extends aqwt<aqso>
{
  private static boolean a;
  
  public static boolean a()
  {
    aqso localaqso = (aqso)aqxe.a().a(576);
    if ((localaqso != null) && (!TextUtils.isEmpty(localaqso.a))) {
      a = "1".equals(localaqso.a);
    }
    return a;
  }
  
  @NonNull
  public aqso a(int paramInt)
  {
    return new aqso();
  }
  
  public aqso a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("IsDanmuEnable");
      if (QLog.isColorLevel()) {
        QLog.e("DanmuConfProcessor", 2, "parse conf, IsDanmuEnable:" + paramString);
      }
      paramString = new aqso(paramString.trim());
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  @Nullable
  public aqso a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      aqso localaqso = a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("DanmuConfProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localaqso;
    }
    return new aqso();
  }
  
  public void a(aqso paramaqso)
  {
    if ((paramaqso != null) && (!TextUtils.isEmpty(paramaqso.a)))
    {
      a = "1".equals(paramaqso.a);
      if (QLog.isColorLevel()) {
        QLog.e("DanmuConfProcessor", 2, "onUpdate, isDanmuEnable:" + a);
      }
    }
  }
  
  public Class<aqso> clazz()
  {
    return aqso.class;
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
 * Qualified Name:     aqsn
 * JD-Core Version:    0.7.0.1
 */