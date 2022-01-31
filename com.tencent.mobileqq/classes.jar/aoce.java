import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aoce
  extends aofy<aocf>
{
  private static boolean a;
  
  public static boolean e()
  {
    aocf localaocf = (aocf)aogj.a().a(576);
    if ((localaocf != null) && (!TextUtils.isEmpty(localaocf.a))) {
      a = "1".equals(localaocf.a);
    }
    return a;
  }
  
  public int a()
  {
    return 576;
  }
  
  @NonNull
  public aocf a(int paramInt)
  {
    return new aocf();
  }
  
  public aocf a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("IsDanmuEnable");
      if (QLog.isColorLevel()) {
        QLog.e("DanmuConfProcessor", 2, "parse conf, IsDanmuEnable:" + paramString);
      }
      paramString = new aocf(paramString.trim());
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  @Nullable
  public aocf a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      aocf localaocf = a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("DanmuConfProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      }
      return localaocf;
    }
    return new aocf();
  }
  
  public Class<aocf> a()
  {
    return aocf.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aocf paramaocf)
  {
    if ((paramaocf != null) && (!TextUtils.isEmpty(paramaocf.a)))
    {
      a = "1".equals(paramaocf.a);
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
 * Qualified Name:     aoce
 * JD-Core Version:    0.7.0.1
 */