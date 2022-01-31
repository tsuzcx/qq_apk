import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class aypu
  extends ajey
{
  aypu(aypt paramaypt) {}
  
  protected void c(Object paramObject)
  {
    azjc localazjc = (azjc)paramObject;
    Object localObject1 = localazjc.c;
    if (!badq.g(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
      localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131627028);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() >= 1) {}
    }
    else
    {
      localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131628332);
    }
    if (aonj.jdField_a_of_type_Boolean)
    {
      localazjc.jdField_a_of_type_JavaLangString = "183.61.37.13";
      localazjc.b = "443";
    }
    if ((azjg.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!TextUtils.isEmpty(localazjc.f)))
    {
      short s2 = localazjc.jdField_a_of_type_Short;
      short s1 = s2;
      if (s2 == 0) {
        s1 = 443;
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("ishttps", true);
      ((Bundle)localObject1).putString("httpsdomain", localazjc.f);
      ((Bundle)localObject1).putShort("httpsport", s1);
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Anxs != null) {
        this.a.jdField_a_of_type_Anxs.a(localazjc.jdField_a_of_type_Boolean, localazjc.jdField_a_of_type_JavaLangString, localazjc.b, localazjc.jdField_a_of_type_Int, (String)localObject2, localazjc.d, null, localazjc.e, (Bundle)localObject1);
      }
      super.c(paramObject);
      return;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aypu
 * JD-Core Version:    0.7.0.1
 */