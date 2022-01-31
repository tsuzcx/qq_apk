import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amlh
  extends ampb<amli>
{
  private static boolean a;
  
  public static boolean e()
  {
    amli localamli = (amli)ampm.a().a(576);
    if ((localamli != null) && (!TextUtils.isEmpty(localamli.a))) {
      a = "1".equals(localamli.a);
    }
    return a;
  }
  
  public int a()
  {
    return 576;
  }
  
  @NonNull
  public amli a(int paramInt)
  {
    return new amli();
  }
  
  public amli a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("IsDanmuEnable");
      if (QLog.isColorLevel()) {
        QLog.e("DanmuConfProcessor", 2, "parse conf, IsDanmuEnable:" + paramString);
      }
      paramString = new amli(paramString.trim());
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  @Nullable
  public amli a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      amli localamli = a(paramArrayOfampi[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("DanmuConfProcessor", 2, "onParsed " + paramArrayOfampi[0].a);
      }
      return localamli;
    }
    return new amli();
  }
  
  public Class<amli> a()
  {
    return amli.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amli paramamli)
  {
    if ((paramamli != null) && (!TextUtils.isEmpty(paramamli.a)))
    {
      a = "1".equals(paramamli.a);
      if (QLog.isColorLevel()) {
        QLog.e("DanmuConfProcessor", 2, "onUpdate, isDanmuEnable:" + a);
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
 * Qualified Name:     amlh
 * JD-Core Version:    0.7.0.1
 */