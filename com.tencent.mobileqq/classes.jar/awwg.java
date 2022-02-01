import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class awwg
  extends arac<awwa>
{
  @NonNull
  public awwa a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WelcomeConfigProcessor", 2, "migrateOldOrDefaultContent");
    }
    return new awwa();
  }
  
  @Nullable
  public awwa a(araj[] paramArrayOfaraj)
  {
    int j;
    int i;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      QLog.d("WelcomeConfigProcessor", 2, "onParsed :" + paramArrayOfaraj);
      if (paramArrayOfaraj != null)
      {
        j = paramArrayOfaraj.length;
        i = 0;
        while (i < j)
        {
          localObject1 = paramArrayOfaraj[i];
          if (localObject1 != null) {
            QLog.d("WelcomeConfigProcessor", 2, "onParsed item: " + ((araj)localObject1).jdField_a_of_type_JavaLangString);
          }
          i += 1;
        }
      }
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      j = paramArrayOfaraj.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = paramArrayOfaraj[i];
        if ((localObject2 != null) && (!TextUtils.isEmpty(((araj)localObject2).jdField_a_of_type_JavaLangString))) {
          try
          {
            localObject1 = new awwa();
            localObject2 = new JSONObject(((araj)localObject2).jdField_a_of_type_JavaLangString);
            if (((JSONObject)localObject2).has("popup_url")) {
              ((awwa)localObject1).jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).getString("popup_url");
            }
            if (((JSONObject)localObject2).has("fixed_entrance_url")) {
              ((awwa)localObject1).b = ((JSONObject)localObject2).getString("fixed_entrance_url");
            }
            if (((JSONObject)localObject2).has("request_interval")) {
              ((awwa)localObject1).jdField_a_of_type_Int = ((JSONObject)localObject2).getInt("request_interval");
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
  
  public void a(awwa paramawwa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WelcomeConfigProcessor", 2, "onUpdate");
    }
    if (paramawwa != null) {
      ((LoginWelcomeManager)BaseApplicationImpl.sApplication.getRuntime().getManager(146)).a(paramawwa);
    }
  }
  
  public Class<awwa> clazz()
  {
    return awwa.class;
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
 * Qualified Name:     awwg
 * JD-Core Version:    0.7.0.1
 */