import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqgz
  extends aqkz<aqha>
{
  private static boolean a;
  private static boolean b;
  
  public static boolean a()
  {
    aqha localaqha = (aqha)aqlk.a().a(579);
    if ((localaqha != null) && (!TextUtils.isEmpty(localaqha.a))) {
      a = "1".equals(localaqha.a);
    }
    return a;
  }
  
  public static boolean b()
  {
    aqha localaqha = (aqha)aqlk.a().a(579);
    if ((localaqha != null) && (!TextUtils.isEmpty(localaqha.b))) {
      b = "1".equals(localaqha.b);
    }
    return b;
  }
  
  @NonNull
  public aqha a(int paramInt)
  {
    return new aqha();
  }
  
  public aqha a(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("IsImageImmersiveEnable");
      localObject = ((JSONObject)localObject).optString("IsVideoImmersiveEnable");
      if (QLog.isColorLevel()) {
        QLog.e("ImmersiveConfProcessor", 2, "ImmersiveConfBean, isImgEnable:" + paramString + ", isVdoEnable:" + (String)localObject);
      }
      paramString = new aqha(paramString.trim(), ((String)localObject).trim());
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  @Nullable
  public aqha a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      aqha localaqha = a(paramArrayOfaqlg[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ImmersiveConfProcessor", 2, "onParsed " + paramArrayOfaqlg[0].a);
      }
      return localaqha;
    }
    return new aqha();
  }
  
  public void a(aqha paramaqha)
  {
    if (paramaqha != null)
    {
      if (TextUtils.isEmpty(paramaqha.a)) {
        a = "1".equals(paramaqha.a);
      }
      if (TextUtils.isEmpty(paramaqha.b)) {
        b = "1".equals(paramaqha.b);
      }
    }
  }
  
  public Class<aqha> clazz()
  {
    return aqha.class;
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
 * Qualified Name:     aqgz
 * JD-Core Version:    0.7.0.1
 */