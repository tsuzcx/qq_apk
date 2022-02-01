import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class awps
  extends aqwt<awpk>
{
  @NonNull
  public awpk a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WelcomeConfigProcessor", 2, "migrateOldOrDefaultContent");
    }
    return new awpk();
  }
  
  @Nullable
  public awpk a(aqxa[] paramArrayOfaqxa)
  {
    int j;
    int i;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      QLog.d("WelcomeConfigProcessor", 2, "onParsed :" + paramArrayOfaqxa);
      if (paramArrayOfaqxa != null)
      {
        j = paramArrayOfaqxa.length;
        i = 0;
        while (i < j)
        {
          localObject1 = paramArrayOfaqxa[i];
          if (localObject1 != null) {
            QLog.d("WelcomeConfigProcessor", 2, "onParsed item: " + ((aqxa)localObject1).jdField_a_of_type_JavaLangString);
          }
          i += 1;
        }
      }
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      j = paramArrayOfaqxa.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = paramArrayOfaqxa[i];
        if ((localObject2 != null) && (!TextUtils.isEmpty(((aqxa)localObject2).jdField_a_of_type_JavaLangString))) {
          try
          {
            localObject1 = new awpk();
            localObject2 = new JSONObject(((aqxa)localObject2).jdField_a_of_type_JavaLangString);
            if (((JSONObject)localObject2).has("popup_url")) {
              ((awpk)localObject1).jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).getString("popup_url");
            }
            if (((JSONObject)localObject2).has("fixed_entrance_url")) {
              ((awpk)localObject1).b = ((JSONObject)localObject2).getString("fixed_entrance_url");
            }
            if (((JSONObject)localObject2).has("request_interval")) {
              ((awpk)localObject1).jdField_a_of_type_Int = ((JSONObject)localObject2).getInt("request_interval");
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
  
  public void a(awpk paramawpk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WelcomeConfigProcessor", 2, "onUpdate");
    }
    if (paramawpk != null) {
      ((LoginWelcomeManager)BaseApplicationImpl.sApplication.getRuntime().getManager(QQManagerFactory.LOGIN_WELCOME_MANAGER)).a(paramawpk);
    }
  }
  
  public Class<awpk> clazz()
  {
    return awpk.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WelcomeConfigProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WelcomeConfigProcessor", 2, "onReqFailed, code = " + paramInt);
    }
  }
  
  public int type()
  {
    return 454;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awps
 * JD-Core Version:    0.7.0.1
 */