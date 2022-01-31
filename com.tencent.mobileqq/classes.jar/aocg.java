import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aocg
  extends aofy<aoch>
{
  private static boolean a;
  private static boolean b;
  
  public static boolean e()
  {
    aoch localaoch = (aoch)aogj.a().a(579);
    if ((localaoch != null) && (!TextUtils.isEmpty(localaoch.a))) {
      a = "1".equals(localaoch.a);
    }
    return a;
  }
  
  public static boolean f()
  {
    aoch localaoch = (aoch)aogj.a().a(579);
    if ((localaoch != null) && (!TextUtils.isEmpty(localaoch.b))) {
      b = "1".equals(localaoch.b);
    }
    return b;
  }
  
  public int a()
  {
    return 579;
  }
  
  @NonNull
  public aoch a(int paramInt)
  {
    return new aoch();
  }
  
  public aoch a(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("IsImageImmersiveEnable");
      localObject = ((JSONObject)localObject).optString("IsVideoImmersiveEnable");
      if (QLog.isColorLevel()) {
        QLog.e("ImmersiveConfProcessor", 2, "ImmersiveConfBean, isImgEnable:" + paramString + ", isVdoEnable:" + (String)localObject);
      }
      paramString = new aoch(paramString.trim(), ((String)localObject).trim());
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  @Nullable
  public aoch a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      aoch localaoch = a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ImmersiveConfProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      }
      return localaoch;
    }
    return new aoch();
  }
  
  public Class<aoch> a()
  {
    return aoch.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aoch paramaoch)
  {
    if (paramaoch != null)
    {
      if (TextUtils.isEmpty(paramaoch.a)) {
        a = "1".equals(paramaoch.a);
      }
      if (TextUtils.isEmpty(paramaoch.b)) {
        b = "1".equals(paramaoch.b);
      }
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aocg
 * JD-Core Version:    0.7.0.1
 */