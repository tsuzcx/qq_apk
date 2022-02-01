import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqwa
  extends arac<aqwb>
{
  private static boolean a;
  
  public static boolean a()
  {
    aqwb localaqwb = (aqwb)aran.a().a(576);
    if ((localaqwb != null) && (!TextUtils.isEmpty(localaqwb.a))) {
      a = "1".equals(localaqwb.a);
    }
    return a;
  }
  
  @NonNull
  public aqwb a(int paramInt)
  {
    return new aqwb();
  }
  
  public aqwb a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("IsDanmuEnable");
      if (QLog.isColorLevel()) {
        QLog.e("DanmuConfProcessor", 2, "parse conf, IsDanmuEnable:" + paramString);
      }
      paramString = new aqwb(paramString.trim());
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  @Nullable
  public aqwb a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      aqwb localaqwb = a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("DanmuConfProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localaqwb;
    }
    return new aqwb();
  }
  
  public void a(aqwb paramaqwb)
  {
    if ((paramaqwb != null) && (!TextUtils.isEmpty(paramaqwb.a)))
    {
      a = "1".equals(paramaqwb.a);
      if (QLog.isColorLevel()) {
        QLog.e("DanmuConfProcessor", 2, "onUpdate, isDanmuEnable:" + a);
      }
    }
  }
  
  public Class<aqwb> clazz()
  {
    return aqwb.class;
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
 * Qualified Name:     aqwa
 * JD-Core Version:    0.7.0.1
 */