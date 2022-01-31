import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amli
  extends ampa<amlj>
{
  private static boolean a;
  private static boolean b;
  
  public static boolean e()
  {
    amlj localamlj = (amlj)ampl.a().a(579);
    if ((localamlj != null) && (!TextUtils.isEmpty(localamlj.a))) {
      a = "1".equals(localamlj.a);
    }
    return a;
  }
  
  public static boolean f()
  {
    amlj localamlj = (amlj)ampl.a().a(579);
    if ((localamlj != null) && (!TextUtils.isEmpty(localamlj.b))) {
      b = "1".equals(localamlj.b);
    }
    return b;
  }
  
  public int a()
  {
    return 579;
  }
  
  @NonNull
  public amlj a(int paramInt)
  {
    return new amlj();
  }
  
  public amlj a(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("IsImageImmersiveEnable");
      localObject = ((JSONObject)localObject).optString("IsVideoImmersiveEnable");
      if (QLog.isColorLevel()) {
        QLog.e("ImmersiveConfProcessor", 2, "ImmersiveConfBean, isImgEnable:" + paramString + ", isVdoEnable:" + (String)localObject);
      }
      paramString = new amlj(paramString.trim(), ((String)localObject).trim());
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  @Nullable
  public amlj a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      amlj localamlj = a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ImmersiveConfProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      }
      return localamlj;
    }
    return new amlj();
  }
  
  public Class<amlj> a()
  {
    return amlj.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amlj paramamlj)
  {
    if (paramamlj != null)
    {
      if (TextUtils.isEmpty(paramamlj.a)) {
        a = "1".equals(paramamlj.a);
      }
      if (TextUtils.isEmpty(paramamlj.b)) {
        b = "1".equals(paramamlj.b);
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
 * Qualified Name:     amli
 * JD-Core Version:    0.7.0.1
 */