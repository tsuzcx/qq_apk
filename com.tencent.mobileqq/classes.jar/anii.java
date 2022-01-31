import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule.ObserverMethod.3;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule.ObserverMethod.6;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;

public class anii
  implements anih
{
  private anii(anif paramanif) {}
  
  public boolean a(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    long l;
    String str;
    if ("AttachEvent".equals(paramString))
    {
      if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 2) || (!paramArrayOfVariantWrapper[0].IsString()) || (!paramArrayOfVariantWrapper[1].IsFunction())) {
        return false;
      }
      paramVariantWrapper = paramArrayOfVariantWrapper[0].GetString();
      l = this.a.a(paramArrayOfVariantWrapper[1].Copy());
      paramString = null;
      if ("Motion".equals(paramVariantWrapper))
      {
        if (!anjy.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ComTencentArkArk$Application, "permission.SENSORS")) {
          return false;
        }
        paramString = new anij(this, l);
      }
      while ((paramString != null) && (!"Position".equals(paramVariantWrapper)))
      {
        this.a.jdField_a_of_type_Anjo.a(paramString, l);
        return true;
        if ("Orientation".equals(paramVariantWrapper))
        {
          if (!anjy.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ComTencentArkArk$Application, "permission.SENSORS")) {
            return false;
          }
          paramString = new anik(this, l);
        }
        else
        {
          if ("Position".equals(paramVariantWrapper))
          {
            if (!anjy.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ComTencentArkArk$Application, "permission.POSITION")) {
              return false;
            }
            if (QLog.isColorLevel()) {
              QLog.i("ArkAppDeviceModule", 2, String.format("Position.app.%s", new Object[] { this.a.jdField_a_of_type_JavaLangString }));
            }
            paramString = null;
            paramArrayOfVariantWrapper = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
            if (paramArrayOfVariantWrapper != null) {
              paramString = paramArrayOfVariantWrapper.getCurrentAccountUin();
            }
            if ((paramArrayOfVariantWrapper == null) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString))) {
              return false;
            }
            paramVariantWrapper = ArkAppCacheMgr.getApplicationDesc(this.a.jdField_a_of_type_JavaLangString);
            paramArrayOfVariantWrapper = paramVariantWrapper;
            if (TextUtils.isEmpty(paramVariantWrapper)) {
              paramArrayOfVariantWrapper = this.a.jdField_a_of_type_JavaLangString;
            }
            paramVariantWrapper = BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0);
            str = "key_ark_authority_show_dialog" + "_" + paramArrayOfVariantWrapper + "_" + "ark_authority_api_location" + "_" + paramString;
            if ((!paramVariantWrapper.getBoolean(str, false)) && (ankc.a))
            {
              ArkAppCenter.a().postToMainThread(new ArkAppDeviceModule.ObserverMethod.3(this, paramArrayOfVariantWrapper, l, paramString));
              paramVariantWrapper.edit().putBoolean(str, true).commit();
              anke.a(paramArrayOfVariantWrapper, paramString);
            }
            for (;;)
            {
              return true;
              if (1 == anke.a(paramArrayOfVariantWrapper, "ark_authority_api_location", paramString))
              {
                paramString = new anip(this, l);
                this.a.jdField_a_of_type_Anjo.a(paramString, l);
              }
              else
              {
                anif.a(this.a, l, false, 0.0D, 0.0D);
                paramString = this.a.a(l);
                if (paramString != null) {
                  paramString.Reset();
                }
              }
            }
          }
          if ("ConnectionTypeChange".equals(paramVariantWrapper))
          {
            if (!anjy.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ComTencentArkArk$Application, "permission.CONNECTION_TYPE")) {
              return false;
            }
            paramString = new aniq(this, l);
          }
        }
      }
      return false;
    }
    if ("DetachEvent".equals(paramString))
    {
      if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (!paramArrayOfVariantWrapper[0].IsString()) || (TextUtils.isEmpty(paramArrayOfVariantWrapper[0].GetString()))) {
        return false;
      }
      this.a.jdField_a_of_type_Anjo.a(paramArrayOfVariantWrapper[0].GetString());
      return true;
    }
    if ("GetCurrentPosition".equals(paramString))
    {
      if (!anjy.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ComTencentArkArk$Application, "permission.POSITION")) {
        return false;
      }
      if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (!paramArrayOfVariantWrapper[0].IsFunction())) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ArkAppDeviceModule", 2, String.format("GetCurrentPosition.app.%s", new Object[] { this.a.jdField_a_of_type_JavaLangString }));
      }
      l = this.a.a(paramArrayOfVariantWrapper[0].Copy());
      paramString = null;
      paramArrayOfVariantWrapper = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (paramArrayOfVariantWrapper != null) {
        paramString = paramArrayOfVariantWrapper.getCurrentAccountUin();
      }
      if ((paramArrayOfVariantWrapper == null) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString))) {
        return false;
      }
      paramVariantWrapper = ArkAppCacheMgr.getApplicationDesc(this.a.jdField_a_of_type_JavaLangString);
      paramArrayOfVariantWrapper = paramVariantWrapper;
      if (TextUtils.isEmpty(paramVariantWrapper)) {
        paramArrayOfVariantWrapper = this.a.jdField_a_of_type_JavaLangString;
      }
      paramVariantWrapper = BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0);
      str = "key_ark_authority_show_dialog" + "_" + paramArrayOfVariantWrapper + "_" + "ark_authority_api_location" + "_" + paramString;
      if ((!paramVariantWrapper.getBoolean(str, false)) && (ankc.a))
      {
        ArkAppCenter.a().postToMainThread(new ArkAppDeviceModule.ObserverMethod.6(this, paramArrayOfVariantWrapper, l, paramString));
        paramVariantWrapper.edit().putBoolean(str, true).commit();
        anke.a(paramArrayOfVariantWrapper, paramString);
      }
      for (;;)
      {
        return true;
        if (1 == anke.a(paramArrayOfVariantWrapper, "ark_authority_api_location", paramString))
        {
          paramString = new aniv(this, l);
          this.a.jdField_a_of_type_Anjo.a(paramString, l);
        }
        else
        {
          anif.a(this.a, l, false, 0.0D, 0.0D);
          paramString = this.a.a(l);
          if (paramString != null) {
            paramString.Reset();
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anii
 * JD-Core Version:    0.7.0.1
 */