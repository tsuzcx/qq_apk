import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class bbte
  extends alpa
{
  bbte(bbtd parambbtd) {}
  
  protected void c(Object paramObject)
  {
    bcnp localbcnp = (bcnp)paramObject;
    Object localObject1 = localbcnp.c;
    if (!bdin.g(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
      localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692747);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() >= 1) {}
    }
    else
    {
      localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694092);
    }
    if (arbp.jdField_a_of_type_Boolean)
    {
      localbcnp.jdField_a_of_type_JavaLangString = "183.61.37.13";
      localbcnp.b = "443";
    }
    if ((bcnt.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!TextUtils.isEmpty(localbcnp.f)))
    {
      short s2 = localbcnp.jdField_a_of_type_Short;
      short s1 = s2;
      if (s2 == 0) {
        s1 = 443;
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("ishttps", true);
      ((Bundle)localObject1).putString("httpsdomain", localbcnp.f);
      ((Bundle)localObject1).putShort("httpsport", s1);
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Aqlx != null) {
        this.a.jdField_a_of_type_Aqlx.a(localbcnp.jdField_a_of_type_Boolean, localbcnp.jdField_a_of_type_JavaLangString, localbcnp.b, localbcnp.jdField_a_of_type_Int, (String)localObject2, localbcnp.d, null, localbcnp.e, (Bundle)localObject1);
      }
      super.c(paramObject);
      return;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbte
 * JD-Core Version:    0.7.0.1
 */