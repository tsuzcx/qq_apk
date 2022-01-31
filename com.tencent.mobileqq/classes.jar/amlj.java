import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amlj
  extends ampb<amlk>
{
  private static boolean a;
  private static boolean b;
  
  public static boolean e()
  {
    amlk localamlk = (amlk)ampm.a().a(579);
    if ((localamlk != null) && (!TextUtils.isEmpty(localamlk.a))) {
      a = "1".equals(localamlk.a);
    }
    return a;
  }
  
  public static boolean f()
  {
    amlk localamlk = (amlk)ampm.a().a(579);
    if ((localamlk != null) && (!TextUtils.isEmpty(localamlk.b))) {
      b = "1".equals(localamlk.b);
    }
    return b;
  }
  
  public int a()
  {
    return 579;
  }
  
  @NonNull
  public amlk a(int paramInt)
  {
    return new amlk();
  }
  
  public amlk a(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("IsImageImmersiveEnable");
      localObject = ((JSONObject)localObject).optString("IsVideoImmersiveEnable");
      if (QLog.isColorLevel()) {
        QLog.e("ImmersiveConfProcessor", 2, "ImmersiveConfBean, isImgEnable:" + paramString + ", isVdoEnable:" + (String)localObject);
      }
      paramString = new amlk(paramString.trim(), ((String)localObject).trim());
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  @Nullable
  public amlk a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      amlk localamlk = a(paramArrayOfampi[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ImmersiveConfProcessor", 2, "onParsed " + paramArrayOfampi[0].a);
      }
      return localamlk;
    }
    return new amlk();
  }
  
  public Class<amlk> a()
  {
    return amlk.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amlk paramamlk)
  {
    if (paramamlk != null)
    {
      if (TextUtils.isEmpty(paramamlk.a)) {
        a = "1".equals(paramamlk.a);
      }
      if (TextUtils.isEmpty(paramamlk.b)) {
        b = "1".equals(paramamlk.b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amlj
 * JD-Core Version:    0.7.0.1
 */