import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bbma
  implements alzd
{
  public static final String a;
  private bbmb jdField_a_of_type_Bbmb;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final int[] jdField_a_of_type_ArrayOfInt = { 0, 1, 1, 1, 0, 0, 1, 1 };
  private final Boolean[] jdField_a_of_type_ArrayOfJavaLangBoolean = new Boolean[8];
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = bbma.class.getSimpleName();
  }
  
  public bbma(QQAppInterface paramQQAppInterface, bbmb parambbmb)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bbmb = parambbmb;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("profile_btn_config", this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("profile_switch_config", this);
    }
  }
  
  private void a(String paramString)
  {
    int[] arrayOfInt = new int[8];
    int i = 0;
    while (i < 8)
    {
      arrayOfInt[i] = this.jdField_a_of_type_ArrayOfInt[i];
      i += 1;
    }
    label384:
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label391;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        break label231;
      }
      localObject = "";
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject;
        label231:
        localException1 = localException1;
        localException1.printStackTrace();
        i = 0;
        if (i < 8)
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
      if (i >= 8) {
        break label384;
      }
      Boolean[] arrayOfBoolean = this.jdField_a_of_type_ArrayOfJavaLangBoolean;
      if (arrayOfInt[i] != 1) {
        break label379;
      }
      label379:
      for (boolean bool = true;; bool = false)
      {
        arrayOfBoolean[i] = Boolean.valueOf(bool);
        i += 1;
        break;
      }
    }
    localObject = alzb.a((String)localObject, "profile_switch_config");
    paramString = (String)localObject;
    label391:
    for (;;) {}
  }
  
  private void b(String paramString)
  {
    Object localObject3 = null;
    Object localObject4 = null;
    label166:
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString)) {
          break label166;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
        {
          str = "";
          str = alzb.a(str, "profile_btn_config");
          paramString = str;
        }
      }
      catch (Exception localException1)
      {
        String str;
        localException1.printStackTrace();
        Object localObject1 = localObject4;
        if (TextUtils.isEmpty(null)) {
          localObject1 = ajjy.a(2131642659);
        }
        this.b = ((String)localObject1);
        continue;
      }
      finally
      {
        paramString = (String)localObject3;
        if (TextUtils.isEmpty(null)) {
          paramString = ajjy.a(2131642659);
        }
        this.b = paramString;
      }
      try
      {
        str = new JSONObject(paramString).optString("call_wording");
        localObject3 = str;
        if (TextUtils.isEmpty(str)) {
          localObject3 = ajjy.a(2131642659);
        }
        this.b = ((String)localObject3);
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("initVoiceBtnConfig [str: %s, content:%s]", new Object[] { this.b, paramString }));
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
      return ajjy.a(2131642641);
    }
    if (this.b == null) {
      b(null);
    }
    return this.b;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Bbmb = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, alzc paramalzc)
  {
    if (paramalzc == null) {}
    for (;;)
    {
      return;
      if ("profile_btn_config".equals(paramString)) {
        b(paramalzc.jdField_a_of_type_JavaLangString);
      }
      while (this.jdField_a_of_type_Bbmb != null)
      {
        this.jdField_a_of_type_Bbmb.a(paramInt, paramString);
        return;
        if ("profile_switch_config".equals(paramString)) {
          a(paramalzc.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    while ((paramInt < 0) || (paramInt >= 8)) {
      return false;
    }
    if (this.jdField_a_of_type_ArrayOfJavaLangBoolean[paramInt] == null) {
      a(null);
    }
    return this.jdField_a_of_type_ArrayOfJavaLangBoolean[paramInt].booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbma
 * JD-Core Version:    0.7.0.1
 */