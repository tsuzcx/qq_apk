import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class arfi
  implements aqho
{
  arfi(arfh paramarfh, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6, Bundle paramBundle)
  {
    if (!paramBoolean)
    {
      QLog.e("FileBrowserModelBase", 1, "sending cs to get preview url but failed, retCode[" + paramLong + "], retMeg[" + paramString3 + "]");
      if (this.jdField_a_of_type_Arfh.jdField_a_of_type_Argg != null) {
        this.jdField_a_of_type_Arfh.jdField_a_of_type_Argg.a(paramLong);
      }
      if (this.jdField_a_of_type_Arfh.jdField_a_of_type_Ardn != null) {
        this.jdField_a_of_type_Arfh.jdField_a_of_type_Ardn.e();
      }
      this.jdField_a_of_type_Arfh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_Arfh.jdField_a_of_type_Ardq.a());
      return;
    }
    this.jdField_a_of_type_Arfh.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Arfh.b = paramString2;
    this.jdField_a_of_type_Arfh.c = paramString4;
    this.jdField_a_of_type_Arfh.d = paramString5;
    paramString2 = "";
    short s;
    if (paramBundle != null) {
      if (this.jdField_a_of_type_Int == 3000)
      {
        paramBoolean = aqxg.g(this.jdField_a_of_type_Arfh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      this.jdField_a_of_type_Arfh.a(this.jdField_a_of_type_Arfh.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Arfh.b, this.jdField_a_of_type_Arfh.c, arni.c(this.jdField_a_of_type_Arfh.jdField_a_of_type_Ardq.a()), "/", this.jdField_a_of_type_Arfh.d, this.jdField_a_of_type_Arfh.jdField_a_of_type_Ardq.a(), paramBoolean, paramString1, s, paramString2, new arfj(this, paramBoolean, paramString1, s));
      return;
      paramBoolean = aqxg.c(this.jdField_a_of_type_Arfh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arfi
 * JD-Core Version:    0.7.0.1
 */