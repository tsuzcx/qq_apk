import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

class becg
  extends amop
{
  becg(becf parambecf) {}
  
  protected void c(Object paramObject)
  {
    bfbu localbfbu = (bfbu)paramObject;
    Object localObject1 = localbfbu.c;
    if (!NetworkUtil.isNetworkAvailable(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
      localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692367);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() >= 1) {}
    }
    else
    {
      localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693496);
    }
    if (asld.jdField_a_of_type_Boolean)
    {
      localbfbu.jdField_a_of_type_JavaLangString = "183.61.37.13";
      localbfbu.b = "443";
    }
    if ((bfby.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!TextUtils.isEmpty(localbfbu.f)))
    {
      short s2 = localbfbu.jdField_a_of_type_Short;
      short s1 = s2;
      if (s2 == 0) {
        s1 = 443;
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("ishttps", true);
      ((Bundle)localObject1).putString("httpsdomain", localbfbu.f);
      ((Bundle)localObject1).putShort("httpsport", s1);
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Aruk != null) {
        this.a.jdField_a_of_type_Aruk.a(localbfbu.jdField_a_of_type_Boolean, localbfbu.jdField_a_of_type_JavaLangString, localbfbu.b, localbfbu.jdField_a_of_type_Int, (String)localObject2, localbfbu.d, null, localbfbu.e, (Bundle)localObject1);
      }
      super.c(paramObject);
      return;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     becg
 * JD-Core Version:    0.7.0.1
 */