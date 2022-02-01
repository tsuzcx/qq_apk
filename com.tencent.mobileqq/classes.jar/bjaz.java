import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bjaz
  implements aqzu
{
  private bjba jdField_a_of_type_Bjba;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private final int[] jdField_a_of_type_ArrayOfInt = { 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0 };
  private final Boolean[] jdField_a_of_type_ArrayOfJavaLangBoolean = new Boolean[13];
  
  public bjaz(QQAppInterface paramQQAppInterface, bjba parambjba)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bjba = parambjba;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("profile_btn_config", this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("profile_switch_config", this);
    }
  }
  
  private void a(String paramString)
  {
    int[] arrayOfInt = new int[13];
    int i = 0;
    while (i < 13)
    {
      arrayOfInt[i] = this.jdField_a_of_type_ArrayOfInt[i];
      i += 1;
    }
    label345:
    label500:
    label505:
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label512;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        break label345;
      }
      localObject = "";
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject;
        localException1 = localException1;
        QLog.e("ProfileConfigHelper", 1, "initProfileSwitchConfig fail.", localException1);
        i = 0;
        if (i < 13)
        {
          arrayOfBoolean = this.jdField_a_of_type_ArrayOfJavaLangBoolean;
          if (arrayOfInt[i] == 1) {}
          for (bool = true;; bool = false)
          {
            arrayOfBoolean[i] = Boolean.valueOf(bool);
            i += 1;
            break;
          }
        }
      }
    }
    finally
    {
      i = 0;
      if (i >= 13) {
        break label505;
      }
      Boolean[] arrayOfBoolean = this.jdField_a_of_type_ArrayOfJavaLangBoolean;
      if (arrayOfInt[i] != 1) {
        break label500;
      }
      for (boolean bool = true;; bool = false)
      {
        arrayOfBoolean[i] = Boolean.valueOf(bool);
        i += 1;
        break;
      }
    }
    localObject = aqzs.a((String)localObject, "profile_switch_config");
    paramString = (String)localObject;
    label512:
    for (;;) {}
  }
  
  private void b(String paramString)
  {
    Object localObject3 = null;
    Object localObject4 = null;
    label165:
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString)) {
          break label165;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
        {
          str = "";
          str = aqzs.a(str, "profile_btn_config");
          paramString = str;
        }
      }
      catch (Exception localException1)
      {
        String str;
        localException1.printStackTrace();
        Object localObject1 = localObject4;
        if (TextUtils.isEmpty(null)) {
          localObject1 = anzj.a(2131707324);
        }
        this.jdField_a_of_type_JavaLangString = ((String)localObject1);
        continue;
      }
      finally
      {
        paramString = (String)localObject3;
        if (TextUtils.isEmpty(null)) {
          paramString = anzj.a(2131707324);
        }
        this.jdField_a_of_type_JavaLangString = paramString;
      }
      try
      {
        str = new JSONObject(paramString).optString("call_wording");
        localObject3 = str;
        if (TextUtils.isEmpty(str)) {
          localObject3 = anzj.a(2131707324);
        }
        this.jdField_a_of_type_JavaLangString = ((String)localObject3);
        if (QLog.isColorLevel()) {
          QLog.i("ProfileConfigHelper", 2, String.format("initVoiceBtnConfig [str:%s content:%s]", new Object[] { this.jdField_a_of_type_JavaLangString, paramString }));
        }
        return;
      }
      catch (Exception localException2)
      {
        continue;
      }
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    }
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return anzj.a(2131707306);
    }
    if (this.jdField_a_of_type_JavaLangString == null) {
      b(null);
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Bjba = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, aqzt paramaqzt)
  {
    if (paramaqzt == null) {}
    for (;;)
    {
      return;
      if ("profile_btn_config".equals(paramString)) {
        b(paramaqzt.jdField_a_of_type_JavaLangString);
      }
      while (this.jdField_a_of_type_Bjba != null)
      {
        this.jdField_a_of_type_Bjba.a(paramInt, paramString);
        return;
        if ("profile_switch_config".equals(paramString)) {
          a(paramaqzt.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    while ((paramInt < 0) || (paramInt >= 13)) {
      return false;
    }
    if (this.jdField_a_of_type_ArrayOfJavaLangBoolean[paramInt] == null) {
      a(null);
    }
    return this.jdField_a_of_type_ArrayOfJavaLangBoolean[paramInt].booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjaz
 * JD-Core Version:    0.7.0.1
 */