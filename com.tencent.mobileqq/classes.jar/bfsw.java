import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class bfsw
  extends anua
{
  bfsw(bfsv parambfsv) {}
  
  protected void c(Object paramObject)
  {
    bgsg localbgsg = (bgsg)paramObject;
    Object localObject1 = localbgsg.c;
    if (!bhnv.g(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
      localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692319);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() >= 1) {}
    }
    else
    {
      localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693401);
    }
    if (atyt.jdField_a_of_type_Boolean)
    {
      localbgsg.jdField_a_of_type_JavaLangString = "183.61.37.13";
      localbgsg.b = "443";
    }
    if ((bgsk.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!TextUtils.isEmpty(localbgsg.f)))
    {
      short s2 = localbgsg.jdField_a_of_type_Short;
      short s1 = s2;
      if (s2 == 0) {
        s1 = 443;
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("ishttps", true);
      ((Bundle)localObject1).putString("httpsdomain", localbgsg.f);
      ((Bundle)localObject1).putShort("httpsport", s1);
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Atib != null) {
        this.a.jdField_a_of_type_Atib.a(localbgsg.jdField_a_of_type_Boolean, localbgsg.jdField_a_of_type_JavaLangString, localbgsg.b, localbgsg.jdField_a_of_type_Int, (String)localObject2, localbgsg.d, null, localbgsg.e, (Bundle)localObject1);
      }
      super.c(paramObject);
      return;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfsw
 * JD-Core Version:    0.7.0.1
 */