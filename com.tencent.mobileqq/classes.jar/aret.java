import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class aret
  extends alzl<aren>
{
  public int a()
  {
    return 454;
  }
  
  @NonNull
  public aren a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WelcomeConfigProcessor", 2, "migrateOldOrDefaultContent");
    }
    return new aren();
  }
  
  @Nullable
  public aren a(alzs[] paramArrayOfalzs)
  {
    int j;
    int i;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      QLog.d("WelcomeConfigProcessor", 2, "onParsed :" + paramArrayOfalzs);
      if (paramArrayOfalzs != null)
      {
        j = paramArrayOfalzs.length;
        i = 0;
        while (i < j)
        {
          localObject1 = paramArrayOfalzs[i];
          if (localObject1 != null) {
            QLog.d("WelcomeConfigProcessor", 2, "onParsed item: " + ((alzs)localObject1).jdField_a_of_type_JavaLangString);
          }
          i += 1;
        }
      }
    }
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      j = paramArrayOfalzs.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = paramArrayOfalzs[i];
        if ((localObject2 != null) && (!TextUtils.isEmpty(((alzs)localObject2).jdField_a_of_type_JavaLangString))) {
          try
          {
            localObject1 = new aren();
            localObject2 = new JSONObject(((alzs)localObject2).jdField_a_of_type_JavaLangString);
            if (((JSONObject)localObject2).has("popup_url")) {
              ((aren)localObject1).jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).getString("popup_url");
            }
            if (((JSONObject)localObject2).has("fixed_entrance_url")) {
              ((aren)localObject1).b = ((JSONObject)localObject2).getString("fixed_entrance_url");
            }
            if (((JSONObject)localObject2).has("request_interval")) {
              ((aren)localObject1).jdField_a_of_type_Int = ((JSONObject)localObject2).getInt("request_interval");
            }
            return localObject1;
          }
          catch (Throwable localThrowable)
          {
            QLog.e("WelcomeConfigProcessor", 1, localThrowable, new Object[0]);
          }
        }
        i += 1;
      }
    }
    return null;
  }
  
  public Class<aren> a()
  {
    return aren.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WelcomeConfigProcessor", 2, "onReqFailed, code = " + paramInt);
    }
  }
  
  public void a(aren paramaren)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WelcomeConfigProcessor", 2, "onUpdate");
    }
    if (paramaren != null) {
      ((LoginWelcomeManager)BaseApplicationImpl.sApplication.getRuntime().getManager(146)).a(paramaren);
    }
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WelcomeConfigProcessor", 2, "migrateOldVersion");
    }
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
 * Qualified Name:     aret
 * JD-Core Version:    0.7.0.1
 */