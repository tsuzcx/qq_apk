import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class apmj
  implements aooq
{
  apmj(apmi paramapmi, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6, Bundle paramBundle)
  {
    if (!paramBoolean)
    {
      QLog.e("FileBrowserModelBase", 1, "sending cs to get preview url but failed, retCode[" + paramLong + "], retMeg[" + paramString3 + "]");
      if (this.jdField_a_of_type_Apmi.jdField_a_of_type_Apng != null) {
        this.jdField_a_of_type_Apmi.jdField_a_of_type_Apng.a(paramLong);
      }
      if (this.jdField_a_of_type_Apmi.jdField_a_of_type_Apkq != null) {
        this.jdField_a_of_type_Apmi.jdField_a_of_type_Apkq.e();
      }
      this.jdField_a_of_type_Apmi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_Apmi.jdField_a_of_type_Apkt.a());
      return;
    }
    this.jdField_a_of_type_Apmi.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Apmi.b = paramString2;
    this.jdField_a_of_type_Apmi.c = paramString4;
    this.jdField_a_of_type_Apmi.d = paramString5;
    paramString2 = "";
    short s;
    if (paramBundle != null) {
      if (this.jdField_a_of_type_Int == 3000)
      {
        paramBoolean = apei.g(this.jdField_a_of_type_Apmi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        paramString1 = paramBundle.getString("httpsdomain");
        if ((TextUtils.isEmpty(paramString1)) || (!paramBoolean)) {
          break label316;
        }
        paramBoolean = true;
        s = paramBundle.getShort("httpsport");
        label210:
        paramString2 = paramBundle.getString("ipv6domain", "");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Apmi.a(this.jdField_a_of_type_Apmi.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Apmi.b, this.jdField_a_of_type_Apmi.c, apug.c(this.jdField_a_of_type_Apmi.jdField_a_of_type_Apkt.a()), "/", this.jdField_a_of_type_Apmi.d, this.jdField_a_of_type_Apmi.jdField_a_of_type_Apkt.a(), paramBoolean, paramString1, s, paramString2, new apmk(this, paramBoolean, paramString1, s));
      return;
      paramBoolean = apei.c(this.jdField_a_of_type_Apmi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      label316:
      paramString1 = null;
      s = 0;
      paramBoolean = false;
      break label210;
      paramString1 = null;
      s = 0;
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apmj
 * JD-Core Version:    0.7.0.1
 */