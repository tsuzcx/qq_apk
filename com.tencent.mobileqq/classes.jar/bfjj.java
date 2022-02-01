import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

class bfjj
  extends anrc
{
  bfjj(bfji parambfji) {}
  
  protected void c(Object paramObject)
  {
    bgka localbgka = (bgka)paramObject;
    Object localObject1 = localbgka.c;
    if (!NetworkUtil.isNetworkAvailable(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
      localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692469);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() >= 1) {}
    }
    else
    {
      localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693677);
    }
    if (atpj.jdField_a_of_type_Boolean)
    {
      localbgka.jdField_a_of_type_JavaLangString = "183.61.37.13";
      localbgka.b = "443";
    }
    if ((bgke.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!TextUtils.isEmpty(localbgka.f)))
    {
      short s2 = localbgka.jdField_a_of_type_Short;
      short s1 = s2;
      if (s2 == 0) {
        s1 = 443;
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("ishttps", true);
      ((Bundle)localObject1).putString("httpsdomain", localbgka.f);
      ((Bundle)localObject1).putShort("httpsport", s1);
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Asyq != null) {
        this.a.jdField_a_of_type_Asyq.a(localbgka.jdField_a_of_type_Boolean, localbgka.jdField_a_of_type_JavaLangString, localbgka.b, localbgka.jdField_a_of_type_Int, (String)localObject2, localbgka.d, null, localbgka.e, (Bundle)localObject1);
      }
      super.c(paramObject);
      return;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfjj
 * JD-Core Version:    0.7.0.1
 */