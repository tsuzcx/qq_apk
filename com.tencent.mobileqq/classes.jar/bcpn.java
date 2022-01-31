import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bcpn
  implements amos
{
  private bcpo jdField_a_of_type_Bcpo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private final int[] jdField_a_of_type_ArrayOfInt = { 0, 1, 1, 1, 0, 0, 1, 1, 1 };
  private final Boolean[] jdField_a_of_type_ArrayOfJavaLangBoolean = new Boolean[9];
  
  public bcpn(QQAppInterface paramQQAppInterface, bcpo parambcpo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bcpo = parambcpo;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("profile_btn_config", this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("profile_switch_config", this);
    }
  }
  
  private void a(String paramString)
  {
    int[] arrayOfInt = new int[9];
    int i = 0;
    while (i < 9)
    {
      arrayOfInt[i] = this.jdField_a_of_type_ArrayOfInt[i];
      i += 1;
    }
    label269:
    label424:
    label429:
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label436;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        break label269;
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
        if (i < 9)
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
      if (i >= 9) {
        break label429;
      }
      Boolean[] arrayOfBoolean = this.jdField_a_of_type_ArrayOfJavaLangBoolean;
      if (arrayOfInt[i] != 1) {
        break label424;
      }
      for (boolean bool = true;; bool = false)
      {
        arrayOfBoolean[i] = Boolean.valueOf(bool);
        i += 1;
        break;
      }
    }
    localObject = amoq.a((String)localObject, "profile_switch_config");
    paramString = (String)localObject;
    label436:
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
          str = amoq.a(str, "profile_btn_config");
          paramString = str;
        }
      }
      catch (Exception localException1)
      {
        String str;
        localException1.printStackTrace();
        Object localObject1 = localObject4;
        if (TextUtils.isEmpty(null)) {
          localObject1 = ajya.a(2131708455);
        }
        this.jdField_a_of_type_JavaLangString = ((String)localObject1);
        continue;
      }
      finally
      {
        paramString = (String)localObject3;
        if (TextUtils.isEmpty(null)) {
          paramString = ajya.a(2131708455);
        }
        this.jdField_a_of_type_JavaLangString = paramString;
      }
      try
      {
        str = new JSONObject(paramString).optString("call_wording");
        localObject3 = str;
        if (TextUtils.isEmpty(str)) {
          localObject3 = ajya.a(2131708455);
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
      return ajya.a(2131708437);
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
    this.jdField_a_of_type_Bcpo = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, amor paramamor)
  {
    if (paramamor == null) {}
    for (;;)
    {
      return;
      if ("profile_btn_config".equals(paramString)) {
        b(paramamor.jdField_a_of_type_JavaLangString);
      }
      while (this.jdField_a_of_type_Bcpo != null)
      {
        this.jdField_a_of_type_Bcpo.a(paramInt, paramString);
        return;
        if ("profile_switch_config".equals(paramString)) {
          a(paramamor.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    while ((paramInt < 0) || (paramInt >= 9)) {
      return false;
    }
    if (this.jdField_a_of_type_ArrayOfJavaLangBoolean[paramInt] == null) {
      a(null);
    }
    return this.jdField_a_of_type_ArrayOfJavaLangBoolean[paramInt].booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcpn
 * JD-Core Version:    0.7.0.1
 */