import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class asaw
  extends ampa<asaq>
{
  public int a()
  {
    return 454;
  }
  
  @NonNull
  public asaq a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WelcomeConfigProcessor", 2, "migrateOldOrDefaultContent");
    }
    return new asaq();
  }
  
  @Nullable
  public asaq a(amph[] paramArrayOfamph)
  {
    int j;
    int i;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      QLog.d("WelcomeConfigProcessor", 2, "onParsed :" + paramArrayOfamph);
      if (paramArrayOfamph != null)
      {
        j = paramArrayOfamph.length;
        i = 0;
        while (i < j)
        {
          localObject1 = paramArrayOfamph[i];
          if (localObject1 != null) {
            QLog.d("WelcomeConfigProcessor", 2, "onParsed item: " + ((amph)localObject1).jdField_a_of_type_JavaLangString);
          }
          i += 1;
        }
      }
    }
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      j = paramArrayOfamph.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = paramArrayOfamph[i];
        if ((localObject2 != null) && (!TextUtils.isEmpty(((amph)localObject2).jdField_a_of_type_JavaLangString))) {
          try
          {
            localObject1 = new asaq();
            localObject2 = new JSONObject(((amph)localObject2).jdField_a_of_type_JavaLangString);
            if (((JSONObject)localObject2).has("popup_url")) {
              ((asaq)localObject1).jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).getString("popup_url");
            }
            if (((JSONObject)localObject2).has("fixed_entrance_url")) {
              ((asaq)localObject1).b = ((JSONObject)localObject2).getString("fixed_entrance_url");
            }
            if (((JSONObject)localObject2).has("request_interval")) {
              ((asaq)localObject1).jdField_a_of_type_Int = ((JSONObject)localObject2).getInt("request_interval");
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
  
  public Class<asaq> a()
  {
    return asaq.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WelcomeConfigProcessor", 2, "onReqFailed, code = " + paramInt);
    }
  }
  
  public void a(asaq paramasaq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WelcomeConfigProcessor", 2, "onUpdate");
    }
    if (paramasaq != null) {
      ((LoginWelcomeManager)BaseApplicationImpl.sApplication.getRuntime().getManager(146)).a(paramasaq);
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
 * Qualified Name:     asaw
 * JD-Core Version:    0.7.0.1
 */