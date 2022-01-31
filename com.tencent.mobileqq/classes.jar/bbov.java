import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class bbov
  extends alkl
{
  bbov(bbou parambbou) {}
  
  protected void c(Object paramObject)
  {
    bcjg localbcjg = (bcjg)paramObject;
    Object localObject1 = localbcjg.c;
    if (!bdee.g(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
      localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692745);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() >= 1) {}
    }
    else
    {
      localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694090);
    }
    if (aqxg.jdField_a_of_type_Boolean)
    {
      localbcjg.jdField_a_of_type_JavaLangString = "183.61.37.13";
      localbcjg.b = "443";
    }
    if ((bcjk.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!TextUtils.isEmpty(localbcjg.f)))
    {
      short s2 = localbcjg.jdField_a_of_type_Short;
      short s1 = s2;
      if (s2 == 0) {
        s1 = 443;
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("ishttps", true);
      ((Bundle)localObject1).putString("httpsdomain", localbcjg.f);
      ((Bundle)localObject1).putShort("httpsport", s1);
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Aqho != null) {
        this.a.jdField_a_of_type_Aqho.a(localbcjg.jdField_a_of_type_Boolean, localbcjg.jdField_a_of_type_JavaLangString, localbcjg.b, localbcjg.jdField_a_of_type_Int, (String)localObject2, localbcjg.d, null, localbcjg.e, (Bundle)localObject1);
      }
      super.c(paramObject);
      return;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbov
 * JD-Core Version:    0.7.0.1
 */