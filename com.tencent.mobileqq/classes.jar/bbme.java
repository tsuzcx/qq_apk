import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class bbme
{
  public static SharedPreferences a(String paramString1, String paramString2, String paramString3)
  {
    if ((AudioHelper.d()) && (TextUtils.isEmpty(paramString2)))
    {
      paramString2 = " getSP, 获取配置需要UIN, uin[" + paramString2 + "], spName[" + paramString3 + "]";
      QLog.w(paramString1, 1, paramString2, new Throwable("打印调用栈"));
      throw new IllegalArgumentException(paramString1 + paramString2);
    }
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getSharedPreferences(paramString3 + paramString2, 4);
      if ((localObject == null) && (AudioHelper.d())) {
        QLog.w(paramString1, 1, "getSP, sp为null, uin[" + paramString2 + "], spName[" + paramString3 + "]", new Throwable("打印调用栈"));
      }
      return localObject;
    }
    if (AudioHelper.d()) {
      QLog.w(paramString1, 1, "getSP, BaseApplicationImpl为null, uin[" + paramString2 + "], spName[" + paramString3 + "]", new Throwable("打印调用栈"));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbme
 * JD-Core Version:    0.7.0.1
 */