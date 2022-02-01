import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class auga
  implements atib
{
  auga(aufz paramaufz, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6, Bundle paramBundle)
  {
    if (!paramBoolean)
    {
      QLog.e("FileBrowserModelBase", 1, "sending cs to get preview url but failed, retCode[" + paramLong + "], retMeg[" + paramString3 + "]");
      if (this.jdField_a_of_type_Aufz.jdField_a_of_type_Augq != null) {
        this.jdField_a_of_type_Aufz.jdField_a_of_type_Augq.a(paramLong);
      }
      if (this.jdField_a_of_type_Aufz.jdField_a_of_type_Auef != null) {
        this.jdField_a_of_type_Aufz.jdField_a_of_type_Auef.c();
      }
      this.jdField_a_of_type_Aufz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_Aufz.jdField_a_of_type_Auei.a());
      return;
    }
    this.jdField_a_of_type_Aufz.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Aufz.b = paramString2;
    this.jdField_a_of_type_Aufz.c = paramString4;
    this.jdField_a_of_type_Aufz.d = paramString5;
    paramString2 = "";
    short s;
    if (paramBundle != null) {
      if (this.jdField_a_of_type_Int == 3000)
      {
        paramBoolean = atyt.g(this.jdField_a_of_type_Aufz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      this.jdField_a_of_type_Aufz.a(this.jdField_a_of_type_Aufz.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aufz.b, this.jdField_a_of_type_Aufz.c, aunj.c(this.jdField_a_of_type_Aufz.jdField_a_of_type_Auei.a()), "/", this.jdField_a_of_type_Aufz.d, this.jdField_a_of_type_Aufz.jdField_a_of_type_Auei.a(), paramBoolean, paramString1, s, paramString2, new augb(this, paramBoolean, paramString1, s));
      return;
      paramBoolean = atyt.c(this.jdField_a_of_type_Aufz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
 * Qualified Name:     auga
 * JD-Core Version:    0.7.0.1
 */