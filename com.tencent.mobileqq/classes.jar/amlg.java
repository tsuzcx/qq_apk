import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amlg
  extends ampa<amlh>
{
  private static boolean a;
  
  public static boolean e()
  {
    amlh localamlh = (amlh)ampl.a().a(576);
    if ((localamlh != null) && (!TextUtils.isEmpty(localamlh.a))) {
      a = "1".equals(localamlh.a);
    }
    return a;
  }
  
  public int a()
  {
    return 576;
  }
  
  @NonNull
  public amlh a(int paramInt)
  {
    return new amlh();
  }
  
  public amlh a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("IsDanmuEnable");
      if (QLog.isColorLevel()) {
        QLog.e("DanmuConfProcessor", 2, "parse conf, IsDanmuEnable:" + paramString);
      }
      paramString = new amlh(paramString.trim());
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  @Nullable
  public amlh a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      amlh localamlh = a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("DanmuConfProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      }
      return localamlh;
    }
    return new amlh();
  }
  
  public Class<amlh> a()
  {
    return amlh.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amlh paramamlh)
  {
    if ((paramamlh != null) && (!TextUtils.isEmpty(paramamlh.a)))
    {
      a = "1".equals(paramamlh.a);
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
 * Qualified Name:     amlg
 * JD-Core Version:    0.7.0.1
 */