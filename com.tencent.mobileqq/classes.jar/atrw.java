import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class atrw
  extends aofy<atrq>
{
  public int a()
  {
    return 454;
  }
  
  @NonNull
  public atrq a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WelcomeConfigProcessor", 2, "migrateOldOrDefaultContent");
    }
    return new atrq();
  }
  
  @Nullable
  public atrq a(aogf[] paramArrayOfaogf)
  {
    int j;
    int i;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      QLog.d("WelcomeConfigProcessor", 2, "onParsed :" + paramArrayOfaogf);
      if (paramArrayOfaogf != null)
      {
        j = paramArrayOfaogf.length;
        i = 0;
        while (i < j)
        {
          localObject1 = paramArrayOfaogf[i];
          if (localObject1 != null) {
            QLog.d("WelcomeConfigProcessor", 2, "onParsed item: " + ((aogf)localObject1).jdField_a_of_type_JavaLangString);
          }
          i += 1;
        }
      }
    }
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      j = paramArrayOfaogf.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = paramArrayOfaogf[i];
        if ((localObject2 != null) && (!TextUtils.isEmpty(((aogf)localObject2).jdField_a_of_type_JavaLangString))) {
          try
          {
            localObject1 = new atrq();
            localObject2 = new JSONObject(((aogf)localObject2).jdField_a_of_type_JavaLangString);
            if (((JSONObject)localObject2).has("popup_url")) {
              ((atrq)localObject1).jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).getString("popup_url");
            }
            if (((JSONObject)localObject2).has("fixed_entrance_url")) {
              ((atrq)localObject1).b = ((JSONObject)localObject2).getString("fixed_entrance_url");
            }
            if (((JSONObject)localObject2).has("request_interval")) {
              ((atrq)localObject1).jdField_a_of_type_Int = ((JSONObject)localObject2).getInt("request_interval");
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
  
  public Class<atrq> a()
  {
    return atrq.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WelcomeConfigProcessor", 2, "onReqFailed, code = " + paramInt);
    }
  }
  
  public void a(atrq paramatrq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WelcomeConfigProcessor", 2, "onUpdate");
    }
    if (paramatrq != null) {
      ((LoginWelcomeManager)BaseApplicationImpl.sApplication.getRuntime().getManager(146)).a(paramatrq);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atrw
 * JD-Core Version:    0.7.0.1
 */