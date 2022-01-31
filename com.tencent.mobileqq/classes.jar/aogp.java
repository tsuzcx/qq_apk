import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aogp
  extends aokh<aogq>
{
  private static boolean a;
  private static boolean b;
  
  public static boolean e()
  {
    aogq localaogq = (aogq)aoks.a().a(579);
    if ((localaogq != null) && (!TextUtils.isEmpty(localaogq.a))) {
      a = "1".equals(localaogq.a);
    }
    return a;
  }
  
  public static boolean f()
  {
    aogq localaogq = (aogq)aoks.a().a(579);
    if ((localaogq != null) && (!TextUtils.isEmpty(localaogq.b))) {
      b = "1".equals(localaogq.b);
    }
    return b;
  }
  
  public int a()
  {
    return 579;
  }
  
  @NonNull
  public aogq a(int paramInt)
  {
    return new aogq();
  }
  
  public aogq a(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("IsImageImmersiveEnable");
      localObject = ((JSONObject)localObject).optString("IsVideoImmersiveEnable");
      if (QLog.isColorLevel()) {
        QLog.e("ImmersiveConfProcessor", 2, "ImmersiveConfBean, isImgEnable:" + paramString + ", isVdoEnable:" + (String)localObject);
      }
      paramString = new aogq(paramString.trim(), ((String)localObject).trim());
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  @Nullable
  public aogq a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      aogq localaogq = a(paramArrayOfaoko[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ImmersiveConfProcessor", 2, "onParsed " + paramArrayOfaoko[0].a);
      }
      return localaogq;
    }
    return new aogq();
  }
  
  public Class<aogq> a()
  {
    return aogq.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aogq paramaogq)
  {
    if (paramaogq != null)
    {
      if (TextUtils.isEmpty(paramaogq.a)) {
        a = "1".equals(paramaogq.a);
      }
      if (TextUtils.isEmpty(paramaogq.b)) {
        b = "1".equals(paramaogq.b);
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
 * Qualified Name:     aogp
 * JD-Core Version:    0.7.0.1
 */