import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aogn
  extends aokh<aogo>
{
  private static boolean a;
  
  public static boolean e()
  {
    aogo localaogo = (aogo)aoks.a().a(576);
    if ((localaogo != null) && (!TextUtils.isEmpty(localaogo.a))) {
      a = "1".equals(localaogo.a);
    }
    return a;
  }
  
  public int a()
  {
    return 576;
  }
  
  @NonNull
  public aogo a(int paramInt)
  {
    return new aogo();
  }
  
  public aogo a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("IsDanmuEnable");
      if (QLog.isColorLevel()) {
        QLog.e("DanmuConfProcessor", 2, "parse conf, IsDanmuEnable:" + paramString);
      }
      paramString = new aogo(paramString.trim());
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  @Nullable
  public aogo a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      aogo localaogo = a(paramArrayOfaoko[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("DanmuConfProcessor", 2, "onParsed " + paramArrayOfaoko[0].a);
      }
      return localaogo;
    }
    return new aogo();
  }
  
  public Class<aogo> a()
  {
    return aogo.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aogo paramaogo)
  {
    if ((paramaogo != null) && (!TextUtils.isEmpty(paramaogo.a)))
    {
      a = "1".equals(paramaogo.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aogn
 * JD-Core Version:    0.7.0.1
 */