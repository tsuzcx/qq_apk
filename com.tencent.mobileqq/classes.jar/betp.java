import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class betp
  extends anif
{
  betp(beto parambeto) {}
  
  protected void c(Object paramObject)
  {
    bfsf localbfsf = (bfsf)paramObject;
    Object localObject1 = localbfsf.c;
    if (!bgnt.g(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
      localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692314);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() >= 1) {}
    }
    else
    {
      localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693389);
    }
    if (atgz.jdField_a_of_type_Boolean)
    {
      localbfsf.jdField_a_of_type_JavaLangString = "183.61.37.13";
      localbfsf.b = "443";
    }
    if ((bfsj.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!TextUtils.isEmpty(localbfsf.f)))
    {
      short s2 = localbfsf.jdField_a_of_type_Short;
      short s1 = s2;
      if (s2 == 0) {
        s1 = 443;
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("ishttps", true);
      ((Bundle)localObject1).putString("httpsdomain", localbfsf.f);
      ((Bundle)localObject1).putShort("httpsport", s1);
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Asrx != null) {
        this.a.jdField_a_of_type_Asrx.a(localbfsf.jdField_a_of_type_Boolean, localbfsf.jdField_a_of_type_JavaLangString, localbfsf.b, localbfsf.jdField_a_of_type_Int, (String)localObject2, localbfsf.d, null, localbfsf.e, (Bundle)localObject1);
      }
      super.c(paramObject);
      return;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     betp
 * JD-Core Version:    0.7.0.1
 */