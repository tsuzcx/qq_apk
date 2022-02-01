import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqsp
  extends aqwt<aqsq>
{
  private static boolean a;
  private static boolean b;
  
  public static boolean a()
  {
    aqsq localaqsq = (aqsq)aqxe.a().a(579);
    if ((localaqsq != null) && (!TextUtils.isEmpty(localaqsq.a))) {
      a = "1".equals(localaqsq.a);
    }
    return a;
  }
  
  public static boolean b()
  {
    aqsq localaqsq = (aqsq)aqxe.a().a(579);
    if ((localaqsq != null) && (!TextUtils.isEmpty(localaqsq.b))) {
      b = "1".equals(localaqsq.b);
    }
    return b;
  }
  
  @NonNull
  public aqsq a(int paramInt)
  {
    return new aqsq();
  }
  
  public aqsq a(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("IsImageImmersiveEnable");
      localObject = ((JSONObject)localObject).optString("IsVideoImmersiveEnable");
      if (QLog.isColorLevel()) {
        QLog.e("ImmersiveConfProcessor", 2, "ImmersiveConfBean, isImgEnable:" + paramString + ", isVdoEnable:" + (String)localObject);
      }
      paramString = new aqsq(paramString.trim(), ((String)localObject).trim());
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  @Nullable
  public aqsq a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      aqsq localaqsq = a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ImmersiveConfProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localaqsq;
    }
    return new aqsq();
  }
  
  public void a(aqsq paramaqsq)
  {
    if (paramaqsq != null)
    {
      if (TextUtils.isEmpty(paramaqsq.a)) {
        a = "1".equals(paramaqsq.a);
      }
      if (TextUtils.isEmpty(paramaqsq.b)) {
        b = "1".equals(paramaqsq.b);
      }
    }
  }
  
  public Class<aqsq> clazz()
  {
    return aqsq.class;
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
 * Qualified Name:     aqsp
 * JD-Core Version:    0.7.0.1
 */