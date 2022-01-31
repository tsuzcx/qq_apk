import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class azqk
  extends ajta
{
  azqk(azqj paramazqj) {}
  
  protected void c(Object paramObject)
  {
    bakf localbakf = (bakf)paramObject;
    Object localObject1 = localbakf.c;
    if (!bbev.g(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
      localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692665);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() >= 1) {}
    }
    else
    {
      localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693973);
    }
    if (apee.jdField_a_of_type_Boolean)
    {
      localbakf.jdField_a_of_type_JavaLangString = "183.61.37.13";
      localbakf.b = "443";
    }
    if ((bakj.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!TextUtils.isEmpty(localbakf.f)))
    {
      short s2 = localbakf.jdField_a_of_type_Short;
      short s1 = s2;
      if (s2 == 0) {
        s1 = 443;
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("ishttps", true);
      ((Bundle)localObject1).putString("httpsdomain", localbakf.f);
      ((Bundle)localObject1).putShort("httpsport", s1);
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Aool != null) {
        this.a.jdField_a_of_type_Aool.a(localbakf.jdField_a_of_type_Boolean, localbakf.jdField_a_of_type_JavaLangString, localbakf.b, localbakf.jdField_a_of_type_Int, (String)localObject2, localbakf.d, null, localbakf.e, (Bundle)localObject1);
      }
      super.c(paramObject);
      return;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azqk
 * JD-Core Version:    0.7.0.1
 */