import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class azqm
  extends ajsy
{
  azqm(azql paramazql) {}
  
  protected void c(Object paramObject)
  {
    bakt localbakt = (bakt)paramObject;
    Object localObject1 = localbakt.c;
    if (!bbfj.g(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
      localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692666);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() >= 1) {}
    }
    else
    {
      localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693974);
    }
    if (apei.jdField_a_of_type_Boolean)
    {
      localbakt.jdField_a_of_type_JavaLangString = "183.61.37.13";
      localbakt.b = "443";
    }
    if ((bakx.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!TextUtils.isEmpty(localbakt.f)))
    {
      short s2 = localbakt.jdField_a_of_type_Short;
      short s1 = s2;
      if (s2 == 0) {
        s1 = 443;
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("ishttps", true);
      ((Bundle)localObject1).putString("httpsdomain", localbakt.f);
      ((Bundle)localObject1).putShort("httpsport", s1);
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Aooq != null) {
        this.a.jdField_a_of_type_Aooq.a(localbakt.jdField_a_of_type_Boolean, localbakt.jdField_a_of_type_JavaLangString, localbakt.b, localbakt.jdField_a_of_type_Int, (String)localObject2, localbakt.d, null, localbakt.e, (Bundle)localObject1);
      }
      super.c(paramObject);
      return;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azqm
 * JD-Core Version:    0.7.0.1
 */