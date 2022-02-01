import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qphone.base.util.QLog;

public class bldi
{
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (!TextUtils.isEmpty(paramString2)) {
        break label28;
      }
      localObject1 = localObject3;
    }
    label28:
    do
    {
      return localObject1;
      try
      {
        paramString1 = Base64.decode(paramString1, paramInt);
        if ((paramString1 == null) || (paramString1.length <= 0)) {
          break;
        }
        paramString1 = new bldh().a(paramString1, paramString2.getBytes());
        if (paramString1 == null) {
          break;
        }
        paramString1 = new String(paramString1);
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          paramString1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.e("WadlProviderUtil", 4, "decodeStr exception:", paramString2);
            paramString1 = localObject2;
            continue;
            paramString1 = null;
          }
        }
      }
      localObject1 = paramString1;
    } while (!QLog.isColorLevel());
    QLog.d("WadlProviderUtil", 4, "decodeStr decodeStr=" + paramString1);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bldi
 * JD-Core Version:    0.7.0.1
 */